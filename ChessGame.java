package PGN;

import java.util.ArrayList;

public class ChessGame {
	private static final String KING = "K";
	private static final String QUEEN = "Q";
	private static final String BISHOP = "B";
	private static final String KNIGHT = "N";
	private static final String ROOK = "R";
	private static final String PAWN = "P";
	ArrayList<ChessPiece> whitePieces;
	ArrayList<ChessPiece> blackPieces;
	
	private void initializeChessPieces() {
		whitePieces.add(new ChessPiece(PAWN,"a2","white"));
		whitePieces.add(new ChessPiece(PAWN,"b2","white"));
		whitePieces.add(new ChessPiece(PAWN,"c2","white"));
		whitePieces.add(new ChessPiece(PAWN,"d2","white"));
		whitePieces.add(new ChessPiece(PAWN,"e2","white"));
		whitePieces.add(new ChessPiece(PAWN,"f2","white"));
		whitePieces.add(new ChessPiece(PAWN,"g2","white"));
		whitePieces.add(new ChessPiece(PAWN,"h2","white"));
		whitePieces.add(new ChessPiece(ROOK,"a1","white"));
		whitePieces.add(new ChessPiece(KNIGHT,"b1","white"));
		whitePieces.add(new ChessPiece(BISHOP,"c1","white"));
		whitePieces.add(new ChessPiece(QUEEN,"d1","white"));
		whitePieces.add(new ChessPiece(KING,"e1","white"));
		whitePieces.add(new ChessPiece(BISHOP,"f1","white"));
		whitePieces.add(new ChessPiece(KNIGHT,"g1","white"));
		whitePieces.add(new ChessPiece(ROOK,"h1","white"));
		
		blackPieces.add(new ChessPiece(PAWN,"a7","black"));
		blackPieces.add(new ChessPiece(PAWN,"b7","black"));
		blackPieces.add(new ChessPiece(PAWN,"c7","black"));
		blackPieces.add(new ChessPiece(PAWN,"d7","black"));
		blackPieces.add(new ChessPiece(PAWN,"e7","black"));
		blackPieces.add(new ChessPiece(PAWN,"f7","black"));
		blackPieces.add(new ChessPiece(PAWN,"g7","black"));
		blackPieces.add(new ChessPiece(PAWN,"h7","black"));
		blackPieces.add(new ChessPiece(ROOK,"a8","black"));
		blackPieces.add(new ChessPiece(KNIGHT,"b8","black"));
		blackPieces.add(new ChessPiece(BISHOP,"c8","black"));
		blackPieces.add(new ChessPiece(QUEEN,"d8","black"));
		blackPieces.add(new ChessPiece(KING,"e8","black"));
		blackPieces.add(new ChessPiece(BISHOP,"f8","black"));
		blackPieces.add(new ChessPiece(KNIGHT,"g8","black"));
		blackPieces.add(new ChessPiece(ROOK,"h8","black"));
	}
	public ChessGame() {
		super();
		whitePieces = new ArrayList<>();
		blackPieces = new ArrayList<>();
		initializeChessPieces();
	}
	
	public void makeMove(String whiteMove,String blackMove) {
		//nf3 qb6
		int whitePieceIndex = findRightPieceForMove(whiteMove,whitePieces);
		ChessPiece wpiece=whitePieces.get(whitePieceIndex);
		wpiece.moveTo(whiteMove);
		
		System.out.println(wpiece);
		int blackPieceIndex = findRightPieceForMove(blackMove,blackPieces);
		ChessPiece bpiece=whitePieces.get(whitePieceIndex);
		bpiece.moveTo(blackMove);	
		
		System.out.println(bpiece);
	}
	
	private int findRightPieceForMove(String move,ArrayList<ChessPiece> listOfPieces) {
		int indexes[] = null;
		String notation = move.substring(0, 1);
		indexes = retriveIndexes(listOfPieces,notation);
		int index = 0;
		while ( listOfPieces.get(index).isValidMove(move.substring(1, move.length())) ) {
			index++;
		}
		return index;
	}
	private int[] retriveIndexes(ArrayList<ChessPiece> listOfPieces, String name) {
		
		int count = 0;
		for (ChessPiece chessPiece : listOfPieces) {
			if(chessPiece.getName().equals(name))
			{
				count++;
			}
		}
		int[] indexes=new int[count];
		int k=0;
		for (int i = 0; i < listOfPieces.size(); i++) {
			
			if(listOfPieces.get(i).getName().equals(name))
			{
				indexes[k]=i;k++;
			}
			
		}
		
		return indexes;
	}
	public void displayCurrentStatus() {
		
	}
	
}
