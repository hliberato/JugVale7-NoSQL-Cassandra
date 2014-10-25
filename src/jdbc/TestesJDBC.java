package jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class TestesJDBC {	
	
	@Test
	public void testeInsert() throws ClassNotFoundException, SQLException{
		CassandraConnectionFactory ccf = new CassandraConnectionFactory();
		String sql = "insert into usersJug (user_key,name,email)" +
                	 " values (?,?,?)";
        PreparedStatement stmt = ccf.getConnection().prepareStatement(sql);

        // PREENCHENDO OS VALORES
        stmt.setString(1, "01");
        stmt.setString(2, "Joaozinho");
        stmt.setString(3, "jo@ozinho.com");

        // EXECUTA
        stmt.execute();
        stmt.close();
	}
	
	@Test
	public void testeSelect() throws SQLException, ClassNotFoundException{	
		CassandraConnectionFactory ccf = new CassandraConnectionFactory();
		
		//QUERY CQL QUE SERÁ EXECUTADA
		String query =  "select * from usersJug";
		
		Statement stmt = ccf.getConnection().createStatement();		
		ResultSet rs = stmt.executeQuery(query); 
		
		// ITERAÇÃO SOBRE TODOS OS ITENS OBTIDOS
		while (rs.next()){
			System.out.println(	rs.getInt("user_key")+" | "+
								rs.getString("name")+" | "+
								rs.getString("email"));
			System.out.println(System.lineSeparator());
		}
		stmt.close();
	}
}
