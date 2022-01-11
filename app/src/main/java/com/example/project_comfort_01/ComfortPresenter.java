package com.example.project_comfort_01;

import android.os.RemoteException;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class ComfortPresenter implements ComfortContractor.Presenter {
    ComfortContractor.View view;
    ComfortContractor.Model model;
    ComfortPresenter presenter;


    public ComfortPresenter(ComfortContractor.View view) {
        this.view = view;
        model = new ComfortModel(presenter);
    }


    @Override
    public void TempUP(int value) throws RemoteException {
        int upvalue = value;
        model.TempValue(upvalue);
    }

    @Override
    public void TempDown(int value) throws RemoteException {
        int downvalue = value;
        model.TempValue(downvalue);
        view.TempDownValue();
    }

    @Override
    public boolean PowerClick(boolean value) throws RemoteException {
        boolean powercheck = model.powerValue(value);
        if (powercheck == true) {
            view.PowerOn();
        } else {
            view.PowerOff();
        }
        return powercheck;
    }

    @Override
    public void MaxACclick(Boolean value) throws RemoteException {


        boolean maxac = model.maxAcValue(value);

        if (maxac == true) {
            view.maxAccolor();
            view.MaxChange();
        } else {
            List<String> maxlist = new ArrayList<String>();
            maxlist = model.getMaxList();
            int temp = Integer.parseInt(maxlist.get(0));
            int fan = Integer.parseInt(maxlist.get(1));
            Log.i("temp", " " + temp);
            Log.i("fan", " " + fan);
            view.maxOff(temp, fan);
            view.SpeedSet(fan);
            view.maxAccolor();
        }
    }

    @Override
    public void AutoClick(boolean value) throws RemoteException {
        boolean auto = model.AutoValue(value);
        if (auto == true) {
            view.AutoUpdate();
            view.SpeedSet(4);

        } else {
            List<String> autolist = new ArrayList<String>();
            autolist = model.getAutoList();
            int temp = Integer.parseInt(autolist.get(0));
            int fan = Integer.parseInt(autolist.get(1));
            Log.i("temp", " " + temp);
            Log.i("fan", " " + fan);
            view.maxOff(temp, fan);
            view.SpeedSet(fan);
        }
    }

    @Override
    public void speed1click(int value) throws RemoteException {
        int speed = value;
        view.SpeedSet(speed);
        model.SpeedValue(speed);

    }


    @Override
    public void acclick(boolean value) throws RemoteException {
        boolean pacvalue = model.acvalue(value);
        if (pacvalue == true) {
            view.acon();
        } else {
            view.acof();
        }

    }

    @Override
    public void tempprogress(int value) throws RemoteException {
        int progress = value;
        model.TempValue(progress);
    }

    @Override
    public void defrostclick(boolean value) throws RemoteException {
        boolean defrost = model.DefrostValue(value);

        if (defrost == true) {
            view.defroston();
        } else {
            List<String> defrostlist = new ArrayList<String>();
            defrostlist = model.getDefrostList();
            int temp = Integer.parseInt(defrostlist.get(0));
            int fan = Integer.parseInt(defrostlist.get(1));
            view.maxOff(temp, fan);
            view.SpeedSet(fan);

        }
    }

    @Override
    public void rearclick(boolean value) throws RemoteException {
        boolean rear = model.RearfrostValue(value);
        if (rear == true) {
            view.rearon();
        } else {
            view.rearoff();
        }
    }

    @Override
    public void checkcnnctn(boolean value) {
        if (value == true) {
            view.acon();
        } else {
            view.acof();
        }


    }

}

