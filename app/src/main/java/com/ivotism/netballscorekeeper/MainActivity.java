package com.ivotism.netballscorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // total score for team A at first run
    int scoreTeamATotal = 0;
    // total score for team B at first run
    int scoreTeamBTotal = 0;
    // GA score for team A at first run
    int gaTeamAScore = 0;
    // GS score for team A at first run
    int gsTeamAScore = 0;
    // GA score for team B at first run
    int gaTeamBScore = 0;
    // GS score for team B at first run
    int gsTeamBScore = 0;
    // Quarter score for team A at first run
    int quarterScoreTeamA = 0;
    // Quarter score for team B at first run
    int quarterScoreTeamB = 0;
    // last scorer for team A set to none for first run
    String whoScoredLastTeamA = "none";
    // last scorer for team B set to none for first run
    String whoScoredLastTeamB = "none";
    // undo buttons for team A and team B
    private Button undoTeamA, undoTeamB;
    // TextView for displaying GA and GS scores for team A and B during each quarter play
    private TextView text_team_a_ga_score, text_team_a_gs_score, text_team_b_ga_score, text_team_b_gs_score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // undoButton for Team A
        undoTeamA = (Button) findViewById(R.id.undoTeamA);
        // undoButton for Team B
        undoTeamB = (Button) findViewById(R.id.undoTeamB);
        // GA team A textview for displaying score
        text_team_a_ga_score = (TextView)findViewById(R.id.text_team_a_ga_score);
        // GS team A textview for displaying score
        text_team_a_gs_score = (TextView)findViewById(R.id.text_team_a_gs_score);
        // GA team B textview for displaying score
        text_team_b_ga_score = (TextView)findViewById(R.id.text_team_b_ga_score);
        // GS team B textview for displaying score
        text_team_b_gs_score = (TextView)findViewById(R.id.text_team_b_gs_score);
        // disable click for undoButton for Team A to prevent
        // going into negative score for first run
        undoTeamA.setClickable(false);
        // disable click for undoButton for Team B to prevent
        // going into negative score for first run
        undoTeamB.setClickable(false);
    }

    // this method is called when team A GA scored goal
    public void gaTeamAScored(View v) {
        // add 1 to quarterScore for team A
        quarterScoreTeamA = quarterScoreTeamA + 1;
        // add 1 to scoreTeamATotal for team A
        gaTeamAScore = gaTeamAScore + 1;
        // add 1 to gsTeamAScore for team A, this will keep track to GS total score
        scoreTeamATotal = scoreTeamATotal + 1;
        // keep track of last scorer for team B for undo changes (GA)
        whoScoredLastTeamA = "ga";
        // enable undo Button for team A, in case the goal is cancelled
        undoTeamA.setClickable(true);
        //display the quarter score for team A after setting it to the recent result
        displayForTeamAQuarter(quarterScoreTeamA);
        //display the total score for team A after setting it to the recent result
        displayForTeamATotal(scoreTeamATotal);
        // display the value of GA score
        displayGaScoreForTeamA(gaTeamAScore);
    }

    // this method is called when team A GS scored goal
    public void gsTeamAScored(View v) {
        // add 1 to quarterScore for team A
        quarterScoreTeamA = quarterScoreTeamA + 1;
        // add 1 to scoreTeamATotal for team A
        scoreTeamATotal = scoreTeamATotal + 1;
        // add 1 to gsTeamAScore for team A, this will keep track to GS total score
        gsTeamAScore = gsTeamAScore + 1;
        // keep track of last scorer for team B for undo changes (GS)
        whoScoredLastTeamA = "gs";
        // enable undo Button for team A, in case the goal is cancelled
        undoTeamA.setClickable(true);
        //display the quarter score for team A after setting it to the recent result
        displayForTeamAQuarter(quarterScoreTeamA);
        //display the total score for team A after setting it to the recent result
        displayForTeamATotal(scoreTeamATotal);
        // display the value of GS score
        displayGsScoreForTeamA(gsTeamAScore);
    }
    // this method is called when team B GA scored goal
    public void gaTeamBScored(View v) {
        // add 1 to quarterScore for team B
        quarterScoreTeamB = quarterScoreTeamB + 1;
        // add 1 to scoreTeamBTotal for team B
        gaTeamBScore = gaTeamBScore + 1;
        // add 1 to gsTeamBScore for team B, this will keep track to GA total score
        scoreTeamBTotal = scoreTeamBTotal + 1;
        // keep track of last scorer for team B for undo changes (GA)
        whoScoredLastTeamB = "ga";
        // enable undo Button for team B, in case the goal is cancelled
        undoTeamB.setClickable(true);
        //display the quarter score for team B after setting it to the recent result
        displayForTeamBQuarter(quarterScoreTeamB);
        //display the total score for team B after setting it to the recent result
        displayForTeamBTotal(scoreTeamBTotal);
        // display the value of GA score
        displayGaScoreForTeamB(gaTeamBScore);
    }

    //This method is called goal shooter score a goal for team B
    public void gsTeamBScored(View v) {
        // add 1 to quarterScore for team B
        quarterScoreTeamB = quarterScoreTeamB + 1;
        // add 1 to scoreTeamBTotal for team B
        scoreTeamBTotal = scoreTeamBTotal + 1;
        // add 1 to gsTeamBScore for team B, this will keep track to GS total score
        gsTeamBScore = gsTeamBScore + 1;
        // keep track of last scorer for team B for undo changes (GS)
        whoScoredLastTeamB = "gs";
        // enable undo Button for team B, in case the goal is cancelled
        undoTeamB.setClickable(true);
        //display the quarter score for team B after setting it to the recent result
        displayForTeamBQuarter(quarterScoreTeamB);
        //display the total score for team B after setting it to the recent result
        displayForTeamBTotal(scoreTeamBTotal);
        // display the value of GS score
        displayGsScoreForTeamB(gsTeamBScore);
    }

    // this method is called when reset button is click,
    // it reset all scores to 0
    public void resetScore(View v) {
        // reset all the scores to 0
        scoreTeamATotal = 0;
        scoreTeamBTotal = 0;
        gaTeamAScore = 0;
        gsTeamAScore = 0;
        gaTeamBScore = 0;
        gsTeamBScore = 0;
        quarterScoreTeamA = 0;
        quarterScoreTeamB = 0;
        whoScoredLastTeamA = "none";
        whoScoredLastTeamB = "none";
        //display the total score for team A after setting it to 0
        displayForTeamATotal(scoreTeamATotal);
        //display the total score for team A after setting it to 0
        displayForTeamBTotal(scoreTeamBTotal);
        //display the quarter score for team A after setting it to 0
        displayForTeamAQuarter(quarterScoreTeamA);
        //display the quarter score for team A after setting it to 0
        displayForTeamBQuarter(quarterScoreTeamB);
        //display GS total score for team A after setting it to 0
        displayGsScoreForTeamA(gsTeamAScore);
        //display GA total score for team A after setting it to 0
        displayGaScoreForTeamA(gaTeamAScore);
        //display GA total score for team B after setting it to 0
        displayGaScoreForTeamB(gaTeamBScore);
        //display GS total score for team B after setting it to 0
        displayGsScoreForTeamB(gsTeamBScore);
    }

    /**
     *
     * @param score Quarter score for team A
     *  Display the score
     */
    public void displayForTeamAQuarter(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_quarter_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     *
     * @param score Total score for team A
     *  Display the score
     */
    public void displayForTeamATotal(int score) {
        TextView scoreViewTotal = (TextView) findViewById(R.id.team_a_total_score);
        scoreViewTotal.setText(String.valueOf(score));
    }

    /**
     *
     * @param score Quarter score for team B
     *  Display the score
     */
    public void displayForTeamBQuarter(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_quarter_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     *
     * @param score Total score for team A
     *  Display the score
     */
    public void displayForTeamBTotal(int score) {
        TextView scoreViewTotal = (TextView) findViewById(R.id.team_b_total_score);
        scoreViewTotal.setText(String.valueOf(score));
    }


    /**
     * Undo team A score
     * Display the score
     */
    public void undoTeamAScore() {

        // check if GA scored the last goal for team A, then subtract 1 from GA scores
        if (whoScoredLastTeamA.equals("ga") && gaTeamAScore > 0) {
            gaTeamAScore = gaTeamAScore - 1;
            displayGaScoreForTeamA(gaTeamAScore);
        }
        // check if GS scored the last goal for team A, then subtract 1 from GS scores
        if (whoScoredLastTeamA.equals("gs") && gsTeamAScore > 0) {
            gsTeamAScore = gsTeamAScore - 1;
            displayGsScoreForTeamA(gsTeamAScore);
        }

        // only subtract if score is greater than 0
        if (quarterScoreTeamA > 0)
        quarterScoreTeamA = quarterScoreTeamA - 1;
        // only subtract if score is greater than 0
        if (scoreTeamATotal > 0)
        scoreTeamATotal = scoreTeamATotal - 1;
        TextView scoreView = (TextView) findViewById(R.id.team_a_quarter_score);
        // subtract 1 from quarterScoreTeamA and display it on the UI
        scoreView.setText(String.valueOf(quarterScoreTeamA));
        TextView scoreViewTotal = (TextView) findViewById(R.id.team_a_total_score);
        // subtract 1 from scoreTeamATotal and display it on the UI
        scoreViewTotal.setText(String.valueOf(scoreTeamATotal));
        // disable click for team A undo button to prevent multiple subtractions
        undoTeamA.setClickable(false);
    }

    /**
     * Undo team B score
     * Display the score
     */
    public void undoTeamBScore() {

        // check if GA scored the last goal for team B, then subtract 1 from GA scores
        if (whoScoredLastTeamB.equals("ga") && gaTeamBScore > 0) {
            gaTeamBScore = gaTeamBScore - 1;
            displayGaScoreForTeamB(gaTeamBScore);
        }
        // check if GS scored the last goal for team B, then subtract 1 from GS scores
        if (whoScoredLastTeamB.equals("gs") && gsTeamBScore > 0) {
            gsTeamBScore = gsTeamBScore - 1;
            displayGsScoreForTeamB(gsTeamBScore);
        }

        // only subtract if score is greater than 0
        if (quarterScoreTeamB > 0)
        quarterScoreTeamB = quarterScoreTeamB - 1;
        // only subtract if score is greater than 0
        if (scoreTeamBTotal > 0)
        scoreTeamBTotal = scoreTeamBTotal - 1;
        TextView scoreView = (TextView) findViewById(R.id.team_b_quarter_score);
        // subtract 1 from quarterScoreTeamB and display it on the UI
        scoreView.setText(String.valueOf(quarterScoreTeamB));
        // subtract 1 from scoreTeamBTotal and display it on the UI
        TextView scoreViewTotal = (TextView) findViewById(R.id.team_b_total_score);
        scoreViewTotal.setText(String.valueOf(scoreTeamBTotal));
        // disable click for team B undo button to prevent multiple subtractions
        undoTeamB.setClickable(false);
    }

    /**
     *
     * @param gaTeamAScore GA score for team A
     *  display GA Scores
     */
    public void displayGaScoreForTeamA(int gaTeamAScore){
        text_team_a_ga_score.setText(String.valueOf(gaTeamAScore));
    }

    /**
     *
     * @param gsTeamAScore GS score for team A
     *  display GS Scores
     */
    public void displayGsScoreForTeamA(int gsTeamAScore){
        text_team_a_gs_score.setText(String.valueOf(gsTeamAScore));
    }

    /**
     *
     * @param gaTeamBScore GA score for team B
     *  display GA Scores
     */
    public void displayGaScoreForTeamB(int gaTeamBScore){
        text_team_b_ga_score.setText(String.valueOf(gaTeamBScore));
    }

    /**
     *
     * @param gsTeamBScore GS score for team B
     *  display GS Scores
     */
    public void displayGsScoreForTeamB(int gsTeamBScore){
        text_team_b_gs_score.setText(String.valueOf(gsTeamBScore));
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

    public void nextQuarter(View v){
        gaTeamAScore = 0;
        gsTeamAScore = 0;
        gaTeamBScore = 0;
        gsTeamBScore = 0;
        quarterScoreTeamA = 0;
        quarterScoreTeamB = 0;
        //display the quarter score for team A after setting it to 0
        displayForTeamAQuarter(quarterScoreTeamA);
        //display the quarter score for team A after setting it to 0
        displayForTeamBQuarter(quarterScoreTeamB);
        //display GS total score for team A after setting it to 0
        displayGsScoreForTeamA(gsTeamAScore);
        //display GA total score for team A after setting it to 0
        displayGaScoreForTeamA(gaTeamAScore);
        //display GA total score for team B after setting it to 0
        displayGaScoreForTeamB(gaTeamBScore);
        //display GS total score for team B after setting it to 0
        displayGsScoreForTeamB(gsTeamBScore);

    }
    /*
     * this method is called when undo buttons for teams A and B are clicked
     */
    public void onClick(View view) {
        switch (view.getId()) {

            // team A undo button is clicked
            case R.id.undoTeamA: {
                undoTeamAScore();
                break;
            }

            // team B undo button is clicked
            case R.id.undoTeamB: {
                undoTeamBScore();
                break;
            }
        }
    }
}
