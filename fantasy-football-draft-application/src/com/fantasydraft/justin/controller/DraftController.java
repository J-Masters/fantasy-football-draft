package com.fantasydraft.justin.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fantasydraft.justin.entity.Draft;


@Controller
@RequestMapping("/")
@SessionAttributes("draft")
public class DraftController {
	
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
	
	@PostMapping("/submitTeams")
	public String submitTeams(@ModelAttribute("draft") Draft draft) {
		
		return "draft-page";
	}

	@PostMapping("/assignPlayer")
	public String assignPlayer(@ModelAttribute("draft") Draft draft) {
		
		return "draft-page";
	}
}
