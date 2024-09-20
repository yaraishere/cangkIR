package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {

	private Connection conn;
	private Statement st;
	private static Connect dbManager;
	private final static String HOST = "localhost:3306";
	private final static String USERNAME = "root";
	private final static String PASSWORD = "";
	private final static String DATABASE = "cangkIR";
	private final static String CONNECTION = String.format("jdbc:mysql://%s/%s", HOST, DATABASE);
	
	public Connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD);
			st = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connect getInstance() {
		if (dbManager == null) {
			dbManager = new Connect();
		}
		return dbManager;
	}
	
	public ResultSet execQuery(String query) {
		try {
			st.executeQuery(query);
			return st.getResultSet();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void execUpdate (String query) {
		try {
			st.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection connect() throws SQLException {
		return DriverManager.getConnection(CONNECTION,USERNAME, PASSWORD);
	}
	
	public static String getUsername(String Username) {
		String query = String.format("SELECT Username FROM msuser WHERE Username = ? ");
		
		try {
			Connection connection = connect();
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, Username);
			ResultSet result = ps.executeQuery();
			if(result.next()) {
				return result.getString("Username");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return Username;
	}
	
}
