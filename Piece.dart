import 'dart:io';

abstract class Piece
{
    String type;
    Point position;

    Piece(String n,Point p)
    {
        type=n;
        position=p;
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
