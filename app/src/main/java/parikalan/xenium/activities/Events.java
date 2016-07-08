package parikalan.xenium.activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONException;

import parikalan.xenium.dataValues.Information;
import parikalan.xenium.R;

public class Events extends AppCompatActivity {

    TextView ename, etype, edesc, edate, etime, evenue, enote, epart, erules, eh1, eh2, epno1, epno2;
    TextView desc, rules, date, time, venue, participants;
    LinearLayout reach1, reach2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final int e_sno = getIntent().getIntExtra("event_sno", 0);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Events.this, RegisterActivity.class);
                in.putExtra("event_sno", e_sno);
                startActivity(in);
                finish();
            }
        });

        ename = (TextView) findViewById(R.id.event_name);
        etype = (TextView) findViewById(R.id.event_type);
        edesc = (TextView) findViewById(R.id.event_desc);
        erules = (TextView) findViewById(R.id.event_rules);
        edate = (TextView) findViewById(R.id.event_date);
        etime = (TextView) findViewById(R.id.event_time);
        evenue = (TextView) findViewById(R.id.event_venue);
        enote = (TextView) findViewById(R.id.event_note);
        epart = (TextView) findViewById(R.id.event_partcipants);
        eh1 = (TextView) findViewById(R.id.name1);
        eh2 = (TextView) findViewById(R.id.name2);
        epno1 = (TextView) findViewById(R.id.no1);
        epno2 = (TextView) findViewById(R.id.no2);
        desc = (TextView) findViewById(R.id.desc);
        rules = (TextView) findViewById(R.id.rules);
        date = (TextView) findViewById(R.id.date);
        time = (TextView) findViewById(R.id.time);
        venue = (TextView) findViewById(R.id.venue);
        participants = (TextView) findViewById(R.id.participants);
        reach1 = (LinearLayout) findViewById(R.id.reach1);
        reach2 = (LinearLayout) findViewById(R.id.reach2);

        Information info = null;
        try {
            info = Information.getData(this).get(e_sno);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ename.setText(info.ename);
        etype.setText(info.etype);
        edesc.setText(info.edesc);
        if(etype.length()<1)
            etype.setVisibility(View.GONE);
        erules.setText(info.erules);
        edate.setText(info.edate);
        etime.setText(info.etime);
        evenue.setText(info.evenue);
        if(info.enote.length()>0)
            enote.setText("Note: "+info.enote);
        else
            enote.setVisibility(View.GONE);
        eh1.setText(info.eh1);
        eh2.setText(info.eh2);
        epno1.setText(info.epno1);
        epno2.setText(info.epno2);
        if (info.emax == info.emin) {
            epart.setText(info.emax + "");
        } else {
            epart.setText(info.emin + "-" + info.emax);
        }

        Typeface tf_heading = Typeface.createFromAsset(getAssets(), "kushan.otf");
        Typeface tf_body = Typeface.createFromAsset(getAssets(), "sofia.otf");
        Typeface tf_bar = Typeface.createFromAsset(getAssets(), "lobster.otf");
        ename.setTypeface(tf_heading);
        edesc.setTypeface(tf_body);
        erules.setTypeface(tf_body);
        enote.setTypeface(tf_body);
        edate.setTypeface(tf_body);
        etime.setTypeface(tf_body);
        evenue.setTypeface(tf_body);
        epart.setTypeface(tf_body);
        etype.setTypeface(tf_bar);
        eh1.setTypeface(tf_bar);
        eh2.setTypeface(tf_bar);
        epno1.setTypeface(tf_bar);
        epno2.setTypeface(tf_bar);
        desc.setTypeface(tf_bar);
        rules.setTypeface(tf_bar);
        date.setTypeface(tf_bar);
        time.setTypeface(tf_bar);
        venue.setTypeface(tf_bar);
        participants.setTypeface(tf_bar);


        reach1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Intent.ACTION_DIAL);
                in.setData(Uri.parse("tel:" + epno1.getText().toString()));
                Intent chooser = Intent.createChooser(in, "Choose Dialer...");
                startActivity(chooser);
            }
        });
        reach2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Intent.ACTION_DIAL);
                in.setData(Uri.parse("tel:" + epno2.getText().toString()));
                Intent chooser = Intent.createChooser(in, "Choose Dialer...");
                startActivity(chooser);
            }
        });
    }

}
