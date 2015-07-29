package PGN;

public enum Constants {
	KING("K"),
	QUEEN("Q"),
	BISHOP("B"),
	KNIGHT("N"),
	 ROOK("R"),
	PAWN("P");
	
	String name;
	private Constants(String x) {
		// TODO Auto-generated constructor stub
		this.name=x;
	}
}
