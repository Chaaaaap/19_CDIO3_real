package code.client.gui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import code.client.service.ServiceClient;

public class Aktiver extends Composite {

	private static AktiverUiBinder uiBinder = GWT.create(AktiverUiBinder.class);

	interface AktiverUiBinder extends UiBinder<Widget, Aktiver> {
	}

	public Aktiver(ServiceClient client) {
		initWidget(uiBinder.createAndBindUi(this));
		
		client.activateUser();
	}

}
