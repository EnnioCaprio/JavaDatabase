package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Giochi;

public class CRUD {
	public final static String STRDRIVER = "com.mysql.jdbc.Driver";
	public final static String STRCONNDB = "jdbc:mysql://127.0.0.1:3306/prodotto";
	public final static String STRUTENTEADMIN = "root";
	public final static String STRPASS = "";

	public boolean inserisciProdotto(Giochi g) throws SQLException{
		try {
			Class.forName(STRDRIVER);
		}catch(Exception e) {
			System.out.println(e);
		}

		try {
			Connection cons;
			cons = DriverManager.getConnection(STRCONNDB, STRUTENTEADMIN, STRPASS);
			PreparedStatement ps = null;
			String sql = "INSERT INTO prodotti (gioco, prezzo) VALUE (?,?)";
			ps = cons.prepareStatement(sql);
			ps.setString(1, g.getGioco());
			ps.setDouble(2, g.getPrezzo());
			ps.executeUpdate();
			ps.close();
			cons.close();
			return true;
		}catch(Exception e)
		{
			System.out.println(e);
			return false;

		}


	}

	public boolean aggiornaProdotto(Giochi g) throws SQLException{
		try {
			Class.forName(STRDRIVER);
		}catch(Exception e) {
			System.out.println(e);
		}

		try {
			Connection cons;
			cons = DriverManager.getConnection(STRCONNDB, STRUTENTEADMIN, STRPASS);
			PreparedStatement pState = null;
			String sql = "UPDATE prodotti SET prodotto = ?, prezzo = ? where id = ?";
			pState = cons.prepareStatement(sql);
			pState.setString(1, g.getGioco());
			pState.setDouble(2, g.getPrezzo() );
			pState.setInt(3, g.getId());
			pState.executeUpdate();
			pState.close();
			cons.close();
			return true;
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public boolean eliminaProdotto(Giochi g) throws SQLException {		
		try {
			Class.forName(STRDRIVER);
		}catch(Exception e) {
			System.out.println(e);
		}

		try {
			Connection cons;
			cons = DriverManager.getConnection(STRCONNDB, STRUTENTEADMIN, STRPASS);
			PreparedStatement pState = null;
			String sql = "DELETE FROM prodotti Where id = ?";
			pState = cons.prepareStatement(sql);
			pState.setString(1, g.getGioco());
			pState.executeUpdate();
			pState.close();
			cons.close();
			return true;
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public boolean eliminaProdottiEPulisci(Giochi g) throws SQLException {		
		try {
			Class.forName(STRDRIVER);
		}catch(Exception e) {
			System.out.println(e);
		}

		try {
			Connection cons;
			cons = DriverManager.getConnection(STRCONNDB, STRUTENTEADMIN, STRPASS);
			PreparedStatement pState = null;
			String sql = "TRUNCATE TABLE prodotti";
			pState = cons.prepareStatement(sql);
			pState.executeUpdate();
			pState.close();
			cons.close();
			return true;
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public boolean leggiProdotto(Giochi g) throws SQLException {
		try {
			Class.forName(STRDRIVER);
		}catch(Exception e) {
			System.out.println(e);
		}

		try {
			Connection cons;
			cons = DriverManager.getConnection(STRCONNDB, STRUTENTEADMIN, STRPASS);
			Statement s = cons.createStatement();
			String query = "SELECT * FROM Prodotti";

			ResultSet rs = s.executeQuery(query);
			
			

			while (rs.next()) {
				String prodotti = g.getGioco();
				
				

				System.out.println(rs.getString(1) + " -- " + rs.getString(2) + " -- " + rs.getString(3));

			}
			s.close();
			cons.close();
			return true;
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}

}
