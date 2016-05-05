package code.server.test;

import static org.junit.Assert.assertNotNull;

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

}
