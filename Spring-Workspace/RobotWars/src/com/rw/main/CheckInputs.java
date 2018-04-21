package com.rw.main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckInputs {

	public boolean checkPosition(int x, int y, char p) {
		Constants con = new Constants();
		if ((x >= con.MIN_X && x <= con.MAX_X) && (y >= con.MIN_Y && y <= con.MAX_Y)
				&& (p == 'N' || p == 'E' || p == 'W' || p == 'S')) {

		} else {
			return false;
		}
		return true;
	}

	public boolean checkcomm(String comm) {
		Pattern pattern = Pattern.compile("[M,R,L]");
		Matcher matcher = pattern.matcher(comm);
		int count = 0;// variable for checking the matches
		while (matcher.find()) {
			count++;
		}
		if (count == comm.length()) {

		} else {
			return false;
		}
		return true;
	}

}
