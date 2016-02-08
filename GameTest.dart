import 'BoardTest.dart';

void main () {

}


class Game {
  Board curr;
  Board prev;
  int player; // +1 black, -1 white - Change to colors??

  Game () {
    curr = new Board(19);
    player = 1;
  }

  //place piece

  //pass


  bool undo() {
    if(curr == prev)
      return false; // or throw exception?
    curr = prev;
    return true;
  }


}
