// ComfortInterface.aidl
package ServicePackage;
//package com.example.project_comfort_01;


// Declare any non-default types here with import statements

interface ComfortInterface {
        boolean AcPressed(boolean acvalue);
        boolean MaxPressed(boolean maxvalue);
        java.util.List<String> getmaxList();
        java.util.List<String>getdefrost();
        java.util.List<String>getautoList();

      //  List<MaxAC> maxList();
        boolean PowerPressed(boolean powervalue);
        boolean AutoValue(boolean autovalue);
         boolean DefrostValue(boolean value);
         boolean RearValue(boolean value);
        int TempValue(int value);
        int SpeedValue(int value);
   //     boolean AutoValue(boolean autovalue);
//        List<Integer> getList();



}