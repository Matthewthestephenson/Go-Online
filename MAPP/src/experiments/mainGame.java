package experiments;

import java.util.Scanner;

// simulates a game of Go
public class mainGame {

	public static void main(String[] args)
	{

		Scanner userInput = new Scanner(System.in);
		Game theGame = new Game();
		System.out.println("Welcome to Go");
		String [] xy;
		while (true)
		{
			// display board, give controls
			theGame.printBoard();
			System.out.println(theGame.player);
			System.out.println("Press 's' to place a stone and 'p' to pass");
			// read input
			String input = userInput.nextLine();
			// s places stone
			if (input.contains("s"))
			{
				do {
					System.out.println("Enter where you want to place the stone (x,y):");
					input = userInput.nextLine();
					xy = input.split(",");
					System.out.println(theGame.placeStone(Integer.parseInt(xy[0]),Integer.parseInt(xy[1])));
				} while (xy.length != 2 && !theGame.placeStone(Integer.parseInt(xy[0]),Integer.parseInt(xy[1])));
			}
			// p passes
			else if (input.contains("p"))
			{
				theGame.pass();
				System.out.println("You Passed");
			}
			if(theGame.gameOver)
			{
				System.out.println("Game Over");
				return;
			}
		}
	}
}
