package com.exercice.colorofclans;

import android.content.Context;
import android.graphics.Color;
import android.view.View;

public class Square extends View {
    
   private String color;
   private boolean isGet;
   private boolean isChecked;
   

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
   
   public String getColor(){
       return this.color;
   }
   
   /**
    * 
    * @param bool 
    */
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
