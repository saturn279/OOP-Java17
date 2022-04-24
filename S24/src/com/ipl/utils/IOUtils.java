package com.ipl.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.ipl.core.Player;
import com.ipl.core.Team;


public class IOUtils {

	
	public static void saveTofile(Team team, String fileName) throws Exception {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));) {
			out.writeObject(team);
		}
	}

	
	public static Team getFromFile(String fileName) throws Exception {
		File TeamFile = new File(fileName);
		if (TeamFile.exists()) {
			try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(TeamFile))) {
				Team team = new Team();
				for(Player player: ((Team)in.readObject()).getPlayerList()) {
					team.addPlayer(new Player(player.getName(),player.getRanking(),player.getPoints()));
				}
				return team;
			}
		}
		return new Team();
	}
}