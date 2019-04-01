package com.example.android.caps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

public class CapsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.caps_layout);
        ask();
        //qNum = 1;
    }

    private String question = "0";
    private Game game = new Game();
    private String answer;
    private int score;
    private int qNum = 1;
    private String paragraph = "";
    private String container = "";
    private String container1 = "";
    private String answerUser;

private void ask()
{
    this.game = new Game();
    String[] qa = game.qa().split("\\n");

    this.answer = qa[1];
    this.question = qa[0];

    ((TextView) findViewById(R.id.question)).setText(question);
    //((TextView) findViewById(R.id.qNum)).setText(this.qNum);

}

public void onDone(View v) {
    if (qNum == 10) {
        finish();
        //((TextView) findViewById(R.id.qNum)).setText("GAME OVER");
        //Button btn = (Button) findViewById(R.id.done);
        //btn.setEnabled(false);
    } else {

        EditText x = (EditText) findViewById(R.id.answer);
        answerUser = x.getText().toString().toUpperCase();
        if (answerUser.equals(answer.toUpperCase())) {
            score++;
            //((TextView) findViewById(R.id.score)).setText("SCORE= " + score);
        }
    }
    //((TextView) findViewById(R.id.qNum)).setText("Q# " +qNum);

    //qNum++;
    String p = ((TextView) findViewById(R.id.log)).getText().toString();
    ((TextView) findViewById(R.id.log)).setText("Q#" + qNum + ":" + question + "\n" +
            "Your answer: " + answerUser + "\n" +
            "Correct answer: " + answer + "\n" + "\n" + p);
    qNum++;
    if(qNum == 10)
    {
        ((TextView) findViewById(R.id.qNum)).setText("GAME OVER");
        Button btn = (Button) findViewById(R.id.done);
        btn.setEnabled(false);
    }
    else{
        ((TextView) findViewById(R.id.qNum)).setText("Q# " +qNum);
        ((TextView) findViewById(R.id.score)).setText("SCORE= " + score);

    }
    ask();

}




}

