package com.learning.elearning.ui.code;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.learning.elearning.R;

public class CodeCategory extends AppCompatActivity {

    ListView programs;
    String[] list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_category);
        loadCategory();
        programs = findViewById(R.id.programs);
        CustomAdapter adapter = new CustomAdapter();
        programs.setAdapter(adapter);
        programs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(CodeCategory.this, CodeActivity.class);
                intent.putExtra("position",list[i]);
                startActivity(intent);
            }
        });

    }

    private void loadCategory() {
        final String chap1[] = {"C++ Program to Maximize count of corresponding same elements in given permutations using cyclic rotations","Java Program to Maximize count of corresponding same elements in given permutations using cyclic rotations","Python3 Program to Maximize count of corresponding same elements in given permutations using cyclic rotations","ssdadasd","adadasdds"};
        final String chap2[] = {"chapter2","gfdxxfgdg","gdfgxxxdfgdf","gdfgdgxxxx","ssdadasd","adadasdds"};
        final String chap3[] = {"chapter3","xxx","gdfgdfxxssgdf","gdfgdg","ssdadaxxxsd","ssssadadasdds"};
        final String chap4[] = {"chapter4","gfdfgdg","gdfwwwgdfgdf","gdwwwwfgdg","sswwwwdadasd","adadasdds"};
        final String chap5[] = {"chapter5","gfdfgdg","gdfgdfgdf","gdfgdg","ssdadasd","adadasdds"};
        final String chap6[] = {"chapter6","gfdfrgdg","gdfgdrrfgdf","gdfrrgdg","ssdadasd","adadrrrrasdds"};
        final String chap7[] = {"chapter7","gfdrrfgdg","gdyyyyfgdfgdf","gdfgdg","ssdadasd","adadasdds"};
        final String chap8[] = {"chapter8","gfdfgdg","gdfgdfgdf","gdfgdg","ssdadasd","adadasdds"};

        String Category = getIntent().getStringExtra("codeCategory");
        switch(Category){
            case "chapter1":
                list = chap1;
                break;

            case "chapter2":
                list = chap2;
                break;

            case "chapter3":
                list = chap3;
                break;

            case "chapter4":
                list = chap4;
                break;

            case "chapter5":
                list = chap5;
                break;

            case "chapter6":
                list = chap6;
                break;

            case "chapter7":
                list = chap7;
                break;

            case "chapter8":
                list = chap8;
                break;
        }

    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return list.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.code_category_item_layout, null);
            TextView textview = view.findViewById(R.id.code_title);
            textview.setText(list[i]);
        return view;
        }
    }
}