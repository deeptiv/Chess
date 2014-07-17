package chess;

import java.util.Scanner;
import java.util.Set;




public class GameController {

	Player black = new Player("black");
	Player white = new Player("white");

	public void startNewGame(){

		ChessBoard board = new ChessBoard();


		board.initializeBoard();

		board.printBoard();

		while (!board.isGameOver()){
			System.out.println("black player turn");
			takeTurn(board);
			board.printBoard();
			if (!board.isGameOver()){
				System.out.println("white player turn");
				takeTurn(board);
				board.printBoard();
			}
		}

	}

	public void takeTurn(ChessBoard board){
		while (true != tryMove(board)){};

	}

	private boolean tryMove(ChessBoard board){
		//take user input for pieceToMove, fromSquare from mouse/touch

		System.out.println("Enter x and y pos of the piece to move");
		Square fromSquare = getUserInput();
		Square[][] boardSquares = board.getSquares();

		Piece pieceToMove = boardSquares[fromSquare.getxCoordinate()][fromSquare.getyCoordinate()].getPiece();

		if(pieceToMove != null){
			Set<Square> toSquares = pieceToMove.getPossibleMoves(fromSquare, board); //display possible moves if help is ON
			if(toSquares.size() != 0){
				for (Square s: toSquares){
					System.out.println("You can possibly move to (" + s.getxCoordinate() + "," + s.getyCoordinate() +")");
				}
			} else {
				System.out.println("no possible moves. Try some other move");
				return false;
			}

			boolean validInputforToLocation = false;
			while(!validInputforToLocation){
				//get user input for toLocation		
				System.out.println("Enter x and y pos of toLocation");
				Square toSquare = getUserInput();

				if (pieceToMove.validateMove(toSquare, toSquares)){
					if(boardSquares[toSquare.getxCoordinate()][toSquare.getyCoordinate()].getPiece() != null){
						System.out.println("piece killed!");
					}
					boardSquares[toSquare.getxCoordinate()][toSquare.getyCoordinate()].setPiece(pieceToMove);
					boardSquares[fromSquare.getxCoordinate()][fromSquare.getyCoordinate()].setPiece(null);
					System.out.println("move successful");
					validInputforToLocation = true;
					return true;
				} else {
					System.out.println("not possible to move to said location. Try some other toLocation");
				}
			}
		} else {
			System.out.println("no piece at your selected position. try some other move");
			return false;
		}
		return false;
	}

	Square getUserInput(){

		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		int y = scan.nextInt();
		System.out.println("You entered (" + x + ", " +y +")");

		Square inputSquare = new Square();
		inputSquare.setxCoordinate(x);
		inputSquare.setyCoordinate(y);

		return inputSquare;

	}


	public static void main(String[] args){

		GameController gameController = new GameController();

		gameController.startNewGame();

	}



}
