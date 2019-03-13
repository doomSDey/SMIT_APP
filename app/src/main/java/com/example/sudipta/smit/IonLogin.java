package com.example.sudipta.smit;


import android.app.ProgressDialog;
import android.content.Intent;
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
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class IonLogin extends Fragment implements View.OnClickListener {


    public IonLogin() {
        // Required empty public constructor
    }

    boolean isLoggedIn = false;
    private EditText regd, pass;
    private Button logBut;
    private ProgressDialog progressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ion_login, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
       // getActivity(R.layout.activity_login);
        regd=(EditText)getView().findViewById(R.id.ionuser);
        pass=(EditText)getView().findViewById(R.id.ionpass);
        logBut=(Button)view.findViewById(R.id.ionbutt);

        progressDialog=new ProgressDialog(getActivity());
        progressDialog.setMessage("please wait...");

        logBut.setOnClickListener(this);

        super.onViewCreated(view, savedInstanceState);
    }


    private void userLogin()
    {
        final String username=regd.getText().toString().trim();
        final String password=pass.getText().toString().trim();
        progressDialog.show();
        StringRequest stringRequest=new StringRequest(
                Request.Method.POST,
                ConnectionClass.URL_LOGIN2,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        try {
                            JSONObject obj =new JSONObject(response);
                            if(!obj.getBoolean("error"))
                            {
                                SharedRefION.getInstance(getActivity()).userLogin(obj.getString("id"),obj.getString("downloaded"),obj.getString("uploaded"));
                                Toast.makeText(getActivity(),"User Login Successful",Toast.LENGTH_LONG).show();
                                launchSecondActivity2();
                            }else
                            {
                                Toast.makeText(getActivity(),"message",Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }

        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String>params=new HashMap<>();
                params.put("username",username);
                params.put("password",password);
                return params;
            }
        };

        SingletonRequestHandler.getInstance(getActivity()).addToRequestQueue(stringRequest);

    }

    @Override
    public void onClick(View v) {
        //if(v==logBut && SharedRefION.getInstance(getActivity()).isLoggedIn()==false)
            userLogin();
       // else
         //   launchSecondActivity2();
    }
    public void launchSecondActivity2() {
        IONlogout ioNlogout = new IONlogout();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, ioNlogout);
        fragmentTransaction.addToBackStack("ioNlogout");
        fragmentTransaction.commit();}

    public void onPause() {
        super.onPause();
        if (isLoggedIn) {
           // finish();
        }
    }
}
