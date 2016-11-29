package com.example.mario.napscheduler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Mario on 14.11.2016..
 */

public class NapViewHolder extends RecyclerView.ViewHolder {
    protected TextView vName;
    protected TextView vDuration;
    protected ImageView vImageView;
    protected TextView vInfo;

    public NapViewHolder(View view) {
        super(view);
        vName = (TextView) view.findViewById(R.id.title);
        vDuration = (TextView) view.findViewById(R.id.duration);
        vImageView = (ImageView) view.findViewById(R.id.image_nap);
        vImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        vInfo = (TextView) view.findViewById(R.id.info);
    }
}
