package experiments;

public  class Game {

	protected Board curr;
	
	protected Color player; // current player color
	
	protected int cumPasses;
	protected boolean gameOver;

	Game () {
		curr = new Board(19);
		player = Color.BLACK;
	}

	

	//place piece - reset cumul passes, add to list of moves (where to store??)
	public boolean placeStone(int x, int y)
	{
		if (curr.validPlacement(player,x,y))
		{
			cumPasses = 0;
			curr.placePiece(player,x,y);
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
		player = (player == Color.BLACK ? Color.WHITE : Color.BLACK);
	}
	

	public void printBoard() { curr.printBoard();}

}
