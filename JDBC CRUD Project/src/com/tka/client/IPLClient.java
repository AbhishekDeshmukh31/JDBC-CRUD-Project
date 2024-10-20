package com.tka.client;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import com.tka.controller.IPLController;
import com.tka.entity.Player;

public class IPLClient {

	public static void main(String[] args) throws Exception {

		IPLController controller = new IPLController();
		Scanner scanner = new Scanner(System.in);
		System.out.println("--------------------------------------------");
		int choice = 0;

		do {
			System.out.println("** Welcome to Player Management System using JDBC **");
			System.out.println();
			System.out.println();
			System.out.println("1. To view all Players from DataBase ");
			System.out.println("2. To view Player details by TeamName");
			System.out.println("3. To insert Players into DataBase ");
			System.out.println("4. To update Player's name in DataBase ");
			System.out.println("5. To update Player's runs in DataBase ");
			System.out.println("6. To update Player's wickets in DataBase ");
			System.out.println("7. To update Player's teamname in DataBase ");
			System.out.println("8. To update Player's jerseyno in DataBase ");
			System.out.println("9. To Delete Player's data from DataBase ");
			System.out.println("10. To exit ");
			System.out.println();
			System.out.println("Please Enter your choice");
			System.out.println();

			choice = scanner.nextInt();

			switch (choice) {
			case 1: {
				System.out.println("------------------------------------------");
				System.out.println("All Players from Database are: ");
				List<Player> allplayerlist = controller.getallplayerController();
				for (Player player : allplayerlist) {
					System.out.println(player);

				}
				break;
			}
			case 2: {
				System.out.println("-------------------------------------------");
				String name = null;
				try {
					System.out.println("Enter teamname you want to see players of: ");
					name = scanner.next();
				} catch (InputMismatchException e) {
					e.printStackTrace();
				}

				System.out.println("Players by selected Teamname: ");
				List<Player> list = controller.getplayerTeamnamecontroller(name);
				for (Player player : list) {
					System.out.println(player);
				}
				break;
			}

			case 3: {
				System.out.println("-------------------------------------------");
				System.out.println("Enter Player details...");
				String name = null;
				String teamname = null;
				int jerseyno = 0;
				int runs = 0;
				int wickets = 0;
				try {
					System.out.println("Enter Jerseyno of player: ");
					jerseyno = scanner.nextInt();
					System.out.println("Enter Name of player: ");
					name = scanner.next();
					System.out.println("Enter Runs of player: ");
					runs = scanner.nextInt();
					System.out.println("Enter Wickets of player: ");
					wickets = scanner.nextInt();
					System.out.println("Enter Teamanme of player: ");
					teamname = scanner.next();

				} catch (InputMismatchException e) {
					e.printStackTrace();
				}
				String list = controller.insertplayerController(jerseyno, name, runs, wickets, teamname);
				System.out.println(list);
				break;
			}
			case 4: {
				System.out.println("-------------------------------------------");
				String name = null;
				int jerseyno = 0;

				try {
					System.out.println("Enter Player new name of player: ");
					name = scanner.next();
					System.out.println();
					System.out.println("Enter Jerseyno of existing player: ");
					jerseyno = scanner.nextInt();
				} catch (InputMismatchException e) {
					e.printStackTrace();
				}
				String list = controller.upadteplayernameController(jerseyno, name);
				System.out.println(list);
				break;
			}
			case 5: {
				System.out.println("-------------------------------------------");
				int runs = 0;
				int jerseyno = 0;

				try {
					System.out.println("Enter new runs of player: ");
					runs = scanner.nextInt();
					System.out.println("Enter Jerseyno of existing player: ");
					jerseyno = scanner.nextInt();
				} catch (InputMismatchException e) {
					e.printStackTrace();
				}
				String list = controller.upadteplayerrunsController(jerseyno, runs);
				System.out.println(list);
				break;
			}
			case 6: {
				System.out.println("-------------------------------------------");
				int wickets = 0;
				int jerseyno = 0;

				try {
					System.out.println("Enter new wickets of player");
					wickets = scanner.nextInt();
					System.out.println("Enter Jerseyno of existing player: ");
					jerseyno = scanner.nextInt();
				} catch (InputMismatchException e) {
					e.printStackTrace();
				}
				String list = controller.upadteplayerwicketsController(jerseyno, wickets);
				System.out.println(list);
				break;
			}
			case 7: {
				System.out.println("-------------------------------------------");
				String teamname = null;
				int jerseyno = 0;

				try {
					System.out.println("Enter new teamname of player");
					teamname = scanner.next();
					System.out.println("Enter Jerseyno of existing player: ");
					jerseyno = scanner.nextInt();
				} catch (InputMismatchException e) {
					e.printStackTrace();
				}
				String list = controller.upadteplayerteamnameController(jerseyno, teamname);
				System.out.println(list);
				break;
			}
			case 8: {
				System.out.println("-------------------------------------------");
				int newjersey = 0;
				int jerseyno = 0;

				try {
					System.out.println("Enter new Jersey number of player");
					newjersey = scanner.nextInt();
					System.out.println("Enter Jerseyno of existing player: ");
					jerseyno = scanner.nextInt();
				} catch (InputMismatchException e) {
					e.printStackTrace();
				}
				String list = controller.upadteplayerjerseyController(jerseyno, newjersey);
				System.out.println(list);
				break;
			}
			case 9: {
				System.out.println("-------------------------------------------");
				int jerseyno = 0;

				try {
					System.out.println("Enter Jersey number of Player you want to delete: ");
					jerseyno = scanner.nextInt();

				} catch (InputMismatchException e) {
					e.printStackTrace();
				}
				String delete = controller.deleteplayerController(jerseyno);
				System.out.println(delete);
				break;
			}
			case 10: {
				System.out.println("Thankyou ! for using our interface.");
				break;
			}

			default:
				System.out.println("Invalid Choice !!");
				System.out.println();
				break;
			}

		} while (choice != 10);
		scanner.close();

	}
}
