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
	
	@Override
	public List<Player> getAvailablePlayers() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Player> query = currentSession.createQuery("from Player where pick is null order by playerName", Player.class);
		
		List<Player> availablePlayers = query.getResultList();
		
		return availablePlayers;
	}
	
	@Override
	public Integer getLatestPick() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Integer> query = currentSession.createQuery("select max(p.pick) from Player p", Integer.class);
		
		Integer latestPick = query.uniqueResult();
		
		if (latestPick == null) {
			latestPick = 0;
		}
		
		return latestPick;
	}
	
	@Override
	public void assignPlayer(String pickedPlayerName, String pickingTeam, Integer pickUsed) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Player> query = currentSession.createQuery("update Player as p set "
				+ "p.fantasyTeam=:team, "
				+ "p.pick=:pickNumber "
				+ "where p.playerName=:pickedPlayer");
		query.setParameter("pickedPlayer", pickedPlayerName);
		query.setParameter("team", pickingTeam);
		query.setParameter("pickNumber", pickUsed);
		query.executeUpdate();
	}
}
