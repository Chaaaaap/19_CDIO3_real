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

public class AdminBrugere extends Composite {

	private static AdminBrugereUiBinder uiBinder = GWT.create(AdminBrugereUiBinder.class);

	interface AdminBrugereUiBinder extends UiBinder<Widget, AdminBrugere> {
	}
	
	private ServiceClient client;

	public AdminBrugere(ServiceClient client) {
		initWidget(uiBinder.createAndBindUi(this));
		this.client = client;
		CDIO3.hideMenu();
	}

	@UiField
	Button opret;
	
	@UiField
	Button opdater;
	
	@UiField
	Button aktiver;
	
	@UiField
	Button tilbage;
	
	@UiHandler("opret")
	void opret(ClickEvent e) {
		CDIO3.clearContent();
		CDIO3.attachContent(this);
		OpretBruger opret = new OpretBruger(client);
		CDIO3.attachContent(opret);
	}
	
	@UiHandler("opdater")
	void opdater(ClickEvent e) {
		CDIO3.clearContent();
		CDIO3.attachContent(this);
		OpdaterBruger opdater = new OpdaterBruger(client);
		CDIO3.attachContent(opdater);
	}
	
	@UiHandler("aktiver")
	void aktiver(ClickEvent e) {
		CDIO3.clearContent();
		CDIO3.attachContent(this);
		Aktiver aktiver = new Aktiver(client);
		CDIO3.attachContent(aktiver);
	}
	
	@UiHandler("tilbage")
	void tilbage(ClickEvent e) {
		CDIO3.clearContent();
		CDIO3.showMenu();
	}
}
