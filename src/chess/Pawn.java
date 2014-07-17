package chess;

import java.util.HashSet;
import java.util.Set;

public class Pawn extends Piece{

	Pawn(Color color) {
		super(color);
		// TODO Auto-generated constructor stub
	}

	@Override
	// Pawn can move one square straight if the square is empty
	Set<Square> getPossibleMoves(Square fromSquare, ChessBoard board) {
		int x = fromSquare.getxCoordinate();
		int y = fromSquare.getyCoordinate();
		Set<Square> toSquares = new HashSet<Square>();
		Square[][] boardSquares = board.getSquares();
		Piece pieceAtCurrentSquare = boardSquares[x][y].getPiece();


		//one square forward
		Square oneSquareForward = new Square();
		if( pieceAtCurrentSquare.getColor() == "BLACK"){
			if( boardSquares[x+1][y].getPiece() == null ){
				oneSquareForward.setxCoordinate(x+1);
				oneSquareForward.setyCoordinate(y);
				toSquares.add(oneSquareForward);
			}
		} else if (( pieceAtCurrentSquare.getColor() == "WHITE")) {
			if( boardSquares[x-1][y].getPiece() == null ){
				oneSquareForward.setxCoordinate(x-1);
				oneSquareForward.setyCoordinate(y);
				toSquares.add(oneSquareForward);
			}
		}

		//one square diagonal
		
		if( pieceAtCurrentSquare.getColor() == "BLACK"){
			if( ChessBoard.indexIsInRangeOfBoard((x+1),(y-1)) && ((boardSquares[x+1][y-1].getPiece() != null) && (boardSquares[x+1][y-1].getPiece().getColor() != "BLACK") ) )
			{
				Square oneSquareDiagonalLeft = new Square();
				oneSquareDiagonalLeft.setxCoordinate(x+1);
				oneSquareDiagonalLeft.setyCoordinate(y-1);
				toSquares.add(oneSquareDiagonalLeft);
			}
			if(ChessBoard.indexIsInRangeOfBoard((x+1),(y+1)) && ((boardSquares[x+1][y+1].getPiece() != null) && (boardSquares[x+1][y+1].getPiece().getColor() != "BLACK") )){
				Square oneSquareDiagonalRight = new Square();
				oneSquareDiagonalRight.setxCoordinate(x+1);
				oneSquareDiagonalRight.setyCoordinate(y+1);
				toSquares.add(oneSquareDiagonalRight);
			}
		} else if (( pieceAtCurrentSquare.getColor() == "WHITE")) {
			if( ChessBoard.indexIsInRangeOfBoard((x-1),(y-1)) && ((boardSquares[x-1][y-1].getPiece() != null) && (boardSquares[x-1][y-1].getPiece().getColor() != "WHITE") ) )
			{
				Square oneSquareDiagonalLeft = new Square();
				oneSquareDiagonalLeft.setxCoordinate(x-1);
				oneSquareDiagonalLeft.setyCoordinate(y-1);
				toSquares.add(oneSquareDiagonalLeft);
			}
			if(ChessBoard.indexIsInRangeOfBoard((x-1),(y+1)) && ((boardSquares[x-1][y+1].getPiece() != null) && (boardSquares[x-1][y+1].getPiece().getColor() != "WHITE") )){
				Square oneSquareDiagonalRight = new Square();
				oneSquareDiagonalRight.setxCoordinate(x-1);
				oneSquareDiagonalRight.setyCoordinate(y+1);
				toSquares.add(oneSquareDiagonalRight);
			}
		}

		return toSquares;
	}



}
