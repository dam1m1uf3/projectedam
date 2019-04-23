package com.exercice.colorofclans;

import android.content.Context;
import android.graphics.Color;
import android.view.View;

public class Square extends View {
    
   private String color;
   private boolean isGet;
   private boolean isChecked;

    /**
     * Constructor of the Square
     *
     * @param color The color of the Square
     * @param squareSize The size of the Square
     * @param cont
     */
   Square (String color, int squareSize, Context cont){
       super(cont);
       this.setBackgroundColor(Color.parseColor(color));
       this.setMinimumWidth(squareSize);
       this.setMinimumHeight(squareSize);
       this.color = color;
   }
   
   public void setColor(String color){
       this.setBackgroundColor(Color.parseColor(color));
       this.color = color;
   }
   

   
   /**
    * Getters and setters of the attributes
    * @param bool 
    */
   public String getColor(){ return this.color; }

   public void setIsGet(boolean bool){
       isGet = bool;
   }
   
   public boolean getIsGet(){
       return isGet;
   }

   public void setIsChecked(boolean bool) {
       isChecked = bool;
   }

   public boolean getIsChecked() {
       return isChecked;
   }
}
