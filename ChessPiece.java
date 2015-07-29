package PGN;

import java.util.ArrayList;
import java.util.List;

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
	public boolean isNotCaptured() {
		return !isCaptured;
	}
	public void captured() {
		this.isCaptured = true;
	}
	public String getColor() {
		return color;
	}
	public boolean isValidMove(String move) {
		boolean isValid = false;
		if (this.name == "P") {
			if (move.contains("x")) {
				if (move.charAt(0) == currentPosition.charAt(0)) {
					if (this.color == "white") {
						isValid = move.substring(1).equals((char)(this.currentPosition.charAt(0) + 1) + "" + (char)(this.currentPosition.charAt(1) + 1));
						isValid |= move.substring(1).equals((char)(this.currentPosition.charAt(0) - 1) + "" + (char)(this.currentPosition.charAt(1) + 1));
					} else {
						isValid = move.substring(1).equals((char)(this.currentPosition.charAt(0) + 1) + "" + (char)(this.currentPosition.charAt(1) - 1));
						isValid |= move.substring(1).equals((char)(this.currentPosition.charAt(0) - 1) + "" + (char)(this.currentPosition.charAt(1) - 1));
					}
				}
			} else {
				if (this.color == "white") {
					isValid = move.equals(this.currentPosition.charAt(0) + "" + (char)(this.currentPosition.charAt(1) + 1));
				} else {
					isValid = move.equals(this.currentPosition.charAt(0) + "" + (char)(this.currentPosition.charAt(1) - 1));
				}
			}
		} else if (this.name == "R") {
			String[] current_x_y_position = this.currentPosition.split("");
			String[] new_x_y_position = move.split("");
			isValid = (current_x_y_position[0] == new_x_y_position[0]) || (current_x_y_position[1] == new_x_y_position[1]);
		} else if (this.name == "N") {
			String[] current_x_y_position = this.currentPosition.split("");
			String[] new_x_y_position = move.split("");
			isValid = ((Math.abs(current_x_y_position[0].charAt(0) - new_x_y_position[0].charAt(0)) == 2) && (Math.abs(current_x_y_position[1].charAt(0) - new_x_y_position[1].charAt(0)) == 1)) || ((Math.abs(current_x_y_position[0].charAt(0) - new_x_y_position[0].charAt(0)) == 2) && (Math.abs(current_x_y_position[1].charAt(0) - new_x_y_position[1].charAt(0)) == 1));
		} else if (this.name == "B") {
			String[] current_x_y_position = this.currentPosition.split("");
			String[] new_x_y_position = move.split("");
			isValid = ((Math.abs(current_x_y_position[0].charAt(0) - new_x_y_position[0].charAt(0))) == (Math.abs(current_x_y_position[1].charAt(0) - new_x_y_position[1].charAt(0))));
		} else {
			isValid = this.name == "Q" || this.name == "K";
		}
		return isValid;
	}
}
