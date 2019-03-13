package com.example.sudipta.smit;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class Marks extends Fragment {


    public Marks() {
        // Required empty public constructor
    }
    private ProgressDialog progressDialog;

    RecyclerView recyclerView;
    attendenceAdapter attendenceAdapter;

    List<Marks_det> marks_detList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

      marks_detList=new ArrayList<>();
      progressDialog=new ProgressDialog(getActivity());
        progressDialog.setMessage("please wait...");

        return inflater.inflate(R.layout.fragment_marks, container, false);
    }



    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        // getActivity(R.layout.activity_login);
        recyclerView=(RecyclerView)getView().findViewById(R.id.recyclerView2);
        Log.e("a","subnam");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        marks_detList=new ArrayList<>();
        loadMarks();
        progressDialog=new ProgressDialog(getActivity());
        super.onViewCreated(view, savedInstanceState);
    }

    private void loadMarks() {
        Log.e("b","viscus");
        StringRequest stringRequest=new StringRequest(Request.Method.POST, ConnectionClass.URL_MARKS, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    progressDialog.dismiss();
                    //JSONObject obj = new JSONObject(response);
                    JSONArray array = new JSONArray(response);
                    //traversing through all the object
                    Log.e("kuchvhi", String.valueOf(array.length()));

                    for (int i = 0; i < array.length(); i++) {

                        //getting product object from json array
                        JSONObject product = array.getJSONObject(i);


                        //adding the product to product list
                   // /    Log.e("kuchvhi1", String.valueOf(y));
                       // Log.e("kuchvhi2", String.valueOf(x));
                        //Log.e("kuchvhi3", String.valueOf(per));
                       marks_detList.add(new Marks_det(
                                product.getString("subName"),
                                product.getString("subID"),
                                product.getString("sessional1"),
                                product.getString("sessional_2"),
                                product.getString("quiz1"),
                                product.getString("quiz2"),
                                product.getString("attendence"),
                               product.getString("assignment"),
                               product.getString("semester"),
                               product.getString("internal")
                               ));
                        Log.e(product.getString("subName"),"subname");
                    }

                    //creating adapter object and setting it to recyclerview
                    Marks_adapter adapter = new Marks_adapter(getActivity(), marks_detList);
                    recyclerView.setAdapter(adapter);
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
                params.put("regdNo",SharedRefManager.getInstance(getActivity()).getUsername());
                return params;
            }
        };
        SingletonRequestHandler.getInstance(getActivity()).addToRequestQueue(stringRequest);
    }

}
