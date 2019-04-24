package com.exercice.colorofclans;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class configActvity extends AppCompatActivity {

    public Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_config_actvity);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        final Button btnMusic = findViewById(R.id.botmusic);
        btnMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(menu.configuracio.getWantMusic()) {
                    btnMusic.setBackgroundResource(R.drawable.off);
                    menu.configuracio.setWantMusic(false);
                }
                else {
                    btnMusic.setBackgroundResource(R.drawable.on);
                    menu.configuracio.setWantMusic(true);
                }
            }
        });
        final Button btnTimer = findViewById(R.id.bottime);
        btnTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(menu.configuracio.getWantTime()) {
                    btnTimer.setBackgroundResource(R.drawable.off);
                    menu.configuracio.setWantTime(false);
                }
                else {
                    btnTimer.setBackgroundResource(R.drawable.on);
                    menu.configuracio.setWantTime(true);
                }
            }
        });
        final Button btnMoves = findViewById(R.id.botmove);
        btnMoves.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(menu.configuracio.getWantMoves()){
                    btnMoves.setBackgroundResource(R.drawable.off);
                    menu.configuracio.setWantMoves(false);
                }
                else{
                    btnMoves.setBackgroundResource(R.drawable.on);
                    menu.configuracio.setWantMoves(true);
                }
            }
        });
        final ImageView imgSize = findViewById(R.id.imageView8);
        imgSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (menu.configuracio.getNumCells()==5){
                    imgSize.setBackgroundResource(R.drawable.second);
                    menu.configuracio.setNumCells(7);
                }
                if (menu.configuracio.getNumCells()==7){
                    imgSize.setBackgroundResource(R.drawable.third);
                    menu.configuracio.setNumCells(10);
                }
                if (menu.configuracio.getNumCells()==10){
                    imgSize.setBackgroundResource(R.drawable.fourth);
                    menu.configuracio.setNumCells(15);
                }
                if (menu.configuracio.getNumCells()==15){
                    imgSize.setBackgroundResource(R.drawable.first);
                    menu.configuracio.setNumCells(5);
                }
            }
        });
        final Button btnColors = findViewById(R.id.botdalto);
        btnColors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(menu.configuracio.getchangeColorActivated()){
                    btnColors.setBackgroundResource(R.drawable.off);
                    menu.configuracio.setChangeColorActivated(false);
                }
                else{
                    btnColors.setBackgroundResource(R.drawable.on);
                    menu.configuracio.setChangeColorActivated(true);
                }
            }
        });
    }

}
