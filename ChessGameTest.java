package PGN;

import static org.junit.Assert.*;

import org.junit.Test;

public class ChessGameTest {

	@Test
	public void testChessGame() {
		fail("Not yet implemented");
	}

	@Test
	public void testMakeMove() {
		ChessGame game = new ChessGame();
		game.makeMove("O-O", "O-O-O");
	}

	@Test
	public void testDisplayCurrentStatus() {
		ChessGame game = new ChessGame();
		game.displayCurrentStatus();
	}

}
