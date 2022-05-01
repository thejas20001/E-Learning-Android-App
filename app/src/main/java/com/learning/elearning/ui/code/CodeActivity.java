package com.learning.elearning.ui.code;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.learning.elearning.R;

import thereisnospon.codeview.CodeView;
import thereisnospon.codeview.CodeViewTheme;

public class CodeActivity extends AppCompatActivity {

    CodeView codeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code);
        codeView = findViewById(R.id.code_view);
        codeView.setTheme(CodeViewTheme.ANDROIDSTUDIO);
        loadPrograms();
    }

    private void loadPrograms() {
        String code = null;
        switch (getIntent().getStringExtra("position")){
            case "C++ Program to Maximize count of corresponding same elements in given permutations using cyclic rotations":
                code = ProgramExample.ex1;
                break;

            case "Java Program to Maximize count of corresponding same elements in given permutations using cyclic rotations":
                code = ProgramExample.ex2;
                break;

            case "Python3 Program to Maximize count of corresponding same elements in given permutations using cyclic rotations":
                code = ProgramExample.ex3;
                break;

            case "chapter4":
                code = ProgramExample.ex1;
                break;

            case "chapter5":
                code = ProgramExample.ex1;
                break;

            case "chapter6":
                code = ProgramExample.ex1;
                break;

            case "chapter7":
                code = ProgramExample.ex1;
                break;

            case "chapter8":
                code = ProgramExample.ex1;
                break;
        }
        codeView.showCode(code);
    }
}