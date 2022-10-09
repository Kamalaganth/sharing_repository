package Array;

import java.util.*;

public class Cinema {

	public static void main(String[] args) {

		try (Scanner scan = new Scanner(System.in)) {

			// seat arrangement inputs
			System.out.print("Enter the number of rows:");
			int row = scan.nextInt();

			System.out.print("Enter the number of seats in each row:");
			int column = scan.nextInt();

			// initialize seat array
			char[][] seatArray = new char[row][column];
			initSeatArray(seatArray);

			// logic starts here
			int choice = 100;
			while (choice != 0) {
				switch (choice) {
				case 1:
					showTheSeats(seatArray);
					break;
				case 2:
					int result = buyTicket(seatArray, row, column);
					System.out.println("Ticket price: $" + result);
					break;
				case 0:
					System.exit(0);
				}
				choice = choiceSelector();
			}
		}

	}

	public static void initSeatArray(char x[][]) {
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[0].length; j++) {
				x[i][j] = 'S';
			}
		}
	}

	public static int choiceSelector() {
		int selectedItem = 0;
		System.out.println("1. Show the seats\r\n" + "2. Buy a ticket\r\n" + "0. Exit");
		try (Scanner scan3 = new Scanner(System.in)) {
			selectedItem = scan3.nextInt();
			return selectedItem;
		}
	}

	public static void showTheSeats(char x[][]) {
		System.out.print("Cinema:\r\n" + "  ");

		for (int i = 1; i <= x[0].length; i++) {
			System.out.print(i + " ");
		}
		System.out.println();

		int inc = 1;
		for (int i = 0; i < x.length; i++) {
			System.out.print(inc + " ");
			for (int j = 0; j < x[0].length; j++) {
				System.out.print(x[i][j] + " ");
			}
			System.out.println();
			inc++;
		}
	}

	public static int buyTicket(char seatArray[][], int row, int column) {
		try (Scanner scan = new Scanner(System.in)) {
			System.out.print("Enter a row number:");
			int userRow = scan.nextInt();

			System.out.print("Enter a seat number in that row:");
			int userSeats = scan.nextInt();

			seatArray[userRow - 1][userSeats - 1] = 'B';

			int a = 10;
			int b = 8;
			int result = 0;

			if ((row * column) <= 60) {
				result = a;
			} else if ((row % 2) == 0) {
				if (userRow <= (row / 2)) {
					result = a;
				} else {
					result = b;
				}
			} else if ((row % 2) != 0) {
				if (userRow <= (row / 2)) {
					result = a;
				} else {
					result = b;
				}
			}
			return result;
		}

	}

}
