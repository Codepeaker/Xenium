package parikalan.xenium;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import parikalan.xenium.adapters.AdapterList;
import parikalan.xenium.dataValues.Information;

public class RegisteredEvents extends Fragment {

    AdapterList eventadapter;
    ArrayList name;
    private OnFragmentInteractionListener mListener;

    public RegisteredEvents() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        name = new ArrayList();
        ArrayList ename = new ArrayList(), uid = new ArrayList(), nop = new ArrayList(), venue = new ArrayList(), time = new ArrayList();
        try {
            SQLiteDatabase db = getContext().openOrCreateDatabase("Xenium16", Context.MODE_PRIVATE, null);
            db.execSQL("create table if not exists reg (id varchar,name varchar,event varchar,nop varchar)");
            Cursor c = db.rawQuery("select * from reg", null);
            if (c.moveToFirst()) {
                do {
                    name.add(c.getString(1));
                    uid.add(c.getString(0));
                    ename.add(c.getString(2));
                    nop.add(c.getString(3));
                    time.add(Information.getTimeonly(c.getString(2),getContext()));
                    venue.add(Information.getvenueonly(c.getString(2),getContext()));
                }
                while (c.moveToNext());
            }
            db.close();
        } catch (Exception e) {
        }
        eventadapter = new AdapterList(getActivity(), name, ename, nop, uid, venue, time);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_registered, container, false);
        RecyclerView eventlist = (RecyclerView) layout.findViewById(R.id.registeredlist);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        eventlist.setLayoutManager(llm);
        eventlist.setAdapter(eventadapter);
        if (name.size() == 0) {
            TextView tv = (TextView) layout.findViewById(R.id.tv);
            tv.setVisibility(View.VISIBLE);
            Typeface tf_heading = Typeface.createFromAsset(getActivity().getAssets(), "kushan.otf");
            tv.setTypeface(tf_heading);
        }
        return layout;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
