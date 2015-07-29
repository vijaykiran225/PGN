package PGN;

import static org.junit.Assert.*;

import org.junit.Test;

public class ChessPieceTest {

	@Test
	public void testName()
	{
		ChessPiece piece = new ChessPiece("K", "e1", "white");
		assertEquals("K", piece.getName());
	}
	
	@Test
	public void testFailName() {
		ChessPiece piece = new ChessPiece("K", "e1", "white");
		assertNotEquals("Q", piece.getName());
	}
	
	@Test
	public void testIsNotCaptured() {
		ChessPiece piece = new ChessPiece("K", "e1", "white");
		assertEquals(true, piece.isNotCaptured());
	}
	
	@Test
	public void testFailIsNotCaptured() {
		ChessPiece piece = new ChessPiece("K", "e1", "white");
		assertNotEquals(false, piece.isNotCaptured());
	}
	
	@Test
	public void testIsValidMove() {
		ChessPiece piece = new ChessPiece("R", "h1", "white");
		assertEquals(false, piece.isValidMove("e2"));
	}
	
	@Test
	public void testFailIsValidMove() {
		ChessPiece piece = new ChessPiece("P", "e2", "white");
		assertEquals(true, piece.isValidMove("e3"));
	}
	
	@Test
	public void testMove() {
		ChessPiece piece = new ChessPiece("K", "e1", "white");
		piece.moveTo("e2");
		assertEquals("e2", piece.getCurrentPosition());
	}
	
}
