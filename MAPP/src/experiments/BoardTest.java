package experiments;

// Test class
public class BoardTest {
	public static void main(String[] args)
	{
		Board b = new Board(5);
		
		b.placePiece(Color.WHITE, 1, 0);
		b.placePiece(Color.WHITE, 0, 1);
		b.placePiece(Color.BLACK, 0, 0);
		b.placePiece(Color.BLACK, 1, 1);
//		b.placePiece(Color.BLACK, 0, 2);
//		b.placePiece(Color.BLACK, 1, 2);
//		b.placePiece(Color.WHITE, 1, 1);
//		b.placePiece(Color.WHITE, 0, 0);
		b.printBoard();
		b.remove(0, 1);
		System.out.println();
		b.printBoard();
	}
}
