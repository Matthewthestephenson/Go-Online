package experiments;

public class SinglePlayerGame extends Game {
	private Board prev; // previous turn
	private Color human;
	private int aiLevel;

	SinglePlayerGame(Color h, int CPU_Difficulty)
	{
		human = h;
		aiLevel = CPU_Difficulty;
	}

	public boolean placeStone(int x, int y)
	{
		if (curr.validPlacement(player,x,y))
		{
			cumPasses = 0;
			if (player == human)
			{
				prev = curr.clone();
			}
			curr.placePiece(player,x,y);
			advancePlayer();
			return true;
		}
		else
		{
			return false;
		}
	}

	// undo function only available in AI play
	public boolean undo() { // void instead?
		if (curr == prev)
			return false; // or throw exception?
		curr = prev;
		cumPasses = 0;
		return true;
	}
	
	public void pass() {
		if (++cumPasses == 2)
			gameOver = true;
		if (player == human)
			prev = curr.clone();
		advancePlayer();
	}
}
