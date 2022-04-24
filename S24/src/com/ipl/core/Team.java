package com.ipl.core;

import java.io.Serializable;
import java.util.ArrayList;

import com.ipl.custom_exceptions.InvalidPlayerDetails;
import com.ipl.custom_exceptions.TeamSizeException;


public class Team implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "Team [playerList=" + playerList + "]";
	}

	public ArrayList<Player> getPlayerList() {
		return playerList;
	}

	private ArrayList<Player> playerList;
	
	public void addPlayer(Player player) throws Exception {
		if(player.getRanking()<=5 && player.getRanking()>=1) 
			if(playerList.size() < 7 )
				if(!isDuplicate(player))
					playerList.add(player);
				else
					throw new InvalidPlayerDetails("Player already enlisted.");
			else
				throw new TeamSizeException("Cannot add player, team full.");
		else
			throw new InvalidPlayerDetails("Invalid Player ranking");
	
	}
	
	public Team() {
		super();
		playerList = new ArrayList<Player>();
	}

	public Boolean isDuplicate(Player player) {
		return playerList.stream().filter(p->p.getName().equals(player.getName()) && p.getPoints() == player.getPoints()).count() > 0;
	}
	
	public void removePlayer(Player player) throws TeamSizeException{
		if(playerList.size() > 5) {
			playerList.remove(player);
		}
		else
			throw new TeamSizeException("Cannot remove player, team size too small.");
	}
}
