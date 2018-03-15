package com.example.android.myquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // create and initialize the integer variable who keeps the score
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //disable popping up the on-screen keyboard without touching the EditText when we change layout from landscape to portrait
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    // This method returns the score for the first question.
    public int editTextQ1(int score) {
        // Casting(finding) the EditText for the first question in order to calculate the score
        EditText q1 = findViewById(R.id.q1EditText);
        // Gets the answer for the first question and remove the unwanted spaces
        String a1 = q1.getText().toString().trim();
        // adds one point, only if the answer is the same as caq1 from strings.xml
        // set the answer to be not case sensitive
        if (a1.equalsIgnoreCase(getResources().getString(R.string.caq1))) {
            score += 1;
        }
        return score;
    }

    // This method returns the score for the second question.
    public int checkBoxQ2(int score) {
        // Casting(finding) all the the check boxes for the second question in order to calculate the score
        CheckBox q2r1 = findViewById(R.id.q2r1_checkbox);
        CheckBox q2r2 = findViewById(R.id.q2r2_checkbox);
        CheckBox q2r3 = findViewById(R.id.q2r3_checkbox);
        CheckBox q2r4 = findViewById(R.id.q2r4_checkbox);
        // adds one point, only if the user checked, the first two checkboxes
        if (q2r1.isChecked() && q2r2.isChecked() && !q2r3.isChecked() && !q2r4.isChecked()) {
            score += 1;
        }
        return score;
    }

    // This method returns the score for the third question.
    public int checkBoxQ3(int score) {
        // Casting(finding) all the check boxes for the third question in order to calculate the score
        CheckBox q3r1 = findViewById(R.id.q3r1_checkbox);
        CheckBox q3r2 = findViewById(R.id.q3r2_checkbox);
        CheckBox q3r3 = findViewById(R.id.q3r3_checkbox);
        CheckBox q3r4 = findViewById(R.id.q3r4_checkbox);
        // adds one point, only if the user checked, the last three options
        if (!q3r1.isChecked() && q3r2.isChecked() && q3r3.isChecked() && q3r4.isChecked()) {
            score += 1;
        }
        return score;
    }

    // This method returns the score for the fourth question.
    public int onRadioButtonQ4(int score) {
        // Casting(finding) the first radio button, the right answer for the fourth question, in order to calculate the score
        RadioButton checkedQ4a1 = findViewById(R.id.radio_q4a1);
        //adds one point, only if the first radio button is selected.
        if (checkedQ4a1.isChecked()) {
            score += 1;
        }
        return score;
    }

    // This method returns the score for the fifth question.
    public int onRadioButtonQ5(int score) {
        // Casting(finding) the sixth radio button, the right answer for the fifth question, in order to calculate the score
        RadioButton checkedQ5a6 = findViewById(R.id.radio_q5a6);
        //adds one point, only if the sixth radio button is selected.
        if (checkedQ5a6.isChecked()) {
            score += 1;
        }
        return score;
    }

    // This method is called when the submitScore button is clicked.
    public void submitScore(View view) {
        //set the score to 0
        score = 0;
        // evaluates the first question and updates the score
        score = editTextQ1(score);
        // evaluates the second question and updates the score
        score = checkBoxQ2(score);
        // evaluates the third question and updates the score
        score = checkBoxQ3(score);
        // evaluates the fourth question and updates the score
        score = onRadioButtonQ4(score);
        // evaluates the fifth question and updates the score
        score = onRadioButtonQ5(score);
        //compare the score and the user receive a toast message
        // in case the score is 5, the user won, else the player should give another try
        if (score == 5) {
            Toast.makeText(this, getString(R.string.succeed) + score + "! " + getString(R.string.bye), Toast.LENGTH_LONG).show();
            finish();
        } else {
            Toast.makeText(this, getString(R.string.score) + score + "! " + getString(R.string.again), Toast.LENGTH_SHORT).show();
        }
    }

    //  that method is for exit the app
    public void exitApp(View view) {
        Toast.makeText(this, getString(R.string.quit), Toast.LENGTH_LONG).show();
        finish();

    }
}

