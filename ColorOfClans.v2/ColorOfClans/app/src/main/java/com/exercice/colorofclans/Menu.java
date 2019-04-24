package com.exercice.colorofclans;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Menu extends AppCompatActivity {

    public Configuracion configuracio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        RelativeLayout background = findViewById(R.id.menuImage);
        background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });

        configuracio = new Configuracion();

        ImageButton config = (ImageButton)findViewById(R.id.settingsButton);
        config.setBackgroundResource(R.drawable.settings_pressed);
        config.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openConfigActivity();
            }
        });

        ImageButton help = (ImageButton)findViewById(R.id.helpButton);
        help.setBackgroundResource(R.drawable.botones_press);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCredits();
            }
        });

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
        Intent configActivity = new Intent(this, configActvity.class);
        startActivity(configActivity);
    }
    public void openCredits(){
        Intent creditActivity = new Intent(this, creditsActivity.class);
        startActivity(creditActivity);
        finish();
    }

}
