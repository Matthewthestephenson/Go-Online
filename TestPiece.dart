import 'dart:io';

enum Color {
  EMPTY, BLACK, WHITE
}

class TestPiece
{
    Color color;

    TestPiece(Color c)
    {
        color = c;
    }

    String toString()
    {
      switch(color)
      {
        case Color.EMPTY:
          return "+";
        case Color.BLACK:
          return "B";
        case Color.WHITE:
          return "W";
      }

    }

}
