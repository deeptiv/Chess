package chess;




public class Player {

	private String color;

	Player(String color){
		this.setColor(color);
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}


}