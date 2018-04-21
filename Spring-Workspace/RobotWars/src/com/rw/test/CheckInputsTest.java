package com.rw.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.rw.main.CheckInputs;
/**
 * JUnit class for unit testing the position and commands validity.
 * @author ImSandeep
 *
 */
public class CheckInputsTest {

	@Test
	public void testCheckPositionForValidCase() {
		CheckInputs inputs = new CheckInputs();
		 boolean bool = inputs.checkPosition(0, 0, 'N');
		assertEquals(true, bool);
	}
	@Test
	public void testCheckPositionForInValidCase() {
		CheckInputs inputs = new CheckInputs();
		 boolean bool = inputs.checkPosition(11, 0, 'A');
		assertEquals(false, bool);
	}
	@Test
	public void testCheckCommandForValidCase() {
		CheckInputs inputs = new CheckInputs();
		 boolean bool = inputs.checkcomm("MMLLRMLR");
		assertEquals(true, bool);
	}
	@Test
	public void testCheckCommandForInValidCase() {
		CheckInputs inputs = new CheckInputs();
		 boolean bool = inputs.checkcomm("ASDFG");
		assertEquals(false, bool);
	}

}
