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

import code.client.CDIO3;
import code.client.service.ServiceClient;
import code.shared.OperatoerDTO;

public class Login extends Composite {

	private static LoginUiBinder uiBinder = GWT.create(LoginUiBinder.class);

	interface LoginUiBinder extends UiBinder<Widget, Login> {
	}
	
	public interface LoginListener {
		void onLogin(OperatoerDTO opr);
	}
	
	CDIO3 entry;
	
	private ServiceClient client;
	
	public Login(ServiceClient client, LoginListener entry) {
		initWidget(uiBinder.createAndBindUi(this));
		
		this.client = client;
		this.entry = (CDIO3) entry;
	}
	
	@UiField
	Label nameLabel;
	
	@UiField
	TextBox nameBox;
	
	@UiField
	Label passwordLabel;
	
	@UiField
	PasswordTextBox passwordBox;
	
	@UiField
	Button submit;
	
	@UiHandler("submit")
	void login(ClickEvent e) {
		int name = Integer.parseInt(nameBox.getText());
		String password = passwordBox.getText();
		
		client.login(name, password);
		
	}
	
	

}
