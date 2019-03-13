package com.example.sudipta.smit;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class Login extends AppCompatActivity implements View.OnClickListener {

    boolean isLoggedIn = false;
    private EditText regd, pass;
    private Button logBut;
    private ProgressDialog progressDialog;

    private static final String LOG_TAG = Login.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        regd=(EditText)findViewById(R.id.editText2);
        pass=(EditText)findViewById(R.id.ionpass);
        logBut=(Button)findViewById(R.id.ionbutt);

        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("please wait...");

        logBut.setOnClickListener(this);
    }
    private void userLogin()
    {
        final String username=regd.getText().toString().trim();
        final String password=pass.getText().toString().trim();
        progressDialog.show();
        StringRequest stringRequest=new StringRequest(
                Request.Method.POST,
                ConnectionClass.URL_LOGIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        try {
                            JSONObject obj =new JSONObject(response);
                            Log.d(obj.getString("id"),"acd");
                            if(!obj.getBoolean("error"))
                            {
                                SharedRefManager.getInstance(getApplicationContext()).userLogin(obj.getString("id"),obj.getString("email"),obj.getString("username"));
                                  Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_LONG).show();
                                launchSecondActivity();
                            }else
                                {
                                    Toast.makeText(getApplicationContext(),"message",Toast.LENGTH_LONG).show();
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

        SingletonRequestHandler.getInstance(this).addToRequestQueue(stringRequest);

    }

    @Override
    public void onClick(View v) {
        if(v==logBut)
            userLogin();
    }
    public void launchSecondActivity() {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, Home.class);
        isLoggedIn = true;
        startActivity(intent);}

        protected void onPause() {
        super.onPause();
        if (isLoggedIn) {
            finish();
        }
    }
}
        // setupUIViews();
        /*

        logBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DoLogin().executeOnExecutor();
                                         Toast.makeText(Login.this,"ss",Toast.LENGTH_SHORT).show();

                //doLogin.execute();
            }
        });

    }

    @SuppressLint("StaticFieldLeak")
    private class DoLogin extends AsyncTask<Void,Void,Void>
    {

        String z = "";
        Boolean isSuccess = false;

        String userid = regd.getText().toString();
        String password = pass.getText().toString();

/*        @Override
        protected void onPostExecute(String r) {
            Toast.makeText(Login.this,r,Toast.LENGTH_SHORT).show();

            if(isSuccess) {
                Toast.makeText(Login.this,r,Toast.LENGTH_SHORT).show();
            }

        }                                                        

        @Override
        protected String doInBackground(String... params)
        {
                                     Toast.makeText(Login.this,"fs",Toast.LENGTH_SHORT).show();

            if(userid.trim().equals("")|| password.trim().equals(""))
                z = "Please enter User Id and Password";
            else
            {
                try {
                    Connection con = connectionClass.CONN();
                    if (con == null)
                    {
                        z = "Error in connection with SQL server";
                                                 Toast.makeText(Login.this,z,Toast.LENGTH_SHORT).show();

                    }
                    else {
                        String query = "select * from ecm_fbStdMaster where regdNo='" + userid + "' and password='" + password + "'";
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(query);
                                                 Toast.makeText(Login.this,"Query",Toast.LENGTH_SHORT).show();

                        if(rs.next())
                        {

                            z = "Login successfull";
                            isSuccess=true;
                            isLoggedIn = true;
                                                     Toast.makeText(Login.this,"Final",Toast.LENGTH_SHORT).show();


                            Intent intent = new Intent(Login.this, Home.class);
                            startActivity(intent);
                            onPause();
      //                      launchSecondActivity(View view);
                            {
                                z = "Invalid Credentials";
                                isSuccess = false;
                            }
                        }
                        else

                    }
                }
                catch (Exception ex)
                {
                    isSuccess = false;
                    z = "Exceptions";
                }
            }
            return z;
        }
*/
        /*
        @Override
        protected Void doInBackground(Void... args0) {
             if(userid.trim().equals("")||password.trim().equals(""))
            {
                 Toast.makeText(Login.this,"Please Enter Regd no. or Password",Toast.LENGTH_SHORT).show();
            }
            else
                {
                    try
                    {
                        Connection connection=connectionClass.CONN();
                        if(connection==null)
                             Toast.makeText(Login.this,"Error in Connecting to SQL Server",Toast.LENGTH_SHORT).show();
                        else
                            {
                                String query="select * from ecm_fbStdMaster where regdNo='" + userid + "' and password='" + password + "'";
                                Statement stmt=connection.createStatement();
                                ResultSet rs=stmt.executeQuery(query);
                                if(rs.next())
                                {
                                   Toast.makeText(Login.this,"Login Successfull",Toast.LENGTH_SHORT).show();
                                   isSuccess=true;
                                   Intent intent =new Intent(Login.this,Home.class);
                                   startActivity(intent);
                                   onPause();
                                }
                                else
                                {
                                   Toast.makeText(Login.this,"Invalid Credentials",Toast.LENGTH_SHORT).show();
                                    isSuccess=false;
                                }
                            }

                    } catch (SQLException e) {
                        isSuccess=false;
                        e.printStackTrace();
                    }
                }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            if(isSuccess)
                Toast.makeText(Login.this,"Success",Toast.LENGTH_SHORT).show();

            super.onPostExecute(aVoid);
        }

        public void executeOnExecutor() {
            doInBackground();
        }
    }

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, Home.class);
        isLoggedIn = true;
        startActivity(intent);}

    private void setupUIViews()
    {
        regd=(EditText)findViewById(R.id.editText2);
        pass=(EditText)findViewById(R.id.editText);
        logBut=(Button)findViewById(R.id.button);
        connectionClass=new ConnectionClass();
    }
    @Override
    protected void onPause() {
        super.onPause();
        if (isLoggedIn) {
            finish();
        }
    }

}
*/