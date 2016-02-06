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

    bool operator ==(other)
    {
      if(other is! Point)
        return false;
      Point thisOne = other;
      return thisOne.x == this.x && thisOne.y == this.y;
    }

}
