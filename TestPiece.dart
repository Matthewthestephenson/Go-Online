import 'dart:io';
import 'Piece.dart';
import 'Point.dart';

class TestPiece extends Piece
{

    TestPiece (String n, int x, int y) : super(n,x,y);

    void setPosition(int x, int y)
    {
        position = new Point(x,y);
    }

}
