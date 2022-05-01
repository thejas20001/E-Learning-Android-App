package com.learning.elearning.chaptertopics;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.learning.elearning.R;
import com.learning.elearning.chapter.chapterone.Android;
import com.learning.elearning.chapter.chapterone.Java;
import com.learning.elearning.chapter.chapterthree.javascript;
import com.learning.elearning.chapter.chaptertwo.php;

public class TopicActivity extends AppCompatActivity {
    ExpandableGridView gridView;
    String chapterName;
    Toolbar toolbar1;
    TopicAdapter adapter;
    String chapter1[] = {"Java", "Android", "Sub Heading 1", "Sub Heading 1", "Sub Heading 1", "Sub Heading 1", "Sub Heading 1", "Sub Heading 1"};
    String chapter2[] = {"php", "Sub Heading 2", "Sub Heading 2", "Sub Heading 2", "Sub Heading 2", "Sub Heading 2", "Sub Heading 2", "Sub Heading 2"};
    String chapter3[] = {"javascript", "Sub Heading 3", "Sub Heading 3", "Sub Heading 3", "Sub Heading 3", "Sub Heading 3", "Sub Heading 3", "Sub Heading 3"};
    String chapter4[] = {"Sub Heading 4", "Sub Heading 4", "Sub Heading 4", "Sub Heading 4", "Sub Heading 4", "Sub Heading 4", "Sub Heading 4", "Sub Heading 4"};
    String chapter5[] = {"Sub Heading 5", "Sub Heading 5", "Sub Heading 5", "Sub Heading 5", "Sub Heading 5", "Sub Heading 5", "Sub Heading 5", "Sub Heading 5"};
    String arr[] = null;
    ImageView chapterImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic2);

        toolbar1 = findViewById(R.id.toolbar);
        gridView = findViewById(R.id.topics_name);
        chapterImage = findViewById(R.id.chapter_image);
        gridView.setExpanded(true);

        //setSupportActionBar(toolbar1);

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        chapterName = getIntent().getStringExtra("chapterName");
        compareandopen();


    }

    ////////////////////// Activity_topic xml change the photo of all chapters///////////////////

    private void compareandopen() {

        if (chapterName.equals("heading1")) {
            arr = chapter1;
            Glide.with(TopicActivity.this).load("https://firebasestorage.googleapis.com/v0/b/elearning-app-d4d58.appspot.com/o/bg5.jpg?alt=media&token=87e0ab6b-13c5-4b37-9d03-216ad9b60d0f").into(chapterImage);

            //chapterImage.setImageResource(R.drawable.bg);
            getSupportActionBar().setTitle("Heading1");

        } else if (chapterName.equals("heading2")) {
            arr = chapter2;
            Glide.with(TopicActivity.this).load("https://firebasestorage.googleapis.com/v0/b/elearning-app-d4d58.appspot.com/o/bg.jpg?alt=media&token=8a2a59a1-5d8a-45c0-bb6d-0fb53b6f50d1").into(chapterImage);

            //chapterImage.setImageResource(R.drawable.bg1);
            getSupportActionBar().setTitle("Heading2");

        } else if (chapterName.equals("heading3")) {
            //chapterImage.setImageResource(R.drawable.bg2);
            Glide.with(TopicActivity.this).load("https://firebasestorage.googleapis.com/v0/b/elearning-app-d4d58.appspot.com/o/bg1.jpg?alt=media&token=7f30df2b-8cbd-4ac7-95cf-6a48093821f5").into(chapterImage);
            arr = chapter3;
            getSupportActionBar().setTitle("Heading3");

        } else if (chapterName.equals("heading4")) {
            //chapterImage.setImageResource(R.drawable.bg3);
            Glide.with(TopicActivity.this).load("https://firebasestorage.googleapis.com/v0/b/elearning-app-d4d58.appspot.com/o/bg5.jpg?alt=media&token=87e0ab6b-13c5-4b37-9d03-216ad9b60d0f").into(chapterImage);

            arr = chapter4;
            getSupportActionBar().setTitle("Heading4");

        } else if (chapterName.equals("heading5")) {
            //chapterImage.setImageResource(R.drawable.bg4);
            Glide.with(TopicActivity.this).load("https://firebasestorage.googleapis.com/v0/b/elearning-app-d4d58.appspot.com/o/bg4.jpg?alt=media&token=f604e078-f6fd-4694-bc2c-2942aaffa159").into(chapterImage);

            arr = chapter5;
            getSupportActionBar().setTitle("Heading5");

        } else
            arr = null;

        adapter = new TopicAdapter(arr, TopicActivity.this);
        gridView.setAdapter(adapter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                openActivity(arr[i]);

            }
        });

    }

    private void openActivity(String s) {

        switch (s) {
            case "Java":
                startActivity(new Intent(TopicActivity.this, Java.class));
                break;


            case "Android":
                startActivity(new Intent(TopicActivity.this, Android.class));
                break;

            case "php":
                startActivity(new Intent(TopicActivity.this, php.class));
                break;

            case "javascript":
                startActivity(new Intent(TopicActivity.this, javascript.class));
                break;
        }
    }
}