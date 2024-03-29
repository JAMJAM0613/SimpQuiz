package dev.jam.simpquiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView optionA,optionB,optionC,optionD;
    TextView questionnumber,question,score;
    TextView chechkout1,checkout2;
    int currentIndex=0;
    int mscore=0;
    int qn=1;
    ProgressBar progressBar;

    int CurrentQuestion,CurrentOptionA,CurrentOptionB,CurrentOptionC,CurrentOptionD;
    AnswerClass[] questionBank;
    private static final int PROGRESS_BAR = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionBank = new AnswerClass[]{
                new AnswerClass(R.string.question_1, R.string.question1_A, R.string.question1_B, R.string.question1_C, R.string.question1_D, R.string.answer_1),
                new AnswerClass(R.string.question_2, R.string.question_2A, R.string.question_2B, R.string.question_2C, R.string.question_2D, R.string.answer_2),
                new AnswerClass(R.string.question_3, R.string.question_3A, R.string.question_3B, R.string.question_3C, R.string.question_3D, R.string.answer_3),
                new AnswerClass(R.string.question_4, R.string.question_4A, R.string.question_4B, R.string.question_4C, R.string.question_4D, R.string.answer_4),
                new AnswerClass(R.string.question_5, R.string.question_5A, R.string.question_5B, R.string.question_5C, R.string.question_5D, R.string.answer_5),
                new AnswerClass(R.string.question_6, R.string.question_6A, R.string.question_6B, R.string.question_6C, R.string.question_6D, R.string.answer_6),
                new AnswerClass(R.string.question_7, R.string.question_7A, R.string.question_7B, R.string.question_7C, R.string.question_7D, R.string.answer_7),
                new AnswerClass(R.string.question_8, R.string.question_8A, R.string.question_8B, R.string.question_8C, R.string.question_8D, R.string.answer_8),
                new AnswerClass(R.string.question_9, R.string.question_9A, R.string.question_9B, R.string.question_9C, R.string.question_9D, R.string.answer_9),
                new AnswerClass(R.string.question_10, R.string.question_10A, R.string.question_10B, R.string.question_10C, R.string.question_10D, R.string.answer_10),
                new AnswerClass(R.string.question_11, R.string.question_11A, R.string.question_11B, R.string.question_11C, R.string.question_11D, R.string.answer_11),
                new AnswerClass(R.string.question_12, R.string.question_12A, R.string.question_12B, R.string.question_12C, R.string.question_12D, R.string.answer_12),
                new AnswerClass(R.string.question_13, R.string.question_13A, R.string.question_13B, R.string.question_13C, R.string.question_13D, R.string.answer_13),
                new AnswerClass(R.string.question_14, R.string.question_14A, R.string.question_14B, R.string.question_14C, R.string.question_14D, R.string.answer_14),
                new AnswerClass(R.string.question_15, R.string.question_15A, R.string.question_15B, R.string.question_15C, R.string.question_15D, R.string.answer_15),
                new AnswerClass(R.string.question_16, R.string.question_16A, R.string.question_16B, R.string.question_16C, R.string.question_16D, R.string.answer_16),
                new AnswerClass(R.string.question_17, R.string.question_17A, R.string.question_17B, R.string.question_17C, R.string.question_17D, R.string.answer_17),
                new AnswerClass(R.string.question_18, R.string.question_18A, R.string.question_18B, R.string.question_18C, R.string.question_18D, R.string.answer_18),
                new AnswerClass(R.string.question_19, R.string.question_19A, R.string.question_19B, R.string.question_19C, R.string.question_19D, R.string.answer_19),
                new AnswerClass(R.string.question_20, R.string.question_20A, R.string.question_20B, R.string.question_20C, R.string.question_20D, R.string.answer_20),

        };

        List<AnswerClass> questionList = Arrays.asList(questionBank);
        Collections.shuffle(questionList);
        questionBank = questionList.toArray(new AnswerClass[0]);

        optionA=findViewById(R.id.optionA);
        optionB=findViewById(R.id.optionB);
        optionC=findViewById(R.id.optionC);
        optionD=findViewById(R.id.optionD);

        question = findViewById(R.id.question);
        score=findViewById(R.id.score);
        questionnumber=findViewById(R.id.QuestionNumber);

        chechkout1=findViewById(R.id.selectoption);
        checkout2=findViewById(R.id.CorrectAnswer);
        progressBar=findViewById(R.id.progress_bar);

        CurrentQuestion=questionBank[currentIndex].getQuestionid();
        question.setText(CurrentQuestion);
        CurrentOptionA=questionBank[currentIndex].getOptionA();
        optionA.setText(CurrentOptionA);
        CurrentOptionB=questionBank[currentIndex].getOptionB();
        optionB.setText(CurrentOptionB);
        CurrentOptionC=questionBank[currentIndex].getOptionC();
        optionC.setText(CurrentOptionC);
        CurrentOptionD=questionBank[currentIndex].getOptionD();
        optionD.setText(CurrentOptionD);

        optionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(CurrentOptionA);
                updateQuestion();

            }
        });

        optionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(CurrentOptionB);
                updateQuestion();


            }
        });
        optionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(CurrentOptionC);
                updateQuestion();


            }
        });
        optionD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkAnswer(CurrentOptionD);
                updateQuestion();

            }
        });


    }

    private void checkAnswer(int userSelection) {

        int correctanswer=questionBank[currentIndex].getAnswerid();

        chechkout1.setText(userSelection);
        checkout2.setText(correctanswer);

        String m= chechkout1.getText().toString().trim();
        String n=checkout2.getText().toString().trim();

        if(m.equals(n))
        {
            Toast.makeText(getApplicationContext(),"Right",Toast.LENGTH_SHORT).show();
            mscore=mscore+1;
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Wrong",Toast.LENGTH_SHORT).show();
        }




    }

    @SuppressLint("SetTextI18n")
    private void updateQuestion()  {

        currentIndex =(currentIndex+1)%questionBank.length;

        if(currentIndex==0)
        {

            AlertDialog.Builder alert=new AlertDialog.Builder(this);
            alert.setTitle("Game Over");
            alert.setCancelable(false);
            alert.setMessage("Your Score" + mscore +"points");
            alert.setPositiveButton("Close Application", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });

            alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    mscore=0;
                    qn=1;
                    progressBar.setProgress(0);
                    score.setText("Score" + mscore +"/" +questionBank.length);
                    questionnumber.setText(qn + "/" + questionBank.length +"Question");
                }
            });

            alert.show();

        }
        int progressIncrement = 100 / questionBank.length;
        progressBar.incrementProgressBy(progressIncrement);



        CurrentQuestion=questionBank[currentIndex].getQuestionid();
        question.setText(CurrentQuestion);
        CurrentOptionA=questionBank[currentIndex].getOptionA();
        optionA.setText(CurrentOptionA);
        CurrentOptionB=questionBank[currentIndex].getOptionB();
        optionB.setText(CurrentOptionB);
        CurrentOptionC=questionBank[currentIndex].getOptionC();
        optionC.setText(CurrentOptionC);
        CurrentOptionD=questionBank[currentIndex].getOptionD();
        optionD.setText(CurrentOptionD);

        qn=qn+1;

        if(qn<=questionBank.length)

        {
            questionnumber.setText(qn + "/" + questionBank.length +"Question");
        }
        score.setText("Score" + mscore +"/" +questionBank.length);

    }
}