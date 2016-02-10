package experiments;

import java.util.Scanner;

public class mainGame {

	public static void main(String[] args)
	{

		Scanner userInput = new Scanner(System.in);
		Game theGame = new Game();
		System.out.println("Welcome to Go");
		String [] xy;
		while (true)
		{
			theGame.printBoard();
			System.out.println(theGame.player);
			System.out.println("Press 's' to place a stone and 'p' to pass");
			String input = userInput.nextLine();
			if (input.contains("s"))
			{
				do {
					System.out.println("Enter where you want to place the stone (x,y):");
					input = userInput.nextLine();
					xy = input.split(",");
					System.out.println(theGame.placeStone(Integer.parseInt(xy[0]),Integer.parseInt(xy[1])));
				} while (xy.length != 2 && !theGame.placeStone(Integer.parseInt(xy[0]),Integer.parseInt(xy[1])));
			}
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
			// Black turn
			// display board, give controls
			// read input
			// complete action, display error if necessary
			// evaluate territory/score changes, check if game over (if so, break)

			// White turn
			// same as above



		}
	}
}
