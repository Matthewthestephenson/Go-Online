package experiments;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


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

	// requires piece to be placed at x,y
	public void remove (int x, int y)
	{
		// TODO - clean up algorithm
		if(pieces[y][x] == Color.EMPTY)
			throw new IllegalStateException("Can't check for removal on empty intersection");
		Set<Point> toRemove = new HashSet<Point>();
		if(capture(pieces[y][x],x,y,toRemove))
			//remove pieces
			for(Point p: toRemove)
				pieces[p.y][p.x] = Color.EMPTY;
		
		toRemove = new HashSet<Point>();
		if(captureRec(pieces[y][x].opposite(),x,y,toRemove) )
			//remove more pieces
			for(Point p: toRemove)
				pieces[p.y][p.x] = Color.EMPTY;
		
	}
	
	// begins recursive calls on neighbors, capturing represents player attempting capture
	private boolean capture(Color capturing, int x, int y, Set<Point> toRemove)
	{
		// TODO - clean up algorithm
		Set<Point> other = new HashSet<Point>();
		if(onBoard(x+1,y)&&captureRec(capturing,x+1,y,other))
			toRemove.addAll(other);	
		other.clear();
		if(onBoard(x-1,y)&&captureRec(capturing,x-1,y,other))
			toRemove.addAll(other);
		other.clear();
		if(onBoard(x,y+1)&&captureRec(capturing,x,y+1,other))	
			toRemove.addAll(other);
		other.clear();
		if(onBoard(x,y-1)&&captureRec(capturing,x,y-1,other))
			toRemove.addAll(other);
		other.clear();
		return !toRemove.isEmpty();
	}
	
	
	// clears intersections for given color
	private boolean captureRec(Color capturing, int x, int y, Set<Point> toRemove) {
		// TODO - clean up algorithm
		if(x>=dimension || x<0 || y>=dimension || y<0)
			return true;
		else if(pieces[y][x] == Color.EMPTY)
			return false;
		else if(pieces[y][x] == capturing.opposite() && !toRemove.contains(new Point(x,y)))
		{
			toRemove.add(new Point(x,y));
			return captureRec(capturing,x+1,y,toRemove) && captureRec(capturing,x-1,y,toRemove) && captureRec(capturing,x,y+1,toRemove) && captureRec(capturing,x,y-1,toRemove);
		}
		else
			return true;
	}
	
	// returns true if x, y pair is in the range [0, dimension)
	private boolean onBoard(int x, int y)
	{
		return x<dimension && x>=0 && y<dimension && y>=0;
	}
	
	//calculate score (territory) for given color
	private int score(Color c)
	{
		// TODO - create a list of examined intersections?

		return 0;
	}

	public String currentScore(Color curr) {
		return score(curr) + " - " + score(curr.opposite());
	}
	
	// returns true if legal to place a piece at (x, y)
	public boolean validPlacement(Color p, int x, int y)
	{
		//TODO - add move restrictions based on previous plays (aka Ko Rule)
		return pieces[y][x]==Color.EMPTY;
	}

	// returns a string representation of a piece stored at a given xy coordinate
	//	    String whatPiece(int x, int y) => pieces[convertI(x,y)].toString();

	// prints a representation of a board
	public void printBoard ()
	{
		for(int i=0;i<dimension;i++)
		{
			for(int j=0;j<dimension;j++)
			{
				System.out.print(pieces[i][j].toShortString());
			}
			System.out.println();
		}
	}

}
