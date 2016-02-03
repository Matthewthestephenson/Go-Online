import 'dart:io';

class Point
{
    int x;
    int y;

    Point(int xPoint,int yPoint)
    {
        x=xPoint;
        y=yPoint;
    }

    int getX()
    {
        return x;
    }

    int getY()
    {
        return y;
    }

    void setPoint(int newX,int newY)
    {
        x=newX;
        y=newY;
    }

    String toString()
    {
        return "($x,$y)";
    }
}
