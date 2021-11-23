package com.example.project_comfort_01;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.fragment.app.Fragment;

public class fragment1 extends Fragment implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    Button b1, b2 ,b3, b4, b5 ,b6, b7;
    SeekBar seekBar;
    TextView textView;
    ImageButton btup, btdown;
    ToggleButton tpower,tmax,tac,tgfd,tgrd,tgcirc,tgauto;
    TextView txtpower;
    RadioGroup radioGroup;
    RadioButton af1,af2,af3,af4;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

       View v= inflater.inflate(R.layout.fragment_front, container, false);

        b1= v.findViewById(R.id.btn1);
        b2= v.findViewById(R.id.btn2);
        b3= v.findViewById(R.id.btn3);
        b4= v.findViewById(R.id.btn4);
        b5= v.findViewById(R.id.btn5);
        b6= v.findViewById(R.id.btn6);
        b7= v.findViewById(R.id.btn7);

        btup=v.findViewById(R.id.button5);
        btdown=v.findViewById(R.id.button);

        seekBar=v.findViewById(R.id.seekbar);
        textView=v.findViewById(R.id.textView);

        tpower=v.findViewById(R.id.power);

        tmax=v.findViewById(R.id.maxac);
        tac=v.findViewById(R.id.ac);
        txtpower=v.findViewById(R.id.txtpower);


        radioGroup=v.findViewById(R.id.rgroup);
        af1=v.findViewById(R.id.af1);
        af2=v.findViewById(R.id.af2);
        af3=v.findViewById(R.id.af3);
        af4=v.findViewById(R.id.af4);

        tgfd=v.findViewById(R.id.tgfd);
        tgrd=v.findViewById(R.id.tgrd);
        tgcirc=v.findViewById(R.id.tgcirc);
        tgauto=v.findViewById(R.id.tgauto);


        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        seekBar.setOnSeekBarChangeListener(this);
        btup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int c = seekBar.getProgress();
                seekBar.setProgress(c + 1);
                textView.setVisibility(View.VISIBLE);

            }
        });
        btdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int c = seekBar.getProgress();
                seekBar.setProgress(c - 1);
                textView.setVisibility(View.VISIBLE);

            }
        });

        tpower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean Tstatus=  tpower.isChecked();
                //  getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                if(Tstatus==true){
                    seekBar.setEnabled(false);
                    btup.setEnabled(false);
                    btdown.setEnabled(false);
                    tmax.setEnabled(false);
                    tac.setEnabled(false);
                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);
                    b5.setEnabled(false);
                    b6.setEnabled(false);
                    b7.setEnabled(false);
                    af1.setEnabled(false);
                    af2.setEnabled(false);
                    af3.setEnabled(false);
                    af4.setEnabled(false);
                    tgfd.setEnabled(false);
                    tgrd.setEnabled(false);
                    tgcirc.setEnabled(false);


                    txtpower.setText("Climate is Off");
                    txtpower.setVisibility(View.VISIBLE);
                    textView.setVisibility(View.INVISIBLE);



                }
                else{
                    seekBar.setEnabled(true);
                    btup.setEnabled(true);
                    btdown.setEnabled(true);
                    tmax.setEnabled(true);
                    tac.setEnabled(true);
                    b1.setEnabled(true);
                    b2.setEnabled(true);
                    b3.setEnabled(true);
                    b4.setEnabled(true);
                    b5.setEnabled(true);
                    b6.setEnabled(true);
                    b7.setEnabled(true);
                    af1.setEnabled(true);
                    af2.setEnabled(true);
                    af3.setEnabled(true);
                    af4.setEnabled(true);
                    tgfd.setEnabled(true);
                    tgrd.setEnabled(true);
                    tgcirc.setEnabled(true);
                    txtpower.setVisibility(View.INVISIBLE);
                }

            }

        });



        tmax.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View v) {
                boolean maxacStatus = tmax.isChecked();

                if (maxacStatus == true) {

                    int c = seekBar.getProgress();
                    seekBar.setProgress(10);
                    txtpower.setText("" + c);


                    switch (v.getId()) {
                        case R.id.maxac:
                            maxAccolor();
                            tmax.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                            tac.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                            tac.setSelected(true);
                            selectfanMax();
                            break;
                    }

                }
                else
                   maxAccolor();

            }



        });
        tgfd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean tgfdstatus=tgfd.isChecked();
                if(tgfdstatus==true) {
                    af4.setChecked(true);
                    selectfanMax();
                    int c = seekBar.getProgress();
                    seekBar.setProgress(40);
                    textView.setText("" + c);

                }else{
                    radioGroup.clearCheck();
                    defrostcolor();


                }

            }
        });

        tgrd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean rearStatus = tgrd.isChecked();

                if (rearStatus == true) {


                    tac.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                    tac.setSelected(true);

                }else{
                    tac.setBackgroundColor(getResources().getColor(R.color.purple_500));
                    tac.setSelected(false);

                }

            }
       });
        tgauto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean autoStatus = tgauto.isChecked();
                if (autoStatus == true) {

                    int c = seekBar.getProgress();
                    seekBar.setProgress(20);
                    txtpower.setText("" + c);
                    b1.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                    b2.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                    b3.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                    b4.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                    radioGroup.clearCheck();


                }
                else{
                    b1.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));
                    b2.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));
                    b3.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));
                    b4.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));
                    b5.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));
                    b6.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));
                    b7.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));

                }


            }


        });






                return v;
    }
    public void defrostcolor(){
        b1.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));
        b2.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));
        b3.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));
        b4.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));
        b5.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));
        b6.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));
        b7.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));

    }
    public void maxAccolor(){
               tmax.setBackgroundColor(getResources().getColor(R.color.purple_500));
               tac.setBackgroundColor(getResources().getColor(R.color.purple_500));
                defrostcolor();

    }
    public void selectfanMax() {
        b1.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
        b2.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
        b3.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
        b4.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
        b5.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
        b6.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
        b7.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
    }

    public void defaultColour()
    {
        b1.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));
        b2.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));
        b3.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));
        b4.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));
        b5.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));
        b6.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));
        b7.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));
    }
    @Override
    public void onClick(View v1) {
        defaultColour();
        switch (v1.getId()){

            // cases applied over different buttons
            case R.id.btn1:
                // Toast message appears when button pressed

                b1.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                break;

            case R.id.btn2:

                b1.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                b2.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                break;

            case R.id.btn3:
                b1.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                b2.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                b3.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                break;
            case R.id.btn4:
                // Toast message appears when button pressed
                b1.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                b2.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                b3.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                b4.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                break;

            case R.id.btn5:

                b1.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                b2.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                b3.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                b4.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                b5.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                break;

            case R.id.btn6:

                b1.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                b2.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                b3.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                b4.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                b5.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                b6.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));

                break;

            case R.id.btn7:

                b1.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                b2.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                b3.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                b4.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                b5.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                b6.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                b7.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                break;

        }
    }



    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
    int i=10;

        i=progress;
        textView.setText(""+i);
        textView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

}