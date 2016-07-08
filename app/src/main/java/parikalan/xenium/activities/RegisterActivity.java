package parikalan.xenium.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.weiwangcn.betterspinner.library.BetterSpinner;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import parikalan.xenium.dataValues.Information;
import parikalan.xenium.dataValues.ServletInterface;
import parikalan.xenium.R;
import me.james.biuedittext.BiuEditText;

public class RegisterActivity extends AppCompatActivity {

    boolean success = false;
    String[] Events;
    BetterSpinner spinner1, spinner2, spinner3;
    BiuEditText college, name, pno, course, email;
    Button b;
    TextView tv;
    List<Information> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Register Here !!!");
        setSupportActionBar(toolbar);

        college = (BiuEditText) findViewById(R.id.viewcollege);
        name = (BiuEditText) findViewById(R.id.viewname);
        pno = (BiuEditText) findViewById(R.id.viewpno);
        course = (BiuEditText) findViewById(R.id.viewcourse);
        email = (BiuEditText) findViewById(R.id.viewemail);
        b = (Button) findViewById(R.id.register);
        tv = (TextView) findViewById(R.id.textview_note);

        final String[] Colleges = getResources().getStringArray(R.array.Colleges);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, Colleges);
        spinner1 = (BetterSpinner) findViewById(R.id.spinner1);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position + 1 == Colleges.length) {
                    college.setVisibility(View.VISIBLE);
                } else {
                    college.setVisibility(View.GONE);
                }
            }
        });

        Typeface tf_heading = Typeface.createFromAsset(getAssets(), "kushan.otf");
        tv.setTypeface(tf_heading);

        try {
            data = Information.getData(this);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Events = new String[data.size()];
        int index = 0;
        for (Information i : data) {
            Events[index++] = i.ename;
        }

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, Events);
        spinner2 = (BetterSpinner) findViewById(R.id.spinner2);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                map_event_part(position);
            }
        });
        spinner3 = (BetterSpinner) findViewById(R.id.spinner3);
        final String[] spinner =new String[]{"---Select Event---"};
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, spinner);
        spinner3.setAdapter(adapter3);

        if (getIntent().hasExtra("event_sno")) {
            Information k = null;
            try {
                k = Information.getData(this).get(getIntent().getExtras().getInt("event_sno"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            spinner2.setText(k.ename);
            map_event_part(k.sno);
        }


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isInternetConnection(RegisterActivity.this)) {
                    Snackbar snackbar = Snackbar.make(findViewById(R.id.coordinate), "No Internet Connection...", Snackbar.LENGTH_LONG);
                    snackbar.show();
                    return;
                } else if ((email.getText().length() == 0) || (course.getText().length() == 0) || (pno.getText().length() == 0) || (name.getText().length() == 0) || (spinner1.getText().length() == 0) || (spinner2.getText().length() == 0) || (spinner3.getText().length() == 0)) {
                    Snackbar snackbar = Snackbar.make(findViewById(R.id.coordinate), "All fields are must...", Snackbar.LENGTH_LONG);
                    snackbar.show();
                    return;
                } else if (pno.getText().length() != 10) {
                    Snackbar snackbar = Snackbar.make(findViewById(R.id.coordinate), "Invalid Phone no...", Snackbar.LENGTH_LONG);
                    snackbar.show();
                    return;
                } else if ((college.getVisibility() == View.VISIBLE) && (college.getText().length() == 0)) {
                    Snackbar snackbar = Snackbar.make(findViewById(R.id.coordinate), "College name is must...", Snackbar.LENGTH_LONG);
                    snackbar.show();
                    return;
                } else if (!(email.getText().toString().contains("@")) || !(email.getText().toString().contains("."))) {
                    Snackbar snackbar = Snackbar.make(findViewById(R.id.coordinate), "Invalid Email ID...", Snackbar.LENGTH_LONG);
                    snackbar.show();
                    return;
                } else {
                    final ProgressDialog pd = new ProgressDialog(RegisterActivity.this);
                    pd.setIndeterminate(true);
                    pd.setTitle("Just a sec...");
                    pd.setMessage("Please have patience while we are registering for the event :)");
                    pd.setCancelable(false);
                    pd.show();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            RegisterActivity.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {

                                    new CountDownTimer(8000, 8000) {

                                        @Override
                                        public void onTick(long millisUntilFinished) {

                                        }

                                        @Override
                                        public void onFinish() {
                                            pd.cancel();
                                            if (!success) {
                                                Snackbar snackbar = Snackbar.make(findViewById(R.id.coordinate), "Bad Network Connection :( Try Again", Snackbar.LENGTH_LONG);
                                                snackbar.show();
                                            }
                                        }
                                    }.start();
                                }
                            });
                            final String[] result = ServletInterface.executeHttpRequest(spinner1.getText().toString(), spinner2.getText().toString(), spinner3.getText().toString(), name.getText().toString(), pno.getText().toString(), course.getText().toString(), email.getText().toString()).split(";");
                            if (result[0].equals("1")) {
                                RegisterActivity.this.runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        pd.cancel();
                                        success = true;
                                        String id="X00"+result[1];
                                        try {
                                            SQLiteDatabase db = openOrCreateDatabase("Xenium16", MODE_PRIVATE, null);
                                            db.execSQL("create table if not exists reg (id varchar,name varchar,event varchar,nop varchar)");
                                            db.execSQL("insert into reg values('" + id + "','" + name.getText() + "','" + spinner2.getText() + "','" + spinner3.getText() + "')");
                                            db.close();
                                        }
                                        catch(Exception e){}
                                        Toast.makeText(RegisterActivity.this, "Registration ID is "+id+" :)", Toast.LENGTH_LONG).show();
                                        finish();
                                    }
                                });
                            } else {
                                RegisterActivity.this.runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        pd.cancel();
                                        success = true;
                                        Snackbar snackbar = Snackbar.make(findViewById(R.id.coordinate), "Registration Unsuccessful :(", Snackbar.LENGTH_LONG);
                                        snackbar.show();
                                    }
                                });
                            }
                        }
                    }).start();
                }
            }
        });

    }

    public boolean isInternetConnection(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED || cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED)
            return true;
        return false;
    }

    void map_event_part(int position) {
        spinner3.setText(null);
        ArrayList<String> no = new ArrayList<String>();

        int min = data.get(position).emin;
        int max = data.get(position).emax;

        if (min == 0) {
            spinner3.setText("");
            no.add("");
        } else if (min == max) {
            spinner3.setText(min + "");
            no.add(min + "");
        } else {
            for (int i = min; i <= max; i++) {
                no.add(i + "");
            }
        }

        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, no);
        spinner3.setAdapter(adapter3);

        if (data.get(position).enote.length() > 0) {
            tv.setVisibility(View.VISIBLE);
            tv.setText("Note: " + data.get(position).enote);
        } else {
            tv.setVisibility(View.GONE);
            tv.setText("");
        }

    }
}
