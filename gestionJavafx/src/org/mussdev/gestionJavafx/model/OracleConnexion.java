package org.mussdev.gestionJavafx.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;


public class OracleConnexion {
	public static Connection conDB = null;
	public static String utilisateur=null;
	public static String motpass=null;
	
	
	public static  Connection connectDB() throws SQLException {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin://@localhost:1521:xe";
			conDB = DriverManager.getConnection(url, utilisateur , motpass);
			return conDB;
		}catch(Exception e) {
			//JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
			
	
}
