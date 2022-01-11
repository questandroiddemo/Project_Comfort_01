package com.example.project_comfort_01;

import android.os.RemoteException;

import java.util.List;

public class ComfortContractor {
    interface View {
        //For temperature progress bar up and down button view methods
        void TempUpValue();

        //void connect(boolean av);
        void TempDownValue();

        //For Power On Off view methods
        void PowerOff();

        void PowerOn();

        //For MAx Ac view methods
        void maxAccolor();

        void MaxChange();

        //For  Auto Button View Methods
        void AutoUpdate();

        void AutoOff();

        //For Fan Button
        void SpeedSet(int value);

        // void ac
        void acon();

        void acof();

        //frontdefrost
        void defroston();

        void defrostof();

        //rear defrost
        void rearon();

        void rearoff();
        //Fan speed set


        void maxOff(int temp, int fan);
    }

    interface Presenter {
        //For temperature progress bar up and down button onClick method
        void TempUP(int value) throws RemoteException;

        void TempDown(int value) throws RemoteException;

        boolean PowerClick(boolean value) throws RemoteException;

        void MaxACclick(Boolean value) throws RemoteException;

        void AutoClick(boolean value) throws RemoteException;

        void speed1click(int value) throws RemoteException;

        void acclick(boolean value) throws RemoteException;

        void tempprogress(int value) throws RemoteException;

        void defrostclick(boolean value) throws RemoteException;

        void rearclick(boolean value) throws RemoteException;

        void checkcnnctn(boolean value);


    }

    interface Model {
        Boolean acvalue(boolean value) throws RemoteException;

        Boolean maxAcValue(boolean value) throws RemoteException;

        Boolean powerValue(boolean value) throws RemoteException;

        void TempValue(int value) throws RemoteException;

        void SpeedValue(int value) throws RemoteException;

        Boolean AutoValue(boolean value) throws RemoteException;

        Boolean DefrostValue(boolean value) throws RemoteException;

        Boolean RearfrostValue(boolean value) throws RemoteException;

        List<String> getMaxList() throws RemoteException;

        List<String> getDefrostList() throws RemoteException;

        List<String> getAutoList() throws RemoteException;
    }

}
