package com.rw.main;

public class ChangeDirection {
	/**
	 * Method for changing the existing direction after taking the command from
	 * user
	 * 
	 * @param position
	 *            of the robot
	 * @param command
	 *            from the user
	 * @return new Position object
	 */
	public Position changeDirection(Position pos, char command) {
		if (command == 'L') {
			if (pos.getP() == 'N') {
				pos.setP('W');
			} else if (pos.getP() == 'E') {
				pos.setP('N');
			} else if (pos.getP() == 'W') {
				pos.setP('S');
			} else if (pos.getP() == 'S') {
				pos.setP('E');
			}
		} else if (command == 'R') {
			if (pos.getP() == 'N') {
				pos.setP('E');
			} else if (pos.getP() == 'E') {
				pos.setP('S');
			} else if (pos.getP() == 'W') {
				pos.setP('N');
			} else if (pos.getP() == 'S') {
				pos.setP('W');
			}
		} else {
			pos.setErrorMessage("Enter a valid command (M,L,R)");
		}
		return pos;
	}
}
