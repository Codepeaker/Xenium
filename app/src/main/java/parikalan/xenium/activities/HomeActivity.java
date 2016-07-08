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

import parikalan.xenium.R;


public class HomeActivity extends AppCompatActivity {

    TextView tvdesc1, tvdesc2, n1, p1, tvreachus, tvmail, tvsite,parikalan;
    LinearLayout reach1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(HomeActivity.this, RegisterActivity.class);
                startActivity(in);
            }
        });

        TextView ename = (TextView) findViewById(R.id.event_name);
        ename.setText("Xenium 16.0");
        tvdesc1 = (TextView) findViewById(R.id.aaghazinfo1);
        tvdesc2 = (TextView) findViewById(R.id.aaghazinfo2);
        tvreachus = (TextView) findViewById(R.id.reachus);
        parikalan = (TextView) findViewById(R.id.parikalan);
        tvmail = (TextView) findViewById(R.id.mail);
        tvsite = (TextView) findViewById(R.id.site);
        n1 = (TextView) findViewById(R.id.name1);
        p1 = (TextView) findViewById(R.id.no1);
        reach1 = (LinearLayout) findViewById(R.id.reach1);

        tvdesc1.setText("The Annual Technical Festival of PGDAV College, University of Delhi.\n" +
                "The Annual Festival “Xenium” is package of various competitions that would exhibit and pit against each other best minds and talents from different colleges and universities in the field of IT. It promises everyone their share of fun, entertainment and opportunities. The event gets the maximum media coverage from both local and national media. Diverse events in the fields of Technology are held during the festival. The event will be marked with cash prizes, goodies and rolling Trophies. \n" +
                "It has a very simple objective – To create a launch pad for the students of computer science around, so that they can get an experience of not only the varied spheres of computer science but to also showcase their talents and compete against others.\n" +
                "It encompasses all the spheres of IT and gives a platform to foster the brilliance inside these talented students. Here we endeavor to generate a Utopian virtual world, so that we can together weave a modern world of technology. Each and every member strives to create magic with their skills and thus, have our fest caption “Coding Logic, Creating Magic”. \n" +
                "The fest caption for Xenium 16.0 is “Coding Logic, Creating Magic\" and as we hit the stage with the most awaited brain bursting technical events, we promise to create a launch pad for the students with technical knowledge around, like never before!\n" +
                "So all the techie out there, brace yourself!");
        tvdesc2.setText("PARIKALAN is Computer Science Society of PGDAV College with motto of Personality development of students and to Boost the knowledge of all technically inclined students. Parikalan provides a productive space to anyone who wishes to manifest his/her ideas through the mediums of “Computer Logic”.\n" +
                "Society currently headed by President Anshul Narula and Head of  Department Mrs. Arpita Agarwal work more as a cooperative where everyone pool in and share their talents and knowledge of computer science. From Workshops to competitions encompassing Web    development, Quiz, coding and much more. The “Student Chapter Board” is constantly updated with weekly Brain Buster Quizzes. Parikalan takes new innovative ideas from the students and brings them to fruition and develops students into tech giants of tomorrow.\n" +
                "\n" +
                "Parikalan has individual departments to handle distinct tasks:-\n" +
                "\n" +
                "Flight into Fantasy:-\n" +
                "The aim of flight into fantasy is to introduce new technological innovations to the students of Computer Science department. Flight into fantasy focuses on providing new technological advancements and information as well as bringing out the best work from students. \n" +
                "\n" +
                "Coding :-\n" +
                "Coding department is the heart of Parikalan where all different aspects of computer programming are used to develop computer application and softwares.\n" +
                "\n" +
                "Promotions:-\n" +
                "Promotions department of Parikalan ensure to promote the society and its students to provide them with better exposures and create a name for themselves.\n" +
                "\n" +
                "Workshop:-\n" +
                "Workshop departments’ sole aim is to provide knowledge to students by conducting various seminars and workshops on interesting and technological topics. \n" +
                "\n" +
                "Quiz:-\n" +
                "The aim of Quiz department is to make student understand the importance of academic oriented general knowledge and at the same time to encourage students to look beyond their textual knowledge and establish a relationship between theory and practicality of the learnt concepts.");

        tvmail.setText("Mail Us at anshul.narula@parikalan.com");
        tvsite.setText("www.parikalan.com");
        n1.setText("Anshul Narula");
        p1.setText("9999678876");

        Typeface tf_heading = Typeface.createFromAsset(getAssets(), "kushan.otf");
        Typeface tf_body = Typeface.createFromAsset(getAssets(), "sofia.otf");
        Typeface tf_bar = Typeface.createFromAsset(getAssets(), "lobster.otf");
        tvreachus.setTypeface(tf_bar);
        parikalan.setTypeface(tf_bar);
        tvdesc1.setTypeface(tf_heading);
        tvdesc2.setTypeface(tf_heading);
        tvsite.setTypeface(tf_heading);
        tvmail.setTypeface(tf_heading);
        ename.setTypeface(tf_heading);
        n1.setTypeface(tf_heading);
        p1.setTypeface(tf_body);

        reach1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Intent.ACTION_DIAL);
                in.setData(Uri.parse("tel:" + p1.getText().toString()));
                Intent chooser = Intent.createChooser(in, "Choose Dialer...");
                startActivity(chooser);
            }
        });

        tvmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "anshul.narula@parikalan.com", null));
                in.putExtra(Intent.EXTRA_SUBJECT, "Aaghaz'16 Enquiry");
                Intent chooser = Intent.createChooser(in, "Mail through...");
                startActivity(chooser);
            }
        });

        tvsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Intent.ACTION_VIEW);
                in.setData(Uri.parse("http://www.parikalan.com"));
                Intent chooser = Intent.createChooser(in, "Open Link through...");
                startActivity(chooser);
            }
        });
    }

}
