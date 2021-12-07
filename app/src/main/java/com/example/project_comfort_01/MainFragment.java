package com.example.project_comfort_01;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import ServicePackage.ComfortInterface;

public class MainFragment extends Fragment  {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    ComfortContractor.Presenter presenter;
    static ComfortInterface comfortInterface;
    Boolean connected = false;
    ComfortContractor.Model model;

    View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        v = inflater.inflate(R.layout.fragemt_main, container, false);

        tabLayout = (TabLayout) v.findViewById(R.id.tabLayout);
        viewPager = (ViewPager) v.findViewById(R.id.viewpager);

        tabLayout.setupWithViewPager(viewPager);
        VPAdapter vpAdapter = new VPAdapter(getActivity().getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpAdapter.addFragment(new fragment1(), "Front");
        vpAdapter.addFragment(new fragment2(), "Seat");
        viewPager.setAdapter(vpAdapter);


        Intent intent = new Intent("com.example.comfortservice.AIDL");

        intent.setClassName("com.example.comfortservice",
                "com.example.comfortservice.MyService");
        if (getActivity().getBaseContext().getApplicationContext().bindService(intent, serviceConnectionObject, Context.BIND_AUTO_CREATE)) {
            connected = true;
            Toast.makeText(getContext(), "Success" + connected, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getContext(), "BindServiceFailed" + connected, Toast.LENGTH_SHORT).show();

        }
        return v;
    }


    ServiceConnection serviceConnectionObject = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

            comfortInterface = ComfortInterface.Stub.asInterface(iBinder);


        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

  public void acvalue(boolean value) {
      boolean abc=value;
      Log.i("MAINFRAGMENT"," "+abc);

      try {

      boolean BC = MainFragment.getAidl().AcPressed(abc);
          Log.i("Service"," "+BC);
      } catch (RemoteException e) {
          e.printStackTrace();
      }


////return comfortInterface.AcPressed(value);
  }
  public static ComfortInterface getAidl(){
      return comfortInterface;
  }




}




