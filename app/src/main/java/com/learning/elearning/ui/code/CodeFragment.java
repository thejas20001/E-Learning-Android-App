package com.learning.elearning.ui.code;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.learning.elearning.R;

import de.hdodenhof.circleimageview.CircleImageView;


public class CodeFragment extends Fragment implements View.OnClickListener{




    public CodeFragment() {
        // Required empty public constructor

    }

    CircleImageView image1,image2,image3,image4,image5,image6,image7,image8;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_code, container, false);
        image1 = view.findViewById(R.id.chapter1);
        image2 = view.findViewById(R.id.chapter2);
        image3 = view.findViewById(R.id.chapter3);
        image4 = view.findViewById(R.id.chapter4);
        image5 = view.findViewById(R.id.chapter5);
        image6 = view.findViewById(R.id.chapter6);
        image7 = view.findViewById(R.id.chapter7);
        image8 = view.findViewById(R.id.chapter8);

        loadImage();

        image1.setOnClickListener(this);
        image2.setOnClickListener(this);
        image3.setOnClickListener(this);
        image4.setOnClickListener(this);
        image5.setOnClickListener(this);
        image6.setOnClickListener(this);
        image7.setOnClickListener(this);
        image8.setOnClickListener(this);



        return view;
    }

    private void loadImage() {
        Glide.with(getContext()).load("https://firebasestorage.googleapis.com/v0/b/elearning-app-d4d58.appspot.com/o/bg5.jpg?alt=media&token=87e0ab6b-13c5-4b37-9d03-216ad9b60d0f").into(image1);
        Glide.with(getContext()).load("https://firebasestorage.googleapis.com/v0/b/elearning-app-d4d58.appspot.com/o/bg.jpg?alt=media&token=8a2a59a1-5d8a-45c0-bb6d-0fb53b6f50d1").into(image2);
        Glide.with(getContext()).load("https://firebasestorage.googleapis.com/v0/b/elearning-app-d4d58.appspot.com/o/bg1.jpg?alt=media&token=7f30df2b-8cbd-4ac7-95cf-6a48093821f5").into(image3);
        Glide.with(getContext()).load("https://firebasestorage.googleapis.com/v0/b/elearning-app-d4d58.appspot.com/o/bg5.jpg?alt=media&token=87e0ab6b-13c5-4b37-9d03-216ad9b60d0f").into(image4);
        Glide.with(getContext()).load("https://firebasestorage.googleapis.com/v0/b/elearning-app-d4d58.appspot.com/o/bg4.jpg?alt=media&token=f604e078-f6fd-4694-bc2c-2942aaffa159").into(image5);
        Glide.with(getContext()).load("https://firebasestorage.googleapis.com/v0/b/elearning-app-d4d58.appspot.com/o/bg5.jpg?alt=media&token=87e0ab6b-13c5-4b37-9d03-216ad9b60d0f").into(image6);
        Glide.with(getContext()).load("https://firebasestorage.googleapis.com/v0/b/elearning-app-d4d58.appspot.com/o/bg.jpg?alt=media&token=8a2a59a1-5d8a-45c0-bb6d-0fb53b6f50d1").into(image7);
        Glide.with(getContext()).load("https://firebasestorage.googleapis.com/v0/b/elearning-app-d4d58.appspot.com/o/bg1.jpg?alt=media&token=7f30df2b-8cbd-4ac7-95cf-6a48093821f5").into(image8);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getContext(), CodeCategory.class);
        switch(v.getId()){
            case R.id.chapter1:
                intent.putExtra("codeCategory","chapter1");
                startActivity(intent);
                break;

            case R.id.chapter2:
                intent.putExtra("codeCategory","chapter2");
                startActivity(intent);
                break;

            case R.id.chapter3:
                intent.putExtra("codeCategory","chapter3");
                startActivity(intent);
                break;

            case R.id.chapter4:
                intent.putExtra("codeCategory","chapter4");
                startActivity(intent);
                break;

            case R.id.chapter5:
                intent.putExtra("codeCategory","chapter5");
                startActivity(intent);
                break;

            case R.id.chapter6:
                intent.putExtra("codeCategory","chapter6");
                startActivity(intent);
                break;

            case R.id.chapter7:
                intent.putExtra("codeCategory","chapter7");
                startActivity(intent);
                break;

            case R.id.chapter8:
                intent.putExtra("codeCategory","chapter8");
                startActivity(intent);
                break;
        }
    }
}