package com.example.sudipta.smit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;
    String b,l,s,d;
    String a[];
    private List<String> menu;
    public SliderAdapter(Context context,List<String>menu)
    {
        this.context=context;
        //Log.e("fooda", a[0]);
        this.menu=menu;
    }



    //Arrays
    public  int[] slide_images={
            R.drawable.breakfastnew,R.drawable.lunch,R.drawable.snacks,R.drawable.dinner
    };

    public  String[] slide_headings=
            {
                    "BREAKFAST","LUNCH","SNACKS","DINNER"
            };

    public String[] slide_content=
            {
//                   b=sharedMenu.getInstance(context).getKeyBreakfast1(),l=sharedMenu.getInstance(context).getKeyLunch(),sharedMenu.getInstance(context).getKeySnacks(),sharedMenu.getInstance(context).getKeyDinner()
            };
    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view ==(ConstraintLayout)object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slide_layout,container,false);
        ImageView slideImageView=(ImageView)view.findViewById(R.id.slide_images);
        TextView slideHeading=(TextView)view.findViewById(R.id.slide_headings);
        TextView slideContent=(TextView)view.findViewById(R.id.slide_contents);
//        Log.e(a[0],"foode");
        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        Log.e("menu position", Integer.toString(position));
        Log.e("menu", menu.toString());
        slideContent.setText(menu.get(position));

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
