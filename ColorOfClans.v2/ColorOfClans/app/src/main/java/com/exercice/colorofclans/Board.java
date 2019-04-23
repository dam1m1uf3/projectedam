package com.exercice.colorofclans;

import android.content.Context;
import android.util.DisplayMetrics;
import android.widget.RelativeLayout;

import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.HashSet;
import java.util.Random;

public class Board {

    private Square[][] myBoard;
    private boolean stillPlaying;
    private int board_size;
    private int positionX;
    private int positionY;
    private int margin_border_RL;
    private String[] colors;

    /**
     * Initializes the matrix of Square
     *
     * @param position_board_x relative position in x for the phone
     * @param position_board_y relative position in y for the phone
     * @param num_cells number of squares in one side of the board
     * @param cell_separation separation between squares
     * @param margin_board_right_left margin left
     * @param winWidth width of the window of the phone
     * @param layout
     * @param cont
     */
    Board(int position_board_x, int position_board_y, int num_cells, int cell_separation , int margin_board_right_left, int winWidth, String[] colors, RelativeLayout layout, Context cont){
        this.myBoard = new Square[num_cells][num_cells];
        this.stillPlaying = true;
        this.board_size = num_cells;
        this.positionX = position_board_x;
        this.positionY = position_board_y;
        this.margin_border_RL = margin_board_right_left;
        this.colors = colors;

        int squareSize = (winWidth-margin_border_RL*2 - ((num_cells-1)*cell_separation))/num_cells;

        for (int i = 0; i < this.board_size; i++){
            this.positionX = position_board_x;
            for(int j = 0; j < this.board_size; j++){
                this.myBoard[i][j] = new Square("#000000",squareSize, cont);

                RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(squareSize,squareSize);
                lp.setMargins(this.positionX+margin_border_RL,this.positionY,0,0);
                this.myBoard[i][j].setLayoutParams(lp);
                layout.addView(this.myBoard[i][j]);

                this.positionX += squareSize + cell_separation;
            }
            this.positionY += squareSize + cell_separation;
        }
        this.myBoard[0][0].setIsGet(true);
        this.putColor();
    }

    /**
     * putColor
     * It puts a random color on every Square of the Board, and a different one
     * of the first Square
     */
    public void putColor (){
        for (int i = 0; i < this.board_size; i++){
            for(int j = 0; j < this.board_size; j++){
                this.myBoard[i][j].setColor(getColorByRandom());
            }
        }
        while(this.myBoard[0][0].getColor().equals(this.myBoard[1][0].getColor())){
            this.myBoard[1][0].setColor(getColorByRandom());
        }

        while(this.myBoard[0][0].getColor().equals(this.myBoard[0][1].getColor())){
            this.myBoard[0][1].setColor(getColorByRandom());
        }
    }


    /**
     * get a random color
     *
     * @return the color choosen
     */
    public String getColorByRandom (){

        Random rand = new Random();
        int n = rand.nextInt(6);

        if (n == 0){
            //blue
            return this.colors[0];
        }
        else if (n == 1){
            //red
            return this.colors[1];
        }
        else if (n == 2){
            //green
            return this.colors[2];
        }
        else if (n == 3){
            //yellow
            return this.colors[3];
        }
        else if (n == 4){
            //pink
            return this.colors[4];
        }
        else{
            //indigo
            return this.colors[5];
        }
    }

    /**
     * Changes the color of the obtained squares to the selected color
     *
     * @param color The selected color
     */
    public void colorChange(String color){

        for (int i = 0; i < this.board_size; i++){
            for(int j = 0; j < this.board_size; j++){
                if(this.myBoard[i][j].getIsGet()){
                    this.myBoard[i][j].setColor(color);

                }
            }
        }
    }

    /**
     * Reestart the attribute reestartIsChecked for the recursive method.
     */
    public void reestartIsChecked(){
        for (int i = 0; i < board_size; i++){
            for(int j = 0; j < board_size; j++){
                myBoard[i][j].setIsChecked(false);
            }
        }
        myBoard[0][0].setIsChecked(true);
    }


    /**
     * Recursive method, it sets to true the isGet value if the adjacent color is the same than the
     * color selected by the player.
     *
     * @param x coordinate in x of the Square in the matrix
     * @param y coordinate in y of the Square in the matrix
     */
    public void checkAdjacentColor(int x, int y){
        myBoard[x][y].setIsChecked(true);
        myBoard[x][y].setIsGet(true);

        if (x != 0){
            if (!myBoard[x-1][y].getIsChecked() && myBoard[x-1][y].getColor().equals(myBoard[x][y].getColor())){
                checkAdjacentColor(x-1, y);
            }
        }
        if (x != board_size - 1){
            if (!myBoard[x+1][y].getIsChecked() && myBoard[x+1][y].getColor().equals(myBoard[x][y].getColor())){
                checkAdjacentColor(x+1, y);
            }
        }
        if (y != 0){
            if (!myBoard[x][y-1].getIsChecked() && myBoard[x][y-1].getColor().equals(myBoard[x][y].getColor())){
                checkAdjacentColor(x, y-1);
            }
        }
        if (y != board_size - 1){
            if (!myBoard[x][y+1].getIsChecked() && myBoard[x][y+1].getColor().equals(myBoard[x][y].getColor())){
                checkAdjacentColor(x, y+1);
            }
        }
    }

    /**
     * GameIsFinished:
     * Check if the game is finished
     *
     * @return boolean if the game is finished or not
     */
    public boolean gameIsFinished(){
        for (int i = 0; i < this.board_size; i++){
            for(int j = 0; j < this.board_size; j++){
                if (!this.myBoard[i][j].getIsGet()){
                    return false;
                }
            }
        }
        return true;
    }
}