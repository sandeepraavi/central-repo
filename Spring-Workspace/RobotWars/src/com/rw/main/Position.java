package com.rw.main;

public class Position {
	private int X;
	private int Y;
	private char P;
	private int collisions;
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public int getCollisions() {
		return collisions;
	}

	public void setCollisions(int collisions) {
		this.collisions = collisions;
	}

	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}

	public char getP() {
		return P;
	}

	public void setP(char p) {
		P = p;
	}

}
