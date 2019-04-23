package com.exercice.colorofclans;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.IOException;
/** Esta guay que puguis pujar coses al github **/
public class MainActivity extends AppCompatActivity {

    Configuracion configuracio = new Configuracion();

    //TODO Position and size relatives
    final int POSITION_BOARD_X = 0;
    final int POSITION_BOARD_Y = 200;
    final int NUM_CELLS = configuracio.getNumCells();
    final int CELL_SEPARATION = 2;

    final int NUM_BTN = 6;
    final int BTN_SEPARATION = 5;

    final int MARGIN_BOARD_RIGHT_LEFT = 10;
    final int MARGIN_BOARD_BOTTOM = 10;

    MediaPlayer mediaPlayer;

    public static int count = 0;

    private Chronometer chronometer;
    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Get Colors*/
        final String[] colors = {"#00ABA9","#FA6800","#0050EF","#F472D0","#A4C400","#AA00FF"};

        count = 0;

        if (!configuracio.getWantMusic()){
            mediaPlayer.stop();
        }

        mediaPlayer= MediaPlayer.create(MainActivity.this, R.raw.dylan);

        /* Start Chronometer */
        chronometer = findViewById(R.id.simpleChronometer);
        startChronometer(findViewById(R.id.simpleChronometer), configuracio);

        /* Start Contador*/
        final TextView contador = findViewById(R.id.Contador);
        count = 0;
        contador.setText("0/30");

        if (configuracio.getWantMoves()){
            contador.setVisibility(View.VISIBLE);
        }

        /* Screen size */
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int winWidth = metrics.widthPixels;
        int winHeight = metrics.heightPixels;

        /* Start create Board of game */
        final RelativeLayout rl = findViewById(R.id.MainLayout);
        final Board board = new Board(POSITION_BOARD_X, POSITION_BOARD_Y, NUM_CELLS, CELL_SEPARATION, MARGIN_BOARD_RIGHT_LEFT, winWidth, colors, rl, getApplicationContext());

        /* BUTTONS */
        int btnSize = (winWidth-MARGIN_BOARD_RIGHT_LEFT*2- ((NUM_BTN-1)*BTN_SEPARATION))/NUM_BTN;

        final Button btncolor1 = findViewById(R.id.btnColor1);
        btncolor1.setBackgroundColor(Color.parseColor(colors[0]));
        RelativeLayout.LayoutParams btn1params = new RelativeLayout.LayoutParams(btnSize, btnSize);
        btn1params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        btn1params.setMargins(MARGIN_BOARD_RIGHT_LEFT,0,0,MARGIN_BOARD_BOTTOM);
        btncolor1.setLayoutParams(btn1params);
        btncolor1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                try {
                    funcButton(colors[0], board, contador);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        final Button btncolor2 = findViewById(R.id.btnColor2);
        btncolor2.setBackgroundColor(Color.parseColor(colors[1]));
        RelativeLayout.LayoutParams btn2params = new RelativeLayout.LayoutParams(btnSize, btnSize);
        btn2params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        btn2params.setMargins(btn1params.leftMargin+btnSize+BTN_SEPARATION,0,0,MARGIN_BOARD_BOTTOM);
        btncolor2.setLayoutParams(btn2params);
        btncolor2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                try {
                    funcButton(colors[1], board, contador);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        final Button btncolor3 = findViewById(R.id.btnColor3);
        btncolor3.setBackgroundColor(Color.parseColor(colors[2]));
        RelativeLayout.LayoutParams btn3params = new RelativeLayout.LayoutParams(btnSize,btnSize);
        btn3params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        btn3params.setMargins(btn2params.leftMargin+btnSize+BTN_SEPARATION,0,0,MARGIN_BOARD_BOTTOM);
        btncolor3.setLayoutParams(btn3params);
        btncolor3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                try {
                    funcButton(colors[2], board, contador);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        final Button btncolor4 = findViewById(R.id.btnColor4);
        btncolor4.setBackgroundColor(Color.parseColor(colors[3]));
        RelativeLayout.LayoutParams btn4params = new RelativeLayout.LayoutParams(btnSize,btnSize);
        btn4params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        btn4params.setMargins(btn3params.leftMargin+btnSize+BTN_SEPARATION,0,0,MARGIN_BOARD_BOTTOM);
        btncolor4.setLayoutParams(btn4params);
        btncolor4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                try {
                    funcButton(colors[3], board, contador);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        final Button btncolor5 = findViewById(R.id.btnColor5);
        btncolor5.setBackgroundColor(Color.parseColor(colors[4]));
        RelativeLayout.LayoutParams btn5params = new RelativeLayout.LayoutParams(btnSize,btnSize);
        btn5params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        btn5params.setMargins(btn4params.leftMargin+btnSize+BTN_SEPARATION,0,0,MARGIN_BOARD_BOTTOM);
        btncolor5.setLayoutParams(btn5params);
        btncolor5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                try {
                    funcButton(colors[4], board, contador);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        final Button btncolor6 = findViewById(R.id.btnColor6);
        btncolor6.setBackgroundColor(Color.parseColor(colors[5]));
        RelativeLayout.LayoutParams btn6params = new RelativeLayout.LayoutParams(btnSize,btnSize);
        btn6params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        btn6params.setMargins(btn5params.leftMargin+btnSize+BTN_SEPARATION,0,0,MARGIN_BOARD_BOTTOM);
        btncolor6.setLayoutParams(btn6params);
        btncolor6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                try {
                    funcButton(colors[5], board, contador);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    /* Function bottons of game*/
    public void funcButton(String color, Board board, TextView contador) throws IOException {
        board.colorChange(color);
        board.reestartIsChecked();
        board.checkAdjacentColor(0,0);
        if(board.gameIsFinished()){
            stopChronometer(findViewById(R.id.simpleChronometer));
            Intent intent = new Intent(this, Menu.class);
            startActivity(intent);
            finish();
        }
        Game.updateMovements(contador);
    }

    /* Mètodes cronòmetre */
    public void startChronometer(View v, Configuracion configuracio){
        if(!running && configuracio.getWantTime()){
            chronometer.setVisibility(View.VISIBLE);
            chronometer.start();
            running=true;
        }
    }

    public void stopChronometer(View v){
        if(running){
            chronometer.start();
            running = false;
        }
    }


    /* Mètodes reproductor */
    @Override
    protected void onStop() {
        super.onStop();
        super.onPause();
        mediaPlayer.pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.pause();
    }

    protected void onResume() {
        super.onResume();
        mediaPlayer.start();
    }
}
