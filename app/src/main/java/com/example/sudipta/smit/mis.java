package com.example.sudipta.smit;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class mis extends Fragment implements View.OnClickListener {


    public mis() {
        // Required empty public constructor
    }

    Button button1;
    Button button;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mis, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        button=(Button)getView().findViewById(R.id.button7);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ComplainMIS complainMIS=new ComplainMIS();
                android.support.v4.app.FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container,complainMIS);
                fragmentTransaction.addToBackStack("complainMIS");
                fragmentTransaction.commit();
            }
        });
        button1=(Button)getView().findViewById(R.id.button4);
        button1.setOnClickListener(this);
        super.onViewCreated(view, savedInstanceState);
    }
    private void send(){
        final String currentDateTimeString = DateFormat.getDateInstance().format(new Date());
        StringRequest stringRequest=new StringRequest(Request.Method.POST, ConnectionClass.URL_ROOMMIS, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject obj = new JSONObject(response);
                    Toast.makeText(getActivity(), obj.getString("message"), Toast.LENGTH_LONG).show();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(),"message",Toast.LENGTH_LONG).show();
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String>params=new HashMap<>();
                params.put("username",SharedRefManager.getInstance(getActivity()).getUsername());
                params.put("date",currentDateTimeString);
                return params;
            }
        };
        SingletonRequestHandler.getInstance(getActivity()).addToRequestQueue(stringRequest);
    }
    @Override
    public void onClick(View v) {
        if(v==button1)
            send();
    }
}
