package code.server;

import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import code.client.service.IService;
import code.server.dal.OperatoerDAO;
import code.shared.OperatoerDTO;

@SuppressWarnings("serial")
public class ServiceImpl extends RemoteServiceServlet implements IService {

	
	private OperatoerDAO oprDAO;

	public ServiceImpl() {
		this.oprDAO = new OperatoerDAO();
	}
	@Override
	public void createUser(int oprID, String navn, String ini, String cpr, String password, String gentagPassword) throws Exception {
		oprDAO.addPerson(oprID, navn, ini, cpr, password, gentagPassword);
	}

	@Override
	public void editUser(int oprID, String navn, String ini, String cpr, String password) throws Exception {
		oprDAO.editPerson(oprID, navn, ini, cpr, password);
	}

	@Override
	public void deactivateUser(OperatoerDTO opr) throws Exception {
		oprDAO.deactivatePerson(opr);
	}

	@Override
	public void activateUser(OperatoerDTO opr) throws Exception {
		oprDAO.activatePerson(opr);
	}

	@Override
	public OperatoerDTO getOperatoer(int oprID) throws Exception {
		return oprDAO.getOperatoer(oprID);
	}
	
	@Override
	public OperatoerDTO login(int name, String password) throws Exception {
		OperatoerDTO opr = oprDAO.getOperatoer(name);
		if(opr!=null && opr.getPassword().equals(password)) {
			return opr;
		}
		throw new Exception("Enten findes brugeren ikke, ellers er koden forkert");
			
		
	}

	@Override
	public List<OperatoerDTO> getOperatoerer() throws Exception {
		List<OperatoerDTO> oprList = oprDAO.getOperatoerer();
		if(oprList.isEmpty())
			throw new Exception("Der er ingen brugere");
		else
			return oprList;
	}
	@Override
	public OperatoerDTO logout() throws Exception {
		return null;
	}
	
	@Override
	public void editPassword(int oprID, String navn, String ini, String cpr, String password) throws Exception {
		oprDAO.editPerson(oprID, navn, ini, cpr, password);
	}

}
