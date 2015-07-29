package PGN;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MainClass {

	public static String[] appendPawnPiece(String[] moves) {
		for (int i = 0; i < moves.length; i++) {

			char firstChar = moves[i].charAt(0);

			if (firstChar == 'a' || firstChar == 'b' || firstChar == 'h' || firstChar == 'c' || firstChar == 'e'
					|| firstChar == 'd' || firstChar == 'f' || firstChar == 'g') {
				moves[i] = "P" + moves[i];
			}
		}
		return moves;

	}

	public static String[] removeCheck(String[] moves) {
		for (int i = 0; i < moves.length; i++) {
			if(moves[i].contains("+"))
			{
				moves[i].replace("+", "");
			}
		}
		return moves;

	}

	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new FileReader("./src/PGN/sample.pgn"));
		String fileContent = "";
		ChessGame game = new ChessGame();
		while ((fileContent = reader.readLine()) != null) {
			// System.out.println(fileContent);
			String[] line = fileContent.split("\\.");
			String[] moves = line[1].split(" ");
			moves = appendPawnPiece(moves);
			moves = removeCheck(moves);
			
			System.out.println(moves[0]+"-"+moves[1] );
			// game.makeMove(fixPawnPiece(move[0]), fixPawnPiece(move[1]));
		}
	}

}
