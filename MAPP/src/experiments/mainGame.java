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
			System.out.println("\n" + theGame.player + "'s turn\n");
			System.out.println("Press 's' to place a stone, 'p' to pass, 'f' to forfeit");
			// read input
			String input = userInput.nextLine();
			// s places stone
			if (input.contains("s"))
			{
				System.out.println("Enter where you want to place the stone (x,y):");
				input = userInput.nextLine();
				xy = input.split(",");
				while (!theGame.placeStone(Integer.parseInt(xy[0]),Integer.parseInt(xy[1])))
				{
					System.out.println("Invalid input, try again");
					input = userInput.nextLine();
					xy = input.split(",");
				}
			}
			// p passes
			else if (input.contains("p"))
			{
				theGame.pass();
				System.out.println("You Passed");
			}
			if(theGame.gameOver || input.contains("f"))
			{
				// TODO - add score, determine winner
				System.out.println("Game Over");
				if(input.contains("f"))
					System.out.println(theGame.player.opposite() + " wins");
				return;
			}
		}
	}
}
