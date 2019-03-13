package com.example.sudipta.smit;


import android.app.ProgressDialog;
import android.content.SharedPreferences;
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
import android.widget.Button;
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
public class Contact_Search extends Fragment {


    public Contact_Search() {
        // Required empty public constructor
    }

    private void readBundle(Bundle bundle) {
        if (bundle != null) {
            name = bundle.getString("YourKey");
            Log.e("abc1211", name);
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString(KEY,name);
            editor.commit();
        }
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        contact_dets=new ArrayList<>();
        sharedpreferences = getActivity().getSharedPreferences(MyPREFERENCES, getActivity().MODE_PRIVATE);
        //name=getArguments().getString("YourKey");
       // Toast.makeText(getActivity(),name,Toast.LENGTH_SHORT);
       // SharedPreferences.Editor editor = sharedpreferences.edit();
       // editor.putString(KEY,name);
       // editor.commit();
        Log.e(name,"name332");
        return inflater.inflate(R.layout.fragment_contact__search, container, false);
    }

    RecyclerView recyclerView;
    Contact_Adapter contact_adapter;
    public String name;
    List<contact_det> contact_dets;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String KEY = "Key";
    SharedPreferences sharedpreferences;

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        // getActivity(R.layout.activity_login);
        recyclerView=(RecyclerView)getView().findViewById(R.id.recCS);
        Log.e("a","subnam");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        contact_dets=new ArrayList<>();
        readBundle(getArguments());
        loadContacts();
        super.onViewCreated(view, savedInstanceState);
    }

    private void loadContacts() {
        Log.e("b","viscus");
        StringRequest stringRequest=new StringRequest(Request.Method.POST, ConnectionClass.URL_SEARCH_CONTACTS, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    //JSONObject obj = new JSONObject(response);
                    JSONArray array = new JSONArray(response);
                    //traversing through all the object
                    Log.e("kuchvhi", String.valueOf(array.length()));

                    for (int i = 0; i < array.length(); i++) {

                        //getting product object from json array
                        JSONObject product = array.getJSONObject(i);
                        Log.e("kuchvhi1",product.getString("dept"));
                        //adding the product to product list
                        contact_dets.add(new contact_det(
                                product.getString("dept"),
                                product.getString("designation"),
                                product.getString("email"),
                                product.getString("emp_id"),
                                product.getString("emp_name"),
                                product.getString("number")
                        ));
                    }

                    //creating adapter object and setting it to recyclerview
                    Contact_Adapter adapter = new Contact_Adapter(getActivity(), contact_dets);
                    recyclerView.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
               // Toast.makeText(getActivity(),"message",Toast.LENGTH_LONG).show();
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String>params=new HashMap<>();
                Log.e(name,"name123");
                Log.e("name","name123");
                params.put("name",name);
                return params;
            }
        };
        SingletonRequestHandler.getInstance(getActivity()).addToRequestQueue(stringRequest);
    }
}
