package parikalan.xenium.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import org.json.JSONException;

import parikalan.xenium.adapters.AdapterEvent;
import parikalan.xenium.adapters.RecyclerItemClickListener;
import parikalan.xenium.dataValues.Information;
import parikalan.xenium.dataValues.MyApplication;
import parikalan.xenium.dataValues.ServletInterface;
import parikalan.xenium.Demo;
import parikalan.xenium.R;
import parikalan.xenium.glideimages.GalleryActivity;

public class Event_List extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public static final String KEY_USER_LEARNED_DRAWER = "user_learned_drawer";
    private boolean mUserLearnedDrawer, mFromSavedInstanceState;
    private DrawerLayout drawer;

    public void setmUserLearnedDrawer(boolean mUserLearnedDrawer) {
        this.mUserLearnedDrawer = mUserLearnedDrawer;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Event_List.this, RegisterActivity.class);
                startActivity(in);
            }
        });

        RecyclerView eventView = (RecyclerView) findViewById(R.id.eventlist);
        AdapterEvent adapterEvent = null;
        try {
            adapterEvent = new AdapterEvent(this, Information.getData(this));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        eventView.setAdapter(adapterEvent);
        eventView.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent in = new Intent(Event_List.this, Events.class);
                in.putExtra("event_sno", position);
                startActivity(in);
            }
        }));
        eventView.setLayoutManager(new LinearLayoutManager(this));

        mUserLearnedDrawer = MyApplication.readFromPreferences(this, KEY_USER_LEARNED_DRAWER, false);
        mFromSavedInstanceState = savedInstanceState != null;

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        if (!mUserLearnedDrawer) {
            drawer.openDrawer(navigationView);
            mUserLearnedDrawer = true;
            MyApplication.saveToPreferences(this, KEY_USER_LEARNED_DRAWER, true);
        }
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);


        //Update
        new Thread(new Runnable() {
            @Override
            public void run() {

                isInternetConnection(getApplicationContext());
            }
        }).start();
    }
    public boolean isInternetConnection(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED || cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED)
        {
            final String result = ServletInterface.jsonRequest();
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    SharedPreferences spd = getSharedPreferences("Xenium16", MODE_PRIVATE);
                    SharedPreferences.Editor e = spd.edit();
                    e.putString("jayson", result);
                    e.apply();
                }
            });
            return true;
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();


        Fragment switchFragment = null;


        if (id == R.id.nav_home) {
            Intent in = new Intent(Event_List.this, HomeActivity.class);
            startActivity(in);
        }
        if (id == R.id.nav_gallery) {
            Intent in = new Intent(Event_List.this, GalleryActivity.class);
            startActivity(in);
        }
        if (id == R.id.nav_register) {
            Intent in = new Intent(Event_List.this, RegisterActivity.class);
            startActivity(in);
        }
        if (id == R.id.nav_timeline) {
            Intent in = new Intent(Event_List.this, Timeline.class);
            startActivity(in);
        }
        if (id == R.id.nav_about) {
            Intent in = new Intent(Event_List.this, AboutUs.class);
            startActivity(in);
        }
        if (id == R.id.nav_collegemap) {
            Intent in = new Intent(Event_List.this, CollegeMapActivity.class);
            startActivity(in);
        }
        if (id == R.id.myev) {
            Intent in = new Intent(Event_List.this, Demo.class);
            startActivity(in);
        }
        if (id == R.id.nav_facebook) {
            Intent in = new Intent(Intent.ACTION_VIEW);
            in.setData(Uri.parse("https://www.facebook.com/xeniumteam"));
            Intent chooser = Intent.createChooser(in, "Open Link through...");
            startActivity(chooser);
        }
        if (id == R.id.nav_twitter) {
            Intent in = new Intent(Intent.ACTION_VIEW);
            Intent chooser = Intent.createChooser(in, "Open Link through...");
            in.setData(Uri.parse("https://twitter.com/xeniumtechfest"));
            startActivity(chooser);
        }
        if (id == R.id.nav_instagram) {
            Intent in = new Intent(Intent.ACTION_VIEW);
            in.setData(Uri.parse("https://www.instagram.com/xeniumtechfest/"));
            Intent chooser = Intent.createChooser(in, "Open Link through...");
            startActivity(chooser);
        }
        if (id == R.id.nav_locate) {
            double latitude = 28.566785;
            double longitude = 77.251446;
            String label = "PGDAV College";
            String uriBegin = "geo:" + latitude + "," + longitude;
            String query = "(" + label + ")";
            String encodedQuery = Uri.encode(query);
            String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
            Uri uri = Uri.parse(uriString);
            Intent intent = new Intent(android.content.Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }

        return true;

    }
}