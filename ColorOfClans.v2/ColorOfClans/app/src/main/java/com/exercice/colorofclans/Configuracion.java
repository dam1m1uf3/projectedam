package com.exercice.colorofclans;

public class Configuracion {

    private boolean wantMusic;
    private boolean changeColorActivated;
    private boolean wantTime;
    private boolean wantMoves;
    private int numCells;

    public Configuracion() {
        wantMusic = true;
        changeColorActivated = false;
        wantTime = false;
        wantMoves = true;
        numCells = 5;
    }

    public boolean getWantMusic(){
        return wantMusic;
    }
    public boolean getchangeColorActivated(){
        return changeColorActivated;
    }
    public boolean getWantTime(){
        return wantTime;
    }
    public boolean getWantMoves(){
        return wantMoves;
    }
    public int getNumCells(){
        return numCells;
    }
    public void setWantMusic(boolean wantMusic){
        this.wantMusic = wantMusic;
    }
    public void setChangeColorActivated(boolean changeColorActivated){
        this.changeColorActivated = changeColorActivated;
    }
    public void setWantTime(boolean wantTime){
        this.wantTime = wantTime;
    }
    public void setWantMoves(boolean wantMoves){
        this.wantMoves = wantMoves;
    }
    public void setNumCells(int numCells){
        this.numCells = numCells;
    }
}
