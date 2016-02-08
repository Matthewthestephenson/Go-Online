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
    print(new Point(2,3) == (new Point (1,3)));
    //  b.dimension = 5;
    b.printBoard();
    print(b.moves(Color.WHITE));
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
    List moves(Color c)
    {
      List possible = new List<Point>();
      for(int i=0;i<dimension*dimension;i++)
      {
        if(validPlacement(new TestPiece(c),convertX(i),convertY(i)))
          possible.add(new Point(convertX(i),convertY(i)));
      }
      return possible;
        //TODO
    }

    // Attempts to place a piece at (x,y) and returns true if successful
    bool placePiece(TestPiece p, int x, int y)
    {
        if(!validPlacement(p,x,y))
          return false;
        pieces[convertI(x,y)] = p;
        // add to moves list
        return true;
    }

    // clears intersections for given color
    void capture(Color c) {
      // TODO
    }

    // returns true if legal to place a piece at (x, y)
    bool validPlacement(TestPiece p, int x, int y)
    {
      //TODO - add move restrictions based on previous plays
      return pieces[convertI(x,y)].color!=Color.EMPTY;
    }

    // returns a string representation of a piece stored at a given xy coordinate
    String whatPiece(int x, int y) => pieces[convert(x,y)].toString();

    // converts from rectangular coordinates to linear location in List
    int convertI(int x, int y) => y*dimension+x;

    // converts index in List to x coordinate
    int convertX(int i) => i%dimension;

    // converts index in List to y coordinate
    int convertY(int i) => i~/dimension;

    // prints a representation of a board
    void printBoard ()
    {
      print("$dimension x $dimension");
      for(var j=0;j<dimension;j++)
      {
        for(var i=0;i<dimension;i++)
        {
          stdout.write(pieces[convertI(i,j)]);
        }
        print('');
      }
    }

}
