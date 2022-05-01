package com.learning.elearning.authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.learning.elearning.MainActivity;
import com.learning.elearning.R;

public class ProfileActivity extends AppCompatActivity {

    TextView name,email;
    ImageView userImage;
    Button logoutBtn;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile2);

        name = findViewById(R.id.UserName);
        email = findViewById(R.id.userEmail);
        logoutBtn = findViewById(R.id.logoutButton);
        userImage = findViewById(R.id.user_image);
        user = FirebaseAuth.getInstance().getCurrentUser();

        name.setText(user.getDisplayName());
        email.setText(user.getEmail());
        Glide.with(ProfileActivity.this).load(user.getPhotoUrl()).into(userImage);

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(ProfileActivity.this, MainActivity.class));
                finish();
            }
        });


    }
}