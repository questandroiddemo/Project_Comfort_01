package com.example.project_comfort_01;

import static android.content.Context.BIND_AUTO_CREATE;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
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

import java.util.List;


public class fragment1 extends Fragment implements ComfortContractor.View {

    Button b1, b2, b3, b4, b5, b6, b7;
    SeekBar seekBar;
    TextView textView;
    ImageButton btup, btdown;
    ToggleButton tpower, tmax, tac, tgfd, tgrd, tgcirc, tgauto;
    TextView txtpower;
    RadioGroup radioGroup;
    RadioButton af1, af2, af3, af4;
    ComfortContractor.Presenter presenter;


    View v;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_front, container, false);


        presenter = new ComfortPresenter(this);

        b1 = view.findViewById(R.id.btn1);
        b2 = view.findViewById(R.id.btn2);
        b3 = view.findViewById(R.id.btn3);
        b4 = view.findViewById(R.id.btn4);
        b5 = view.findViewById(R.id.btn5);
        b6 = view.findViewById(R.id.btn6);
        b7 = view.findViewById(R.id.btn7);

        btup = view.findViewById(R.id.button5);
        btdown = view.findViewById(R.id.button);

        seekBar = view.findViewById(R.id.seekbar);
        textView = view.findViewById(R.id.textView);

        tpower = view.findViewById(R.id.power);

        tmax = view.findViewById(R.id.maxac);
        tac = view.findViewById(R.id.ac);
        txtpower = view.findViewById(R.id.txtpower);


        radioGroup = view.findViewById(R.id.rgroup);
        af1 = view.findViewById(R.id.af1);
        af2 = view.findViewById(R.id.af2);
        af3 = view.findViewById(R.id.af3);
        af4 = view.findViewById(R.id.af4);

        tgfd = view.findViewById(R.id.tgfd);
        tgrd = view.findViewById(R.id.tgrd);
        tgcirc = view.findViewById(R.id.tgcirc);
        tgauto = view.findViewById(R.id.tgauto);
        Toast.makeText(getActivity(), "value" + tac.isChecked(), Toast.LENGTH_LONG).show();

        //Press Temperature Up button
        btup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int c = seekBar.getProgress();
                seekBar.setProgress(c + 1);
                int d = seekBar.getProgress();
                try {
                    presenter.TempUP(d);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }


            }
        });
        //Press Temperature Down Button
        btdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int c = seekBar.getProgress();
                seekBar.setProgress(c - 1);
                int d = seekBar.getProgress();
                try {
                    presenter.TempDown(d);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });

        //Press Power Button
        tpower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean Tstatus = tpower.isChecked();
                try {
                    presenter.PowerClick(Tstatus);
                    Toast.makeText(getActivity(), "Power" + Tstatus, Toast.LENGTH_LONG).show();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });


        //Press MAX AC Button

        tmax.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                boolean maxacStatus = tmax.isChecked();


                try {
                    presenter.MaxACclick(maxacStatus);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }


        });

        //Press Auto Button
        tgauto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean autoStatus = tgauto.isChecked();
                try {
                    presenter.AutoClick(autoStatus);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });

        //Press Fan speed 1 Button
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    presenter.speed1click(1);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                maxCheck(1);


            }
        });

        //Press Fan speed 2 Button
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try {
                    presenter.speed1click(2);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                maxCheck(2);

            }
        });

        //Press Fan speed 3 Button
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    presenter.speed1click(3);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                maxCheck(3);

            }
        });

        //Press Fan speed 4 Button
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try {
                    presenter.speed1click(4);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                maxCheck(4);

            }
        });
        //Press Fan speed 5 Button
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    presenter.speed1click(5);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                maxCheck(5);

            }
        });

        //Press Fan speed 6 Button
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try {
                    presenter.speed1click(6);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                maxCheck(6);

            }
        });
        //Press Fan speed 7 Button
        b7.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                try {
                    presenter.speed1click(7);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                maxCheck(7);

            }
        });

        //Press AC Button
        tac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean acstatus = tac.isChecked();
                Toast.makeText(getActivity(), "ButtonPressed" + acstatus, Toast.LENGTH_LONG).show();
                try {
                    presenter.acclick(acstatus);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });

        //Press Front Defrost Button
        tgfd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean fdefroststatus = tgfd.isChecked();
                try {
                    presenter.defrostclick(fdefroststatus);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });

        //Press Rear Defrost Button

        tgrd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean rearstatus = tgrd.isChecked();
                try {
                    presenter.rearclick(rearstatus);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
        //Seekbar progress
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                int i = 10;
                i = progress;

                textView.setText("" + i);
                textView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        return view;

    }
//Code for change user interface

    @Override
    public void TempUpValue() {

        textView.setVisibility(View.VISIBLE);
    }


    @Override
    public void TempDownValue() {

        textView.setVisibility(View.VISIBLE);
    }

    @Override
    public void PowerOff() {

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
        tgauto.setEnabled(true);
        txtpower.setVisibility(View.INVISIBLE);

    }

    @Override
    public void PowerOn() {

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
        tgauto.setEnabled(false);

        txtpower.setText("Climate is Off");
        txtpower.setVisibility(View.VISIBLE);
        textView.setVisibility(View.INVISIBLE);

    }

    @Override
    public void maxAccolor() {
        tmax.setBackgroundColor(getResources().getColor(R.color.purple_500));
        tac.setBackgroundColor(getResources().getColor(R.color.purple_500));

    }


    @Override
    public void MaxChange() {

        seekBar.setProgress(10);
        int c = seekBar.getProgress();
        txtpower.setText("" + c);


        maxAccolor();
        tmax.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
        tac.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
        tac.setSelected(true);
        selectfanMax();

    }

    @Override
    public void AutoUpdate() {
        int c = seekBar.getProgress();
        seekBar.setProgress(20);
        txtpower.setText("" + c);
        b1.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
        b2.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
        b3.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
        b4.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
        radioGroup.clearCheck();

    }

    @Override
    public void AutoOff() {
        b1.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));
        b2.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));
        b3.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));
        b4.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));
        b5.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));
        b6.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));
        b7.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));

    }

    @Override
    public void SpeedSet(int value) {
        defaultColour();
        switch (value) {

            // cases applied over different buttons
            case 1:
                // Toast message appears when button pressed

                b1.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                break;

            case 2:

                b1.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                b2.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                break;

            case 3:
                b1.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                b2.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                b3.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                break;
            case 4:
                // Toast message appears when button pressed
                b1.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                b2.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                b3.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                b4.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                break;

            case 5:

                b1.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                b2.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                b3.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                b4.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                b5.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                break;

            case 6:

                b1.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                b2.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                b3.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                b4.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                b5.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                b6.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));

                break;

            case 7:

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
    public void acon() {
        tac.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));

    }

    @Override
    public void acof() {
        tac.setBackgroundColor(getResources().getColor(R.color.purple_500));

    }

    @Override
    public void defroston() {
        af4.setChecked(true);
        selectfanMax();

        seekBar.setProgress(40);
        int c = seekBar.getProgress();
        textView.setText("" + c);
    }

    @Override
    public void defrostof() {
        radioGroup.clearCheck();
        defrostcolor();
    }

    @Override
    public void rearon() {
        tac.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
        tac.setSelected(true);
    }

    @Override
    public void rearoff() {
        tac.setBackgroundColor(getResources().getColor(R.color.purple_500));
        tac.setSelected(false);
    }


    @Override
    public void maxOff(int temp, int fan) {
        seekBar.setProgress(temp);
        SpeedSet(fan);
        Toast.makeText(getActivity(), "fan" + temp + fan, Toast.LENGTH_LONG);
    }


    public void maxCheck(int speed) {
        boolean max = tmax.isChecked();
        if ((speed != 7) && (max == true)) {
            tmax.setBackgroundColor(getResources().getColor(R.color.purple_500));

        }
    }


    public void defrostcolor() {
        b1.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));
        b2.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));
        b3.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));
        b4.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));
        b5.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));
        b6.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));
        b7.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));

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


    public void defaultColour() {
        b1.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));
        b2.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));
        b3.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));
        b4.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));
        b5.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));
        b6.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));
        b7.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));
    }



}