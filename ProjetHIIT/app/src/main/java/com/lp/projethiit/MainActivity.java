package com.lp.projethiit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int tempsTravail = 10;
    TextView afficheTempsChoisi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button add = (Button) findViewById(R.id.btnAdd);
        Button less = (Button) findViewById(R.id.btnLess);
        afficheTempsChoisi = (TextView) findViewById(R.id.afficheTempsChoisi);

        afficheTempsChoisi.setText("Vous avez choisi " +  String.valueOf(tempsTravail));
    }

    public void actionBtnAdd(View view) {
        Log.d("Marie", "ActionBtnAdd");
        Log.d("Marie",String.valueOf(tempsTravail));

        tempsTravail = tempsTravail + 1;

        afficheTempsChoisi.setText("Vous avez choisi " + tempsTravail);
    }

    public void actionBtnLess(View view) {
        tempsTravail = tempsTravail - 1;
        afficheTempsChoisi.setText("Vous avez choisi " + tempsTravail);
    }

    public void goToChrono(View view) {
        Intent pageChrono = new Intent(this, ChronoActivity.class);
        pageChrono.putExtra("temps_travail", tempsTravail * 1000);
        startActivity(pageChrono);
    }
}
