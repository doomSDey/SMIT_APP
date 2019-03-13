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

public class SharedRefManager {
    private static SharedRefManager mInstance;
    //private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;
    private static Context mCtx;
    private static final String SHARED_PREF_NAME="mysharedpref12";
    public static final String KEY_USERNAME="username";
    public static final String KEY_USER_EMAIL="useremail";
    public static final String KEY_REGD_ID="userid";

    private SharedRefManager(Context context) {
        mCtx = context;

    }

    public static synchronized SharedRefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedRefManager(context);
        }
        return mInstance;
    }

    public boolean userLogin(String id,String email,String username)
     {
        SharedPreferences sharedPreferences=mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();

         editor.putString(KEY_REGD_ID,id);
        editor.putString(KEY_USER_EMAIL,email);
        editor.putString(KEY_USERNAME,username);
         Log.d(KEY_REGD_ID,"regd");
        editor.apply();
        return true;
    }

    public boolean isLoggedIn()
    {
        SharedPreferences sharedPreferences=mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        if(sharedPreferences.getString(KEY_USERNAME,null)!=null){

        return true;}
        else
            return false;
    }

    public boolean logout()
    {
        SharedPreferences sharedPreferences=mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.clear();
        editor.apply();
        return true;
    }

    public String getUsername()
    {
        SharedPreferences sharedPreferences=mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_REGD_ID,null);
    }


    public String getname()
    {
        SharedPreferences sharedPreferences=mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USERNAME,null);
    }
// ..
}
