import 'dart:io';
import 'dart:html';

abstract class AI
{
    int level;

    AI(int l)
    {
        level=l;
    }

    void setLevel(int l)
    {
        level=l;
    }

    Point move();

    String toString()
    {
        return "Level set to: $level";
    }
}
