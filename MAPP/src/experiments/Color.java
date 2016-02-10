package experiments;

public enum Color 
{
	EMPTY, BLACK, WHITE;


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
}