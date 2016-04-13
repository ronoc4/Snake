package com.conor;

import java.util.Random;

/**
 * Created by conor on 4/13/16.
 */
public class Wall {

    private int wallBottom;
    private int wallSide;


    public Wall() {
        Random rnd = new Random();

        wallBottom = rnd.nextInt(SnakeGame.xSquares);
        wallSide = rnd.nextInt(SnakeGame.ySquares);
    }

    //Add dimensions for square from Square class
    public Square getSquare() {
        return new Square(wallBottom, wallSide);
    }

    //Getters for variables for wall
    public int getWallBottom() {
        return wallBottom;
    }

    public int getWallSide() {
        return wallSide;
    }

}
