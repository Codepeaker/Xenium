package parikalan.xenium.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import parikalan.xenium.animations.AnimationUtils;
import parikalan.xenium.R;

/**
 * Created by akansh on 3/6/2016.
 */
public class AdapterList extends RecyclerView.Adapter<AdapterList.MyeventViewHolder> {

    ArrayList name,ename,nop,uid,time,venue;
    private int mPreviousPosition = 0;
    private LayoutInflater inflater;
    private View view;

    public AdapterList(Context context, ArrayList name, ArrayList ename, ArrayList nop, ArrayList uid, ArrayList time, ArrayList venue) {
        inflater = LayoutInflater.from(context);
        this.name=name;
        this.ename=ename;
        this.uid=uid;
        this.nop=nop;
        this.venue=venue;
        this.time=time;
    }

    @Override
    public MyeventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = inflater.inflate(R.layout.custom_registeredview, parent, false);
        return new MyeventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterList.MyeventViewHolder holder, int position) {
        holder.name.setText(name.get(position)+"");
        holder.ename.setText(ename.get(position) + "");
        holder.uid.setText(uid.get(position) + "");
        holder.nop.setText(nop.get(position)+" members");
        holder.venue.setText(venue.get(position)+"");
        holder.time.setText(time.get(position)+"");
        holder.date.setText("11 March");

        if (position > mPreviousPosition) {
            AnimationUtils.animateSunblind(holder, true);
        } else {
            AnimationUtils.animateSunblind(holder, false);
        }
        mPreviousPosition = position;

    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    class MyeventViewHolder extends RecyclerView.ViewHolder {

        TextView name,ename,nop,uid,time,date,venue;

        public MyeventViewHolder(View itemView) {
            super(itemView);
            name= (TextView) itemView.findViewById(R.id.name);
            ename= (TextView) itemView.findViewById(R.id.ename);
            uid= (TextView) itemView.findViewById(R.id.uid);
            nop= (TextView) itemView.findViewById(R.id.nop);
            time= (TextView) itemView.findViewById(R.id.time);
            date= (TextView) itemView.findViewById(R.id.date);
            venue= (TextView) itemView.findViewById(R.id.venue);
        }
    }
}