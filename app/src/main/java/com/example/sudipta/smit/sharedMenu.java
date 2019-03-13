package com.example.sudipta.smit;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.LruCache;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

public class sharedMenu {
    private static sharedMenu mInstance;
    //private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;
    private static Context mCtx;
    private static final String SHARED_PREF_MENU="mysharedpref12";
    private static final String KEY_BREAKFAST1="mysharedpref12";
    public static final String KEY_LUNCH="username";
    public static final String KEY_SNACKS="useremail";
    public static final String KEY_DINNER="userid";

    private sharedMenu(Context context) {
        mCtx = context;

    }

    public static synchronized sharedMenu getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new sharedMenu(context);
        }
        return mInstance;
    }


    public boolean getMenu(String breakfast,String lunch,String snacks,String dinner)
    {
        SharedPreferences sharedPreferences=mCtx.getSharedPreferences(SHARED_PREF_MENU,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();

        editor.putString(KEY_BREAKFAST1,breakfast);
        editor.putString(KEY_LUNCH,lunch);
        editor.putString(KEY_SNACKS,snacks);
        editor.putString(KEY_DINNER,dinner);
        editor.apply();
        return true;
    }



    public String getKeyBreakfast1()
    {
        SharedPreferences sharedPreferences=mCtx.getSharedPreferences(SHARED_PREF_MENU,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_BREAKFAST1,null);
    }

    public String getKeyLunch()
    {
        SharedPreferences sharedPreferences=mCtx.getSharedPreferences(SHARED_PREF_MENU,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_LUNCH,null);
    }

    public String getKeySnacks()
    {
        SharedPreferences sharedPreferences=mCtx.getSharedPreferences(SHARED_PREF_MENU,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_SNACKS,null);
    }

    public String getKeyDinner()
    {
        SharedPreferences sharedPreferences=mCtx.getSharedPreferences(SHARED_PREF_MENU,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_DINNER,null);
    }
// ..
}
