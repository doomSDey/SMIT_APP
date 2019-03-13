package com.example.sudipta.smit;


import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Integer.valueOf;


/**
 * A simple {@link Fragment} subclass.
 */
public class Menu extends Fragment {


    public Menu() {
        // Required empty public constructor
    }

    private ViewPager mSlideViewPager;
    private LinearLayout DotLayout;
    private SliderAdapter sliderAdapter;
    private TextView[] textView;
    private static String b=null;
    private static String l=null;
    private static String s=null;
    private static String d=null;


    SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
    Date date = new Date();
    String dayOfTheWeek = sdf.format(date);
    List<String> menu = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        Date d = new Date();
        String dayOfTheWeek = sdf.format(d);
        Toast.makeText(getActivity(), dayOfTheWeek, Toast.LENGTH_SHORT).show();
//        new xx().execute("");
        xxx();

        return inflater.inflate(R.layout.fragment_menu, container, false);

    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        //  xxx();
        String a[] = new String[4];
        //a[0] = new String(b);
        //a[1] = new String(l);
        //a[2] =new String(s);
        //a[3] = new String(d);
        //sliderAdapter = new SliderAdapter(getActivity(),menu);
        Log.e(a[0],"see12");
        super.onViewCreated(view, savedInstanceState);

    }


    private class xx extends AsyncTask<String,String,String>
    {
        @Override
        protected String doInBackground(String... params){


            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
//            mSlideViewPager = (ViewPager) getView().findViewById(R.id.slide);
//            DotLayout = (LinearLayout) getView().findViewById(R.id.dots);
//            sliderAdapter = new SliderAdapter(getActivity(),menu);
//            mSlideViewPager = (ViewPager) getView().findViewById(R.id.slide);
//            DotLayout = (LinearLayout) getView().findViewById(R.id.dots);
//            mSlideViewPager.setAdapter(sliderAdapter);
//            adddDotsIndicator(0);
//            mSlideViewPager.addOnPageChangeListener(viewListner);
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }
    }

    public void xxx() {
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                ConnectionClass.URL_MENU,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject obj = new JSONObject(response);
                            if (!obj.getBoolean("error")) {
                                b = obj.getString("breakfast");
                                l = obj.getString("lunch");
                                s = obj.getString("snacks");
                                d = obj.getString("dinner");
                                Log.d(obj.getString("lunch"), "snacks");
                                menu = Arrays.asList(b,l,s,d);
                                sharedMenu.getInstance(getActivity()).getMenu(obj.getString("breakfast"),obj.getString("lunch"),obj.getString("snacks"),obj.getString("dinner"));

                              //  Toast.makeText(getActivity(), obj.getString("snacks"), Toast.LENGTH_LONG).show();
                                //   SharedRefManager.getInstance(context).userLogin(obj.getString("id"),obj.getString("email"),obj.getString("username"));
                                mSlideViewPager = (ViewPager) getView().findViewById(R.id.slide);
                                DotLayout = (LinearLayout) getView().findViewById(R.id.dots);
                                sliderAdapter = new SliderAdapter(getActivity(),menu);
                                mSlideViewPager = (ViewPager) getView().findViewById(R.id.slide);
                                DotLayout = (LinearLayout) getView().findViewById(R.id.dots);
                                mSlideViewPager.setAdapter(sliderAdapter);
                                adddDotsIndicator(0);
                                mSlideViewPager.addOnPageChangeListener(viewListner);
                            } else {
                                Toast.makeText(getActivity(), "message", Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("menu error", error.getMessage());
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("day", dayOfTheWeek);
                return params;
            }
        };

        SingletonRequestHandler.getInstance(getActivity()).addToRequestQueue(stringRequest);
    }

    public void adddDotsIndicator(int postion) {

        textView = new TextView[4];
        DotLayout.removeAllViews();
        for (int i = 0; i < 4; i++) {
            textView[i] = new TextView(getActivity());
            textView[i].setText(Html.fromHtml("&#8226;"));
            textView[i].setTextSize(35);
            textView[i].setTextColor(getResources().getColor(R.color.transparentwhite));
            DotLayout.addView(textView[i]);
        }
        if(textView.length>0)
            textView[postion].setTextColor(getResources().getColor(R.color.white));
    }

    ViewPager.OnPageChangeListener viewListner=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int i) {
            adddDotsIndicator(i);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };


}