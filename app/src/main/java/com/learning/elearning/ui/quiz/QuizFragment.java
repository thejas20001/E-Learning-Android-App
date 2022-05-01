package com.learning.elearning.ui.quiz;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.learning.elearning.R;
import com.learning.elearning.authentication.LoginActivity;


public class QuizFragment extends Fragment {



    public QuizFragment() {
        // Required empty public constructor
    }
    Button playQuiz;
    FirebaseUser user;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_quiz, container, false);

        playQuiz = root.findViewById(R.id.playQuiz);
        user = FirebaseAuth.getInstance().getCurrentUser();

        playQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user!=null){
                    startActivity(new Intent(getContext(),StartQuiz.class));
                }
                else{
                    startActivity(new Intent(getContext(), LoginActivity.class));

                }
            }
        });


        return root;
    }
}