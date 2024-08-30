package com.example.classconnect;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavBar;
    private final AnnouncementFragment announcementFragment = new AnnouncementFragment();
    private final ChatFragment chatFragment = new ChatFragment();
    private final RecordFragment recordFragment = new RecordFragment();
    private final TaskFragment taskFragment = new TaskFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                // Custom back press behavior
                moveTaskToBack(true); // Move the task to the background instead of exiting
            }
        };
        getOnBackPressedDispatcher().addCallback(this, callback);

        initializeView();
    }

    private void initializeView(){
        bottomNavBar = (BottomNavigationView) findViewById(R.id.bottom_nav_container);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragments_container, taskFragment).commit();

        bottomNavBar.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if(menuItem.getItemId() == R.id.tasks_item){
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragments_container, taskFragment).addToBackStack(null).addToBackStack(null).commit();
                }else if(menuItem.getItemId() == R.id.updates_item){
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragments_container, announcementFragment).addToBackStack(null).addToBackStack(null).commit();
                }else if(menuItem.getItemId() == R.id.chat_item){
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragments_container, chatFragment).addToBackStack(null).addToBackStack(null).commit();
                }else if(menuItem.getItemId() == R.id.records_item){
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragments_container, recordFragment).addToBackStack(null).addToBackStack(null).commit();
                }

                return true;
            }
        });


    }
}