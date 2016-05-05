package code.client.service;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import code.shared.OperatoerDTO;

@RemoteServiceRelativePath("cdio3")
public interface IService extends RemoteService {

	public void createUser(int oprID, String navn, String ini, String cpr, String password, String gentagPassword) throws Exception;
	public void editUser(int oprID, String navn, String ini, String cpr, String password) throws Exception;
	public void deactivateUser(OperatoerDTO opr) throws Exception;
	public void activateUser(OperatoerDTO opr) throws Exception;
	public OperatoerDTO getOperatoer(int oprID) throws Exception;
	public List<OperatoerDTO> getOperatoerer() throws Exception;
	public OperatoerDTO login(int name, String password) throws Exception;
	public OperatoerDTO logout() throws Exception;
	public void editPassword(int oprID, String navn, String ini, String cpr, String password) throws Exception;
}
