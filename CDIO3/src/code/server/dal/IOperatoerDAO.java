package code.server.dal;

import java.util.List;

import code.shared.OperatoerDTO;



public interface IOperatoerDAO {
	
	@SuppressWarnings("serial")
	public class DALException extends Exception {
		public DALException(String msg) {
			super(msg);
		}
	}
	
	public List<OperatoerDTO> getOperatoerer() throws Exception;
	public OperatoerDTO getOperatoer(int oprID) throws Exception; 
	public void addPerson(int oprID, String navn, String ini, String cpr, String password, String gentagPassword) throws Exception;
	public void deactivatePerson(OperatoerDTO opr) throws Exception;
	public void activatePerson(OperatoerDTO opr) throws Exception;
	public void editPerson(int oprID, String navn, String ini, String cpr, String password) throws Exception;
	public void showPerson() throws Exception;
	public void login(int oprID, String password) throws Exception;
}
