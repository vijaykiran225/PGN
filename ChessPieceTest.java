package PGN;

import static org.junit.Assert.*;

import org.junit.Test;

public class ChessPieceTest {

	@Test
	public void testCreation()
	{
		ChessPiece piece=new ChessPiece("K", "e1", "W");
		System.out.println(piece);
	}
}
