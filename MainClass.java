package PGN;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MainClass {

	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader reader=new BufferedReader(new FileReader("./src/PGN/sample.pgn"));
		String fileContent="";
		ChessGame game=new ChessGame();
		while((fileContent=reader.readLine())!=null)
		{
			//System.out.println(fileContent);
			String[] line=fileContent.split("\\.");
			String[] move=line[1].split(" ");
			System.out.println(move[0]+"-"+move[1]);
			//game.makeMove(move[0], move[1]);
			System.out.println(Constants.KNIGHT.name);
		}
	}

}
