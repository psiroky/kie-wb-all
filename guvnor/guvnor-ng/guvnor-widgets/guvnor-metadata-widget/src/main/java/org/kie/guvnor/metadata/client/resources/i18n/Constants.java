package org.kie.guvnor.metadata.client.resources.i18n;

import java.util.Date;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.Messages;

/**
 *
 */
public interface Constants extends
                           Messages {

    public static final Constants INSTANCE = GWT.create( Constants.class );

    String Title();

    String Metadata();

    String LastModified();

    String ModifiedByMetaData();

    String NoteMetaData();

    String CreatedOnMetaData();

    String CreatedByMetaData();

    String IsDisabledMetaData();

    String DisableTip();

    String FormatMetaData();

    String OtherMetaData();

    String AShortDescriptionOfTheSubjectMatter();

    String TypeMetaData();

    String TypeTip();

    String ExternalLinkMetaData();

    String ExternalLinkTip();

    String SourceMetaData();

    String SourceMetaDataTip();

    String VersionHistory();

    String SubjectMetaData();

    String CategoriesMetaData();

    String AssetCategoryEditorAddNewCategory();

    String AddANewCategory();

    String OK();

    String SelectCategoryToAdd();

    String RemoveThisCategory();

    String PleaseWait();

    String NoCategoriesCreatedYetTip();

    String Refresh();

    String NewItem();

    String Trash();

    String RuleDocHint();

    String Description();

    String documentationDefault();

    String Discussion();

    String AddADiscussionComment();

    String EraseAllComments();

    String EraseAllCommentsWarning();

    String Cancel();

    String smallCommentBy0On1Small( final String author,
                                    final Date date );

    String ImportedTypes();

    String FactTypesJarTip();

    String AreYouSureYouWantToRemoveThisFactType();

    String ChooseAFactType();

    String loadingList();

    String ChooseClassType();

    String TypesInThePackage();

    String IfNoTypesTip();

    String EnteringATypeClassName();

    String EnterTypeNameTip();

    String advancedClassName();

    String AdvancedView();

    String SwitchToTextModeEditing();

    String SwitchToAdvancedTextModeForPackageEditing();

    String BasicView();

    String SwitchToGuidedModeEditing();

    String CanNotSwitchToBasicView();

    String CanNotSwitchToBasicViewDeclaredTypes();

    String CanNotSwitchToBasicViewFunctions();

    String CanNotSwitchToBasicViewRules();

    String SwitchToGuidedModeForPackageEditing();

    String ConfigurationSection();

    String Configuration();

    String NewItemDisabled();

    String Home();
}
