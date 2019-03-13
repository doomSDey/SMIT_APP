package com.example.sudipta.smit;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

        NavigationView navigationView = null;
        //Toolbar toolbar = null;
        private int clickedNavItem=0;
        DrawerLayout drawerLayout;
        ImageView ivInfo;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_home);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            ((AppCompatActivity)this).getSupportActionBar().setTitle("SMIT");

            MainFragment mainFragment=new MainFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,mainFragment);
            //fragmentTransaction.addToBackStack("mainFragment");
            fragmentTransaction.commit();

                    // ivInfo = (ImageView) findViewById(R.id.imageView);
            drawerLayout = findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
            drawerLayout.addDrawerListener(drawerToggle);
            drawerToggle.syncState();
            //View view = inflater.inflate(R.layout.fragment_drawer_fragment_main, container, false);
            navigationView = (NavigationView) findViewById(R.id.nav_view);
            View headerView = navigationView.getHeaderView(0);

            TextView textView=(TextView)headerView.findViewById(R.id.username);
            TextView textView1=(TextView)headerView.findViewById(R.id.regd);
            textView1.setText(SharedRefManager.getInstance(this).getUsername());
            textView.setText(SharedRefManager.getInstance(this).getname());

            navigationView.setNavigationItemSelectedListener(this);

        }

        @Override
        public void onStart() {
            super.onStart();
            //RelativeLayout rl=(RelativeLayout)findViewById(R.id.nav_header_layout);
            //rl.setBackgroundResource(R.drawable.bg2);
        }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        //TextView tw=TextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable., 0, 0, 0);
        //ivInfo.setImageDrawable(drawable);
           // ivInfo=(ImageView)findViewById(R.id.imageView);
            //closeDrawer();
        int id=item.getItemId();
        Fragment fragment =null;
        Class fragmentClass;
        switch (item.getItemId())
            {
                case R.id.ecm:
                    clickedNavItem=R.id.ecm;
                   // Toast.makeText(Home.this,"ecm",Toast.LENGTH_SHORT).show()
                    // in my case I get the support fragment manager, it should work with the native one too
                    android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
                    // this will clear the back stack and displays no animation on the screen
                    fragmentManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);

                    ecm ecm=new ecm();
                    android.support.v4.app.FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container,ecm);
                    fragmentTransaction.addToBackStack("ecm");
                    fragmentTransaction.commit();
                    //fragmentClass=messfrag

                    break;
                case R.id.mess:
                     fragmentManager = getSupportFragmentManager();
                    // this will clear the back stack and displays no animation on the screen
                    fragmentManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                    clickedNavItem=R.id.mess;
                   messfrag messfrag=new messfrag();
                    fragmentTransaction=getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container,messfrag);
                    fragmentTransaction.addToBackStack("messfrag");
                    fragmentTransaction.commit();
                    //fragmentClass=messfrag*/
                    break;
                case R.id.HomeFrag:
                    fragmentManager = getSupportFragmentManager();
                    // this will clear the back stack and displays no animation on the screen
                    fragmentManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                    clickedNavItem=R.id.HomeFrag;
                    MainFragment mainFragment=new MainFragment();
                    fragmentTransaction=getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container,mainFragment);
                    fragmentTransaction.addToBackStack("mainFragment");
                    fragmentTransaction.commit();
                    break;
                case R.id.mis:
                    fragmentManager = getSupportFragmentManager();
                    // this will clear the back stack and displays no animation on the screen
                    fragmentManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                    clickedNavItem=R.id.mis;
                    mis mis=new mis();
                    fragmentTransaction=getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container,mis);
                    fragmentTransaction.addToBackStack("mis");
                    fragmentTransaction.commit();
                    break;

                case R.id.ion:
                    fragmentManager = getSupportFragmentManager();
                    // this will clear the back stack and displays no animation on the screen
                    fragmentManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                    clickedNavItem=R.id.ion;
                    if(SharedRefION.getInstance(this).Uploaded()!=null) {
                        IONlogout ioNlogout = new IONlogout();
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.fragment_container, ioNlogout);
                        fragmentTransaction.addToBackStack("ioNlogout");
                        fragmentTransaction.commit();
                    }
                    else {
                        IonLogin ionLogin = new IonLogin();
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.fragment_container, ionLogin);
                        fragmentTransaction.addToBackStack("ioNlogin");
                        fragmentTransaction.commit();
                    }
                    break;
                case R.id.contacts:
                    fragmentManager = getSupportFragmentManager();
                    // this will clear the back stack and displays no animation on the screen
                    fragmentManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                    clickedNavItem=R.id.contacts;
                    Contacts contacts =new Contacts();
                    fragmentTransaction=getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container,contacts);
                    fragmentTransaction.addToBackStack("contacts");
                    fragmentTransaction.commit();
                    break;

            }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);
            return true;
    }

    private void closeDrawer() {
            drawerLayout.closeDrawer(GravityCompat.START);
    }

    private void openDrawer()
    {
        drawerLayout.openDrawer(GravityCompat.START);
    }
    boolean doubleBackToExitPressedOnce = false;
    @Override
    public void onBackPressed() {
        int count = getSupportFragmentManager().getBackStackEntryCount();
        Log.d(String.valueOf(count),"abc12341");
        if (drawerLayout.isDrawerOpen
                (GravityCompat.START))
            closeDrawer();
            //super.onBackPressed();

            //additional code

        if(doubleBackToExitPressedOnce && count==0){
            super.onBackPressed();
            return;


        }else
            getSupportFragmentManager().popBackStack();
        this.doubleBackToExitPressedOnce = true;
        if(
                count ==0)
            Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);}

    private void onBackPressedExit() {
        super.onBackPressed();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.right_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();

        if(id==R.id.logout)
        {
            SharedRefManager.getInstance(this).logout();
            finish();
            startActivity(new Intent(this,Login.class));
            return true;
        }
         return super.onOptionsItemSelected(item);
    }

}
/*{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
}*/
