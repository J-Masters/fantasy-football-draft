package com.fantasydraft.justin.service;

import java.util.List;

import com.fantasydraft.justin.entity.Player;

public interface PlayerService {

	public List<Player> getDraftedPlayers();
	public List<Player> getAvailablePlayers();
	public Integer getLatestPick();
	public void assignPlayer(String pickedPlayerName, String pickingTeam, Integer pickUsed);
}
