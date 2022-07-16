package com.doinWondrs.betterme.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.doinWondrs.betterme.R;
import com.doinWondrs.betterme.helpers.GoToNav;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    //field declaration
    private GoToNav gotoHelper = new GoToNav();//TODO: do I need to instantiate?

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navGoTo();

    }

    public void navGoTo()
    {
        //notes: https://www.geeksforgeeks.org/how-to-implement-bottom-navigation-with-activities-in-android/
        //TODO: bottomnavbar is deprecated: https://developer.android.com/reference/com/google/android/material/bottomnavigation/BottomNavigationView.OnNavigationItemSelectedListener

        //initialize, instantiate
        NavigationBarView navigationBarView;//new way to do nav's but more research needed
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        //iset home selected
        bottomNavigationView.setSelectedItemId(R.id.home_nav);
        //perform item selected listener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.home_nav: //if at home we dont select home
                        break;
                    case R.id.workouts_nav:
                        //gotoHelper.gotoWorkouts
                        startActivity
                                (new Intent(getApplicationContext(), WorkoutpageMainActivity.class));
                        overridePendingTransition(0,0);
                        break;
                    default: return false;// this is to cover all other cases if not working properly
                }

                return true;
            }
        });//end lambda: bottomNavview

        //this is how to do with new way but didn't finish it
        /*
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item)

        /*
        navigationBarView.setOnItemSelectedListener
        (item ->{
            switch (item.getItemId()){
                case R.id.home_nav:
                    gotoHelper.gotoHome(new MainActivity());
                    break;
                case R.id.workouts_nav:
                    gotoHelper.gotoWorkouts(new WorkoutpageMainActivity());
                    break;
            }
            return true;
        });

        return;
    }
    */

    }//end method: navGoTo
}//end class