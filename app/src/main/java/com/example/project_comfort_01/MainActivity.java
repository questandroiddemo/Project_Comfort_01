package com.example.project_comfort_01;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    VPAdapter vpAdapter;
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    public String[] titles= new String[]{"Front","Seat"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
         viewPager2=findViewById(R.id.viewpager);
         tabLayout=findViewById(R.id.tabLayout);
         vpAdapter= new VPAdapter(this);
         viewPager2.setAdapter(vpAdapter);
         new TabLayoutMediator(tabLayout,viewPager2,((tab, position) -> tab.setText(titles[position]))).attach();
    }
}