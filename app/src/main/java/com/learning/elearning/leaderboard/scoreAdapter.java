package com.learning.elearning.leaderboard;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.learning.elearning.R;

import java.util.List;

public class scoreAdapter extends RecyclerView.Adapter<scoreAdapter.scoreViewAdapter> {

    List<scoreData> list;
    Context context;




    public scoreAdapter(List<scoreData> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public scoreViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.score_list_item,parent,false);
        return new scoreViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull scoreViewAdapter holder, int position) {
        scoreData currentItem = list.get(position);
        holder.name.setText(currentItem.getName());
        holder.score.setText(String.valueOf(currentItem.getScore()));
        holder.rank.setText(String.valueOf(list.size()-position));
        Glide.with(context).load(currentItem.getImage()).into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class scoreViewAdapter extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name,score,rank;

        public scoreViewAdapter(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.score_userImage);
            name = itemView.findViewById(R.id.score_userName);
            score = itemView.findViewById(R.id.score_userResult);
            rank = itemView.findViewById(R.id.score_userRank);

        }
    }
}
