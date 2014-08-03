/*
 * Copyright 2012 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.drools.workbench.screens.guided.dtable.client.editor;

import java.util.List;
import javax.enterprise.context.Dependent;
import javax.enterprise.event.Event;
import javax.enterprise.inject.New;
import javax.inject.Inject;

import com.google.gwt.user.client.ui.IsWidget;
import org.drools.workbench.models.guided.dtable.shared.model.GuidedDecisionTable52;
import org.drools.workbench.screens.guided.dtable.client.resources.i18n.GuidedDecisionTableConstants;
import org.drools.workbench.screens.guided.dtable.client.type.GuidedDTableResourceType;
import org.drools.workbench.screens.guided.dtable.model.GuidedDecisionTableEditorContent;
import org.drools.workbench.screens.guided.dtable.service.GuidedDecisionTableEditorService;
import org.guvnor.common.services.shared.metadata.model.Metadata;
import org.guvnor.common.services.shared.validation.model.ValidationMessage;
import org.jboss.errai.common.client.api.Caller;
import org.jboss.errai.common.client.api.RemoteCallback;
import org.kie.uberfire.client.callbacks.DefaultErrorCallback;
import org.kie.uberfire.client.callbacks.HasBusyIndicatorDefaultErrorCallback;
import org.kie.uberfire.client.common.MultiPageEditor;
import org.kie.uberfire.client.common.Page;
import org.kie.workbench.common.services.datamodel.model.PackageDataModelOracleBaselinePayload;
import org.kie.workbench.common.services.shared.rulename.RuleNamesService;
import org.kie.workbench.common.widgets.client.callbacks.CommandBuilder;
import org.kie.workbench.common.widgets.client.callbacks.CommandDrivenErrorCallback;
import org.kie.workbench.common.widgets.client.datamodel.AsyncPackageDataModelOracle;
import org.kie.workbench.common.widgets.client.datamodel.AsyncPackageDataModelOracleFactory;
import org.kie.workbench.common.widgets.client.editor.GuvnorEditor;
import org.kie.workbench.common.widgets.client.popups.file.CommandWithCommitMessage;
import org.kie.workbench.common.widgets.client.popups.file.SaveOperationService;
import org.kie.workbench.common.widgets.client.popups.validation.DefaultFileNameValidator;
import org.kie.workbench.common.widgets.client.popups.validation.ValidationPopup;
import org.kie.workbench.common.widgets.client.resources.i18n.CommonConstants;
import org.kie.workbench.common.widgets.configresource.client.widget.bound.ImportsWidgetPresenter;
import org.kie.workbench.common.widgets.metadata.client.widget.OverviewWidgetPresenter;
import org.uberfire.backend.vfs.ObservablePath;
import org.uberfire.client.annotations.WorkbenchEditor;
import org.uberfire.client.annotations.WorkbenchMenu;
import org.uberfire.client.annotations.WorkbenchPartTitle;
import org.uberfire.client.annotations.WorkbenchPartView;
import org.uberfire.client.workbench.events.ChangeTitleWidgetEvent;
import org.uberfire.lifecycle.IsDirty;
import org.uberfire.lifecycle.OnClose;
import org.uberfire.lifecycle.OnMayClose;
import org.uberfire.lifecycle.OnStartup;
import org.uberfire.mvp.Command;
import org.uberfire.mvp.PlaceRequest;
import org.uberfire.workbench.events.NotificationEvent;
import org.uberfire.workbench.model.menu.Menus;
import org.uberfire.workbench.type.FileNameUtil;

/**
 * Guided Decision Table Editor Presenter
 */
@Dependent
@WorkbenchEditor(identifier = "GuidedDecisionTableEditor", supportedTypes = {GuidedDTableResourceType.class})
public class GuidedDecisionTableEditorPresenter
        extends GuvnorEditor {

    @Inject
    private OverviewWidgetPresenter overview;

    private GuidedDecisionTableEditorView view;

    @Inject
    private ImportsWidgetPresenter importsWidget;

    @Inject
    @New
    private MultiPageEditor multiPage;

    @Inject
    private Caller<GuidedDecisionTableEditorService> service;

    @Inject
    private Event<NotificationEvent> notification;

    @Inject
    private Event<ChangeTitleWidgetEvent> changeTitleNotification;

    @Inject
    private Caller<RuleNamesService> ruleNameService;

    @Inject
    private GuidedDTableResourceType type;

    @Inject
    private AsyncPackageDataModelOracleFactory oracleFactory;

    @Inject
    private DefaultFileNameValidator fileNameValidator;

    private GuidedDecisionTable52 model;
    private AsyncPackageDataModelOracle oracle;
    private Metadata metadata;

    @Inject
    public GuidedDecisionTableEditorPresenter(GuidedDecisionTableEditorView view) {
        super(view);
        this.view = view;
    }

    @OnStartup
    public void onStartup(final ObservablePath path,
            final PlaceRequest place) {
        super.init(path, place);
    }

    protected void loadContent() {
        view.showBusyIndicator(CommonConstants.INSTANCE.Loading());
        service.call(getModelSuccessCallback(),
                new CommandDrivenErrorCallback(view,
                        new CommandBuilder().addNoSuchFileException(view,
                                multiPage,
                                menus).build()
                )).loadContent(versionRecordManager.getCurrentPath());
    }

    private RemoteCallback<GuidedDecisionTableEditorContent> getModelSuccessCallback() {
        return new RemoteCallback<GuidedDecisionTableEditorContent>() {

            @Override
            public void callback(final GuidedDecisionTableEditorContent content) {
                //Path is set to null when the Editor is closed (which can happen before async calls complete).
                if (versionRecordManager.getCurrentPath() == null) {
                    return;
                }

                multiPage.clear();

                multiPage.addWidget(overview,
                        CommonConstants.INSTANCE.Overview());
                overview.setContent(content.getOverview(), versionRecordManager.getCurrentPath());

                multiPage.addPage(new Page(view,
                        CommonConstants.INSTANCE.EditTabTitle()) {
                    @Override
                    public void onFocus() {
                        view.setContent(
                                versionRecordManager.getCurrentPath(),
                                model,
                                content.getWorkItemDefinitions(),
                                oracle,
                                ruleNameService,
                                isReadOnly);
                    }

                    @Override
                    public void onLostFocus() {

                    }
                });

                multiPage.addWidget(importsWidget,
                        CommonConstants.INSTANCE.ConfigTabTitle());

                model = content.getModel();
                metadata = content.getOverview().getMetadata();
                final PackageDataModelOracleBaselinePayload dataModel = content.getDataModel();
                oracle = oracleFactory.makeAsyncPackageDataModelOracle(
                        versionRecordManager.getCurrentPath(),
                        model,
                        dataModel);

                versionRecordManager.setVersions(content.getOverview().getMetadata().getVersion());

                importsWidget.setContent(oracle,
                        model.getImports(),
                        isReadOnly);

                view.hideBusyIndicator();
            }
        };
    }

    protected Command onValidate() {
        return new Command() {
            @Override
            public void execute() {
                service.call(new RemoteCallback<List<ValidationMessage>>() {
                    @Override
                    public void callback(final List<ValidationMessage> results) {
                        if (results == null || results.isEmpty()) {
                            notification.fire(new NotificationEvent(CommonConstants.INSTANCE.ItemValidatedSuccessfully(),
                                    NotificationEvent.NotificationType.SUCCESS));
                        } else {
                            ValidationPopup.showMessages(results);
                        }
                    }
                }, new DefaultErrorCallback()).validate(
                        versionRecordManager.getCurrentPath(),
                        view.getContent());
            }
        };
    }

    protected void save() {
        new SaveOperationService().save(versionRecordManager.getCurrentPath(),
                new CommandWithCommitMessage() {
                    @Override
                    public void execute(final String commitMessage) {
                        view.showBusyIndicator(CommonConstants.INSTANCE.Saving());
                        service.call(getSaveSuccessCallback(),
                                new HasBusyIndicatorDefaultErrorCallback(view)).save(
                                versionRecordManager.getCurrentPath(),
                                model,
                                metadata,
                                commitMessage);
                    }
                }
        );
        concurrentUpdateSessionInfo = null;
    }

    @IsDirty
    public boolean isDirty() {
        return view.isDirty();
    }

    @OnClose
    public void onClose() {
        this.versionRecordManager.clear();
        this.oracleFactory.destroy(oracle);
    }

    @OnMayClose
    public boolean checkIfDirty() {
        if (isDirty()) {
            return view.confirmClose();
        }
        return true;
    }

    @WorkbenchPartTitle
    public String getTitle() {
        String fileName = FileNameUtil.removeExtension(
                versionRecordManager.getCurrentPath(),
                type);
        if (versionRecordManager.getVersion() != null) {
            fileName = fileName + " v" + versionRecordManager.getVersion();
        }
        return GuidedDecisionTableConstants.INSTANCE.GuidedDecisionTableEditorTitle() + " [" + fileName + "]";
    }

    @WorkbenchPartView
    public IsWidget getWidget() {
        return multiPage;
    }

    @WorkbenchMenu
    public Menus getMenus() {
        return menus;
    }

}
