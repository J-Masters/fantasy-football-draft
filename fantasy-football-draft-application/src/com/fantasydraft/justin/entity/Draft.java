package com.fantasydraft.justin.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


public class Draft {
	
	@NotNull(message="There must be 2 to 12 teams.")
	@Min(value=2, message="Can't have less than 2 teams.")
	@Max(value=12, message="Can't have more than 12 teams.")
	private Integer numTeams;
	
	private Integer currentPick;
	
	private Integer currentTeam;
	
	private String draftType;
	
	private LinkedList<String> draftTypeOptions;
	
	private LinkedList<Integer> fwdRounds;
	
	private List<String> draftTeams;
	
	private List<Player> draftedPlayers;
	
	private List<Player> availablePlayers;
	
	private String selectedPlayerName;
	
	private Player selectedPlayer;
	
	public Draft() {
		
		draftTeams = new LinkedList<>();
		draftedPlayers = new ArrayList<>();
		selectedPlayer = new Player();
		
		draftTypeOptions = new LinkedList<String>();
		draftTypeOptions.add("Linear");
		draftTypeOptions.add("Snake");
		draftTypeOptions.add("Reverse Snake");
		
		fwdRounds = new LinkedList<Integer>();
		Integer[] ints = new Integer[]{1, 4, 5, 8, 9, 12, 13, 16};
		fwdRounds.addAll(Arrays.asList(ints));
		
		currentPick = 1;
	}
	
	
	public Integer getNumTeams() {
		return numTeams;
	}

	public void setNumTeams(Integer numTeams) {
		this.numTeams = numTeams;
	}
	
	public Integer getCurrentPick() {
		return currentPick;
	}
	
	public void setCurrentPick(Integer currentPick) {
		this.currentPick = currentPick;
	}
	
	public Integer getCurrentTeam() {
		currentTeam = (currentPick - 1) % numTeams;
		int round = (currentPick - 1) / numTeams + 1;
		
		if (!fwdRounds.contains(round)) {
			currentTeam = 7 - currentTeam;
		}
		
		return currentTeam;
	}
		
	public String getDraftType() {
		return draftType;
	}

	public void setDraftType(String draftType) {
		this.draftType = draftType;
	}
	
	public LinkedList<String> getDraftTypeOptions() {
		return draftTypeOptions;
	}
	
	public LinkedList<Integer> getFwdRounds() {
		return fwdRounds;
	}

	public List<String> getDraftTeams() {
		return draftTeams;
	}

	public void addDraftTeam(String team) {
		draftTeams.add(team);
	}

	public void clearDraftTeams() {
		draftTeams.clear();
	}
	
	public void setDraftedPlayers(List<Player> draftedPlayers) {
		this.draftedPlayers = draftedPlayers;
	}
	
	public void addDraftedPlayer() {
		//todo: hibernate in controller will add pick and team to player then this will add player to draftedPlayers
		//todo: add this when javascript added, setDraftedPlayer will load whenever page is reloaded
	}
	
	public List<Player> getDraftedPlayers() {
		return draftedPlayers;
	}
	
	public void clearDraftedPlayers() {
		draftedPlayers.clear();
	}
	
	public void setAvailablePlayers(List<Player> availablePlayers) {
		this.availablePlayers = availablePlayers;
	}
	
	public List<Player> getAvailablePlayers() {
		return availablePlayers;
	}
	
	public void clearAvailablePlayers() {
		availablePlayers.clear();
	}
	
	public String getSelectedPlayerName() {
		return selectedPlayerName;
	}
	
	public void setSelectedPlayerName(String selectedPlayerName) {
		this.selectedPlayerName = selectedPlayerName;
	}
	
	public Player getSelectedPlayer() {
		return selectedPlayer;
	}
	
	public void setSelectedPlayer(Player selectedPlayer) {
		this.selectedPlayer = selectedPlayer;
	}
}
