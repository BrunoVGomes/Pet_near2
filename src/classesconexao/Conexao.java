package classesconexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	public class faz_conexao {

	}

	public static Connection faz_conexao() throws SQLException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			return DriverManager.getConnection("jdbc:mysql://localhost/trabalho_pi", "root", "123456");
			
		} catch (ClassNotFoundException e) {
			throw new SQLException(e.getException());
		}
	}
		
		
}
