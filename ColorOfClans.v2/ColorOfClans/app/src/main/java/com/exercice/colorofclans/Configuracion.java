package com.exercice.colorofclans;

public class Configuracion {

    private boolean wantMusic;
    private boolean changeColorActivated;
    private boolean wantTime;
    private boolean wantMoves;

    public Configuracion() {
        wantMusic = true;
        changeColorActivated = false;
        wantTime = true;
        wantMoves = false;
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
}
