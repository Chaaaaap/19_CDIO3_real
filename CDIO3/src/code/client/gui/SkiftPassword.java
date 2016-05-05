package code.client.gui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.Widget;

import code.client.service.ServiceClient;
import code.shared.OperatoerDTO;

public class SkiftPassword extends Composite {

	private static SkiftPasswordUiBinder uiBinder = GWT.create(SkiftPasswordUiBinder.class);

	interface SkiftPasswordUiBinder extends UiBinder<Widget, SkiftPassword> {
	}

	private ServiceClient client;

	private OperatoerDTO oprLoggedIn;

	public SkiftPassword(ServiceClient client, OperatoerDTO oprLoggedIn) {
		initWidget(uiBinder.createAndBindUi(this));
		this.client = client;
		this.oprLoggedIn = oprLoggedIn;
	}
	
	@UiField
	Label glPassLabel;
	
	@UiField
	PasswordTextBox glPassBox;
	
	@UiField
	Label nyPassLabel;
	
	@UiField
	PasswordTextBox nyPassBox;
	
	@UiField
	Label gentagLabel;
	
	@UiField
	PasswordTextBox gentagPassBox;
	
	@UiField
	Button submit;
	
	@UiHandler("submit")
	void submitPassword(ClickEvent e) {
		Window.alert(oprLoggedIn+"");
		client.editUser(oprLoggedIn.getOprID(), oprLoggedIn.getOprNavn(), oprLoggedIn.getIni(), oprLoggedIn.getCpr(), oprLoggedIn.getPassword());
	}

}
