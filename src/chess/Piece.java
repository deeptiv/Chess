package chess;

import java.util.Set;


public  abstract class Piece {
	public enum Color  { 

		BLACK, WHITE;

		/*private int value; 

		private Color(int value){
			this.value = value;
		}

		public int getColor() {
			return this.value;
		}
		 */	
	};

	private Color color;

	Piece(Color color){
		this.setColor(color);
	}

	public String getColor() {
		return color.toString();
	}

	public void setColor(Color color) {
		this.color = color;
	}



	abstract Set<Square> getPossibleMoves(Square fromSquare, ChessBoard board );


	boolean validateMove(Square toSquare, Set<Square> toSquares){

		for(Square s : toSquares){
			if ( (s.getxCoordinate() == toSquare.getxCoordinate()) && (s.getyCoordinate() == toSquare.getyCoordinate()) ){
				return true;
			}
		}
		return false;

	}

}
