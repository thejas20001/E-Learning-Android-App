package com.learning.elearning;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.learning.elearning.authentication.LoginActivity;
import com.learning.elearning.authentication.ProfileActivity;
import com.learning.elearning.authentication.RegisterActivity;
import com.learning.elearning.leaderboard.LeaderboardActivity;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView bottomNavigationView;
    private NavController navController;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    FirebaseUser user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.my_drawer);
        navigationView = findViewById(R.id.navigation_view);

        toggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.start,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(this);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        navController = Navigation.findNavController(this,R.id.main_fragment);
        NavigationUI.setupWithNavController(bottomNavigationView,navController);

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(toggle.onOptionsItemSelected(item))
            return true;
        if(item.getItemId()==R.id.profile){
            if(user!=null){
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
            }
            else
            {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));

            }
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }
        return true;
    }

    @Override
    protected void onStart() {

        super.onStart();
        user = FirebaseAuth.getInstance().getCurrentUser();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.pdf:
                Toast.makeText(this, "Ebook", Toast.LENGTH_SHORT).show();
                break;

            case R.id.leaderBoard:
                startActivity(new Intent(MainActivity.this, LeaderboardActivity.class));
                break;


            case R.id.share:
                Toast.makeText(this, "share", Toast.LENGTH_SHORT).show();
                break;

            case R.id.rate:
                Toast.makeText(this, "rate", Toast.LENGTH_SHORT).show();
                break;

            case R.id.about:
                Toast.makeText(this, "about", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}