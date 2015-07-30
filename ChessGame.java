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
		if (whiteMove.contains("x")) {
			captureChessPiece(whiteMove);
			if (!whiteMove.contains("P")) {
				whiteMove = whiteMove.replace("x", "");
			}
		}
		if (blackMove.contains("x")) {
			captureChessPiece(blackMove);
			if (!blackMove.contains("P")) {
				blackMove = blackMove.replace("x", "");
			}
		}
		if (whiteMove.equals(Constants.KING_SIDE_CASTLING.name)
				|| whiteMove.equals(Constants.QUEEN_SIDE_CASTLING.name)) {
			makeCastling(whiteMove, Constants.WHITE.name);
		} else {
			int index = findRightPieceForMove(whiteMove, Constants.WHITE.name);
			movePieceAtIndex(index, whiteMove);
		}
		if (blackMove.equals(Constants.KING_SIDE_CASTLING.name)
				|| blackMove.equals(Constants.QUEEN_SIDE_CASTLING.name)) {
			makeCastling(blackMove, Constants.BLACK.name);
		} else {
			int index = findRightPieceForMove(blackMove, Constants.BLACK.name);
			movePieceAtIndex(index, blackMove);
		}
	}

	private void captureChessPiece(String move) {
		int index = retrieveChessPieceAtPosition(move.substring(move.length() - 2, move.length()));
		ChessPiece piece = chessPieces.get(index);
		piece.captured();
		chessPieces.set(index, piece);
	}

	private void movePieceAtIndex(int index, String move) {
		ChessPiece piece = chessPieces.get(index);
		piece.moveTo(move.substring(move.length() - 2));
		chessPieces.set(index, piece);
		System.out.println(chessPieces.get(index));
	}

	private void makeCastling(String Move, String color) {

		int rookIndex;
		int kingIndex;
		if (Move.equals(Constants.KING_SIDE_CASTLING.name)) {
			if (color.equals(Constants.WHITE.name)) {

				rookIndex = retrieveChessPieceAtPosition("h1");
				kingIndex = retrieveChessPieceAtPosition("e1");
				movePieceAtIndex(rookIndex, "f1");
				movePieceAtIndex(kingIndex, "g1");
			} else {
				rookIndex = retrieveChessPieceAtPosition("h8");
				kingIndex = retrieveChessPieceAtPosition("e8");
				movePieceAtIndex(rookIndex, "f8");
				movePieceAtIndex(kingIndex, "g8");
			}

		} else if (Move.equals(Constants.QUEEN_SIDE_CASTLING.name)) {
			if (color.equals(Constants.WHITE.name)) {

				rookIndex = retrieveChessPieceAtPosition("a1");
				kingIndex = retrieveChessPieceAtPosition("e1");
				movePieceAtIndex(rookIndex, "d1");
				movePieceAtIndex(kingIndex, "c1");
			} else {
				rookIndex = retrieveChessPieceAtPosition("a8");
				kingIndex = retrieveChessPieceAtPosition("e8");
				movePieceAtIndex(rookIndex, "d8");
				movePieceAtIndex(kingIndex, "c8");
			}
		}
	}

	private int findRightPieceForMove(String move, String color) {

		String notation = move.substring(0, 1);
		int indicesOfPieces[] = retriveIndexes(notation, color);
		int index = 0;
		if (notation.equals(Constants.QUEEN.name) || notation.equals(Constants.KING.name)) {
			index = 0;
		} else {
			while (!chessPieces.get(indicesOfPieces[index]).isValidMove(move.substring(1))) {
				index++;
			}
			if (notation.equals(Constants.ROOK.name)) {
				if (indicesOfPieces.length==2 && (chessPieces.get(indicesOfPieces[0]).isValidMove(move.substring(1)))
						&& (chessPieces.get(indicesOfPieces[1]).isValidMove(move.substring(1)))) {
					index = retrievePieceIndexWithoutObstacles(indicesOfPieces, move.substring(move.length() - 2));
					return indicesOfPieces[index];
				}
			}
		}
		return indicesOfPieces[index];
	}

	private int retrievePieceIndexWithoutObstacles(int[] indexes, String target) {
		// TODO Auto-generated method stub
		int i = 0;
		for (i = 0; i < indexes.length; i++) {
			String position = chessPieces.get(i).getCurrentPosition();
			if (!checkForObstaclesInBetween(position, target)) {
				break;
			}
		}
		return i;
	}

	private boolean checkForObstaclesInBetween(String position, String target) {

		if (position.compareTo(target) > 0) {
			String temp = position;
			position = target;
			target = temp;
		}
		if (position.charAt(0) == target.charAt(0)) {
			char firstLetter = position.charAt(0);
			char secondLetter = position.charAt(1);
			while (secondLetter != target.charAt(1)) {
				secondLetter++;
				String newPos = firstLetter + "" + secondLetter;
				if (retrieveChessPieceAtPosition(newPos) != -1) {
					return true;
				}
			}
		} else {
			char firstLetter = position.charAt(0);
			char secondLetter = position.charAt(1);
			while (firstLetter != target.charAt(0)) {
				firstLetter++;
				String newPos = firstLetter + "" + secondLetter;
				if (retrieveChessPieceAtPosition(newPos) != -1) {
					return true;
				}
			}
		}
		return false;

	}

	private int[] retriveIndexes(String name, String color) {

		int count = 0;
		for (ChessPiece chessPiece : chessPieces) {

			if (chessPiece.getName().equals(name) && chessPiece.getColor().equals(color)
					&& chessPiece.isNotCaptured()) {

				count++;
			}
		}
		int[] indexes = new int[count];
		int k = 0;
		for (int i = 0; i < chessPieces.size(); i++) {

			if (chessPieces.get(i).getName().equals(name) && chessPieces.get(i).getColor().equals(color)
					&& chessPieces.get(i).isNotCaptured()) {

				indexes[k] = i;
				k++;
			}
		}
		return indexes;
	}

	private int retrieveChessPieceAtPosition(String position) {
		int index = 0;
		while (index < chessPieces.size() && !chessPieces.get(index).getCurrentPosition().equals(position)) {
			index++;
		}
		if (index == chessPieces.size()) {
			return -1;
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
