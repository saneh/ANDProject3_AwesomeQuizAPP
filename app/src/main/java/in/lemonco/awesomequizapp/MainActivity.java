package in.lemonco.awesomequizapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private int counter = 1;
    private int correct_answers_count = 0;
    private TextView question;
    private TextView tracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        question = (TextView) findViewById(R.id.question_text);
        tracker = (TextView) findViewById(R.id.tracker);
        question.setText(Quiz.QUIZCARDS[counter - 1].getQuestion());
        tracker.setText(counter + "/10");
        EditText answer_text = (EditText) findViewById(R.id.answer_text);
        answer_text.setTextColor(Color.BLUE);// have to set color programatically , dont know why color is notshowing when I set it via xml.


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //updates textview when next button is clicked. Also updates the counter
    public void next(View v) {
        EditText answer_text = (EditText) findViewById(R.id.answer_text);
        String answer = answer_text.getText().toString();
        if ((Quiz.QUIZCARDS[counter - 1].getAnswer()).equalsIgnoreCase(answer)) {
            correct_answers_count++;
        }
        if (counter < 10) {
            counter++;
            question.setText(Quiz.QUIZCARDS[counter - 1].getQuestion());
            tracker.setText(counter + "/10");
            answer_text.setText("");
        } else {
            Button submit_button = (Button) findViewById(R.id.submit_button);
            Button next_button = (Button) findViewById(R.id.next_button);
            submit_button.setVisibility(View.VISIBLE);
            next_button.setVisibility(View.INVISIBLE);

            Toast.makeText(this, getString(R.string.completion_msg), Toast.LENGTH_SHORT).show();
        }

    }

    //displays the final count of correct answer in a new activity.
    public void submit(View v) {
        Intent intent = new Intent(this, FinalResult.class);
        intent.putExtra(FinalResult.ANSWERCOUNT, correct_answers_count);
        startActivity(intent);
    }


}
