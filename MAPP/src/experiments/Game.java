package experiments;

public class Game {

	protected Board curr;
	protected Color player; // current player color
	protected int cumPasses;
	protected boolean gameOver;

	public Game() 
	{
		this(19);
	}

	public Game (int boardSize)
	{
		curr = new Board(boardSize);
		player = Color.BLACK;
	}
	
	//place piece - reset cumul passes - performs removal
	//TODO - add to list of moves (where to store??)
	public boolean placeStone(int x, int y)
	{
		if (curr.validPlacement(player,x,y))
		{
			cumPasses = 0;
			curr.placePiece(player,x,y);
			curr.remove(x, y);
			advancePlayer();
			return true;
		}
		else
		{
			return false;
		}
	}

	//pass - 2 consecutive passes = game over
	public void pass() {
		if (++cumPasses == 2)
			gameOver = true;
		advancePlayer();
	}

	public void advancePlayer() {
		player = player.opposite();
	}
	
	// calls board's printBoard
	public void printBoard() { curr.printBoard();}
	
	// calls board's score
	public String score() { return curr.currentScore(player); }
}
