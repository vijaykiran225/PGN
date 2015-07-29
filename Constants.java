package PGN;

public enum Constants {
	KING("K"),
	QUEEN("Q"),
	BISHOP("B"),
	KNIGHT("N"),
	 ROOK("R"),
	PAWN("P"),
	BLACK("black"),
	WHITE ("white"),
	QUEEN_SIDE_CASTLING("O-O-O"),
	KING_SIDE_CASTLING("O-O");
	
	String name;
	private Constants(String x) {
		// TODO Auto-generated constructor stub
		this.name=x;
	}
}
