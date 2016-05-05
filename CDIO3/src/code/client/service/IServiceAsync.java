package code.client.service;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import code.shared.OperatoerDTO;

public interface IServiceAsync {

	
	
	public void createUser(int oprID, String navn, String ini, String cpr, String password, String gentagPassword, AsyncCallback callback);
	public void editUser(int oprID, String navn, String ini, String cpr, String password, AsyncCallback callback);
	public void deactivateUser(OperatoerDTO opr, AsyncCallback callback);
	public void activateUser(OperatoerDTO opr, AsyncCallback callback);
	public void getOperatoer(int oprID, AsyncCallback callback);
	public void getOperatoerer(AsyncCallback<List<OperatoerDTO>> callback);
	public void login(int name, String password, AsyncCallback<OperatoerDTO> callback);
	public void logout(AsyncCallback<OperatoerDTO> asyncCallback);
	public void editPassword(int oprID, String navn, String ini, String cpr, String password, AsyncCallback asyncCallback);
}
