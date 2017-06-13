package com.fantasydraft.justin.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fantasydraft.justin.dao.PlayerDAO;
import com.fantasydraft.justin.entity.Player;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayerDAO playerDAO;
	
	@Override
	@Transactional
	public List<Player> getDraftedPlayers() {
		
		return playerDAO.getDraftedPlayers();
	}
}
