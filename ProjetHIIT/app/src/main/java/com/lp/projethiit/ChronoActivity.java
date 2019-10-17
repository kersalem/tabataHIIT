package com.lp.projethiit;

import android.os.CountDownTimer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ChronoActivity extends AppCompatActivity {

    // CONSTANTE
    private final static long INITIAL_TIME = 5000;

    // VIEW
    private Button startButton;
    private Button pauseButton;
    private TextView timerValue;
    int tempsTravail;
    TextView afficheTempsChoisi;

    // DATA
    private long updatedTime;
    private CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chrono);

        // Récupérer les view
        timerValue = (TextView) findViewById(R.id.timerValue);
        startButton = (Button) findViewById(R.id.startButton);
        pauseButton = (Button) findViewById(R.id.pauseButton);

        //Récupération temps de travail choisi

        tempsTravail = getIntent().getIntExtra("temps_travail", 1);
         afficheTempsChoisi = (TextView) findViewById(R.id.afficheTempsChoisi);
        afficheTempsChoisi.setText("Le temps de travail choisi est : " + tempsTravail);
        //

        updatedTime = tempsTravail;
        miseAJour();
    }

    /**
     * ATTENTION L'utilisateur peut créer plusieurs CountDownTimer !!!
     * -> Pensez à faire tester votre application par un tiers
     *
     * @param view
     */
    public void onStart(View view) {

        timer = new CountDownTimer(updatedTime, 10) {

            public void onTick(long millisUntilFinished) {
                updatedTime = millisUntilFinished;
                miseAJour();
            }

            public void onFinish() {
                updatedTime = 0;
                miseAJour();
            }
        }.start();

    }

    // Mettre en pause le compteur
    public void onPause(View view) {
        if (timer != null) {
            timer.cancel(); // Arrete le CountDownTimer
        }
    }


    // Mise à jour graphique
    private void miseAJour() {

        // Décompositions en secondes et minutes
        int secs = (int) (updatedTime / 1000);
        int mins = secs / 60;
        secs = secs % 60;
        int milliseconds = (int) (updatedTime % 1000);

        // Affichage du "timer"
        timerValue.setText("" + mins + ":"
                + String.format("%02d", secs) + ":"
                + String.format("%03d", milliseconds));

    }

    // Remettre à le compteur à la valeur initiale
    public void onReset(View view) {

        // Mettre en pause
        if (timer != null) {
            timer.cancel();
        }

        // Réinitialiser
        updatedTime = tempsTravail;

        // Mise à jour graphique
        miseAJour();

    }
}
