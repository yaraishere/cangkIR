package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import main.Register;
import utils.Connect;

public class UserModel {

	public ArrayList<Register> getAllTransactions(){
		ArrayList<Register> uList= new ArrayList<>();
		String query = "SELECT * FROM msuser";
		ResultSet rs = Connect.getInstance().execQuery(query);
		
		if (uList != null) {
			try {
				while(rs.next()) {
					uList.add(new Register(
							rs.getString("UserID"),
								rs.getString("Username"),
								rs.getString("UserEmail"),
								rs.getString("UserPassword"),
								rs.getString("UserGender"),
								rs.getString("UserRole")
							));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return uList;
	}
	
}
