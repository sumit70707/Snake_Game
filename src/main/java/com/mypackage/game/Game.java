package com.mypackage.game;
import javax.swing.*;


public class Game
{
    public static void main( String[] args )
    {
        int boardWidth=600;
        int boardHeight=boardWidth;

        JFrame frame=new JFrame("Snake Game");
        frame.setVisible(true);
        frame.setSize(boardWidth,boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Snake snake=new Snake(boardHeight,boardHeight);
        frame.add(snake);
        frame.pack();
        snake.requestFocus();


    }
}
