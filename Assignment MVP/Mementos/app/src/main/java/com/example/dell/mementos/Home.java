package com.example.dell.mementos;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity
{
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ActionBarDrawerToggle mtoggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        viewPager = findViewById(R.id.pager);
        setupViewPager(viewPager);

        tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        DrawerLayout mdrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        mtoggle = new ActionBarDrawerToggle(this, mdrawerLayout,R.string.open,R.string.close);
        mdrawerLayout.addDrawerListener(mtoggle);
        mtoggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mtoggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupViewPager(ViewPager viewPager)
    {

        List<Fragment> mFragmentList = new ArrayList<>();
        List<String> mFragmentTitleList = new ArrayList<>();

        mFragmentList.add(new HomeFeed());
        mFragmentList.add(new Profile());
        mFragmentList.add(new Notification());

        mFragmentTitleList.add("Home");
        mFragmentTitleList.add("Profile");
        mFragmentTitleList.add("Notifications");

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), mFragmentList, mFragmentTitleList);
        adapter.notifyDataSetChanged();
        viewPager.setAdapter(adapter);
    }

    public void moveToSearch(View view)
    {
        Intent i = new Intent(Home.this, Search.class);
        startActivity(i);
    }
}
