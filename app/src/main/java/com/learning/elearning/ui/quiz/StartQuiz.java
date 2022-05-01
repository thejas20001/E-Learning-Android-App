package com.learning.elearning.ui.quiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.learning.elearning.R;

import java.util.ArrayList;
import java.util.List;

public class StartQuiz extends AppCompatActivity {
    private TextView questionText,indicator;
    private LinearLayout container;
    private Button nextButton,shareButton;
    private int score = 0;
    private int position = 0;
    private int count = 0;

    DatabaseReference reference;

    private List<QuestionData> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_quiz);

        questionText = findViewById(R.id.question);
        indicator = findViewById(R.id.indicator);
        container = findViewById(R.id.linearLayout2);
        nextButton = findViewById(R.id.nextButton);
        shareButton = findViewById(R.id.shareButton);

        list = new ArrayList<>();
        reference = FirebaseDatabase.getInstance().getReference();
        reference.child("Questions").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot1: dataSnapshot.getChildren()){
                    String question = snapshot1.child("question").getValue().toString();
                    String option1 = snapshot1.child("option1").getValue().toString();
                    String option2 = snapshot1.child("option2").getValue().toString();
                    String option3 = snapshot1.child("option3").getValue().toString();
                    String option4 = snapshot1.child("option4").getValue().toString();
                    String answer = snapshot1.child("answer").getValue().toString();

                    list.add(new QuestionData(option1,option2,option3,option4,question,answer));
                }
                if(list.size()>0){
                    loadQuestion(questionText,0,list.get(position).getQuestion());
                    for (int i=0;i<4;i++){
                        container.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                checkAnswer((Button)view);
                            }
                        });
                    }



                    nextButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            nextButton.setEnabled(false);
                            nextButton.setAlpha(0.7f);
                            enabled(true);
                            position++;

                            if(position==list.size()){
                                Intent intent = new Intent(StartQuiz.this,ScoreActivity.class);
                                intent.putExtra("score",score);
                                intent.putExtra("total",list.size());
                                startActivity(intent);
                                finish();
                                return;
                            }
                            count = 0;
                            loadQuestion(questionText,0,list.get(position).getQuestion());


                        }
                    });
                    shareButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String body = "*" + list.get(position).getQuestion()+"*"+
                                    "(a)" +list.get(position).getOption1()+"\n"+
                                    "(b)" +list.get(position).getOption2()+"\n"+
                                    "(c)" +list.get(position).getOption3()+"\n"+
                                    "(d)" +list.get(position).getOption4();
                            Intent intent = new Intent(Intent.ACTION_SEND);
                            intent.setType("Text/Plain");
                            intent.putExtra(Intent.EXTRA_SUBJECT,"Learning App");
                            intent.putExtra(Intent.EXTRA_TEXT,body);
                            startActivity(Intent.createChooser(intent,"Share via"));
                        }
                    });

                }
                else
                {
                    Toast.makeText(StartQuiz.this, "No data found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(StartQuiz.this,databaseError.getMessage() , Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void checkAnswer(Button selectedOption) {
        enabled(false);
        nextButton.setEnabled(true);
        nextButton.setAlpha(1);
        if(selectedOption.getText().toString().equals(list.get(position).getAnswer())){
            score++;
            selectedOption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#4caf50")));
        }else{
            selectedOption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff0000")));
            Button correctOption = container.findViewWithTag(list.get(position).getAnswer());
            correctOption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#4caf50")));

        }

    }
    private void enabled(Boolean enable){
        for (int i=0;i<4;i++){
            container.getChildAt(i).setEnabled(enable);
            if(enable){
                container.getChildAt(i).setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#989898")));
            }
        }
    }

    private void loadQuestion(View view, int value, String data) {
        for (int i=0;i<4;i++){
            container.getChildAt(i).setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#989898")));
        }
        view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(500)
                .setStartDelay(100).setInterpolator(new DecelerateInterpolator())
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        if(value==0 && count<4){
                            String option = "";
                            if(count==0)
                                option = list.get(position).getOption1();
                            else if (count==1)
                                option = list.get(position).getOption2();
                            else if (count==2)
                                option = list.get(position).getOption3();
                            else if (count==3)
                                option = list.get(position).getOption4();

                            loadQuestion(container.getChildAt(count),0,option);
                            count++;

                        }
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        if(value==0){
                            try {
                                ((TextView)view).setText(data);
                                indicator.setText(position+ "/" +list.size());
                            } catch (ClassCastException e) {
                                ((Button)view).setText(data);
                            }
                            view.setTag(data);
                            loadQuestion(view,1,data);

                        }

                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });

    }


}