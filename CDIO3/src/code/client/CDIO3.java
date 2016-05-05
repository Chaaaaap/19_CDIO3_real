package code.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import code.client.gui.Header;
import code.client.gui.Login;
import code.client.gui.Login.LoginListener;
import code.client.gui.MainMenu;
import code.client.service.ServiceClient;
import code.shared.OperatoerDTO;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class CDIO3 implements EntryPoint, LoginListener {

	private VerticalPanel vPanel = new VerticalPanel();
	private static VerticalPanel content = new VerticalPanel();
	private Header header = new Header();
	private static MainMenu menu;
	private static Login login;
	private static OperatoerDTO oprLoggedIn;
	static ServiceClient client;
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		client = new ServiceClient(GWT.getHostPageBaseURL()+"cdio3");
		login  = new Login(client, this);
		menu = new MainMenu(client, oprLoggedIn);
		
		vPanel.add(header);
		vPanel.add(menu);
		content.add(login);
		vPanel.add(content);
		
		menu.hide();
		
		content.getElement().setAttribute("align", "center");
		vPanel.getElement().setAttribute("align", "center");
		
		RootPanel.get().add(vPanel);
	}
	
	public static void attachContent(Widget w) {
		content.add(w);
	}
	
	public static void clearContent() {
		content.clear();
	}

	public static void hideMenu() {
		menu.hide();
	}
	
	public static void showMenu() {
		menu.show();
	}

	public void onLogin(OperatoerDTO opr) {
		clearContent();

		attachContent(menu);
	}

	public static void showLogin() {
		content.add(login);
	}

	public static void setOpr(OperatoerDTO result) {
		oprLoggedIn = result;
	}
}
