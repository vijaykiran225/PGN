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
		if (this.name.equals(Constants.PAWN.name)) {
			if (move.contains(Constants.CAPTURE.name)) {
				if (move.charAt(0) == currentPosition.charAt(0)) {
					if (this.color.equals(Constants.WHITE.name)) {
						isValid = move.substring(2).equals((char)(this.currentPosition.charAt(0) + 1) + "" + (char)(this.currentPosition.charAt(1) + 1));
						isValid |= move.substring(2).equals((char)(this.currentPosition.charAt(0) - 1) + "" + (char)(this.currentPosition.charAt(1) + 1));
					} else {
						isValid = move.substring(2).equals((char)(this.currentPosition.charAt(0) + 1) + "" + (char)(this.currentPosition.charAt(1) - 1));
						isValid |= move.substring(2).equals((char)(this.currentPosition.charAt(0) - 1) + "" + (char)(this.currentPosition.charAt(1) - 1));
					}
				}
			}else if (this.color.equals(Constants.WHITE.name)) {
					isValid = move.equals(this.currentPosition.charAt(0) + "" + (char)(this.currentPosition.charAt(1) + 1));
				if (this.currentPosition.contains(Constants.WHITE_START.name)) {
					isValid |= move.equals(this.currentPosition.charAt(0) + "" + (char)(this.currentPosition.charAt(1) + 2));
				}
			} else {
				isValid = move.equals(this.currentPosition.charAt(0) + "" + (char)(this.currentPosition.charAt(1) - 1));
				if (this.currentPosition.contains(Constants.BLACK_START.name)) {
					isValid |= move.equals(this.currentPosition.charAt(0) + "" + (char)(this.currentPosition.charAt(1) - 2));
				}
			}
		} else if (this.name.equals(Constants.ROOK.name)) {
			String[] current_x_y_position = this.currentPosition.split("");
			String[] new_x_y_position = move.split("");
			System.out.println(currentPosition);
			System.out.println(move);
			if(move.length() == 2) {				
				isValid = (current_x_y_position[0].equals(new_x_y_position[0]) || current_x_y_position[1].equals(new_x_y_position[1]));
			} else {

				if (current_x_y_position[0].equals(new_x_y_position[0])) {
					isValid = (current_x_y_position[0].equals(new_x_y_position[1]) || current_x_y_position[1].equals(new_x_y_position[2]));
				}
			}
		} else if (this.name.equals(Constants.KNIGHT.name)) {
			String[] current_x_y_position = this.currentPosition.split("");
			String[] new_x_y_position = move.split("");
			isValid = ((Math.abs(current_x_y_position[0].charAt(0) - new_x_y_position[0].charAt(0)) == 2) && (Math.abs(current_x_y_position[1].charAt(0) - new_x_y_position[1].charAt(0)) == 1)) 
					|| ((Math.abs(current_x_y_position[0].charAt(0) - new_x_y_position[0].charAt(0)) == 1) && (Math.abs(current_x_y_position[1].charAt(0) - new_x_y_position[1].charAt(0)) == 2));
		} else if (this.name.equals(Constants.BISHOP.name)) {
			String[] current_x_y_position = this.currentPosition.split("");
			String[] new_x_y_position = move.split("");
			isValid = ((Math.abs(current_x_y_position[0].charAt(0) - new_x_y_position[0].charAt(0))) == (Math.abs(current_x_y_position[1].charAt(0) - new_x_y_position[1].charAt(0))));
		} else {
			isValid = this.name.equals(Constants.QUEEN.name) || this.name.equals(Constants.KING.name);
		}
		return isValid;
	}
}
