package com.rw.main;

import java.util.Scanner;

public class RobotWars {

	private Position position = new Position();

	public Position intialPosition(int x, int y, char p) {
		position.setX(x);
		position.setY(y);
		position.setP(p);
		return position;
	}

	public static void main(String[] args) {
		Constants con = new Constants();
		Position pos = new Position();
		ChangePosition changePosition = new ChangePosition();
		ChangeDirection changeDriection = new ChangeDirection();
		CheckInputs check = new CheckInputs();
		System.out.println(
				"Please provide the inital position of the Robot in the format x y p (x,y in {0-4}, p in{N,E,W,S})and hit enter");
		Scanner input = new Scanner(System.in);
while(input.hasNext()){
	while (input.hasNext()) {
		int positionX = input.nextInt();
		int positionY = input.nextInt();
		char ps = input.next().toUpperCase().charAt(0);
		// Checking the validity of input positions provided by the user.
		if (check.checkPosition(positionX, positionY, ps)) {
			RobotWars robotWars = new RobotWars();
			pos = robotWars.intialPosition(positionX, positionY, ps);
			System.out.println("Please enter the command(s) (M,L,R):");
			break;
		} else {
			System.out.println(
					"Invalid Inputs. Please enter values in format x y p and with valid values(x,y in [0-4] and p in {N,E,W,S})");
		}
	}
	while (input.hasNext()) {
		String command = input.next().toUpperCase();
		// Checking the validity of the commands provided by the user.
		if (check.checkcomm(command)) {
			for (int i = 0; i < command.length(); i++) {
				if (command.charAt(i) == 'L' || command.charAt(i) == 'R') {
					pos = changeDriection.changeDirection(pos, command.charAt(i));
				} else if (command.charAt(i) == 'M') {
					pos = changePosition.changePosition(pos, command.charAt(i));
				} else {
					System.out.println("Plese enter a valid command (M,L,R)");
				}
			}
			break;
		} else {
			System.out.println("Please enter the valid commands");
		}

	}
	System.out.println("Result Position:" + pos.getX() + " " + pos.getY() + " " + pos.getP() + " collision count:"
			+ pos.getCollisions());
	System.out.println("Please provide the inital position of the Robot in the format x y p (x,y in {0-4}, p in{N,E,W,S})and hit enter");
}

}
		}
