package com.fantasydraft.justin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="players")
public class Player {

	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="player_name")
	private String playerName;
	
	@Column(name="position")
	private String position;
	
	@Column(name="nfl_team")
	private String nflTeam;
	
	@Column(name="fantasy_team")
	private String fantasyTeam;
	
	@Column(name="pick")
	private Integer pick;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getNflTeam() {
		return nflTeam;
	}

	public void setNflTeam(String nflTeam) {
		this.nflTeam = nflTeam;
	}

	public String getFantasyTeam() {
		return fantasyTeam;
	}

	public void setFantasyTeam(String fantasyTeam) {
		this.fantasyTeam = fantasyTeam;
	}

	public Integer getPick() {
		return pick;
	}

	public void setPick(Integer pick) {
		this.pick = pick;
	}

	@Override
	public String toString() {
		return playerName;
	}
}
