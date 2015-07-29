package PGN;

import java.util.ArrayList;

public class ChessGame {

	ArrayList<ChessPiece> whitePieces;
	ArrayList<ChessPiece> blackPieces;

	private void initializeChessPieces() {
		whitePieces.add(new ChessPiece(Constants.PAWN.name, "a2", Constants.WHITE.name));
		whitePieces.add(new ChessPiece(Constants.PAWN.name, "b2", Constants.WHITE.name));
		whitePieces.add(new ChessPiece(Constants.PAWN.name, "c2", Constants.WHITE.name));
		whitePieces.add(new ChessPiece(Constants.PAWN.name, "d2", Constants.WHITE.name));
		whitePieces.add(new ChessPiece(Constants.PAWN.name, "e2", Constants.WHITE.name));
		whitePieces.add(new ChessPiece(Constants.PAWN.name, "f2", Constants.WHITE.name));
		whitePieces.add(new ChessPiece(Constants.PAWN.name, "g2", Constants.WHITE.name));
		whitePieces.add(new ChessPiece(Constants.PAWN.name, "h2", Constants.WHITE.name));
		whitePieces.add(new ChessPiece(Constants.ROOK.name, "a1", Constants.WHITE.name));
		whitePieces.add(new ChessPiece(Constants.KNIGHT.name, "b1", Constants.WHITE.name));
		whitePieces.add(new ChessPiece(Constants.BISHOP.name, "c1", Constants.WHITE.name));
		whitePieces.add(new ChessPiece(Constants.QUEEN.name, "d1", Constants.WHITE.name));
		whitePieces.add(new ChessPiece(Constants.KING.name, "e1", Constants.WHITE.name));
		whitePieces.add(new ChessPiece(Constants.BISHOP.name, "f1", Constants.WHITE.name));
		whitePieces.add(new ChessPiece(Constants.KNIGHT.name, "g1", Constants.WHITE.name));
		whitePieces.add(new ChessPiece(Constants.ROOK.name, "h1", Constants.WHITE.name));

		blackPieces.add(new ChessPiece(Constants.PAWN.name, "a7", Constants.BLACK.name));
		blackPieces.add(new ChessPiece(Constants.PAWN.name, "b7", Constants.BLACK.name));
		blackPieces.add(new ChessPiece(Constants.PAWN.name, "c7", Constants.BLACK.name));
		blackPieces.add(new ChessPiece(Constants.PAWN.name, "d7", Constants.BLACK.name));
		blackPieces.add(new ChessPiece(Constants.PAWN.name, "e7", Constants.BLACK.name));
		blackPieces.add(new ChessPiece(Constants.PAWN.name, "f7", Constants.BLACK.name));
		blackPieces.add(new ChessPiece(Constants.PAWN.name, "g7", Constants.BLACK.name));
		blackPieces.add(new ChessPiece(Constants.PAWN.name, "h7", Constants.BLACK.name));
		blackPieces.add(new ChessPiece(Constants.ROOK.name, "a8", Constants.BLACK.name));
		blackPieces.add(new ChessPiece(Constants.KNIGHT.name, "b8", Constants.BLACK.name));
		blackPieces.add(new ChessPiece(Constants.BISHOP.name, "c8", Constants.BLACK.name));
		blackPieces.add(new ChessPiece(Constants.QUEEN.name, "d8", Constants.BLACK.name));
		blackPieces.add(new ChessPiece(Constants.KING.name, "e8", Constants.BLACK.name));
		blackPieces.add(new ChessPiece(Constants.BISHOP.name, "f8", Constants.BLACK.name));
		blackPieces.add(new ChessPiece(Constants.KNIGHT.name, "g8", Constants.BLACK.name));
		blackPieces.add(new ChessPiece(Constants.ROOK.name, "h8", Constants.BLACK.name));
	}

	public ChessGame() {
		super();
		whitePieces = new ArrayList<>();
		blackPieces = new ArrayList<>();
		initializeChessPieces();
	}

	public void makeMove(String whiteMove, String blackMove) {
		// nf3 qb6
		if(whiteMove.equals(Constants.KING_SIDE_CASTLING.name) ||whiteMove.equals(Constants.QUEEN_SIDE_CASTLING.name))
		{
			whitePieces=makeCastling(whiteMove,whitePieces);
		}
		else{
		int whitePieceIndex = findRightPieceForMove(whiteMove, whitePieces);
		ChessPiece wpiece = whitePieces.get(whitePieceIndex);
		wpiece.moveTo(whiteMove.substring(1));

		System.out.println(wpiece);
		}
		if(blackMove.equals(Constants.KING_SIDE_CASTLING.name)|| blackMove.equals(Constants.QUEEN_SIDE_CASTLING.name))
		{
			blackPieces=makeCastling(blackMove,blackPieces);
		}else{
		int blackPieceIndex = findRightPieceForMove(blackMove, blackPieces);
		ChessPiece bpiece = blackPieces.get(blackPieceIndex);
		bpiece.moveTo(blackMove.substring(1));

		System.out.println(bpiece);
		}
	}

	
	private ArrayList<ChessPiece> makeCastling(String Move, ArrayList<ChessPiece> Pieces) {
		// TODO Auto-generated method stub

		if(Move.equals(Constants.KING_SIDE_CASTLING.name))
		{
			for (ChessPiece chessPiece : Pieces) {
				if(chessPiece.getName().equals(Constants.KING.name)){
					if(chessPiece.getColor().equals(Constants.BLACK.name))
					{
//						System.out.println(chessPiece);
						chessPiece.moveTo("g8");
						System.out.println(chessPiece);
					}else{
//						System.out.println(chessPiece);
						chessPiece.moveTo("g1");
						System.out.println(chessPiece);
					}
					
					
				}
				if(chessPiece.getName().equals(Constants.ROOK.name)){
					if(chessPiece.getColor().equals(Constants.BLACK.name))
					{
//						System.out.println(chessPiece);
						chessPiece.moveTo("f8");
						System.out.println(chessPiece);
					}else{
//						System.out.println(chessPiece);
						chessPiece.moveTo("f1");
						System.out.println(chessPiece);
					}
				}
			}
		}else if(Move.equals(Constants.QUEEN_SIDE_CASTLING.name))
		{
			for (ChessPiece chessPiece : Pieces) {
				if(chessPiece.getName().equals(Constants.KING.name)){
					if(chessPiece.getColor().equals(Constants.BLACK.name))
					{
//						System.out.println(chessPiece);
						chessPiece.moveTo("c8");
						System.out.println(chessPiece);
					}else{
//						System.out.println(chessPiece);
						chessPiece.moveTo("c1");
						System.out.println(chessPiece);
					}
				}
				if(chessPiece.getName().equals(Constants.ROOK.name)){
					if(chessPiece.getColor().equals(Constants.BLACK.name))
					{
//						System.out.println(chessPiece);
						chessPiece.moveTo("d8");
						System.out.println(chessPiece);
					}else{
//						System.out.println(chessPiece);
						chessPiece.moveTo("d1");
						System.out.println(chessPiece);
					}
				}
			}
		}
		return Pieces;
	}

	

	private int findRightPieceForMove(String move, ArrayList<ChessPiece> listOfPieces) {
		String notation = move.substring(0, 1);
		int indexes[] = retriveIndexes(listOfPieces, notation);
		int index = 0;
		if (notation.equals(Constants.QUEEN.name) || notation.equals(Constants.KING.name)) {
			index = indexes[0];
		} else {
			while (!listOfPieces.get(indexes[index]).isValidMove(move.substring(1, move.length()))) {
				index++;
			}
		}
		return index;
	}

	private int[] retriveIndexes(ArrayList<ChessPiece> listOfPieces, String name) {

		int count = 0;
		for (ChessPiece chessPiece : listOfPieces) {
			if (chessPiece.getName().equals(name)) {
				count++;
			}
		}
		int[] indexes = new int[count];
		int k = 0;
		for (int i = 0; i < listOfPieces.size(); i++) {

			if (listOfPieces.get(i).getName().equals(name)) {
				indexes[k] = i;
				k++;
			}
		}
		return indexes;
	}

	public void displayCurrentStatus() {

		System.out.println("Black pieces status");
		for (ChessPiece chessPiece : blackPieces) {
			System.out.println(chessPiece);
		}
		System.out.println("White pieces status");
		for (ChessPiece chessPiece : whitePieces) {
			System.out.println(chessPiece);
		}
		
	}

}
