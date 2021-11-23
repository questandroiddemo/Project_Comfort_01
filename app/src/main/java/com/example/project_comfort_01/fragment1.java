package com.example.project_comfort_01;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.fragment.app.Fragment;

public class fragment1 extends Fragment implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    Button b1, b2 ,b3, b4, b5 ,b6, b7;
    SeekBar seekBar;
    TextView textView;




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
        seekBar=v.findViewById(R.id.seekbar);
        textView=v.findViewById(R.id.textView);


        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        seekBar.setOnSeekBarChangeListener(this);



        return v;
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