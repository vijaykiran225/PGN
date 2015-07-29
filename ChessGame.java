package PGN;

import java.util.ArrayList;

public class ChessGame {
	ArrayList<ChessPiece> whitePieces;
	ArrayList<ChessPiece> blackPieces;
	
	private void initializeChessPieces() {
		whitePieces.add(new ChessPiece("P","a2","white"));
		whitePieces.add(new ChessPiece("P","b2","white"));
		whitePieces.add(new ChessPiece("P","c2","white"));
		whitePieces.add(new ChessPiece("P","d2","white"));
		whitePieces.add(new ChessPiece("P","e2","white"));
		whitePieces.add(new ChessPiece("P","f2","white"));
		whitePieces.add(new ChessPiece("P","g2","white"));
		whitePieces.add(new ChessPiece("P","h2","white"));
		whitePieces.add(new ChessPiece("R","a1","white"));
		whitePieces.add(new ChessPiece("N","b1","white"));
		whitePieces.add(new ChessPiece("B","c1","white"));
		whitePieces.add(new ChessPiece("Q","d1","white"));
		whitePieces.add(new ChessPiece("K","e1","white"));
		whitePieces.add(new ChessPiece("B","f1","white"));
		whitePieces.add(new ChessPiece("N","g1","white"));
		whitePieces.add(new ChessPiece("R","h1","white"));
		
		blackPieces.add(new ChessPiece("P","a7","black"));
		blackPieces.add(new ChessPiece("P","b7","black"));
		blackPieces.add(new ChessPiece("P","c7","black"));
		blackPieces.add(new ChessPiece("P","d7","black"));
		blackPieces.add(new ChessPiece("P","e7","black"));
		blackPieces.add(new ChessPiece("P","f7","black"));
		blackPieces.add(new ChessPiece("P","g7","black"));
		blackPieces.add(new ChessPiece("P","h7","black"));
		blackPieces.add(new ChessPiece("R","a8","black"));
		blackPieces.add(new ChessPiece("N","b8","black"));
		blackPieces.add(new ChessPiece("B","c8","black"));
		blackPieces.add(new ChessPiece("Q","d8","black"));
		blackPieces.add(new ChessPiece("K","e8","black"));
		blackPieces.add(new ChessPiece("B","f8","black"));
		blackPieces.add(new ChessPiece("N","g8","black"));
		blackPieces.add(new ChessPiece("R","h8","black"));
	}
	public ChessGame(ArrayList<ChessPiece> whitePieces, ArrayList<ChessPiece> blackPieces) {
		super();
		initializeChessPieces();
	}
	
	public void makeMove(String whiteMove,String blackMove) {
		
	}
	
	public void displayCurrentStatus() {
		
	}
	
}
