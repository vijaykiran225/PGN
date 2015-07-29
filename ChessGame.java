package PGN;

import java.util.ArrayList;

public class ChessGame {

	ArrayList<ChessPiece> chessPieces;

	private void initializeChessPieces() {
		chessPieces.add(new ChessPiece(Constants.PAWN.name, "a2", Constants.WHITE.name));
		chessPieces.add(new ChessPiece(Constants.PAWN.name, "b2", Constants.WHITE.name));
		chessPieces.add(new ChessPiece(Constants.PAWN.name, "c2", Constants.WHITE.name));
		chessPieces.add(new ChessPiece(Constants.PAWN.name, "d2", Constants.WHITE.name));
		chessPieces.add(new ChessPiece(Constants.PAWN.name, "e2", Constants.WHITE.name));
		chessPieces.add(new ChessPiece(Constants.PAWN.name, "f2", Constants.WHITE.name));
		chessPieces.add(new ChessPiece(Constants.PAWN.name, "g2", Constants.WHITE.name));
		chessPieces.add(new ChessPiece(Constants.PAWN.name, "h2", Constants.WHITE.name));
		chessPieces.add(new ChessPiece(Constants.ROOK.name, "a1", Constants.WHITE.name));
		chessPieces.add(new ChessPiece(Constants.KNIGHT.name, "b1", Constants.WHITE.name));
		chessPieces.add(new ChessPiece(Constants.BISHOP.name, "c1", Constants.WHITE.name));
		chessPieces.add(new ChessPiece(Constants.QUEEN.name, "d1", Constants.WHITE.name));
		chessPieces.add(new ChessPiece(Constants.KING.name, "e1", Constants.WHITE.name));
		chessPieces.add(new ChessPiece(Constants.BISHOP.name, "f1", Constants.WHITE.name));
		chessPieces.add(new ChessPiece(Constants.KNIGHT.name, "g1", Constants.WHITE.name));
		chessPieces.add(new ChessPiece(Constants.ROOK.name, "h1", Constants.WHITE.name));

		chessPieces.add(new ChessPiece(Constants.PAWN.name, "a7", Constants.BLACK.name));
		chessPieces.add(new ChessPiece(Constants.PAWN.name, "b7", Constants.BLACK.name));
		chessPieces.add(new ChessPiece(Constants.PAWN.name, "c7", Constants.BLACK.name));
		chessPieces.add(new ChessPiece(Constants.PAWN.name, "d7", Constants.BLACK.name));
		chessPieces.add(new ChessPiece(Constants.PAWN.name, "e7", Constants.BLACK.name));
		chessPieces.add(new ChessPiece(Constants.PAWN.name, "f7", Constants.BLACK.name));
		chessPieces.add(new ChessPiece(Constants.PAWN.name, "g7", Constants.BLACK.name));
		chessPieces.add(new ChessPiece(Constants.PAWN.name, "h7", Constants.BLACK.name));
		chessPieces.add(new ChessPiece(Constants.ROOK.name, "a8", Constants.BLACK.name));
		chessPieces.add(new ChessPiece(Constants.KNIGHT.name, "b8", Constants.BLACK.name));
		chessPieces.add(new ChessPiece(Constants.BISHOP.name, "c8", Constants.BLACK.name));
		chessPieces.add(new ChessPiece(Constants.QUEEN.name, "d8", Constants.BLACK.name));
		chessPieces.add(new ChessPiece(Constants.KING.name, "e8", Constants.BLACK.name));
		chessPieces.add(new ChessPiece(Constants.BISHOP.name, "f8", Constants.BLACK.name));
		chessPieces.add(new ChessPiece(Constants.KNIGHT.name, "g8", Constants.BLACK.name));
		chessPieces.add(new ChessPiece(Constants.ROOK.name, "h8", Constants.BLACK.name));
	}

	public ChessGame() {
		super();
		chessPieces = new ArrayList<>();
		initializeChessPieces();
	}

	public void makeMove(String whiteMove, String blackMove) {
		if ( whiteMove.contains("x")) {
			captureChessPiece(whiteMove);
		}
		if ( blackMove.contains("x")) {
			captureChessPiece(blackMove);
		}
		if (whiteMove.equals(Constants.KING_SIDE_CASTLING.name) || whiteMove.equals(Constants.QUEEN_SIDE_CASTLING.name)) {
			chessPieces = makeCastling(whiteMove, chessPieces);
		} else {
			int index = findRightPieceForMove(whiteMove, Constants.WHITE.name);
			movePieceAtIndex(index,whiteMove);
		}
		if (blackMove.equals(Constants.KING_SIDE_CASTLING.name) || blackMove.equals(Constants.QUEEN_SIDE_CASTLING.name)) {
			chessPieces = makeCastling(blackMove, chessPieces);
		} else {
			int index = findRightPieceForMove(blackMove, Constants.BLACK.name);
			movePieceAtIndex(index, blackMove);
		}
	}
	private void captureChessPiece(String move) {
		int index = retrieveChessPieceAtPosition(move.substring(move.length()-2, move.length()));
		ChessPiece piece = chessPieces.get(index);
		piece.captured();
		chessPieces.set(index, piece);
	}
	private void movePieceAtIndex(int index,String move) {
		ChessPiece piece = chessPieces.get(index);
		piece.moveTo(move.substring(1));
		chessPieces.set(index, piece);
		System.out.println(piece);
	}
	private ArrayList<ChessPiece> makeCastling(String Move, ArrayList<ChessPiece> Pieces) {

		if (Move.equals(Constants.KING_SIDE_CASTLING.name)) {
			for (ChessPiece chessPiece : Pieces) {
				if (chessPiece.getName().equals(Constants.KING.name)) {
					if (chessPiece.getColor().equals(Constants.BLACK.name)) {
						// System.out.println(chessPiece);
						chessPiece.moveTo("g8");
						System.out.println(chessPiece);
					} else {
						// System.out.println(chessPiece);
						chessPiece.moveTo("g1");
						System.out.println(chessPiece);
					}
					
					
				}
				if (chessPiece.getName().equals(Constants.ROOK.name)) {
					if (chessPiece.getColor().equals(Constants.BLACK.name)) {
						// System.out.println(chessPiece);
						chessPiece.moveTo("f8");
						System.out.println(chessPiece);
					} else {
						// System.out.println(chessPiece);
						chessPiece.moveTo("f1");
						System.out.println(chessPiece);
					}
				}
			}
		} else if (Move.equals(Constants.QUEEN_SIDE_CASTLING.name)) {
			for (ChessPiece chessPiece : Pieces) {
				if (chessPiece.getName().equals(Constants.KING.name)) {
					if (chessPiece.getColor().equals(Constants.BLACK.name)) {
						// System.out.println(chessPiece);
						chessPiece.moveTo("c8");
						System.out.println(chessPiece);
					} else {
						// System.out.println(chessPiece);
						chessPiece.moveTo("c1");
						System.out.println(chessPiece);
					}
				}
				if (chessPiece.getName().equals(Constants.ROOK.name)) {
					if (chessPiece.getColor().equals(Constants.BLACK.name)) {
						// System.out.println(chessPiece);
						chessPiece.moveTo("d8");
						System.out.println(chessPiece);
					} else {
						// System.out.println(chessPiece);
						chessPiece.moveTo("d1");
						System.out.println(chessPiece);
					}
				}
			}
		}
		return Pieces;
	}

	private int findRightPieceForMove(String move, String color) {

		String notation = move.substring(0, 1);
		int indexes[] = retriveIndexes(notation, color);
		int index = 0;
		if (notation.equals(Constants.QUEEN.name) || notation.equals(Constants.KING.name)) {
			index = indexes[0];
		} else {
			while (!chessPieces.get(indexes[index]).isValidMove(move.substring(1, move.length()))) {
				index++;
			}
		}
		return index;
	}

	private int[] retriveIndexes(String name, String color) {

		int count = 0;
		for (ChessPiece chessPiece : chessPieces) {
			if (chessPiece.getName().equals(name) && chessPiece.getColor().equals(color) && !chessPiece.isCaptured()) {
				count++;
			}
		}
		int[] indexes = new int[count];
		int k = 0;
		for (int i = 0; i < chessPieces.size(); i++) {

			if (chessPieces.get(i).getName().equals(name) && chessPieces.get(i).getColor().equals(color) && !chessPieces.get(i).isCaptured()) {
				indexes[k] = i;
				k++;
			}
		}
		return indexes;
	}

	private int retrieveChessPieceAtPosition(String position) {
		int index = 0;
		while (!chessPieces.get(index).getCurrentPosition().equals(position)) {
			index++;
		}
		return index;
	}

	public void displayCurrentStatus() {

		System.out.println("Black pieces status");
		for (ChessPiece chessPiece : chessPieces) {
			System.out.println(chessPiece);
		}
		System.out.println("White pieces status");
		for (ChessPiece chessPiece : chessPieces) {
			System.out.println(chessPiece);
		}
	}

}
