package code.server.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import code.client.connector.Connector;
import code.shared.OperatoerDTO;

public class OperatoerDAO implements IOperatoerDAO {
	
	private List<OperatoerDTO> oprList;
	private Connector connector;
	
	public OperatoerDAO() {
		connector = new Connector();
	}
	
	public void addPerson(int oprID, String navn, String ini, String cpr, String password, String gentagPassword) throws Exception {
		try {
			connector.doUpdate(
					"INSERT INTO operatoer(opr_id, opr_navn, ini, cpr, password, aktiv, type) VALUES " +
					"(" + oprID + ", '" + navn + "', '" + ini + "', '" + 
					cpr + "', '" + password + "'"+", '1', 'administrator')"
				);
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void deactivatePerson(OperatoerDTO opr) throws Exception {
		try {
		connector.doUpdate(
				"UPDATE operatoer SET aktiv = '0' WHERE opr_ID = '"+ opr.getOprID() +"'");
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void activatePerson(OperatoerDTO opr) throws Exception {
		try {
			connector.doUpdate(
					"UPDATE operatoer SET aktiv = '1' WHERE opr_ID = '"+ opr.getOprID() +"'");
			} catch(Exception e) {
				throw new Exception(e.getMessage());
			}
	}

	@Override
	public void editPerson(int oprID, String navn, String ini, String cpr, String password) throws Exception {
		try {
			connector.doUpdate(
					"UPDATE operatoer SET opr_navn = '" + navn + "', ini =  '" + ini + 
					"', cpr = '" + cpr + "', password = '" + password + "' WHERE opr_id = " +
					oprID
			);
			
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void showPerson() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<OperatoerDTO> getOperatoerer() throws Exception {
		oprList = new ArrayList<>();
		try
		{
			ResultSet rs = connector.doQuery("SELECT * FROM operatoer");
			if(!rs.first()) throw new Exception("Listen er tom");
			do  
			{
				oprList.add(new OperatoerDTO(rs.getInt("opr_id"), rs.getString("opr_navn"), rs.getString("ini"), 
						rs.getString("cpr"), rs.getString("password"), Integer.parseInt(rs.getString("aktiv")), rs.getString("type")));
			}while (rs.next());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return oprList;
	}
	
	@Override
	public OperatoerDTO getOperatoer(int oprID) throws Exception{
		
	    try {
	    	ResultSet rs = connector.doQuery("SELECT * FROM operatoer WHERE opr_id = '" + oprID+"'");
	    	if (!rs.first()) throw new Exception("Operatoeren '" + oprID + "' findes ikke");
	    	return new OperatoerDTO (rs.getInt("opr_id"), rs.getString("opr_navn"), rs.getString("ini"), 
	    			rs.getString("cpr"), rs.getString("password"), Integer.parseInt(rs.getString("aktiv")), rs.getString("type"));
	    }
	    catch (Exception e) {
	    	throw new Exception(e.getMessage());
	    }
	}
	
	@Override
	public void login(int oprID, String password) {
		
	}

}
