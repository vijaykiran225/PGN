package PGN;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MainClass {

	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader reader=new BufferedReader(new FileReader("sample.pgn"));
		String fileContent="";
		while((fileContent=reader.readLine())!=null)
		{
			System.out.println(fileContent);
		}
	}

}
