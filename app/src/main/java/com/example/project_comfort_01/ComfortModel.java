package com.example.project_comfort_01;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.widget.Toast;

import ServicePackage.ComfortInterface;
import android.app.FragmentManager;

public class ComfortModel implements ComfortContractor.Model{
    MainFragment mainFragment;





    public ComfortModel(ComfortContractor.Presenter presenter) {
        this.presenter = presenter;
         mainFragment =new MainFragment();
    }

    ComfortContractor.Presenter presenter;









    @Override
    public void acvalue(boolean ac) throws RemoteException {
        Log.i("MODEL"," "+ac);

mainFragment.acvalue(ac);

    }



}
