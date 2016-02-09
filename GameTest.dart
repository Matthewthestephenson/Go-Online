import 'BoardTest.dart';
import 'TestPiece.dart';
import 'dart:io';

void main () {
  Game theGame = new Game();
  print("Welcome to Go");
  List<String> xy;
  while (true)
  {
      theGame.printBoard();
      print(theGame.player);
      print("Press 's' to place a stone and 'p' to pass");
      // can use stdin.readLineSync() to read from command line (for testing only)
      String input = stdin.readLineSync();
      if (input.contains("s"))
      {
        do {
          print("Enter where you want to place the stone (x,y):");
          String input = stdin.readLineSync();
          xy = input.split(",").toList();
          print(theGame.placeStone(int.parse(xy[0]),int.parse(xy[1])));
        } while (xy.length != 2 && !theGame.placeStone(int.parse(xy[0]),int.parse(xy[1])));
      }
      else if (input.contains("p"))
      {
        theGame.pass();
        print("You Passed");
      }
      if(theGame.gameOver)
      {
        print("Game Over");
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


class Game {
  Board curr;
  Board prev; // previous turn
  Color player; // current player color
  Color human;
  int cumPasses;
  bool gameOver;

  Game () {
    curr = new Board(19);
    player = Color.BLACK;
  }

  Game.single(Color h)
  {
    curr = new Board(19);
    player = Color.BLACK;
    human = h;
  }

  //place piece - reset cumul passes, add to list of moves (where to store??)
  bool placeStone(int x, int y)
  {
    if (curr.validPlacement(new TestPiece(player),x,y))
    {
      cumPasses = 0;
      if (player == human)
      {
        prev = curr.clone();
      }
      curr.placePiece(new TestPiece(player),x,y);
      advancePlayer();
      return true;
    }
    else
    {
      return false;
    }
  }

  //pass - 2 consecutive passes = game over
  void pass() {
    if (++cumPasses == 2)
      gameOver = true;
    if (player == human)
      prev = curr.clone();
    advancePlayer();
  }

  void advancePlayer() {
     player = (player == Color.BLACK ? Color.WHITE : Color.BLACK);
   }
  // undo function only available in AI play
  bool undo() { // void instead?
    if (curr == prev)
      return false; // or throw exception?
    curr = prev;
    cumPasses = 0;
    return true;
  }

  void printBoard() => curr.printBoard();

  String status()
  {
    return gameOver ? "Game Over" : "$player to move, White: $curr.score(WHITE), Black: $curr.score(BLACK)";
  }

}
