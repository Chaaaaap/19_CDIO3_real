package code.client.service;

import java.util.List;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;

import code.client.CDIO3;
import code.client.gui.Login.LoginListener;
import code.shared.OperatoerDTO;

public class ServiceClient {

	private IServiceAsync service;

	public ServiceClient(String url) {
		service = GWT.create(IService.class);
		ServiceDefTarget endpoint = (ServiceDefTarget) service;
		endpoint.setServiceEntryPoint(url);
	}

	public void createUser(int oprID, String navn, String ini, String cpr, String password, String gentagPassword) {
		service.createUser(oprID, navn, ini, cpr, password, gentagPassword, new AsyncCallback<OperatoerDTO>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert(caught.getMessage());
			}

			@Override
			public void onSuccess(OperatoerDTO result) {
				Window.alert("Brugeren er nu oprettet");
			}

		});

	}

	public void editUser(int oprID, String navn, String ini, String cpr, String password) {
		service.editUser( oprID,  navn,  ini,  cpr,  password, new AsyncCallback<OperatoerDTO>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onSuccess(OperatoerDTO result) {
				// TODO Auto-generated method stub

			}

		});

	}
	
	public void editPassword(int oprID, String navn, String ini, String cpr, String password) {
		service.editPassword( oprID,  navn,  ini,  cpr,  password, new AsyncCallback<OperatoerDTO>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onSuccess(OperatoerDTO result) {
				// TODO Auto-generated method stub

			}

		});

	}

	public void deactivateUser(OperatoerDTO opr) {
		service.deactivateUser(opr, new AsyncCallback<OperatoerDTO>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert(caught.getMessage());
			}

			@Override
			public void onSuccess(OperatoerDTO result) {
				// TODO Auto-generated method stub

			}

		});

	}

	public void activateUser() {
		service.getOperatoerer(new AsyncCallback<List<OperatoerDTO>>() {
			
			@Override
			public void onFailure(Throwable caught) {
				Window.alert(caught.getMessage());
			}

			@Override
			public void onSuccess(List<OperatoerDTO> result) {
				List<OperatoerDTO> oprList = result;
				for (int i = 0; i <= oprList.size(); i++) {
					if(i == 0) {
						HorizontalPanel hPanel = new HorizontalPanel();
						Label labelID = new Label("Operatør ID");
						Label labelNavn = new Label("Operatør navn");
						Label labelStatus = new Label("Status");
						Label labelSkift = new Label("Aktiver/deaktiver");
						
						labelID.setWidth("170px");
						labelNavn.setWidth("170px");
						labelStatus.setWidth("170px");
						labelSkift.setWidth("170px");
						
						hPanel.add(labelID);
						hPanel.add(labelNavn);
						hPanel.add(labelStatus);
						hPanel.add(labelSkift);
						
						CDIO3.attachContent(hPanel);
					} else {
						final OperatoerDTO opr = result.get(i);
						HorizontalPanel hPanel = new HorizontalPanel();
						
						final Label labelID = new Label(result.get(i).getOprID()+"");
						final Label labelNavn = new Label(result.get(i).getOprNavn());
						final Label labelStatus = new Label(result.get(i).isActive()+"");
						final Anchor deaktiver = new Anchor("Deaktiver");
						final Anchor aktiver = new Anchor("Aktiver");
						
						if(result.get(i).isActive() == 1) {
							aktiver.setVisible(false);
							labelStatus.setText("Aktiv");
						} else {
							deaktiver.setVisible(false);
							labelStatus.setText("Deaktiv");
						}
						
						labelID.setWidth("170px");
						labelNavn.setWidth("170px");
						labelStatus.setWidth("170px");
						
						deaktiver.addClickHandler(new ClickHandler() {

							@Override
							public void onClick(ClickEvent event) {
								
								
								service.deactivateUser(opr, new AsyncCallback<OperatoerDTO>() {

									@Override
									public void onFailure(Throwable caught) {
										Window.alert(caught.getMessage());
									}

									@Override
									public void onSuccess(OperatoerDTO result) {
										deaktiver.setVisible(false);
										aktiver.setVisible(true);
										labelStatus.setText("Deaktiv");
									}
									
								});
							}
							
						});
						
						aktiver.addClickHandler(new ClickHandler() {

							@Override
							public void onClick(ClickEvent event) {
								service.activateUser(opr, new AsyncCallback<OperatoerDTO>() {

									@Override
									public void onFailure(Throwable caught) {
										Window.alert(caught.getMessage());
									}

									@Override
									public void onSuccess(OperatoerDTO result) {
										deaktiver.setVisible(true);
										aktiver.setVisible(false);
										labelStatus.setText("Aktiv");
									}
									
								});
								
							}
							
						});
						
						hPanel.add(labelID);
						hPanel.add(labelNavn);
						hPanel.add(labelStatus);
						hPanel.add(deaktiver);
						hPanel.add(aktiver);
						
						CDIO3.attachContent(hPanel);
					}
				}
			}
			
		});

	}

	public void getOperatoer(int oprID) {
		service.getOperatoer(oprID, new AsyncCallback<OperatoerDTO>() {

			@Override
			public void onFailure(Throwable caught) {

			}

			@Override
			public void onSuccess(OperatoerDTO result) {

			}

		});

	}

	public void getOperatoerer() {
		service.getOperatoerer(new AsyncCallback<List<OperatoerDTO>>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Der skete en fejl");
			}

			@Override
			public void onSuccess(List<OperatoerDTO> result) {
				if(!result.isEmpty()) {
					for (int i = 0; i <= result.size(); i++) {
						if(i == 0)  {
							HorizontalPanel hPanel = new HorizontalPanel();
							Label labelID = new Label("Operatør ID");
							labelID.setWidth("187px");
							Label labelNavn = new Label("Operatør navn");
							labelNavn.setWidth("187px");
							Label labelIni = new Label("Initialer");
							labelIni.setWidth("187px");
							Label labelCpr = new Label("CPR-nummer");
							labelCpr.setWidth("187px");
							Label labelPassword = new Label("Password");
							labelPassword.setWidth("187px");

							hPanel.add(labelID);
							hPanel.add(labelNavn);
							hPanel.add(labelIni);
							hPanel.add(labelCpr);
							hPanel.add(labelPassword);

							hPanel.getElement().setAttribute("align", "center");

							CDIO3.attachContent(hPanel);
						} else {
							final OperatoerDTO opr = result.get(i-1);
							HorizontalPanel hPanel = new HorizontalPanel();
							final TextBox boxID = new TextBox();
							boxID.setEnabled(false);
							boxID.setText(opr.getOprID()+"");
							hPanel.add(boxID);
							
							final TextBox boxNavn = new TextBox();
							boxNavn.setEnabled(false);
							boxNavn.setText(opr.getOprNavn());
							hPanel.add(boxNavn);
							
							final TextBox boxIni = new TextBox();
							boxIni.setEnabled(false);
							boxIni.setText(opr.getIni());
							hPanel.add(boxIni);
							
							final TextBox boxCpr = new TextBox();
							boxCpr.setEnabled(false);
							boxCpr.setText(result.get(i-1).getCpr());
							hPanel.add(boxCpr);
							
							final PasswordTextBox boxPassword = new PasswordTextBox();
							boxPassword.setEnabled(false);
							boxPassword.setText(opr.getPassword());
							hPanel.add(boxPassword);
							
							final Button rediger = new Button("Rediger");
							hPanel.add(rediger);

							final Button ok = new Button("Gem");
							ok.setVisible(false);
							hPanel.add(ok);
							
							final Button annuller = new Button("Annuller");
							annuller.setVisible(false);
							hPanel.add(annuller);	

							rediger.addClickHandler(new ClickHandler() {

								@Override
								public void onClick(ClickEvent event) {
									rediger.setVisible(false);
									ok.setVisible(true);
									annuller.setVisible(true);
									boxNavn.setEnabled(true);
									boxIni.setEnabled(true);
									boxCpr.setEnabled(true);
									boxPassword.setEnabled(true);
								}

							});

							ok.addClickHandler(new ClickHandler() {

								@Override
								public void onClick(ClickEvent event) {
									if(Integer.parseInt(boxID.getText()) < 999999999 && Integer.parseInt(boxID.getText()) > 0 ) {
										rediger.setVisible(true);
										ok.setVisible(false);
										annuller.setVisible(false);
										boxNavn.setEnabled(false);
										boxIni.setEnabled(false);
										boxCpr.setEnabled(false);
										boxPassword.setEnabled(false);

										service.editUser(Integer.parseInt(boxID.getText()), boxNavn.getText(), boxIni.getText(),
												boxCpr.getText(), boxPassword.getText(), new AsyncCallback<OperatoerDTO>() {

											@Override
											public void onFailure(Throwable caught) {
												Window.alert("Ups! Noget gik galt");
											}

											@Override
											public void onSuccess(OperatoerDTO result) {
												// TODO Auto-generated method stub

											}

										});

									} else {
										Window.alert("Operatør ID skal bestå af tal");
									}
								}

							});

							annuller.addClickHandler(new ClickHandler() {

								@Override
								public void onClick(ClickEvent event) {

									rediger.setVisible(true);
									ok.setVisible(false);
									annuller.setVisible(false);
									boxID.setEnabled(false);
									boxID.setText(opr.getOprID()+"");
									boxNavn.setEnabled(false);
									boxNavn.setText(opr.getOprNavn());
									boxIni.setEnabled(false);
									boxIni.setText(opr.getIni());
									boxCpr.setEnabled(false);
									boxCpr.setText(opr.getCpr());
									boxPassword.setEnabled(false);
									boxPassword.setText(opr.getPassword());

								}

							});

							CDIO3.attachContent(hPanel);
						}

					}
				} else {
					Window.alert("Der er ingen brugere!");					
				}
			}
		});
	}

	public void login(int name, String password) {
		service.login(name, password, new AsyncCallback<OperatoerDTO>() {
//			final CDIO3 listener = (CDIO3) enter;
			@Override
			public void onFailure(Throwable caught) {
				Window.alert(caught.getMessage());
			}

			@Override
			public void onSuccess(OperatoerDTO result) {
				if(result != null) {
					if(result.isActive() == 1) {
					Window.alert("Du er nu logget ind");
					CDIO3.clearContent();
					CDIO3.showMenu();
//					listener.onLogin(result);
					} else {
						Window.alert("Din bruger er deaktiveret");
					}
				} else {
					Window.alert("Forkert bruger ID eller password");
				}
			}
		});
	}

	public void logout() {
		service.logout(new AsyncCallback<OperatoerDTO>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert(caught.getMessage());
			}
			
			@Override
			public void onSuccess(OperatoerDTO result) {
				CDIO3.clearContent();
				CDIO3.hideMenu();
				CDIO3.showLogin();
			}
			
		});
	}
}
