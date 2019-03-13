package com.example.sudipta.smit;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactDept extends Fragment {


    RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact_dept, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        //the recyclerview
        //getting the recyclerview from xml
        recyclerView = (RecyclerView) getView().findViewById(R.id.re3);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //initializing the productlist
        List<String> contactDeptListtList = new ArrayList<>();


        //adding some items to our list
        contactDeptListtList = Arrays.asList("PHYSICS",
                "CHEMISTRY",
                "MATHEMATICS",
                "ELECTRONICS AND COMMUNICATION  ENGINEERING",
                "ELECTRICAL AND ELECTRONICS  ENGINEERING",
                "COMPUTER SCIENCES & ENGINEERING",
                "MECHANICAL ENGINEERING",
                "INFORMATION TECHNOLOGY",
                "APPLIED ELECTRONICS & INSTRUMENTATION ENGINEERING",
                "CIVIL ENGINEERING",
                "MANAGEMENT STUDIES",
                "OFFICE SMIT ",
                "CENTRAL LIBRARY SMIT",
                "HOSTEL DEPARTMENT",
                "CLINICS SMIT ",
                "SMU--IT",
                "ADMINISTRATION SMIT");

        ContactDeptAdapter adapter = new ContactDeptAdapter(getActivity(), contactDeptListtList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
        super.onViewCreated(view, savedInstanceState);
    }
}