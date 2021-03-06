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
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import ServicePackage.ComfortInterface;

public class MainFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    static ComfortInterface comfortInterface;
    Boolean connected = false;


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
//  Ac button state send and recieve from service app
    public Boolean acvalue(boolean value) {
        boolean abc = value;
        boolean BC = false;
        try {
            BC = MainFragment.getAidl().AcPressed(abc);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return BC;
    }
//  Maxvalue button state send and recieve from service app
    public Boolean maxvalue(boolean value) {
        boolean MAX = false;
        try {
            MAX = MainFragment.getAidl().AcPressed(value);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return MAX;
    }
//  Receive temperature and fan speed value from service while MAX AC on

    public List<String> getMaxList() {
        List<String> maxliststring = new ArrayList<>();
        try {
            maxliststring = MainFragment.getAidl().getmaxList();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return maxliststring;
    }

//  Power value button state send and recieve from service app
    public Boolean powervalue(boolean pvalue) {
        boolean POWER = false;
        try {
            POWER = MainFragment.getAidl().PowerPressed(pvalue);
            Log.i("POWER MAIN", " " + POWER);

        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return POWER;

    }
//  Temperature value  send and recieve from service app

    public void tempValue(int value) {
        try {
            MainFragment.getAidl().TempValue(value);

        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
//  fan speed value  send and recieve from service app

    public void SpeedValue(int value) {
        try {
            MainFragment.getAidl().SpeedValue(value);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
//  Auto  Button state  send and recieve from service app

    public boolean AutoValue(boolean value) {
        boolean auto = false;
        try {
            auto = MainFragment.getAidl().AutoValue(value);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return auto;
    }
//  Receive temperature and fan speed value from service while Auto on

    public List<String> getAutoList() {
        List<String> autoliststring = new ArrayList<>();
        try {
            autoliststring = MainFragment.getAidl().getautoList();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return autoliststring;
    }
//  Defrost  Button state  send and recieve from service app

    public boolean Defrost(boolean value) {
        boolean defrost = false;
        try {
            defrost = MainFragment.getAidl().DefrostValue(value);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return defrost;
    }
//  Receive temperature and fan speed value from service while Defrost button on
    public List<String> getDefrostList() {
        List<String> defrostliststring = new ArrayList<>();
        try {
            defrostliststring = MainFragment.getAidl().getdefrost();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return defrostliststring;
    }
//  RearFrost  Button state  send and recieve from service app
    public boolean RearFrost(boolean value) {
        boolean rearfrost = false;
        try {
            rearfrost = MainFragment.getAidl().RearValue(value);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return rearfrost;
    }
//Return Object Aidl

    public static ComfortInterface getAidl() {
        return comfortInterface;
    }


}




