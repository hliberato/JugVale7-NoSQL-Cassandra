package jdbc;

import java.sql.*;

public class CassandraConnectionFactory {
	
	public Connection con = null;
	
	public Connection getConnection() throws ClassNotFoundException, SQLException{		

			// OBT�M O DRIVER DE CONEX�O
			Class.forName("org.apache.cassandra.cql.jdbc.CassandraDriver");
			con = DriverManager
					.getConnection("jdbc:cassandra://localhost:9160/jugkeyspace");
			
		//RETORNA A CONEX�O
		return con;
	}
}




