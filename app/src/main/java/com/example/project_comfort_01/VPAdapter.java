package com.example.project_comfort_01;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class VPAdapter extends FragmentStateAdapter{
      public String[] titles= new String[]{"Front","Seat"};
      public VPAdapter(@NonNull FragmentActivity fragmentActivity){
          super(fragmentActivity);
      }
      @NonNull
      @Override
      public Fragment createFragment(int position) {
        switch (position)
        {
            case 0:
                return new fragment1();
            case 1:
                return new com.example.project_comfort_01.fragment2();
        }
        return new fragment1();
      }

      @Override
      public int getItemCount() {
          return titles.length;
      }
  }