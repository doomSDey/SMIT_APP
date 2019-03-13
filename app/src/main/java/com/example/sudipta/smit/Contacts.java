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
public class Contacts extends Fragment {


    public Contacts() {
        // Required empty public constructor
    }
    Button button;
    Button  button2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contacts, container, false);
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    button=(Button)getView().findViewById(R.id.dept);
        button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

           ContactDept contactDept=new ContactDept();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,contactDept);
            fragmentTransaction.addToBackStack("contactDept");
            fragmentTransaction.commit();
        }
    });
      button2=(Button)getView().findViewById(R.id.search);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SearchCont searchCont=new SearchCont();
                android.support.v4.app.FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container,searchCont);
                fragmentTransaction.addToBackStack("searchCont");
                fragmentTransaction.commit();
            }
        });
        super.onViewCreated(view, savedInstanceState);
    }
}
