package org.jbpm.designer.client.popups;

import com.github.gwtbootstrap.client.ui.Modal;
import com.github.gwtbootstrap.client.ui.constants.BackdropType;
import com.github.gwtbootstrap.client.ui.event.HiddenEvent;
import com.github.gwtbootstrap.client.ui.event.HiddenHandler;
import com.github.gwtbootstrap.client.ui.event.ShowEvent;
import com.github.gwtbootstrap.client.ui.event.ShowHandler;
import com.google.gwt.core.client.GWT;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import org.uberfire.client.workbench.widgets.common.ModalFooterOKButton;
import org.uberfire.mvp.Command;

/**
 * A popup that shows an error message
 */
public class ErrorPopup extends Modal {

    interface ErrorPopupWidgetBinder
            extends
            UiBinder<Widget, ErrorPopup> {

    }

    private static ErrorPopupWidgetBinder uiBinder = GWT.create( ErrorPopupWidgetBinder.class );

    private static ErrorPopup instance = new ErrorPopup();

    @UiField
    protected HTML message;

    private ErrorPopup() {
        setTitle( "Error" );
        setMaxHeigth( ( Window.getClientHeight() * 0.75 ) + "px" );
        setBackdrop( BackdropType.STATIC );
        setKeyboard( true );
        setAnimation( true );
        setDynamicSafe( true );
        setHideOthers( false );

        add( uiBinder.createAndBindUi( this ) );
        add( new ModalFooterOKButton( new Command() {
            @Override
            public void execute() {
                hide();
            }
        } ) );
    }

    public void setMessage( final String message ) {
        this.message.setHTML( SafeHtmlUtils.fromTrustedString( message ) );
    }

    public static void showMessage( String message ) {
        instance.setMessage( message );
        instance.show();
    }

    public static void showMessage( final String msg,
                                    final Command afterShow,
                                    final Command afterClose ) {
        new ErrorPopup() {{
            setMessage( msg );
            addShowHandler( new ShowHandler() {
                @Override
                public void onShow( final ShowEvent showEvent ) {
                    if ( afterShow != null ) {
                        afterShow.execute();
                    }
                }
            } );
            addHiddenHandler( new HiddenHandler() {
                @Override
                public void onHidden( final HiddenEvent hiddenEvent ) {
                    if ( afterClose != null ) {
                        afterClose.execute();
                    }
                }
            } );
        }}.show();
    }

}
