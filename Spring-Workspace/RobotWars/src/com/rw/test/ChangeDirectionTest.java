package com.rw.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.rw.main.ChangeDirection;
import com.rw.main.Position;

public class ChangeDirectionTest {

	@Test
	public void testChangeDirection() {
		ChangeDirection direction = new ChangeDirection();
		Position pos = new Position();
		pos.setX(0); pos.setY(0);pos.setP('N');
		Position resPos = direction.changeDirection(pos, 'M');
		assertEquals(resPos, direction.changeDirection(pos, 'M'));
		
	}

}
