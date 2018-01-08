package com.example.endrit.finalproject.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.example.endrit.finalproject.R;
import com.example.endrit.finalproject.adapters.MainPagerAdapter;
import com.squareup.picasso.Picasso;

/**
 * Created by endrit on 1/7/2018.
 */

public class MainPagerActivity extends Activity {
    ViewPager mainPager;
    MainPagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_pager);

        adapter = new MainPagerAdapter(this);
        mainPager = findViewById(R.id.main_pager);
        mainPager.setAdapter(adapter);
    }
}
