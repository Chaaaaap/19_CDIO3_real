package code.client.gui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import code.client.service.ServiceClient;

public class OpretBruger extends Composite {

	private static OpretBrugerUiBinder uiBinder = GWT.create(OpretBrugerUiBinder.class);

	interface OpretBrugerUiBinder extends UiBinder<Widget, OpretBruger> {
	}
	
	private ServiceClient client;

	public OpretBruger(ServiceClient client) {
		initWidget(uiBinder.createAndBindUi(this));
		this.client = client;
	}
	
	@UiField
	Label labelID;
	
	@UiField
	TextBox boxID;
	
	@UiField
	Label labelNavn;
	
	@UiField
	TextBox boxNavn;
	
	@UiField
	Label labelIni;
	
	@UiField
	TextBox boxIni;
	
	@UiField
	Label labelCPR;
	
	@UiField
	TextBox boxCPR;
	
	@UiField
	Label labelPassword;
	
	@UiField
	PasswordTextBox boxPassword;
	
	@UiField
	Label labelGentagPassword;
	
	@UiField
	PasswordTextBox boxGentagPassword;
	
	@UiField
	Button submit;
	
	@UiHandler("submit")
	void opretBruger(ClickEvent e) {
		int oprID = Integer.parseInt(boxID.getText());
		String navn = boxNavn.getText();
		String ini = boxIni.getText();
		String cpr = boxCPR.getText();
		String password = boxPassword.getText();
		String gentagPassword = boxGentagPassword.getText();
		
		client.createUser(oprID, navn, ini, cpr,  password, gentagPassword);
	}

}
