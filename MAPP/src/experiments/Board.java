package experiments;

import java.awt.List;
import java.awt.Point;
import java.util.ArrayList;


public class Board {
		
	    private Color[][] pieces;
	    private int dimension;
	    
	    public Board (int dimension)
	    {
	        pieces = new Color[dimension][dimension];
	        this.dimension = dimension;
	        for(int i=0;i<dimension;i++)
	        	for(int j;j<dimension;j++)
	        		pieces[i][j]=Color.EMPTY;
	    }

	    // creates deep copy of the board
	    public Board clone ()
	    {
	        Board r = new Board(dimension);
//	        r.pieces = ;
	        return r;
	    }

	    // returns a list containing all possible moves in x, y pairs
	    public ArrayList<Integer> moves(Color c)
	    {
	      ArrayList<Integer> possible = new  ArrayList<Integer>();
	      for(int i=0;i<dimension*dimension;i++)
	      {
	        if(validPlacement(c,convertX(i),convertY(i)))
	          possible.add(new Point(convertX(i),convertY(i)));
	      }
	      return possible;
	        //TODO
	    }

	    // Attempts to place a piece at (x,y) and returns true if successful
	    public boolean placePiece(Color c, int x, int y)
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

	    //calculate score (territory) for given color
	    int score(Color c)
	    {
	      // TODO - create a list of examined intersections?
	      return 0;
	    }

	    // returns true if legal to place a piece at (x, y)
	    bool validPlacement(Color p, int x, int y)
	    {
	      //TODO - add move restrictions based on previous plays
	      return pieces[x][y]==Color.EMPTY;
	    }

	    // returns a string representation of a piece stored at a given xy coordinate
	    String whatPiece(int x, int y) => pieces[convertI(x,y)].toString();

	    // converts from rectangular coordinates to linear location in List
	    int convertI(int x, int y) => y*dimension+x;

	    // converts index in List to x coordinate
	    int convertX(int i) => i%dimension;

	    // converts index in List to y coordinate
	    int convertY(int i) => i~/dimension;

	    // prints a representation of a board
	    void printBoard ()
	    {
	  //    print("$dimension x $dimension");
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

}
