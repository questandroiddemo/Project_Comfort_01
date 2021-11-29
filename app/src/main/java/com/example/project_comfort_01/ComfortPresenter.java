package com.example.project_comfort_01;

import android.app.Activity;


public class ComfortPresenter implements ComfortContractor.Presenter{
    ComfortContractor.View view;

    public ComfortPresenter(ComfortContractor.View view) {
        this.view = view;
    }


    @Override
    public void TempUP(int value) {

        view.TempUpValue();
    }

    @Override
    public void TempDown(int value) {
        view.TempDownValue();
    }

    @Override
    public void PowerClick(boolean value) {
     if(value==true){
         view.PowerOn();
     }
     else {
         view.PowerOff();
     }
    }

    @Override
    public void MaxACclick(boolean value) {
        if(value==true){
            view.maxAccolor();
            view.MaxChange();
        }
     else{
           view.maxAccolor();
        }
    }

    @Override
    public void AutoClick(boolean value) {
      if(value==true){
          view.AutoUpdate();

  }
      else {
        view.AutoOff();
      }
    }

    @Override
    public void speed1click(int value) {
        int speed = value;
         //(speed == 1 || speed == 2 || speed == 3 || speed == 4 | speed == 5 || speed == 6 || speed == 7) {
            view.SpeedSet(speed);
//            if((speed == 7 )&& (maxacstatus=true)){
//                view.maxacoff();
//            }


    }

    @Override
    public void acclick(boolean value) {
       if(value==true){

           view.acof();
       }
       else {
           view.acon();
       }
    }

    @Override
    public void defrostclick(boolean value) {
    if(value==true){
        view.defroston();
    }
    else {
        view.defrostof();
    }
    }

    @Override
    public void rearclick(boolean value) {
    if(value==true){
        view.rearon();
    }
    else {
        view.rearoff();
    }
    }

}

