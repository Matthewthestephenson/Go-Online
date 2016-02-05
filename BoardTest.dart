import 'dart:io';
import 'Point.dart';
import 'TestPiece.dart';

void main () {
    Board b = new Board(4);
    //b.printBoard();
    //Board c = b.clone();
    b.placePiece(new TestPiece(Color.BLACK),2,3);
    var z = b.placePiece(new TestPiece(Color.WHITE),2,1);
  //  print(b.whatPiece(2,3));
  //  print("$z");
  //  b.dimension = 5;
    b.printBoard();
    print(b.moves());
    //c.printBoard();
}

class Board
{
    List pieces;
    int dimension;
    Board (int dimension)
    {
        pieces = new List<TestPiece>(dimension*dimension);
        this.dimension = dimension;
        for(int i=0;i<(dimension*dimension);i++)
            pieces[i]=new TestPiece(Color.EMPTY);
    }

    // creates deep copy of the board
    Board clone ()
    {
        Board r = new Board(dimension);
        r.pieces = new List.from(pieces);
        return r;
    }

    // returns a list containing all possible moves in x, y pairs
    List moves()
    {
      List possible = new List<int>();
      for(int i=0;i<dimension*dimension;i++)
      {
        if(pieces[i].color==Color.EMPTY)
          possible.add(i);
      }
      return possible;
        //TODO
    }

    // returns true if legal to place a piece at x, y)
    bool placePiece(TestPiece p, int x, int y)
    {
        if(pieces[convert(x,y)].color!=Color.EMPTY)
          return false;
        pieces[convert(x,y)] = p;
        return true;

    }

    String whatPiece(int x, int y) => pieces[convert(x,y)].toString();

    int convert(int x, int y) => x*dimension+y;

    // prints a representation of a board
    void printBoard ()
    {
      print("$dimension x $dimension");
      for(var j=0;j<dimension;j++)
      {
        for(var i=0;i<dimension;i++)
        {
          stdout.write(pieces[convert(i,j)]);
        }
        print('');
      }
    }
}
