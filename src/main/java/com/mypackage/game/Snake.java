package com.mypackage.game;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;


public class Snake extends JPanel implements ActionListener, KeyListener{
    private class Tile  {//for defining starting position of snake
        int x;
        int y;

        Tile( int x, int y) {
            this.x = x;
            this.y = y;

        }
    }
    int boardWidth;
    int boardHeight;
    int tileSize=25;
    //snake
    Tile snakeHead;
    ArrayList<Tile> snakeBody;
    //food
    Tile food;
    Random random;

    //Logic
    Timer gameLoop;
    int veloX;
    int veloY;
    boolean gameOver=false;

     Snake( int boardWidth,int boardHeight) {
         this.boardWidth = boardWidth;
         this.boardHeight=boardHeight;
         setPreferredSize(new Dimension(this.boardWidth,this.boardHeight));
         setBackground(Color.black);
         addKeyListener(this);
         setFocusable(true);

         snakeHead= new Tile(5,5);
         snakeBody=new ArrayList<Tile>();

         food=new Tile(10,10);
         random=new Random();
         placeFood();

         veloX=0;
         veloY=0;

         gameLoop = new Timer(100,this); //how long it takes to start timer, milliseconds gone between frames
         gameLoop.start();

     }



    //draw snake box
    public void paintComponent(Graphics g){
         super.paintComponent(g);
         draw(g);
    }

    public void draw(Graphics g) {
        //food
        g.setColor(Color.red);

        g.fill3DRect(food.x*tileSize, food.y*tileSize,tileSize,tileSize,true);
         //snake head
        g.setColor(Color.green);

        g.fill3DRect(snakeHead.x*tileSize,snakeHead.y*tileSize,tileSize,tileSize,true);

        //body
        for(int i=0;i<snakeBody.size();i++){
            Tile snakePart=snakeBody.get(i);

            g.fill3DRect(snakePart.x*tileSize,snakePart.y*tileSize,tileSize,tileSize,true);
        }
        //score
        g.setFont(new Font("Arial",Font.PLAIN,16));
        if(gameOver){
            g.setColor(Color.red);
            g.drawString("GAME OVER: "+String.valueOf(snakeBody.size()),tileSize-16,tileSize);
        }
        else {
            g.drawString("Score: "+String.valueOf(snakeBody.size()),tileSize-16,tileSize);
        }
    }
    public void placeFood() {
         food.x=random.nextInt(boardWidth/tileSize);
         food.y=random.nextInt(boardHeight/tileSize);

    }


    //detect collision
    public boolean collision(Tile t1,Tile t2){
         return t1.x==t2.x && t1.y==t2.y;

    }
    public void move() {
         //food eat
        if(collision(snakeHead,food)){
            snakeBody.add(new Tile(food.x,food.y));
            placeFood();
        }
        //S body
        for(int i=snakeBody.size()-1;i>=0;i--){
            Tile snakePart=snakeBody.get(i);
            if(i==0){
                snakePart.x=snakeHead.x;
                snakePart.y=snakeHead.y;
            }
            else{
                Tile prevSnakePart=snakeBody.get(i-1);
                snakePart.x=prevSnakePart.x;
                snakePart.y=prevSnakePart.y;

            }
        }
        //s head
        snakeHead.x+=veloX;
        snakeHead.y+=veloY;
        //game over
        for(int i=0;i<snakeBody.size();i++){
            Tile snakePart=snakeBody.get(i);
            if(collision(snakeHead,snakePart)){
                gameOver=true;
            }

        }
        if(snakeHead.x*tileSize<0 || snakeHead.x*tileSize>boardWidth || snakeHead.y*tileSize<0 || snakeHead.y*tileSize>boardHeight){
            gameOver=true;
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
         move();
         repaint();
         if(gameOver) {
             gameLoop.stop();
         }

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_UP && veloY != 1) {
            veloX = 0;
            veloY = -1;
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN && veloY != -1) {
            veloX = 0;
            veloY = 1;
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT && veloX != 1) {
            veloX = -1;
            veloY = 0;
        }
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT && veloX != -1) {
            veloX = 1;
            veloY = 0;
        }
    }

    //not needed
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}




}
