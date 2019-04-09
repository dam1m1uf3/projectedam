package com.exercice.colorofclans;

import android.widget.TextView;

public class Game {
    public static void updateMovements(TextView movimientos){
        MainActivity.count++;
        movimientos.setText(MainActivity.count+"/30");
    }
}
