import 'BoardTest.dart';
import 'dart:io';

void main () {
  Game theGame = new Game();
  while(true)
  {
      // Black turn
        // display board, give controls
        // read input
        // complete action, display error if necessary
        // evaluate territory/score changes, check if game over (if so, break)

      // White turn
        // same as above
  }

  // can use stdin.readLineSync() to read from command line (for testing only)
}


class Game {
  Board curr;
  Board prevB; // previous black turn
  Board prevW; // previous white turn
  Color player; // current player color
  int cumPasses;
  bool gameOver;

  Game () {
    curr = new Board(19);
    player = Color.BLACK;
  }

  //place piece - reset cumul passes


  //pass
  void pass() {
    if (++cumPasses == 2)
      gameOver = true;
    if (player == Color.BLACK)
    {
      prevB = curr.clone();
      player = Color.WHITE;
    }
    else {
      prevW = curr.clone();
      player = Color.BLACK;
    }
  }


  // undo function only available in AI play
  bool undo() { // void instead?
    if (curr == prev)
      return false; // or throw exception?
    curr = prev;
    cumPasses = 0;
    return true;
  }

  String status()
  {
    return gameOver ? "Game Over" : "$player to move, White: " + curr.score(WHITE) + " Black: " + curr.score(BLACK);
  }

}
