package com.tka.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.tka.entity.Player;
import com.tka.utility.IPLUtility;

public class IPLDao {

	Connection connection = null;
	Statement st = null;
	PreparedStatement pst = null;
	Player player = null;

	public List<Player> getallplayer() throws SQLException {
		connection = IPLUtility.getConnection();
		st = connection.createStatement();
		String selectquery = "SELECT * FROM iplplayermanagement.player;";
		ResultSet rs = st.executeQuery(selectquery);
		List<Player> allplayerlist = new ArrayList<Player>();

		while (rs.next()) {
			int jerseyno = rs.getInt("jerseyno");
			String name = rs.getString("name");
			int runs = rs.getInt("runs");
			int wickets = rs.getInt("wickets");
			String teamname = rs.getString("teamname");

			Player player = new Player(jerseyno, name, runs, wickets, teamname);

			allplayerlist.add(player);

		}
		return allplayerlist;
	}
	
	public List<Player> getplayerbyteam(String tn) throws SQLException {
		String selectquery = "SELECT * FROM iplplayermanagement.player where teamname =?";
		connection = IPLUtility.getConnection();
		pst = connection.prepareStatement(selectquery);
		pst.setString(1, tn);
		ResultSet rs = pst.executeQuery();
		List<Player> list = new ArrayList<Player>();

		while (rs.next()) {
			int jerseyno = rs.getInt("jerseyno");
			String name = rs.getString("name");
			int runs = rs.getInt("runs");
			int wickets = rs.getInt("wickets");
			String teamname = rs.getString("teamname");

			Player player = new Player(jerseyno, name, runs, wickets, teamname);

			list.add(player);

		}
		return list;
	}

	public String insertplayer(int jerseyno, String name, int runs, int wickets, String teamname) {

		String result = null;
		String addQuery = "INSERT INTO iplplayermanagement.player(jerseyno,name,runs,wickets,teamname)VALUES(?,?,?,?,?);";

		try {
			connection = IPLUtility.getConnection();
			pst = connection.prepareStatement(addQuery);

			pst.setInt(1, jerseyno);
			pst.setString(2, name);
			pst.setInt(3, runs);
			pst.setInt(4, wickets);
			pst.setString(5, teamname);

			int rowsaffected = pst.executeUpdate();

			if (rowsaffected > 0) {
				result = "Data Inserted Successfully";

			} else {
				result = "Data not inserted ! ";
			}
			return result;

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println("Error");
		}
		return result;
	}

	public String updatePlayerData(int jersey, String name, int runs, int wickets, String teamname) {

		String updatequery = "UPDATE iplplayermanagement.player SET name=?,runs=?,wickets=?,teamname=? WHERE jerseyno=? ";
		String result = null;
		try {
			connection = IPLUtility.getConnection();

			pst = connection.prepareStatement(updatequery);

			pst.setString(1, name);
			pst.setInt(2, runs);
			pst.setInt(3, wickets);
			pst.setString(4, teamname);
			pst.setInt(5, jersey);

			int rowsAffected = pst.executeUpdate();

			if (rowsAffected > 0) {
				result = "Player Updated Successfully";

			} else {
				result = "Player not updated successfully";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public String updatePlayername(int jersey, String name) {

		String updatequery = "UPDATE iplplayermanagement.player SET name=? WHERE jerseyno=? ";
		String result = null;
		try {
			connection = IPLUtility.getConnection();

			pst = connection.prepareStatement(updatequery);

			pst.setString(1, name);
			pst.setInt(2, jersey);

			int rowsAffected = pst.executeUpdate();

			if (rowsAffected > 0) {
				result = "Player Name Updated Successfully";

			} else {
				result = "Player name cannot be updated ";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public String updatePlayerruns(int jersey, int runs) {

		String updatequery = "UPDATE iplplayermanagement.player SET runs=? WHERE jerseyno=? ";
		String result = null;
		try {
			connection = IPLUtility.getConnection();

			pst = connection.prepareStatement(updatequery);

			pst.setInt(1, runs);
			pst.setInt(2, jersey);

			int rowsAffected = pst.executeUpdate();

			if (rowsAffected > 0) {
				result = "Player Runs data Updated Successfully";

			} else {
				result = "Player runs data cannot be updated ";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public String updatePlayerwickets(int jersey, int wickets) {

		String updatequery = "UPDATE iplplayermanagement.player SET wickets=? WHERE jerseyno=? ";
		String result = null;
		try {
			connection = IPLUtility.getConnection();

			pst = connection.prepareStatement(updatequery);

			pst.setInt(1, wickets);
			pst.setInt(2, jersey);

			int rowsAffected = pst.executeUpdate();

			if (rowsAffected > 0) {
				result = "Player wicket data Updated Successfully";

			} else {
				result = "Player wicket data cannot be updated ";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public String updatePlayerteamname(int jersey, String tname) {

		String updatequery = "UPDATE iplplayermanagement.player SET teamname=? WHERE jerseyno=? ";
		String result = null;
		try {
			connection = IPLUtility.getConnection();

			pst = connection.prepareStatement(updatequery);

			pst.setString(1, tname);
			pst.setInt(2, jersey);

			int rowsAffected = pst.executeUpdate();

			if (rowsAffected > 0) {
				result = "Player teamname Updated Successfully";

			} else {
				result = "Player teamname cannot be updated ";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public String updatePlayerjerseyno(int jersey, int njersey) {

		String updatequery = "UPDATE iplplayermanagement.player SET jerseyno=? WHERE jerseyno=? ";
		String result = null;
		try {
			connection = IPLUtility.getConnection();

			pst = connection.prepareStatement(updatequery);

			pst.setInt(1, njersey);
			pst.setInt(2, jersey);

			int rowsAffected = pst.executeUpdate();

			if (rowsAffected > 0) {
				result = "Player jersey number is changed Successfully";

			} else {
				result = "Player jersey number cannot be changed ";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public String deleteplayer(int jerseyno) {

		String result = null;
		String deleteQuery = "DELETE FROM iplplayermanagement.player where jerseyno=?";

		try {
			connection = IPLUtility.getConnection();
			pst = connection.prepareStatement(deleteQuery);

			pst.setInt(1, jerseyno);
			int rowsaffected = pst.executeUpdate();

			if (rowsaffected > 0) {
				result = "Data Deleted Successfully";
			} else {
				result = "Data not deleted ! ";
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return result;

	}
}
