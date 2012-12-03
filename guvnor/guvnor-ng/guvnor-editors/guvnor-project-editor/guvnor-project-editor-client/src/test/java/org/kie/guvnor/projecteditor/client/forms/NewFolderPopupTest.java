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

package org.kie.guvnor.projecteditor.client.forms;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.uberfire.backend.vfs.Path;
import org.uberfire.client.workbench.widgets.events.ClosePlaceEvent;
import org.uberfire.shared.mvp.PlaceRequest;

import javax.enterprise.event.Event;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class NewFolderPopupTest {

    private NewFolderPopup popup;
    private NewFolderPopupView view;
    private NewFolderPopupView.Presenter presenter;
    private NewFolderPopupTest.MockClosePlaceEvent closeEvent;
    private MockFileServiceCaller fileServiceCaller;
    private NewFolderPopupTest.MockFocusFileEvent focusFileEvent;

    @Before
    public void setUp() throws Exception {
        view = mock(NewFolderPopupView.class);
        closeEvent = mock(MockClosePlaceEvent.class);
        focusFileEvent = mock(MockFocusFileEvent.class);
        fileServiceCaller = new MockFileServiceCaller();
        popup = new NewFolderPopup(
                fileServiceCaller,
                view,
                closeEvent,
                focusFileEvent);

        presenter = popup;
    }

    @Test
    public void testPresenter() throws Exception {
        verify(view).setPresenter(presenter);
    }


    @Test
    public void testCreateFolder() throws Exception {
        Path path = mock(Path.class);
        fileServiceCaller.setNewPathToReturn(path);
        PlaceRequest placeRequest = mock(PlaceRequest.class);
        popup.init(placeRequest);

        presenter.onNameChange("newToRoot");

        presenter.onOk();

        ArgumentCaptor<FocusFileEvent> focusFileEventArgumentCaptor = ArgumentCaptor.forClass(FocusFileEvent.class);
        verify(focusFileEvent).fire(focusFileEventArgumentCaptor.capture());
        assertEquals("newToRoot", focusFileEventArgumentCaptor.getValue().getFileName());
    }

    //TODO Test if the folder already exists and warn the user -Rikkola-

    @Test
    public void testCancel() throws Exception {
        PlaceRequest placeRequest = mock(PlaceRequest.class);
        popup.init(placeRequest);

        presenter.onCancel();

        ArgumentCaptor<ClosePlaceEvent> closePlaceEventArgumentCaptor = ArgumentCaptor.forClass(ClosePlaceEvent.class);
        verify(closeEvent).fire(closePlaceEventArgumentCaptor.capture());

        assertEquals(placeRequest, closePlaceEventArgumentCaptor.getValue().getPlace());
    }

    abstract class MockClosePlaceEvent
            implements Event<ClosePlaceEvent> {
    }

    abstract class MockFocusFileEvent
            implements Event<FocusFileEvent> {
    }
}
