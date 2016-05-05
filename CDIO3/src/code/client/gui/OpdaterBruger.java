package code.client.gui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Widget;

import code.client.service.ServiceClient;

public class OpdaterBruger extends Composite {

	private static OpdaterBrugerUiBinder uiBinder = GWT.create(OpdaterBrugerUiBinder.class);

	interface OpdaterBrugerUiBinder extends UiBinder<Widget, OpdaterBruger> {
	}

	private ServiceClient client;
	
	public OpdaterBruger(ServiceClient client) {
		initWidget(uiBinder.createAndBindUi(this));
		this.client = client;
		
		client.getOperatoerer();
		
	}
	
}
