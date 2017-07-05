package com.fantasydraft.justin.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fantasydraft.justin.entity.Draft;
import com.fantasydraft.justin.service.PlayerService;


@Controller
@RequestMapping("/")
@SessionAttributes("draft")
public class DraftController {
	
	@Autowired
	private PlayerService playerService;
	
	@GetMapping("/home")
	public String showHome(){
		
		return "home";
	}
	
	@GetMapping("/newDraft")
	public String newDraft(Model model) {
		
		model.addAttribute("draft", new Draft());
		
		return "new-draft";
	}
	
	@PostMapping("/startNewDraft")
	public String startNewDraft(@Valid @ModelAttribute("draft") Draft draft, BindingResult bindingResult) {
		
		int teamNum;
		
		draft.clearDraftTeams();
		
		for(int i = 0; i < draft.getNumTeams(); i++) {
			teamNum = i + 1;
			
			draft.addDraftTeam("Team " + teamNum);
		}
		
		if(bindingResult.hasErrors()) {
			return "new-draft";
		} else {
			return "team-input";
		}
	}
	
	@RequestMapping("/draft")
	public String submitTeams(@ModelAttribute("draft") Draft draft) {
		
		draft.setDraftedPlayers(playerService.getDraftedPlayers());
		draft.setAvailablePlayers(playerService.getAvailablePlayers());
		
		// for debugging
		System.out.println(draft.getDraftedPlayers());
		System.out.println(draft.getAvailablePlayers());
		
		return "draft-page";
	}
	
	@GetMapping("/setDraftedPlayers")
	public void setDraftedPlayers(@ModelAttribute("draft") Draft draft) {
		
		draft.setDraftedPlayers(playerService.getDraftedPlayers());
	}
	
	@GetMapping("/setAvailablePlayers")
	public void setAvailablePlayers(@ModelAttribute("draft") Draft draft) {
		
		draft.setAvailablePlayers(playerService.getAvailablePlayers());
	}

	@PostMapping("/assignPlayer")
	public String assignPlayer(@ModelAttribute("draft") Draft draft) {
		
		// fetch the current pick number from database
		draft.setCurrentPick(playerService.getLatestPick() + 1);
		
		// assign currentPick to pick field in database
		Integer pickUsed = draft.getCurrentPick();
		
		// assign currentTeam to fantasy_team field in database
		String pickingTeam = draft.getDraftTeams().get(draft.getCurrentTeam());
		
		// update player in database with fantasy team and pick number
		playerService.assignPlayer(draft.getSelectedPlayerName(), pickingTeam, pickUsed);
		
		// update draftedPlayers and availablePlayers
		// todo: update to not redo entire lists, just add drafted player and remove available player based on pick
		draft.clearDraftedPlayers();
		draft.setDraftedPlayers(playerService.getDraftedPlayers());
		draft.clearAvailablePlayers();
		draft.setAvailablePlayers(playerService.getAvailablePlayers());
		
		// return draft page to update it
		// replace this return with some javascript eventually
		return "draft-page";
	}
}
