import 'dart:io';
import 'Point.dart';
import 'TestPiece.dart';

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
    List pieces;
    int dimension;
    // Need to make data storage for board - Make 2D array? or map? or List?, linked hash map?

    Board (int dimension)
    {
        pieces = new List<Piece>(dimension*dimension);
        this.dimension = dimension;
        //TODO
    }

    // creates deep copy of the board
    Board clone ()
    {
        //TODO
        Board r = new Board(dimension);
        r.pieces = new List.from(pieces);
        return r;
    }

    // returns a list containing all possible moves in x, y pairs
    List moves()
    {

    }

    // returns true if legal to place a piece at x, y)
    bool placePiece(Piece p, int x, int y)
    {
        //if(pieces())
        return false;
    }

    int convert(int x, int y) => x*19+y;

    void printBoard ()
    {
      print("$dimension x $dimension");
      print("$pieces");
        //TODO
    }
}
