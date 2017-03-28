package sacha.kleynjans.edu.ece.fr.projet;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.Semaphore;

/**
 * Created by SachaKleynjans on 28/03/2017.
 */

public class MainActivity extends AppCompatActivity {

    private TextView score1;
    private TextView score2;
    private TextView team1;
    private TextView team2;
    private Handler h;
    private Button but1, but2;
    private Semaphore mutex = new Semaphore(1, true);

    private int scoreInt;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        but1 = (Button) findViewById(R.id.but1);
        but2 = (Button) findViewById(R.id.but2);
        score1 = (TextView) findViewById(R.id.score1);
        score2 = (TextView) findViewById(R.id.score2);
        team1 = (TextView) findViewById(R.id.team1);
        team2 = (TextView) findViewById(R.id.team2);

        h = new Handler(); // getWindow().getDecorView().getHandler();

        Intent intent = getIntent();
        String resultat = intent.getStringExtra("result"); //Récupérer la valeur de "result" envoyée par MainActivity
        //operation.setText(String.valueOf(resultat)); //Mettre la valeur dans l'id operation

        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addbut("1");
            }
        });
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addbut("2");
            }
        });
    }

    public void addbut(String teamNb) {
        if (teamNb == "1") {
            String score = score1.getText().toString();
            int scoreInt = Integer.parseInt(score)+1;
            score1.setText(String.valueOf(scoreInt));
        } else {
            if (teamNb == "2") {
                String score = score2.getText().toString();
                int scoreInt = Integer.parseInt(score)+1;
                score2.setText(String.valueOf(scoreInt));
            }
        }
    }

}
