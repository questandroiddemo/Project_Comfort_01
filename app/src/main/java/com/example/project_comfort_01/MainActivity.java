package com.example.project_comfort_01;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import ServicePackage.ComfortInterface;

public class MainActivity extends AppCompatActivity {
    public ComfortInterface comfortInterface;

   // public String[] titles= new String[]{"Front","Seat"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportFragmentManager().findFragmentById(android.R.id.content)==null) {
            getSupportFragmentManager().beginTransaction()
                    .add(android.R.id.content, new MainFragment())
                    .setReorderingAllowed(true)
                    .commit();
        }
//        getSupportActionBar().hide();
//         viewPager2=findViewById(R.id.viewpager);
//         tabLayout=findViewById(R.id.tabLayout);
//         vpAdapter= new VPAdapter(this);
//         viewPager2.setAdapter(vpAdapter);
//         new TabLayoutMediator(tabLayout,viewPager2,((tab, position) -> tab.setText(titles[position]))).attach();
    }
}