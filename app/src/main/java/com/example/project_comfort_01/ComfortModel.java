package com.example.project_comfort_01;

import android.os.RemoteException;

import java.util.List;

public class ComfortModel implements ComfortContractor.Model {
    MainFragment mainFragment;
    ComfortContractor.View view;
    ComfortContractor.Presenter presenter;
    public ComfortModel(ComfortContractor.Presenter presenter) {
        this.presenter = presenter;
        mainFragment = new MainFragment();
    }

    @Override
    public Boolean acvalue(boolean ac) throws RemoteException {
        boolean Acvalue = mainFragment.acvalue(ac);
        return Acvalue;
    }

    @Override
    public Boolean maxAcValue(boolean value) throws RemoteException {

        boolean Maxvalue = mainFragment.maxvalue(value);


        return Maxvalue;
    }


    @Override
    public Boolean powerValue(boolean value) throws RemoteException {
        boolean powervalue = mainFragment.powervalue(value);
        return powervalue;
    }

    @Override
    public void TempValue(int value) throws RemoteException {
        mainFragment.tempValue(value);

    }

    @Override
    public void SpeedValue(int value) throws RemoteException {
        mainFragment.SpeedValue(value);
    }

    @Override
    public Boolean AutoValue(boolean value) throws RemoteException {
        boolean auto = mainFragment.AutoValue(value);
        return auto;
    }

    @Override
    public Boolean DefrostValue(boolean value) throws RemoteException {
        boolean defrost = mainFragment.Defrost(value);
        return defrost;
    }

    @Override
    public Boolean RearfrostValue(boolean value) throws RemoteException {
        boolean rearfrost = mainFragment.RearFrost(value);
        return rearfrost;
    }

    @Override
    public List<String> getMaxList() throws RemoteException {

        return mainFragment.getMaxList();

    }

    @Override
    public List<String> getDefrostList() throws RemoteException {
        return mainFragment.getDefrostList();
    }

    @Override
    public List<String> getAutoList() throws RemoteException {
        return mainFragment.getAutoList();
    }


}
