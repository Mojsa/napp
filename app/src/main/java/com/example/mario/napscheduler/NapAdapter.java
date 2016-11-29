package com.example.mario.napscheduler;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.provider.AlarmClock;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.joda.time.DateTime;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Mario on 14.11.2016..
 */

public class NapAdapter extends RecyclerView.Adapter<NapViewHolder> {

    private List<NapInfo> mNapInfos;
    private Random rand= new Random(254);

    public NapAdapter(List<NapInfo> napInfos) {
        this.mNapInfos = napInfos;
    }

    @Override
    public NapViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.nap_card_view, parent, false);
        return new NapViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(NapViewHolder holder, final int position) {
        final NapInfo ni = mNapInfos.get(position);
        final Context context = holder.itemView.getContext();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = createAlarmIntent(context, ni);
                if(i.resolveActivity(context.getPackageManager()) != null){
                    context.startActivity(i);
                }else{
                    Log.d("ALARM_NOT_FOUND", "Alarm app not found?");
                }

            }
        });
        holder.vName.setText(ni.name);
        holder.vDuration.setText(ni.duration);
        holder.vInfo.setText(ni.info);
        holder.vImageView.setImageBitmap(NapInfo.decodeSampledBitmapFromResource(context.getResources(), ni.mImage, holder.vImageView.getLayoutParams().width, holder.vImageView.getLayoutParams().height));
        holder.vImageView.setVisibility(View.VISIBLE);
    }

    @Override
    public int getItemCount() {
        return mNapInfos.size();
    }

    private Intent createAlarmIntent(Context context, NapInfo ni){
        Intent i = new Intent(AlarmClock.ACTION_SET_ALARM);
        DateTime dateTime = DateTime.now();
        DateTime alarmDateTime;
        if(ni.duration.equalsIgnoreCase(context.getString(R.string.nap_1_duration))){
            alarmDateTime = dateTime.plusMinutes(randInt(10,20));
        }else if(ni.duration.equalsIgnoreCase(context.getString(R.string.nap_2_duration))){
            alarmDateTime = dateTime.plusMinutes(randInt(20,30));
        }else if(ni.duration.equalsIgnoreCase(context.getString(R.string.nap_3_duration))){
            alarmDateTime = dateTime.plusMinutes(randInt(30,60));
        }else if(ni.duration.equalsIgnoreCase(context.getString(R.string.nap_4_duration))){
            alarmDateTime = dateTime.plusMinutes(randInt(60,90));
        }else{
            alarmDateTime = dateTime.plusMinutes(randInt(90,120));
        }
        i.putExtra(AlarmClock.EXTRA_MESSAGE, ni.name);
        i.putExtra(AlarmClock.EXTRA_HOUR, alarmDateTime.getHourOfDay());
        i.putExtra(AlarmClock.EXTRA_MINUTES, alarmDateTime.getMinuteOfHour());
        i.putExtra(AlarmClock.EXTRA_SKIP_UI, true);
        return i;
    }

    public int randInt(int min, int max){
        int currentApiVersion = Build.VERSION.SDK_INT;
        if(currentApiVersion >= Build.VERSION_CODES.LOLLIPOP){
            //lollipop
            return ThreadLocalRandom.current().nextInt(min, max +1);
        }else{
            return rand.nextInt((max -min) +1) +min;
        }
    }
}
