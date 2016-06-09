package com.vadivelansr.android.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private static final String SCORE_A = "score_a";
    private static final String SCORE_B = "score_b";
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.text_team_a_score)
    TextView textTeamAScore;
    @Bind(R.id.text_team_b_score)
    TextView textTeamBScore;
    private int scoreA;
    private int scoreB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getString(R.string.app_name));
        if(savedInstanceState != null){
            scoreA = savedInstanceState.getInt(SCORE_A, 0);
            scoreB = savedInstanceState.getInt(SCORE_B, 0);
            textTeamAScore.setText("" + scoreA);
            textTeamBScore.setText("" + scoreB);
        }
    }

    public void onClickTeamAPoint(View view) {
        if (view.getId() == R.id.button_team_a_1) {
            scoreA = scoreA + 1;
            textTeamAScore.setText("" + scoreA);
        }
        else if (view.getId() == R.id.button_team_a_2){
            scoreA = scoreA + 2;
            textTeamAScore.setText("" + scoreA);
        }
        else if (view.getId() == R.id.button_team_a_3){
            scoreA = scoreA + 3;
            textTeamAScore.setText("" + scoreA);
        }
    }

    public void onClickTeamBPoint(View view) {
       if (view.getId() == R.id.button_team_b_1){
           scoreB = scoreB + 1;
           textTeamBScore.setText("" + scoreB);
       }
        else if (view.getId() == R.id.button_team_b_2){
           scoreB = scoreB + 2;
           textTeamBScore.setText("" + scoreB);
       }
        else if (view.getId() == R.id.button_team_b_3){
           scoreB = scoreB + 3;
           textTeamBScore.setText("" + scoreB);
       }
    }

    @OnClick(R.id.button_reset)
    public void onReset() {
        textTeamAScore.setText("0");
        textTeamBScore.setText("0");
        scoreA = 0;
        scoreB = 0;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SCORE_A, scoreA);
        outState.putInt(SCORE_B, scoreB);
    }
}
