package code.server.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import code.server.dal.OperatoerDAO;
import code.shared.OperatoerDTO;

public class OperatoerDAOTest {

	@Test
	public void testGetOperatoer() throws Exception {
		OperatoerDAO dao = new OperatoerDAO();
		OperatoerDTO opr = dao.getOperatoer(1);
		assertNotNull("Operator was null, check your database", opr);
	}
	
	@Test
	public void testGetOperatoerList() throws Exception {
		OperatoerDAO dao = new OperatoerDAO();
		List<OperatoerDTO> oprList = dao.getOperatoerer();
		assertNotNull("ArrayList was null, check your databse", oprList);
	}
	
	@Test
	public void testEditOperatoer() throws Exception {
		OperatoerDAO dao = new OperatoerDAO();
		dao.editPerson(1, "Søren", "S", "0011223344", "Test1234");
		OperatoerDTO opr = dao.getOperatoer(1);
		
		assertEquals("Søren", dao.getOperatoer(1).getOprNavn());
	}
	
	@Test
	public void testCreateOperatoer() throws Exception {
		OperatoerDAO dao = new OperatoerDAO();
		dao.addPerson(99, "Christian B", "CB", "2525258888", "Hej", "Hej");
		OperatoerDTO opr = dao.getOperatoer(99);
		
		assertNotNull("Operator was null, check your database", opr);
	}

}
