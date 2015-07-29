package PGN;

import java.util.ArrayList;

public class ChessGame {
	
	 
	ArrayList<ChessPiece> whitePieces;
	ArrayList<ChessPiece> blackPieces;
	
	private void initializeChessPieces() {
		whitePieces.add(new ChessPiece(Constants.PAWN.name,"a2",Constants.WHITE.name));
		whitePieces.add(new ChessPiece(Constants.PAWN.name,"b2",Constants.WHITE.name));
		whitePieces.add(new ChessPiece(Constants.PAWN.name,"c2",Constants.WHITE.name));
		whitePieces.add(new ChessPiece(Constants.PAWN.name,"d2",Constants.WHITE.name));
		whitePieces.add(new ChessPiece(Constants.PAWN.name,"e2",Constants.WHITE.name));
		whitePieces.add(new ChessPiece(Constants.PAWN.name,"f2",Constants.WHITE.name));
		whitePieces.add(new ChessPiece(Constants.PAWN.name,"g2",Constants.WHITE.name));
		whitePieces.add(new ChessPiece(Constants.PAWN.name,"h2",Constants.WHITE.name));
		whitePieces.add(new ChessPiece(Constants.ROOK.name,"a1",Constants.WHITE.name));
		whitePieces.add(new ChessPiece(Constants.KNIGHT.name,"b1",Constants.WHITE.name));
		whitePieces.add(new ChessPiece(Constants.BISHOP.name,"c1",Constants.WHITE.name));
		whitePieces.add(new ChessPiece(Constants.QUEEN.name,"d1",Constants.WHITE.name));
		whitePieces.add(new ChessPiece(Constants.KING.name,"e1",Constants.WHITE.name));
		whitePieces.add(new ChessPiece(Constants.BISHOP.name,"f1",Constants.WHITE.name));
		whitePieces.add(new ChessPiece(Constants.KNIGHT.name,"g1",Constants.WHITE.name));
		whitePieces.add(new ChessPiece(Constants.ROOK.name,"h1",Constants.WHITE.name));
		
		blackPieces.add(new ChessPiece(Constants.PAWN.name,"a7",Constants.BLACK.name));
		blackPieces.add(new ChessPiece(Constants.PAWN.name,"b7",Constants.BLACK.name));
		blackPieces.add(new ChessPiece(Constants.PAWN.name,"c7",Constants.BLACK.name));
		blackPieces.add(new ChessPiece(Constants.PAWN.name,"d7",Constants.BLACK.name));
		blackPieces.add(new ChessPiece(Constants.PAWN.name,"e7",Constants.BLACK.name));
		blackPieces.add(new ChessPiece(Constants.PAWN.name,"f7",Constants.BLACK.name));
		blackPieces.add(new ChessPiece(Constants.PAWN.name,"g7",Constants.BLACK.name));
		blackPieces.add(new ChessPiece(Constants.PAWN.name,"h7",Constants.BLACK.name));
		blackPieces.add(new ChessPiece(Constants.ROOK.name,"a8",Constants.BLACK.name));
		blackPieces.add(new ChessPiece(Constants.KNIGHT.name,"b8",Constants.BLACK.name));
		blackPieces.add(new ChessPiece(Constants.BISHOP.name,"c8",Constants.BLACK.name));
		blackPieces.add(new ChessPiece(Constants.QUEEN.name,"d8",Constants.BLACK.name));
		blackPieces.add(new ChessPiece(Constants.KING.name,"e8",Constants.BLACK.name));
		blackPieces.add(new ChessPiece(Constants.BISHOP.name,"f8",Constants.BLACK.name));
		blackPieces.add(new ChessPiece(Constants.KNIGHT.name,"g8",Constants.BLACK.name));
		blackPieces.add(new ChessPiece(Constants.ROOK.name,"h8",Constants.BLACK.name));
	}
	public ChessGame() {
		super();
		whitePieces = new ArrayList<>();
		blackPieces = new ArrayList<>();
		initializeChessPieces();
	}
	
	public void makeMove(String whiteMove,String blackMove) {
		
		ChessPiece whitePiece = findRightPieceForMove(whiteMove);
		whitePiece.moveTo(whiteMove);
		ChessPiece blackPiece = findRightPieceForMove(blackMove);
		blackPiece.moveTo(blackMove);	
	}
	
	private ChessPiece findRightPieceForMove(String move) {
		//String[] notations = {"R","N","B","K","Q"};
		String notation = move.substring(0, 1);
		if (notation.equals(Constants.ROOK.name)) {
			
		}
		return null;
	}
	public void displayCurrentStatus() {
		
	}
	
}