package controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnDB {

	public final static String STRDRIVER = "com.mysql.jdbc.Driver";
	public final static String STRCONNDB = "jdbc:mysql://localhost:3306:/prodotto";
	public final static String STRUTENTEADMIN = "root";
	public final static String STRPAS = "";

	public void connectionDB(Connection cons) throws SQLException {
		try {
			Class.forName(STRDRIVER);
			System.out.println("Driver caricato");
			cons = DriverManager.getConnection(STRCONNDB, STRUTENTEADMIN, STRPAS);
			System.out.println("Connessione effettuata");
		}catch(Exception e) {
			System.out.println(e);
			Connection conn = null;
			conn.close();
		}
	}

	public void closeConn(Connection conn) throws SQLException {
		conn.close();
		System.out.println("Connessione chiusa");
	}
}