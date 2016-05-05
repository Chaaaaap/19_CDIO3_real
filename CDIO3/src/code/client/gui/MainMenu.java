package code.client.gui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import code.client.CDIO3;
import code.client.service.ServiceClient;
import code.shared.OperatoerDTO;

public class MainMenu extends Composite {

	private static MainMenuUiBinder uiBinder = GWT.create(MainMenuUiBinder.class);

	interface MainMenuUiBinder extends UiBinder<Widget, MainMenu> {
	}
	
	private ServiceClient client;
	private OperatoerDTO oprLoggedIn;
	
	public MainMenu(ServiceClient client, OperatoerDTO oprLoggedIn) {
		initWidget(uiBinder.createAndBindUi(this));
		this.client = client;
		this.oprLoggedIn = oprLoggedIn;
	}
	
	@UiField
	Button afvej;
	
	@UiHandler("afvej")
	void afvej(ClickEvent e) {
		CDIO3.clearContent();
		Afvej afvejPage = new Afvej();
		CDIO3.attachContent(afvejPage);
	}

	@UiField
	Button skiftPassword;
	
	@UiHandler("skiftPassword")
	void changePassword(ClickEvent e) {
		CDIO3.clearContent();
		SkiftPassword skiftPassword = new SkiftPassword(client, oprLoggedIn);
		CDIO3.attachContent(skiftPassword);
	}
	
	@UiField
	Button adminBrugere;
	
	@UiHandler("adminBrugere")
	void adminBrugere(ClickEvent e) {
		CDIO3.clearContent();
		AdminBrugere admin = new AdminBrugere(client);
		CDIO3.attachContent(admin);
	}
	
	@UiField
	Button logout;
	
	@UiHandler("logout")
	void logout(ClickEvent e) {
		client.logout();
	}

	public void hide() {
		afvej.setVisible(false);
		adminBrugere.setVisible(false);
		skiftPassword.setVisible(false);
		logout.setVisible(false);
	}
	
	public void show() {
		afvej.setVisible(true);
		adminBrugere.setVisible(true);
		skiftPassword.setVisible(true);
		logout.setVisible(true);
	}
}
