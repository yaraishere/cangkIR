package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import main.HomeCupList;
import utils.Connect;

public class HomeCupListModel {
	public ArrayList<HomeCupList> getAllTransactions() {
		ArrayList<HomeCupList> cList = new ArrayList<>();
		String query = "SELECT * FROM msuser";
		ResultSet rs = Connect.getInstance().execQuery(query);

		if (cList != null) {
			try {
				while (rs.next()) {
					cList.add(new HomeCupList(
							rs.getString("CupID"), 
							rs.getString("CupName"), 
							rs.getInt("CupPrice")));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cList;
	}
}
