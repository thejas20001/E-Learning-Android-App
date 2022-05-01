package com.learning.elearning.ui.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.learning.elearning.R;
import com.learning.elearning.chaptertopics.TopicActivity;


public class HomeFragment extends Fragment implements View.OnClickListener {

    public HomeFragment() {
        // Required empty public constructor
    }

    CardView heading1,heading2,heading3,heading4,heading5;
    ImageView image1,image2,image3,image4,image5;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        heading1 = view.findViewById(R.id.heading1);
        heading2 = view.findViewById(R.id.heading2);
        heading3 = view.findViewById(R.id.heading3);
        heading4 = view.findViewById(R.id.heading4);
        heading5 = view.findViewById(R.id.heading5);

        image1 = view.findViewById(R.id.image1);
        image2 = view.findViewById(R.id.image2);
        image3 = view.findViewById(R.id.image3);
        image4= view.findViewById(R.id.image4);
        image5 = view.findViewById(R.id.image5);

        loadImage();


        heading1.setOnClickListener(this);
        heading2.setOnClickListener(this);
        heading3.setOnClickListener(this);
        heading4.setOnClickListener(this);
        heading5.setOnClickListener(this);



        return  view;
    }

    private void loadImage() {
        Glide.with(getContext()).load("https://firebasestorage.googleapis.com/v0/b/elearning-app-d4d58.appspot.com/o/bg5.jpg?alt=media&token=87e0ab6b-13c5-4b37-9d03-216ad9b60d0f").into(image1);
        Glide.with(getContext()).load("https://firebasestorage.googleapis.com/v0/b/elearning-app-d4d58.appspot.com/o/bg.jpg?alt=media&token=8a2a59a1-5d8a-45c0-bb6d-0fb53b6f50d1").into(image2);
        Glide.with(getContext()).load("https://firebasestorage.googleapis.com/v0/b/elearning-app-d4d58.appspot.com/o/bg1.jpg?alt=media&token=7f30df2b-8cbd-4ac7-95cf-6a48093821f5").into(image3);
        Glide.with(getContext()).load("https://firebasestorage.googleapis.com/v0/b/elearning-app-d4d58.appspot.com/o/bg5.jpg?alt=media&token=87e0ab6b-13c5-4b37-9d03-216ad9b60d0f").into(image4);
        Glide.with(getContext()).load("https://firebasestorage.googleapis.com/v0/b/elearning-app-d4d58.appspot.com/o/bg4.jpg?alt=media&token=f604e078-f6fd-4694-bc2c-2942aaffa159").into(image5);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getContext(),TopicActivity.class);
        switch (view.getId()){

            case R.id.heading1:
                intent.putExtra("chapterName","heading1");
                startActivity(intent);
                break;

            case R.id.heading2:
                intent.putExtra("chapterName","heading2");
                startActivity(intent);
                break;

            case R.id.heading3:
                intent.putExtra("chapterName","heading3");
                startActivity(intent);
                break;

            case R.id.heading4:
                intent.putExtra("chapterName","heading4");
                startActivity(intent);
                break;

            case R.id.heading5:
                intent.putExtra("chapterName","heading5");
                startActivity(intent);
                break;
        }
    }
}