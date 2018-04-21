package com.rw.main;

public class ChangePosition {
	/**
	 * Method for changing the position of the robot.
	 * 
	 * @param position
	 * @param command
	 *            from User
	 * @return new Position object
	 */
	public Position changePosition(Position pos, char command) {

		if (command == 'M') {
			if (pos.getP() == 'N') {
				pos.setY(pos.getY() + 1);
			}
			if (pos.getP() == 'E') {
				pos.setX(pos.getX() + 1);
			}
			if (pos.getP() == 'W') {
				pos.setX(pos.getX() - 1);
			}
			if (pos.getP() == 'S') {
				pos.setY(pos.getY() - 1);
			}
		} else {
			pos.setErrorMessage("Please enter a valid command (M,L,R)");
		}
		ChangePosition changePosition = new ChangePosition();
		Position resultPosition = changePosition.checkCollisions(pos);
		return resultPosition;
	}

	/**
	 * Method for checking for collisions and noting down the collision counts
	 * 
	 * @param position
	 *            of the robot
	 * @return new Position along with collisions(if any)
	 */
	public Position checkCollisions(Position pos) {

		Constants con = new Constants();
		int collisions = pos.getCollisions();
		if (pos.getX() > con.MAX_X) {
			pos.setX(con.MAX_X);
			collisions++;
		}
		if (pos.getX() < con.MIN_X) {
			pos.setX(con.MIN_X);
			collisions++;
		}
		if (pos.getY() > con.MAX_Y) {
			pos.setY(con.MAX_Y);
			collisions++;
		}
		if (pos.getY() < con.MIN_Y) {
			pos.setY(con.MIN_Y);
			collisions++;
		}
		pos.setCollisions(collisions);

		return pos;

	}

}
