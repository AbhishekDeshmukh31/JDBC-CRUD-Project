package com.tka.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.tka.dao.IPLDao;
import com.tka.entity.Player;

public class IPLService {
	IPLDao dao = null;

	public List<Player> getallplayerService() throws SQLException {

		dao = new IPLDao();
		List<Player> allplayerlist = dao.getallplayer();
		return allplayerlist;
	}

	public List<Player> getplayerbytname(String n) throws SQLException {

		dao = new IPLDao();
		List<Player> list = dao.getplayerbyteam(n);

		return list;
	}

	public String addplayerService(int jerseyno, String name, int runs, int wickets, String teamname)
			throws SQLException {

		String result = null;
		dao = new IPLDao();
		List<Player> currentlist = dao.getallplayer();
		int count = 0;
		for (Player player : currentlist) {
			if (player.getName().equalsIgnoreCase(name)) {
				count++;
			}
		}
		if (count == 0) {
			result = dao.insertplayer(jerseyno, name, runs, wickets, teamname);
		} else {
			result = "Player already present";
		}
		return result;
	}

	public String updateplayerDataService(int j, String n, int r, int w, String tn) {
		dao = new IPLDao();

		String result = dao.updatePlayerData(j, n, r, w, tn);
		return result;
	}

	public String updateplayernameService(int j, String n) {
		dao = new IPLDao();

		String result = dao.updatePlayername(j, n);
		return result;
	}

	public String updateplayerrunsService(int j, int r) {
		dao = new IPLDao();

		String result = dao.updatePlayerruns(j, r);
		return result;
	}

	public String updateplayerwicketsService(int j, int w) {
		dao = new IPLDao();

		String result = dao.updatePlayerwickets(j, w);
		return result;
	}

	public String updateplayerteamnameService(int j, String tn) {
		dao = new IPLDao();

		String result = dao.updatePlayerteamname(j, tn);
		return result;
	}

	public String updateplayerjerseyService(int j, int nj) {
		dao = new IPLDao();

		String result = dao.updatePlayerjerseyno(j, nj);
		return result;
	}

	public String deleteplayerService(int n) {
		dao = new IPLDao();

		String result = dao.deleteplayer(n);
		return result;
	}

}
