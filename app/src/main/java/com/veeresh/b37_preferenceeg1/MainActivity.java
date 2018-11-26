package com.veeresh.b37_preferenceeg1;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //TASK 1 : WHEN USER OPENS THE APPLICATION, LOAD WELCOME FRAGMENT
        if(savedInstanceState == null) {
            WelcomeFragment welcomeFragment = new WelcomeFragment();
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.add(R.id.container, welcomeFragment);
            transaction.commit();
        }
        //END OF TASK 1
    }

    public void loadRegisterFragment() {
        //TASK 2-b: WHEN USER CLICKS REGISTER BUTTON, OPEN REGISTER FRAGMENT
        RegisterFragment registerFragment = new RegisterFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, registerFragment);
        transaction.addToBackStack(null);
        transaction.commit();
        //END OF TASK 2-b
    }

    public void gobackToWelcomeFragment() {
        //TASK 4-b : IF SAVED SUCCESSFULLY - GO TO PREVIOUS FRAGMENT
        FragmentManager manager = getSupportFragmentManager();
        manager.popBackStack();//this method can be used to go to previous fragment
        //END OF TASK 4-b
    }

    public void loadHomeFragment(String original_email) {
        //TASK 6-b : LOAD HOME FRAGMENT
        HomeFragment homeFragment = new HomeFragment();
        Bundle bundle = new Bundle();
        bundle.putString("email",original_email);
        homeFragment.setArguments(bundle);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, homeFragment);
        transaction.addToBackStack(null);
        transaction.commit();
        //END OF TASK 6-b
    }
}
