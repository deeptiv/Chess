package chess;




public class ChessBoard {

	private Square[][] squares = new Square[8][8];


	public Square[][] getSquares() {
		return squares;
	}

	public void setSquares(Square[][] squares) {
		this.squares = squares;
	}

	void initializeBoard(){

		//set the color of board squares, alternate black and white
		boolean alt_white_flag = false;

		for(int i = 0; i < 8; i++) {
			alt_white_flag = !alt_white_flag;
			for (int j = 0; j < 8; j++) {
				squares[i][j] = new Square();
				if (alt_white_flag) {
					squares[i][j].setColor(Square.Color.WHITE);
					alt_white_flag = false;
				} else {
					squares[i][j].setColor(Square.Color.BLACK);
					alt_white_flag = true;
				}

			}
		}

		//place black pieces on the board
		for(int i = 0; i < 2; i++) {
			for (int j = 0; j < 8; j++) {			
				Piece piece = new Pawn(Piece.Color.BLACK);
				squares[i][j].setPiece(piece);
			}
		}

		//place white pieces on the board
		for(int i = 6; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Piece piece = new Pawn(Piece.Color.WHITE);
				squares[i][j].setPiece(piece);
			}
		}

		for(int i = 2; i < 6 ; i++) {
			for (int j = 0; j < 8; j++) {
				squares[i][j].setPiece(null);
			}
		}



	}

	void printBoard(){
		for (int i=0; i<8; i++){
			for (int j=0; j<8; j++){
				if(this.squares[i][j].getPiece() != null){
					System.out.printf("(%d,"  + "%d)->" + "%s " , i,j,this.squares[i][j].getPiece().getColor());
				} else {
					System.out.printf("(%d,"  + "%d)->" + "%s " , i,j , "empty");
				}

			}
			System.out.println("\n");
		}

		/*		for (int i=0; i<8; i++){
			for (int j=0; j<8; j++){
				if(this.squares[i][j] != null){
					System.out.printf("(%d,"  + "%d)->" + "%s " , i,j,this.squares[i][j].getColor());
				} else {
					System.out.printf("(%d,"  + "%d)->" + "%s " , i,j , "empty");
				}

			}
			System.out.println("\n");
		}
		 */	}

	boolean isGameOver(){
		for (int i=0; i<8; i++){
			for (int j=0; j<8; j++){
				if(this.squares[i][j].getPiece() != null){
					return false;
				}
			}
		}
		return true;
	}

	public static final boolean indexIsInRangeOfBoard(int x, int y){
		if ( (x>=0 && x <=7) && (y>=0 && y<=7)){
			return true;
		} else return false;
	}

	public static void main(String[] args){

		ChessBoard b = new ChessBoard();
		b.initializeBoard();
		b.printBoard();
		System.out.println("(0,1) hasPiece " + b.squares[0][1].hasPiece());
		System.out.println("(3,1) hasPiece " + b.squares[3][1].hasPiece());


	}
}