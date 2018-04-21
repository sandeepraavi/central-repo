package com.rw.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.rw.main.ChangeDirection;
import com.rw.main.ChangePosition;
import com.rw.main.Position;

public class ChangePositionTest {

	@Test
	public void testChangePosition() {
		ChangePosition position = new ChangePosition();
		Position pos = new Position();
		pos.setX(0); pos.setY(0);pos.setP('N');
		Position resPos = position.changePosition(pos,'L');
		assertEquals(resPos, position.changePosition(pos, 'L'));
		
	}

}
