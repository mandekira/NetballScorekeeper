package com.ivotism.netballscorekeeper;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    int scoreTeamB = 0;
    int scoreTeamATotal = 0;
    int gaTeamAScore = 0;
    int gsTeamAScore = 0;
    int quarterScoreTeamA = 0;
    int scoreTeamBTotal = 0;
    int gaTeamBScore = 0;
    int gsTeamBScore = 0;
    int quarterScoreTeamB = 0;

    String whoScoredLastTeamA = "none";
    String whoScoredLastTeamB = "none";

    private TextView undoTeamA, undoTeamB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        undoTeamA = (TextView) findViewById(R.id.undoTeamA);
        undoTeamB = (TextView) findViewById(R.id.undoTeamB);
        undoTeamA.setClickable(false);
        undoTeamB.setClickable(false);
    }

    public void gaTeamAScored(View v) {
        quarterScoreTeamA = quarterScoreTeamA + 1;
        gaTeamAScore = gaTeamAScore + 1;
        scoreTeamATotal = scoreTeamATotal + 1;
        whoScoredLastTeamA = "ga";
        undoTeamA.setActivated(true);
        displayForTeamAQuarter(quarterScoreTeamA);
        displayForTeamATotal(scoreTeamATotal);
    }

    public void gsTeamAScored(View v) {
        quarterScoreTeamA = quarterScoreTeamA + 1;
        scoreTeamATotal = scoreTeamATotal + 1;
        gsTeamAScore = gsTeamAScore + 1;
        whoScoredLastTeamA = "gs";
        undoTeamA.setClickable(true);
        displayForTeamAQuarter(quarterScoreTeamA);
        displayForTeamATotal(scoreTeamATotal);
    }


    public void gaTeamBScored(View v) {
        quarterScoreTeamB = quarterScoreTeamB + 1;
        gaTeamBScore = gaTeamBScore + 1;
        scoreTeamBTotal = scoreTeamBTotal + 1;
        whoScoredLastTeamB = "ga";
        undoTeamB.setActivated(true);
        displayForTeamBQuarter(quarterScoreTeamB);
        displayForTeamBTotal(scoreTeamBTotal);
    }

    public void gsTeamBScored(View v) {
        quarterScoreTeamB = quarterScoreTeamB + 1;
        scoreTeamBTotal = scoreTeamBTotal + 1;
        gsTeamBScore = gsTeamBScore + 1;
        whoScoredLastTeamB = "gs";
        undoTeamB.setClickable(true);
        displayForTeamBQuarter(quarterScoreTeamB);
        displayForTeamBTotal(scoreTeamBTotal);
    }

    public void resetScore(View v) {
        scoreTeamATotal = 0;
        gaTeamAScore = 0;
        gsTeamAScore = 0;
        quarterScoreTeamA = 0;
        scoreTeamBTotal = 0;
        gaTeamBScore = 0;
        gsTeamBScore = 0;
        quarterScoreTeamB = 0;
        whoScoredLastTeamA = "none";
        whoScoredLastTeamB = "none";

        displayForTeamAQuarter(scoreTeamA);
        displayForTeamBQuarter(scoreTeamB);
    }

    public void displayForTeamAQuarter(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_quarter_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayForTeamATotal(int score) {
        TextView scoreViewTotal = (TextView) findViewById(R.id.team_a_total_score);
        scoreViewTotal.setText(String.valueOf(score));
    }

    public void displayForTeamBQuarter(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_quarter_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayForTeamBTotal(int score) {
        TextView scoreViewTotal = (TextView) findViewById(R.id.team_b_total_score);
        scoreViewTotal.setText(String.valueOf(score));
    }


    public void undoTeamAScore() {

        if (whoScoredLastTeamA.equals("ga")) {
            gaTeamAScore = gaTeamAScore - 1;
        }
        if (whoScoredLastTeamA.equals("gs")) {
            gsTeamAScore = gsTeamAScore - 1;
        }

        TextView scoreView = (TextView) findViewById(R.id.team_a_quarter_score);
        scoreView.setText(String.valueOf(quarterScoreTeamA - 1));
        TextView scoreViewTotal = (TextView) findViewById(R.id.team_a_total_score);
        scoreViewTotal.setText(String.valueOf(scoreTeamATotal - 1));
        undoTeamA.setClickable(false);


    }

    public void undoTeamBScore() {

        if (whoScoredLastTeamB.equals("ga")) {
            gaTeamBScore = gaTeamBScore - 1;
        }
        if (whoScoredLastTeamB.equals("gs")) {
            gsTeamBScore = gsTeamBScore - 1;
        }

        TextView scoreView = (TextView) findViewById(R.id.team_b_quarter_score);
        scoreView.setText(String.valueOf(quarterScoreTeamB - 1));
        TextView scoreViewTotal = (TextView) findViewById(R.id.team_b_total_score);
        scoreViewTotal.setText(String.valueOf(scoreTeamBTotal - 1));
        undoTeamB.setClickable(false);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //noinspection SimpSlifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.undoTeamA: {
                undoTeamAScore();
                break;
            }
            case R.id.undoTeamB: {
                undoTeamBScore();
                break;
            }
        }
    }
}
