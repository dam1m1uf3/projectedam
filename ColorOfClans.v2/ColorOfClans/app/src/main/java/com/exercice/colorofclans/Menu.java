package com.exercice.colorofclans;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);

        RelativeLayout background = findViewById(R.id.menuImage);
        background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });

        Button config = (Button)findViewById(R.id.settingsButton);
        config.setBackgroundResource(R.drawable.settings_pressed);
        config.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openConfigActivity();
            }
        });

        Button help = (Button)findViewById(R.id.helpButton);
        help.setBackgroundResource(R.drawable.botones_press);

        final ImageView start = (ImageView)findViewById(R.id.startButton);

        final Thread hilo1= new Thread(){
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(500);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (View.VISIBLE == start.getVisibility()) {
                                    start.setVisibility(View.INVISIBLE);
                                }
                                else {
                                    start.setVisibility(View.VISIBLE);
                                }
                            }
                        });
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        hilo1.start();
    }
    public void openMainActivity(){
        Intent mainIntent = new Intent(this, MainActivity.class);
        startActivity(mainIntent);
        finish();
    }
    public void openConfigActivity(){

    }
}
