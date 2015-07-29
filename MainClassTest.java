package PGN;

import static org.junit.Assert.*;

import org.junit.Test;

public class MainClassTest {

	@Test
	public void testMain() {
		fail("Not yet implemented");
	}

	@Test
	public void testFixPawnPiece()
	{
		String[] moves=new String[2];
		moves[0]=new String("Be4");
		moves[1]=new String("Nh4+");
		System.out.println(MainClass.appendPawnPiece(moves)[1]);
	}
}
