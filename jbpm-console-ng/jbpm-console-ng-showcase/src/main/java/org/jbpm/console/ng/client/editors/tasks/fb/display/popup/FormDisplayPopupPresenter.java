/*
 * Copyright 2011 JBoss Inc 
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jbpm.console.ng.client.editors.tasks.fb.display.popup;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import org.jboss.errai.bus.client.api.RemoteCallback;
import org.jboss.errai.ioc.client.api.Caller;
import org.jbpm.console.ng.shared.TaskServiceEntryPoint;
import org.jbpm.console.ng.shared.fb.FormServiceEntryPoint;
import org.jbpm.console.ng.shared.fb.events.FormRenderedEvent;
import org.uberfire.client.annotations.OnReveal;
import org.uberfire.client.annotations.WorkbenchPartTitle;
import org.uberfire.client.annotations.WorkbenchPartView;
import org.uberfire.client.annotations.WorkbenchPopup;
import org.uberfire.client.mvp.PlaceManager;
import org.uberfire.client.mvp.UberView;
import org.uberfire.security.Identity;
import org.uberfire.shared.mvp.PlaceRequest;

@Dependent
@WorkbenchPopup(identifier = "Form Display Popup")
public class FormDisplayPopupPresenter {

    @Inject
    private FormBuilderView view;
    @Inject
    private Caller<FormServiceEntryPoint> formServices;
    @Inject
    private Caller<TaskServiceEntryPoint> taskServices;
    @Inject
    private Event<FormRenderedEvent> formRendered;
    @Inject
    private Identity identity;
    @Inject
    private PlaceManager                     placeManager;
    
    
    public interface FormBuilderView
            extends
            UberView<FormDisplayPopupPresenter> {

       

        void displayNotification(String text);
        
 
        
        long getTaskId();
        void setTaskId(long taskId);
    }

    @PostConstruct
    public void init() {
        publish(this);
        publishGetFormValues();
    }

    public void renderForm(long taskId) {

        formServices.call(new RemoteCallback<String>() {
            @Override
            public void callback(String form) {

                formRendered.fire(new FormRenderedEvent(form));
            }
        }).getFormDisplay(taskId);

    }

    @WorkbenchPartTitle
    public String getTitle() {
        return "Form Display";
    }

    @WorkbenchPartView
    public UberView<FormDisplayPopupPresenter> getView() {
        return view;
    }

    public void completeTask(String values) {
        final Map<String, Object> params = getUrlParameters(values);
        taskServices.call(new RemoteCallback<Void>() {
            @Override
            public void callback(Void nothing) {
                view.displayNotification("Form for Task Id: " + params.get("taskId") + " was completed!");

            }
        }).complete(Long.parseLong(params.get("taskId").toString()), identity.getName(), params);

    }
    
    public void startTask(String values) {
        final Map<String, Object> params = getUrlParameters(values);
        taskServices.call(new RemoteCallback<Void>() {
            @Override
            public void callback(Void nothing) {
                view.displayNotification("Task Id: " + params.get("taskId") + " was started!");

            }
        }).start(Long.parseLong(params.get("taskId").toString()), identity.getName());

    }

    // Set up the JS-callable signature as a global JS function.
    private native void publish(FormDisplayPopupPresenter fdp);

    private native void publishGetFormValues() /*-{
     $wnd.getFormValues = function(form){
     var params = '';
     for(i=0; i<form.elements.length; i++)
     {
     var fieldName = form.elements[i].name;
     var fieldValue = form.elements[i].value;
     params += fieldName + '=' + fieldValue + '&';
     }
     return params;
     };
      
     }-*/;

    public static Map<String, Object> getUrlParameters(String values) {
        Map<String, Object> params = new HashMap<String, Object>();
        for (String param : values.split("&")) {
            String pair[] = param.split("=");
            String key = pair[0];
            String value = "";
            if (pair.length > 1) {
                value = pair[1];
            }
            params.put(key, value);
        }
        return params;
    }

    @OnReveal
    public void onReveal() {
        final PlaceRequest p = placeManager.getCurrentPlaceRequest();
        long taskId = Long.parseLong(p.getParameter("taskId", "0").toString());
        view.setTaskId(taskId);
        renderForm(taskId);
    }
}
