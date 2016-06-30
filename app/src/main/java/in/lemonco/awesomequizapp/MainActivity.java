package in.lemonco.awesomequizapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private int counter = 1;
    private int correct_answers_count = 0;
    private TextView tracker;
    private ViewFlipper VF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        VF = (ViewFlipper) findViewById(R.id.viewFlipper);
        displayQuestion(counter);
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
    private void displayQuestion(int counter) {
        if (counter < 11) {
            VF.setDisplayedChild(0);
            TextView question_singleChoice = (TextView) findViewById(R.id.question_text_singleChoice);
            question_singleChoice.setText(Quiz.QUIZCARDS[counter - 1].getQuestion());
            EditText answer_text = (EditText) findViewById(R.id.answer_text_singleChoice);
            answer_text.setTextColor(Color.BLUE);

        } else if (counter == 11) {
            VF.setDisplayedChild(1);
            TextView question_text_multi = (TextView) findViewById(R.id.question_text_multiChoice);
            question_text_multi.setText(Quiz.QUIZCARDS[counter - 1].getQuestion());

        } else if (counter == 12) {
            VF.setDisplayedChild(2);
            TextView question_text_radio = (TextView) findViewById(R.id.question_text_singleChoiceRadio);
            question_text_radio.setText(Quiz.QUIZCARDS[counter - 1].getQuestion());
        }
        tracker = (TextView) findViewById(R.id.tracker);
        tracker.setText(counter + "/12");
    }

    public void next(View v) {
        if (VF.getDisplayedChild() == 0) {
            EditText answer_text = (EditText) findViewById(R.id.answer_text_singleChoice);
            String answer = answer_text.getText().toString();
            if ((Quiz.QUIZCARDS[counter - 1].getAnswer()).equalsIgnoreCase(answer)) {
                correct_answers_count++;
            }
            answer_text.setText("");  //Clear text on clicking next
        } else if (VF.getDisplayedChild() == 1) {
            CheckBox earth = (CheckBox) findViewById(R.id.earth);
            CheckBox sun = (CheckBox) findViewById(R.id.sun);
            CheckBox venus = (CheckBox) findViewById(R.id.venus);
            CheckBox jupiter = (CheckBox) findViewById(R.id.jupiter);
            ArrayList<String> answer = Quiz.QUIZCARDS[counter - 1].getMultiAnswer();
            if (earth.isChecked() == answer.contains(earth.getText()) && sun.isChecked() == answer.contains(sun.getText()) && venus.isChecked() == answer.contains(venus.getText()) && jupiter.isChecked() == answer.contains(jupiter.getText())) {
                correct_answers_count++;
            }

        } else if (VF.getDisplayedChild() == 2) {

            RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
            int button = radioGroup.getCheckedRadioButtonId();
            if(button!=-1) {
                RadioButton radioButton = (RadioButton) radioGroup.findViewById(button);
                String answer = (String) radioButton.getText();
                if ((Quiz.QUIZCARDS[counter - 1].getAnswer()).equalsIgnoreCase(answer)) {
                    correct_answers_count++;
                }
            }
        }

        if (counter < 12) {
            counter++;
            displayQuestion(counter);
        } else {
            Toast.makeText(this, getString(R.string.completion_msg), Toast.LENGTH_SHORT).show();
            Button nextButton = (Button)findViewById(R.id.next_button);
            Button submitButton = (Button)findViewById(R.id.submit_button);
            nextButton.setVisibility(View.INVISIBLE);  //make next button invisible
            submitButton.setVisibility(View.VISIBLE);   //make submit button visible

        }


    }

    //displays the final count of correct answer in a new activity.
    public void submit(View v) {
        Intent intent = new Intent(this, FinalResult.class);
        intent.putExtra(FinalResult.ANSWERCOUNT, correct_answers_count);
        startActivity(intent);
    }


}
