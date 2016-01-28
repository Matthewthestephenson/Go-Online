import 'dart:io';

class Points
{
    int x;
    int y;
    Piece piece;

    Points(int xPoint,int yPoint,Piece p)
    {
        x=xPoint;
        y=yPoint;
        p=piece;
    }

    int getX()
    {
        return x;
    }

    int getY()
    {
        return y;
    }

    Piece getPiece()
    {
        return piece;
    }

    void setPoint(int newX,int newY)
    {
        x=newX;
        y=newY;
    }

    void setPiece(Piece p)
    {
        piece=p;
    }

    String toString()
    {
        String p=piece.toString();

        return "($x,$y), $p";
    }
}
