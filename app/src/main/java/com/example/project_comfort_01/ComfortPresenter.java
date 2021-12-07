package com.example.project_comfort_01;

import android.os.RemoteException;
import android.util.Log;

import ServicePackage.ComfortInterface;


public class ComfortPresenter implements ComfortContractor.Presenter {
    ComfortContractor.View view;
    // ComfortContractor.IComfort iComfort;
    ComfortInterface comfortInterface;

    public ComfortPresenter(ComfortContractor.Model model) {
        this.model = model;
    }

    ComfortContractor.Model model;
    ComfortPresenter presenter;
    MainFragment mainFragment;


    public ComfortPresenter(ComfortContractor.View view) {

        this.view = view;
        model=new ComfortModel(presenter);
    }




    @Override
    public void TempUP(int value) {
        int upvalue = value;
        view.TempUpValue();
        // iComfort.TempUpData(upvalue);


    }

    @Override
    public void TempDown(int value) {
        view.TempDownValue();
    }

    @Override
    public void PowerClick(boolean value) {
        if (value == true) {
            view.PowerOn();
        } else {
            view.PowerOff();
        }
    }

    @Override
    public void MaxACclick(boolean value) {
        if (value == true) {
            view.maxAccolor();
            view.MaxChange();
        } else {
            view.maxAccolor();
        }
    }

    @Override
    public void AutoClick(boolean value) {
        if (value == true) {
            view.AutoUpdate();

        } else {
            view.AutoOff();
        }
    }

    @Override
    public void speed1click(int value) {
        int speed = value;
        //(speed == 1 || speed == 2 || speed == 3 || speed == 4 | speed == 5 || speed == 6 || speed == 7) {
        view.SpeedSet(speed);
//            if((speed == 7 )&& (maxacs
//            tatus=true)){
//                view.maxacoff();
//            }


    }


    @Override
    public void acclick(boolean value) throws RemoteException {

        Log.i("PRSENTER"," "+value);
        model.acvalue(value);
       // mainFragment.acvalue(value);

//       try {
//           boolean bc=comfortInterface.AcPressed(value);
//            view.connect(bc);
//       } catch (RemoteException e) {
//           e.printStackTrace();
//       }
       // boolean c=value;

//        if (value == true) {
//
//            view.acof();
//        } else {
//            view.acon();
//        }
    }

    @Override
    public void defrostclick(boolean value) {
        if (value == true) {
            view.defroston();
        } else {
            view.defrostof();
        }
    }

    @Override
    public void rearclick(boolean value) {
        if (value == true) {
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

