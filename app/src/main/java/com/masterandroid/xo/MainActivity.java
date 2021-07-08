package com.masterandroid.xo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView score1;
    private TextView score2;
    private Button[] buttons = new Button[10];
    private Button buttonRst;

    private int playerScor1;
    private int playerScor2;
    private int roundCount;
    private boolean activePlayer;
    //player 1 is 1;
    //player 2 is 2;
    private int[] state = {2, 2, 2, 2, 2, 2, 2, 2, 2 , 2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        score1 = (TextView) findViewById(R.id.ScorePlayerOne);
        score2 = (TextView) findViewById(R.id.scorePlayerTwo);
        buttonRst = (Button) findViewById(R.id.buttonRst);

        for (int i = 1; i < buttons.length; i++) {
            String button = "button" + i;
            int resourceId = getResources().getIdentifier(button, "id", getPackageName());
            buttons[i] = (Button) findViewById(resourceId);
            buttons[i].setOnClickListener(this);
        }
        playerScor1 = 0;
        playerScor2 = 0;
        //true for first player, false for second player
        activePlayer = true;
    }

    @Override
    public void onClick(View v) {
        Log.i("test", "button clicked");
        if (!((Button) v).getText().toString().equals("")) {
            return;
        }
        String buttonId = v.getResources().getResourceEntryName(v.getId());
        int nrButtonPressed = Integer.parseInt(buttonId.substring(buttonId.length() - 1, buttonId.length()));
        if (activePlayer == true) {
            state[nrButtonPressed] = 1;
            ((Button) v).setText("X");
        } else {
            state[nrButtonPressed] = 2;
            ((Button) v).setText("O");
        }
        roundCount++;
        if (checkWinner() == 1) {
            Toast.makeText(this, "Jucator 1 a castigat", Toast.LENGTH_SHORT).show();
            score1.setText(playerScor1+1);
        }
        if (checkWinner() == 0) {
            Toast.makeText(this, "Jucator 2 a castigat", Toast.LENGTH_SHORT).show();
            score1.setText(playerScor1+1);
        }
        if(activePlayer)
            activePlayer = false;
        else
            activePlayer =true;
    }

    public int checkWinner() {
        if (state[1] == 1 && state[2] == 1 && state[3] == 1)
            return 1;
        if (state[1] == 0 && state[2] == 0 && state[3] == 0)
            return 0;
        if (state[4] == 1 && state[5] == 1 && state[6] == 1)
            return 1;
        if (state[4] == 0 && state[5] == 0 && state[6] == 0)
            return 0;
        if (state[7] == 1 && state[8] == 1 && state[9] == 1)
            return 1;
        if (state[7] == 0 && state[8] == 0 && state[9] == 0)
            return 0;


        if (state[1] == 1 && state[4] == 1 && state[7] == 1)
            return 1;
        if (state[1] == 0 && state[4] == 0 && state[7] == 0)
            return 0;
        if (state[2] == 1 && state[5] == 1 && state[8] == 1)
            return 1;
        if (state[2] == 0 && state[5] == 0 && state[8] == 0)
            return 0;
        if (state[3] == 1 && state[6] == 1 && state[9] == 1)
            return 1;
        if (state[3] == 0 && state[6] == 0 && state[9] == 0)
            return 0;

        if (state[1] == 1 && state[5] == 1 && state[9] == 1)
            return 1;
        if (state[1] == 0 && state[5] == 0 && state[9] == 0)
            return 0;

        if (state[3] == 1 && state[5] == 1 && state[7] == 1)
            return 1;
        if (state[3] == 0 && state[5] == 0 && state[7] == 0)
            return 0;
        return 2;
    }
}