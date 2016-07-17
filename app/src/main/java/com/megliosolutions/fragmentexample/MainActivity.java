package com.megliosolutions.fragmentexample;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.res.Configuration;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public static final String FRAG_TAG = "FRAG_TAG";
    public FragmentManager fragmentManager;
    public Toolbar toolbar;
    public DrawerLayout mDrawerLayout;
    public NavigationView mNavView;
    public ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mNavView = (NavigationView) findViewById(R.id.navigationView);
        if(mNavView != null){
            mNavView.setNavigationItemSelectedListener(this);
        }
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                toolbar,
                R.string.drawer_open,
                R.string.drawer_close);
        mDrawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        BuildFrag();
    }

    private void BuildFrag() {
        FragmentExample fragment = new FragmentExample();
        fragmentManager = getFragmentManager();
        //Replace intent with Bundle and put it in the transaction
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.main_frameLayout, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.nav_id_map){
            Toast.makeText(getApplicationContext(), "Map",Toast.LENGTH_SHORT).show();
            mDrawerLayout.closeDrawer(GravityCompat.START);
            Log.i("FragmentExample", "Item Clicked");
            FragmentExample fragment = new FragmentExample();
            fragmentManager = getFragmentManager();
            //Replace intent with Bundle and put it in the transaction
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.main_frameLayout, fragment);
            fragmentTransaction.commit();
            Log.i("NavDrawer", "Map " + item.getItemId());
            return true;
        }
        if(item.getItemId() == R.id.nav_id_tag){
            Toast.makeText(getApplicationContext(), "Tag",Toast.LENGTH_SHORT).show();
            mDrawerLayout.closeDrawer(GravityCompat.START);
            Log.i("FragmentExample", "Item Clicked");
            MovieInfo movie = new MovieInfo();
            fragmentManager = getFragmentManager();
            //Replace intent with Bundle and put it in the transaction
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.main_frameLayout, movie);
            fragmentTransaction.commit();
            Log.i("NavDrawer", "Tag " + item.getItemId());
            return true;
        }
        if(item.getItemId() == R.id.nav_id_profile){
            Toast.makeText(getApplicationContext(), "Profile",Toast.LENGTH_SHORT).show();
            mDrawerLayout.closeDrawer(GravityCompat.START);
            Log.i("FragmentExample", "Item Clicked");
            MovieInfo movie = new MovieInfo();
            fragmentManager = getFragmentManager();
            //Replace intent with Bundle and put it in the transaction
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.main_frameLayout, movie);
            fragmentTransaction.commit();
            Log.i("NavDrawer", "Profile " + item.getItemId());
            return true;
        }
        if(item.getItemId() == R.id.nav_id_settings){
            Toast.makeText(getApplicationContext(), "Settings",Toast.LENGTH_SHORT).show();
            mDrawerLayout.closeDrawer(GravityCompat.START);
            Log.i("FragmentExample", "Item Clicked");
            MovieInfo movie = new MovieInfo();
            fragmentManager = getFragmentManager();
            //Replace intent with Bundle and put it in the transaction
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.main_frameLayout, movie);
            fragmentTransaction.commit();
            Log.i("NavDrawer", "Settings " + item.getItemId());
            return true;
        }

        return false;
    }
}
