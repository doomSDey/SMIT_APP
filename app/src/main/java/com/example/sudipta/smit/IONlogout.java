package com.example.sudipta.smit;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.valueOf;


/**
 * A simple {@link Fragment} subclass.
 */
public class IONlogout extends Fragment implements View.OnClickListener {

    Button button;
    public IONlogout() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_ionlogout, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        TextView t1,t2,t3,t4;
        t1=(TextView)getView().findViewById(R.id.textView7);
        t2=(TextView)getView().findViewById(R.id.textView8);
        t3=(TextView)getView().findViewById(R.id.textView9);
        t4=(TextView)getView().findViewById(R.id.textView10);
        t1.setText("Welcome "+SharedRefION.getInstance(getActivity()).getUsername());
        t2.setText("    Downloaded="+SharedRefION.getInstance(getActivity()).Downloaded()+"GB");
        t3.setText("    Uploaded="+SharedRefION.getInstance(getActivity()).Uploaded()+"GB");
        int x;
        try{
        x=Integer.parseInt(SharedRefION.getInstance(getActivity()).Uploaded());
        int y=Integer.parseInt(SharedRefION.getInstance(getActivity()).Downloaded());
        x=x+y;
        x=30-x;}
        catch (Exception e){

            x=0;
        }
        t4.setText("    Remaining="+valueOf(x)+"GB");
        button=(Button)getView().findViewById(R.id.logb1);
        button.setOnClickListener(this);
        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    public void onClick(View v) {
        if(v==button )
        {
            SharedRefION.getInstance(getActivity()).logout();
            IonLogin ionLogin = new IonLogin();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, ionLogin);
            fragmentTransaction.commit();}

    }
    }
