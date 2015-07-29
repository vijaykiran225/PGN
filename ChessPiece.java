package PGN;

public class ChessPiece {
	private String name;
	private String currentPosition;
	private boolean isCaptured;
	private String color;
	
	
	public ChessPiece(String name, String currentPosition, String color) {
		super();
		this.name = name;
		this.currentPosition = currentPosition;
		this.isCaptured = false;
		this.color = color;
	}
	
	@Override
	public String toString() {
		return "ChessPiece [name=" + name + ", currentPosition=" + currentPosition + ", isCaptured=" + isCaptured
				+ ", color=" + color + "]";
	}
	public String getName() {
		return name;
	}
	public String getCurrentPosition() {
		return currentPosition;
	}
	public void moveTo(String newPosition) {
		this.currentPosition = newPosition;
	}
	public boolean isCaptured() {
		return isCaptured;
	}
	public void captured() {
		this.isCaptured = true;
	}
	public String getColor() {
		return color;
	}
	public boolean isValidMove(String move) {
		return true;
	}
}
