package com.example.sudipta.smit;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class messfrag extends Fragment {

    Button button;

    public messfrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_messfrag, container, false);


        }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        button=(Button)getView().findViewById(R.id.menubut);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Menu menu = new Menu();
                android.support.v4.app.FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, menu);
                fragmentTransaction.addToBackStack("menu");
                fragmentTransaction.commit();
            }
        });
        Button button1=(Button)getView().findViewById(R.id.CompMess);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ComplaintM complaintM= new ComplaintM();
                android.support.v4.app.FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, complaintM);
                fragmentTransaction.addToBackStack("complainM");
                fragmentTransaction.commit();
            }
        });

        super.onViewCreated(view, savedInstanceState);
    }
}
