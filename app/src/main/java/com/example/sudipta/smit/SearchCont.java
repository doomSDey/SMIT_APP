package com.example.sudipta.smit;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class SearchCont extends Fragment {


    public SearchCont() {
        // Required empty public constructor
    }
    Button button;
    EditText editText;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_cont, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        button=(Button)getView().findViewById(R.id.button3);
        editText=(EditText)getView().findViewById(R.id.editText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args=new Bundle();
                String a=editText.getText().toString();
                Log.e(a,"nanan123");
                args.putString("YourKey", a);
                Contact_Search contact_search= new Contact_Search();
                contact_search.setArguments(args);
                android.support.v4.app.FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, contact_search);
                fragmentTransaction.addToBackStack("contact_search");
                fragmentTransaction.commit();
            }
        });

        super.onViewCreated(view, savedInstanceState);
    }

}
