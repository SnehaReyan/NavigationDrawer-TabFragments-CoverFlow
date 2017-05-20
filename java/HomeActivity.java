package com.example.dell.spotsoontest;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ListViewCompat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

public class HomeActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private static final String LCAT = "HomeActivity";
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private ListViewCompat navBarListView;
    private NavBarListAdapter navBarListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        navBarListView = (ListViewCompat) findViewById(R.id.nav_bar_listview);
        navBarListAdapter = new NavBarListAdapter(this);
        navBarListView.setAdapter(navBarListAdapter);
        navBarListView.setOnItemClickListener(this);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }

        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.blank_string, R.string.blank_string) {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerStateChanged(int newState) {
                super.onDrawerStateChanged(newState);
            }
        };
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavHomeFragment homeFragment = new NavHomeFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container,homeFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.i(LCAT, "Item Clicked at position: " + position);
        drawerLayout.closeDrawers();
        switch (position) {
            case 0:
                NavHomeFragment homeFragment = new NavHomeFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container,homeFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {

        }
        return true;
    }

}
