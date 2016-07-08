package parikalan.xenium.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.Collections;
import java.util.List;

import parikalan.xenium.animations.AnimationUtils;
import parikalan.xenium.dataValues.Information;
import parikalan.xenium.R;

/**
 * Created by vishal on 1/16/2016.
 */
public class AdapterEvent extends RecyclerView.Adapter<AdapterEvent.MyeventViewHolder> {

    List<Information> data = Collections.emptyList();
    private int mPreviousPosition = 0;
    private LayoutInflater inflater;
    private View view;

    public AdapterEvent(Context context, List<Information> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public MyeventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = inflater.inflate(R.layout.custom_eventview, parent, false);
        return new MyeventViewHolder(view);

    }

    @Override
    public void onBindViewHolder(AdapterEvent.MyeventViewHolder holder, int position) {
        final Information current = data.get(position);
        holder.icon.setImageResource(current.iconId);

        if (position > mPreviousPosition) {
            AnimationUtils.animateSunblind(holder, true);
        } else {
            AnimationUtils.animateSunblind(holder, false);
        }
        mPreviousPosition = position;

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyeventViewHolder extends RecyclerView.ViewHolder {

        ImageView icon;

        public MyeventViewHolder(View itemView) {
            super(itemView);
            icon = (ImageView) itemView.findViewById(R.id.eventlistimage);
        }
    }
}
