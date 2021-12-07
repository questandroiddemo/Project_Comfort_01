package com.example.project_comfort_01;

import android.os.RemoteException;

public class ComfortContractor {
    interface View{
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







    }
    interface Presenter{
        //For temperature progress bar up and down button onClick method
    void TempUP(int value);

    void TempDown(int value);
    void PowerClick(boolean value);
    void MaxACclick(boolean value);
    void AutoClick(boolean value);
    void speed1click(int value);
    void acclick(boolean value) throws RemoteException;

    void defrostclick(boolean value);
    void rearclick(boolean value);
    void  checkcnnctn(boolean value);



    }
    interface Model{
     void acvalue(boolean value) throws RemoteException;

    }

}
