package com.ipl.tester;

import java.util.Scanner;

import com.ipl.core.Player;
import com.ipl.core.Team;
import com.ipl.utils.IOUtils;



public class TestIPL {

	public static void main(String[] args) {
		
		try(Scanner sc = new Scanner(System.in)){
			Boolean exit = false;
			Team team = IOUtils.getFromFile("Team.ser");
			do {
				try {
					
				System.out.println("\n1.Add player to the team\n2.Diplay IPL team\n3.Remove player by id\n4.Save and Exit\n\tChoose option: ");
				switch(sc.nextInt()) {
				case 1:
					System.out.println("Enter player name, ranking, points [String int double]: ");
					team.addPlayer(new Player(sc.next(),sc.nextInt(),sc.nextDouble()));
					System.out.println("Player enlisted.");
					break;
				case 2:
					System.out.println(team);
					break;
				case 3:
					System.out.println("Enter player id: ");
					team.removePlayer(new Player(sc.nextInt()));
					System.out.println("Player removed.");
					break;
				case 4:
					IOUtils.saveTofile(team, "Team.ser");
					exit=true;
				}
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
				sc.nextLine();
			}while(!exit);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
