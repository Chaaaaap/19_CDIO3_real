package code.client.gui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class Afvej extends Composite {

	private static AfvejUiBinder uiBinder = GWT.create(AfvejUiBinder.class);

	interface AfvejUiBinder extends UiBinder<Widget, Afvej> {
	}

	public Afvej() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@UiField
	Label afvejLabel;

}
