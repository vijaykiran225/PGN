package PGN;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MainClass {

	public static String fixPawnPiece(String move)
	{
		char firstChar=move.charAt(0);
		
		if(firstChar=='a' ||firstChar=='b'
				||firstChar=='h' ||firstChar=='c'
				||firstChar=='e' ||firstChar=='d' 
				||firstChar=='f' ||firstChar=='g')
		{
			move="P"+move;
		}
		return move;
		
	}
	
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
			//System.out.println(move[0]+"-"+move[1]);
			//game.makeMove(move[0], move[1]);
			System.out.println(fixPawnPiece(move[0])+" - "+fixPawnPiece(move[1]));
			
		}
	}

}
