package com.learning.elearning.ui.quiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.learning.elearning.R;

public class ScoreActivity extends AppCompatActivity {

    TextView scoreTxt,totalTxt;
    int score,total;
    FirebaseUser user;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        score = getIntent().getIntExtra("score",0);
        total = getIntent().getIntExtra("total",0);
        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference();

        scoreTxt = findViewById(R.id.score);
        totalTxt = findViewById(R.id.total);

        scoreTxt.setText(String.valueOf(score));
        totalTxt.setText(String.valueOf(total));

        reference.child("Score").child(user.getUid()).child("score").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){

                    score += Integer.parseInt(dataSnapshot.getValue().toString());

                }
                dataSnapshot.getRef().setValue(score);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




    }
}