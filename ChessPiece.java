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
	public boolean isCaptured() {
		return isCaptured;
	}
	public void setCaptured(boolean isCaptured) {
		this.isCaptured = isCaptured;
	}
	public String getColor() {
		return color;
	}	
}
