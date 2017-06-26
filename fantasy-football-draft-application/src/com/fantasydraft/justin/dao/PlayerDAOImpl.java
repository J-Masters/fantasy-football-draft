package com.fantasydraft.justin.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fantasydraft.justin.entity.Player;

@Repository
public class PlayerDAOImpl implements PlayerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Player> getDraftedPlayers() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Player> query = currentSession.createQuery("from Player where pick is not null", Player.class);
		
		List<Player> draftedPlayers = query.getResultList();
		
		return draftedPlayers;
	}
}
