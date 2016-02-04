import 'dart:io';
import 'Point.dart';
import 'TestPiece.dart';
import 'Piece.dart';

void main () {
    Board b = new Board(4);
    b.printBoard();
    Board c = b.clone();
    b.placePiece(new TestPiece("white",3,4));
    var z = b.placePiece(new TestPiece("black",3,4));
    print("$z");
    b.dimension = 5;
    b.printBoard();
    c.printBoard();
}

class Board
{
    Map pieces;
    int dimension;
    // Need to make data storage for board - Make 2D array? or map? or List?

    Board (int dimension)
    {
        pieces = new Map<Point,Piece>();
        this.dimension = dimension;
        //TODO
    }

    // creates deep copy of the board
    Board clone ()
    {
        //TODO
        Board r = new Board(dimension);
        r.pieces = new Map.from(pieces);
        return r;
    }

    bool placePiece(Piece p)
    {
        if(pieces.containsKey(p.position))
          return false;
        pieces[p.position] = p;
        return true;
    }

    void printBoard ()
    {
      print("$dimension x $dimension");
      print("$pieces");
        //TODO
    }
}
