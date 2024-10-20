package com.tka.entity;

public class Player {

	private int jerseyno;
	private String name;
	private int runs;
	private int wickets;
	private String teamname;

	public Player() {
		super();
	}

	public Player(int jerseyno, String name, int runs, int wickets, String teamname) {
		super();
		this.jerseyno = jerseyno;
		this.name = name;
		this.runs = runs;
		this.wickets = wickets;
		this.teamname = teamname;
	}

	public int getJerseyno() {
		return jerseyno;
	}

	public void setJerseyno(int jerseyno) {
		this.jerseyno = jerseyno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRuns() {
		return runs;
	}

	public void setRuns(int runs) {
		this.runs = runs;
	}

	public int getWickets() {
		return wickets;
	}

	public void setWickets(int wickets) {
		this.wickets = wickets;
	}

	public String getTeamname() {
		return teamname;
	}

	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}

	@Override
	public String toString() {
		return "Player [Jerseyno = " + jerseyno + ", name = " + name + ", runs = " + runs + ", wickets = " + wickets
				+ ", teamname = " + teamname + " ]";
	}

}
