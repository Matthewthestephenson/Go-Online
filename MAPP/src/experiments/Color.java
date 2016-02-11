package experiments;

public enum Color 
{
	EMPTY, BLACK, WHITE;

	// for board printing
	public String toShortString()
	{
		switch(this)
		{
		case EMPTY:
			return "+";
		case BLACK:
			return "B";
		case WHITE:
			return "W";
		default:
			return "";
		}
	}
	
	// for screen display
	public String toString()
	{
		switch(this)
		{
		case EMPTY:
			return "Empty";
		case BLACK:
			return "Black";
		case WHITE:
			return "White";
		default:
			return "";
		}
	}
	
	// returns other player
	public Color opposite()
	{
		switch(this)
		{
		case EMPTY:
			return Color.EMPTY;
		case BLACK:
			return Color.WHITE;
		case WHITE:
			return Color.BLACK;
		default:
			return Color.EMPTY;
		}
	}
}