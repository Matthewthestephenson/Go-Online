import 'dart:io';

abstract class Piece
{
    String type;
    Point position;

    Piece(String n, int x, int y)
    {
        type=n;
        position=new Point(x,y);
    }

    String getPosition()
    {
        return position.toString();
    }

    String getType()
    {
        return type;
    }

    String toString()
    {
        return getType()+" at "+getPosition();
    }
}
