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
			for(int j = 0;j<dimension;j++)
				pieces[i][j]=Color.EMPTY;
	}

	// creates deep copy of the board
	public Board clone ()
	{
		Board r = new Board(dimension);
		r.pieces = pieces.clone();
		return r;
	}

	// returns a list containing all possible moves in x, y pairs
	public ArrayList<Point> moves(Color c)
	{
		ArrayList<Point> possible = new ArrayList<Point>();
		for(int i=0;i<dimension;i++)
		{
			for(int j=0;j<dimension;j++)
				if(validPlacement(c,i,j))
					possible.add(new Point(i,j));
		}
		return possible;
		//TODO
	}

	// Attempts to place a piece at (x,y) and returns true if successful
	public boolean placePiece(Color c, int x, int y)
	{
		if(!validPlacement(c,x,y))
			return false;
		pieces[y][x] = c;
		// add to moves list
		return true;
	}

	// clears intersections for given color
	private void capture(Color c) {
		// TODO
	}

	//calculate score (territory) for given color
	private int score(Color c)
	{
		// TODO - create a list of examined intersections?
		return 0;
	}

	// returns true if legal to place a piece at (x, y)
	public boolean validPlacement(Color p, int x, int y)
	{
		//TODO - add move restrictions based on previous plays
		return pieces[x][y]==Color.EMPTY;
	}

	// returns a string representation of a piece stored at a given xy coordinate
	//	    String whatPiece(int x, int y) => pieces[convertI(x,y)].toString();

	// prints a representation of a board
	public void printBoard ()
	{
		//    print("$dimension x $dimension");
		for(int j=0;j<dimension;j++)
		{
			for(int i=0;i<dimension;i++)
			{
				System.out.print(pieces[j][i].toShortString());
			}
			System.out.println();
		}
	}

}
