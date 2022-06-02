package com.app.tester;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.app.core.Player;
import com.app.utils.IOUtils;

public class TestClass {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			ArrayList<Player> pL;
			
			IOUtils<ArrayList<Player>> IO = new IOUtils<>();
			if (IO.getFromFile("test.ser") != null) {
				pL = IO.getFromFile("test.ser");
			} else {
				pL = new ArrayList<Player>();
			}
			
			Boolean exit = false;
			do {
				try {

					System.out.println("\n1. \n2. \n3. \n4. \n5. \n\tChoose option: ");
					switch (sc.nextInt()) {
					case 1:

							System.out.println(pL);
						break;
					case 2:

						break;
					case 3:

						break;
					case 4:

						break;
					case 5:
						IO.saveTofile(pL, "test.ser");
						exit = true;
						break;
					}
				} catch (Exception e) {
					//System.out.println(e.getMessage());
					e.printStackTrace();
				}
				sc.nextLine();
			} while (!exit);
		} catch (Exception e) {
			//System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
