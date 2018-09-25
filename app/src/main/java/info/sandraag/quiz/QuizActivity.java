package info.sandraag.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private QuizQuestion question;
    private RadioGroup answersView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        GenerateQuestion();

        TextView textView = findViewById(R.id.textView);
        answersView = findViewById(R.id.answersView);
        RadioButton btn_ans0 = findViewById(R.id.btn_ans0);
        RadioButton btn_ans1 = findViewById(R.id.btn_ans1);
        RadioButton btn_ans2 = findViewById(R.id.btn_ans2);
        RadioButton btn_ans3 = findViewById(R.id.btn_ans3);

        textView.setText(question.getText());
        btn_ans0.setText(question.getAnswers()[0]);
        btn_ans1.setText(question.getAnswers()[1]);
        btn_ans2.setText(question.getAnswers()[2]);
        btn_ans3.setText(question.getAnswers()[3]);
    }

    private void GenerateQuestion() {

        String[] answers = new String[4];
        answers[0] = "Stardew Valley";
        answers[1] = "Nintendogs";
        answers[2] = "Portal";
        answers[3] = "Fallout";

        question = new QuizQuestion("Which game does not contain dogs?", answers, 2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Delegate the creation of the menu to the inflater
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.quiz_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.menuCheck:
                CheckAnswer();
                break;

            case R.id.menuReset:
                answersView.clearCheck();
                break;
        }

        return true;
    }

    private void CheckAnswer() {

        if (getButtonIndex() == question.getCorrect())
            Toast.makeText(this, "Congrats!!!", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, "Try again!", Toast.LENGTH_SHORT).show();
    }

    private int getButtonIndex() {

        int selected = answersView.getCheckedRadioButtonId();

        int ids[] = { R.id.btn_ans0, R.id.btn_ans1, R.id.btn_ans2, R.id.btn_ans3 };
        int index = -1;

        for (int i = 0; i < ids.length; i++) {

            if (ids[i] == selected) {

                index = i;
                break;
            }
        }

        return index;
    }
}
