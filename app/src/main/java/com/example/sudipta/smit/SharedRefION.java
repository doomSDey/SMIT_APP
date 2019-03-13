package com.example.sudipta.smit;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

public class SharedRefION {

        private static com.example.sudipta.smit.SharedRefION mInstance1;
        //private RequestQueue mRequestQueue;
        private ImageLoader mImageLoader;
        private static Context mCtx2;
       private static final String SHARED_PREF_NAME2="mysharedpref12";
        public static final String KEY_UPLOADED="u";
        public static final String KEY_DOWNLOADED="d";
        public static final String KEY_REGD_ID2="userid";

        private SharedRefION(Context context) {
            mCtx2 = context;

        }

        public static synchronized com.example.sudipta.smit.SharedRefION getInstance(Context context) {
            if (mInstance1 == null) {
                mInstance1 = new com.example.sudipta.smit.SharedRefION(context);
            }
            return mInstance1;
        }

        public boolean userLogin(String id,String downloaded,String uploaded)
        {
            SharedPreferences sharedPreferences=mCtx2.getSharedPreferences(SHARED_PREF_NAME2,Context.MODE_PRIVATE);
            SharedPreferences.Editor editor=sharedPreferences.edit();

            editor.putString(KEY_REGD_ID2,id);
            editor.putString(KEY_UPLOADED,uploaded);
            editor.putString(KEY_DOWNLOADED,downloaded);

            editor.apply();
            return true;
        }

        public boolean isLoggedIn()
        {
            SharedPreferences sharedPreferences=mCtx2.getSharedPreferences(SHARED_PREF_NAME2,Context.MODE_PRIVATE);
            if(sharedPreferences.getString(KEY_REGD_ID2,null)!=null)
                return true;
            else
                return false;
        }

        public boolean logout()
        {
            SharedPreferences sharedPreferences1=mCtx2.getSharedPreferences(SHARED_PREF_NAME2,Context.MODE_PRIVATE);
            SharedPreferences.Editor editor=sharedPreferences1.edit();
            editor.clear();
            editor.apply();
            return true;
        }

    public String getUsername()
    {
        SharedPreferences sharedPreferences=mCtx2.getSharedPreferences(SHARED_PREF_NAME2,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_REGD_ID2,null);
    }


    public String Downloaded()
    {
        SharedPreferences sharedPreferences=mCtx2.getSharedPreferences(SHARED_PREF_NAME2,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_DOWNLOADED,null);
    }


    public String Uploaded()
    {
        SharedPreferences sharedPreferences=mCtx2.getSharedPreferences(SHARED_PREF_NAME2,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_UPLOADED,null);
    }


// ..
    }

