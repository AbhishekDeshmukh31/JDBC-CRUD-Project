package com.tka.controller;

import java.sql.SQLException;
import java.util.List;

import com.tka.entity.Player;
import com.tka.service.IPLService;

public class IPLController {
	IPLService service = null;

	public List<Player> getallplayerController() throws SQLException {
		service = new IPLService();
		List<Player> allplayers = service.getallplayerService();

		return allplayers;
	}

	public List<Player> getplayerTeamnamecontroller(String n) throws SQLException {
		service = new IPLService();
		List<Player> playerteam = service.getplayerbytname(n);
		return playerteam;
	}

	public String insertplayerController(int j, String n, int r, int w, String tn) throws SQLException {
		String result = null;
		service = new IPLService();
		result = service.addplayerService(j, n, r, w, tn);
		return result;
	}

	public String upadteplayerdataController(int j, String n, int r, int w, String tn) throws SQLException {
		String result = null;
		service = new IPLService();
		result = service.updateplayerDataService(j, n, r, w, tn);
		return result;
	}

	public String upadteplayernameController(int j, String n) throws SQLException {
		String result = null;
		service = new IPLService();
		result = service.updateplayernameService(j, n);
		return result;
	}

	public String upadteplayerrunsController(int j, int r) throws SQLException {
		String result = null;
		service = new IPLService();
		result = service.updateplayerrunsService(j, r);
		return result;
	}

	public String upadteplayerwicketsController(int j, int w) throws SQLException {
		String result = null;
		service = new IPLService();
		result = service.updateplayerwicketsService(j, w);
		return result;
	}

	public String upadteplayerteamnameController(int j, String tn) throws SQLException {
		String result = null;
		service = new IPLService();
		result = service.updateplayerteamnameService(j, tn);
		return result;
	}

	public String upadteplayerjerseyController(int j, int nj) throws SQLException {
		String result = null;
		service = new IPLService();
		result = service.updateplayerjerseyService(j, nj);
		return result;
	}

	public String deleteplayerController(int n) {
		String result = null;
		service = new IPLService();
		result = service.deleteplayerService(n);
		return result;
	}

}
