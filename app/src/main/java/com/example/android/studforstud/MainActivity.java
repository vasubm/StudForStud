package com.example.android.studforstud;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new OldTransactionsFragment()).commit();
            navigationView.setCheckedItem(R.id.old_transaction);

        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.old_transaction:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new OldTransactionsFragment()).commit();
                break;
            case R.id.notification:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Notifications()).commit();
                break;
            case R.id.terms_and_conditions:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new TermsAndConditions()).commit();
                break;
            case R.id.settings:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Settings()).commit();
                break;
            case R.id.logout:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Logout()).commit();
                break;
            case R.id.feedback_form:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FeedbackForm()).commit();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed(){

        if(drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }
}
