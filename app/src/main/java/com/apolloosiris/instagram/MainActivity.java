package com.apolloosiris.instagram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.apolloosiris.instagram.Fragments.HomeFragment;
import com.apolloosiris.instagram.Fragments.NotificationFragment;
import com.apolloosiris.instagram.Fragments.ProfileFragment;
import com.apolloosiris.instagram.Fragments.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private User user;
    private BottomNavigationView bottomNavigationView;
    private Fragment selectorFragment;
    private Intent postIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //user = (User) getIntent().getSerializableExtra("user");
        //System.out.println(user.getname());

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container , new HomeFragment()).commit();

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.nav_home :
                        selectorFragment = new HomeFragment();
                        break;

                    case R.id.nav_search :
                        selectorFragment = new SearchFragment();
                        break;

                    case R.id.nav_add :
                        selectorFragment = null;
                        postIntent=new Intent(MainActivity.this , PostActivity.class);
                        //postIntent.putExtra("user",user);
                        startActivity(postIntent);
                        break;

                    case R.id.nav_heart :
                        selectorFragment = new NotificationFragment();
                        break;

                    case R.id.nav_profile :
                        selectorFragment = new ProfileFragment();
                        break;
                }

                if (selectorFragment != null){
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container , selectorFragment).commit();
                }

                return  true;

            }
        });


        

    }
}