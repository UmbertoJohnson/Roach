package com.roach.massimo.roach;

import android.app.FragmentManager;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity

        implements NavigationView.OnNavigationItemSelectedListener {

    NavigationView navigationView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);

        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.content_frame,
                        new HomeFragment())
                .commit();
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fragmentManager = getFragmentManager();


        if (id == R.id.nav_first_layout) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame,
                            new HomeFragment())
                    .commit();
        } else if (id == R.id.nav_second_layout) {
            getSupportActionBar().setTitle(R.string.divider_massimo);
            getSupportActionBar().setSubtitle(item.getTitle());
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame,
                            new MassimoIdentFragment())
                    .commit();
        } else if (id == R.id.nav_third_layout) {
            getSupportActionBar().setTitle(R.string.divider_massimo);
            getSupportActionBar().setSubtitle(item.getTitle());
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame,
                            new MassimoStatFragment())
                    .commit();
        } else if (id == R.id.nav_fourth_layout) {
            getSupportActionBar().setTitle(R.string.divider_massimo);
            getSupportActionBar().setSubtitle(item.getTitle());
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame,
                            new MassimoPersonFragment())
                    .commit();
        } else if (id == R.id.nav_ninth_layout) {
            getSupportActionBar().setTitle(R.string.divider_massimo);
            getSupportActionBar().setSubtitle(item.getTitle());
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame,
                            new MassimoTrailerFragment())
                    .commit();
        } else if (id == R.id.nav_fifth_layout) {
            getSupportActionBar().setTitle(R.string.divider_bradley);
            getSupportActionBar().setSubtitle(item.getTitle());
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame,
                            new BradleyIdentFragment())
                    .commit();
        } else if (id == R.id.nav_sixth_layout) {
            getSupportActionBar().setTitle(R.string.divider_bradley);
            getSupportActionBar().setSubtitle(item.getTitle());
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame,
                            new BradleyStatFragment())
                    .commit();
        } else if (id == R.id.nav_seventh_layout) {
            getSupportActionBar().setTitle(R.string.divider_bradley);
            getSupportActionBar().setSubtitle(item.getTitle());
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame,
                            new BradleyPersonFragment())
                    .commit();

        } else if (id == R.id.nav_eighth_layout) {
            getSupportActionBar().setTitle(R.string.divider_bradley);
            getSupportActionBar().setSubtitle(item.getTitle());
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame,
                            new BradleyTrailerFragment())
                    .commit();
        } else if (id == R.id.nav_ninth_layout) {
                getSupportActionBar().setTitle(R.string.divider_eliana);
                getSupportActionBar().setSubtitle(item.getTitle());
                fragmentManager.beginTransaction()
                        .replace(R.id.content_frame,
                                new ElianaPersonFragment())
                        .commit();
            }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
