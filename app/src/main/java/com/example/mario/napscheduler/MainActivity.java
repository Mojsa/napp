package com.example.mario.napscheduler;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recList = (RecyclerView) findViewById(R.id.cardList);
        recList.hasFixedSize();
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);

        NapAdapter na = new NapAdapter(createList());
        recList.setAdapter(na);

        /*
        ImageView image_id = (ImageView)findViewById(R.id.ImageID);
        image_id.setScaleType(ImageView.ScaleType.CENTER_CROP);
         */
    }

    private List<NapInfo> createList(){
        List<NapInfo> result = new ArrayList<>();
        NapInfo n = new NapInfo();
        n.duration= getString(R.string.nap_1_duration);
        n.name = getString(R.string.nap_1_name);
        n.info = getString(R.string.nap_1_info);
        //n.mImage = BitmapFactory.decodeResource(getResources(), R.drawable.powernap);
        //n.mImage = decodeSampledBitmapFromResource(getResources(),R.drawable.powernap, 130, 130);
        n.mImage = R.drawable.powernap;
        result.add(n);

        NapInfo bla = new NapInfo();
        bla.duration = getString(R.string.nap_2_duration);
        bla.name = getString(R.string.nap_2_name);
        bla.info = getString(R.string.nap_2_info);
        bla.mImage = R.drawable.sosonap;
        result.add(bla);

        NapInfo mbn = new NapInfo();
        mbn.duration = getString(R.string.nap_3_duration);
        mbn.name = getString(R.string.nap_3_name);
        mbn.info = getString(R.string.nap_3_info);
        mbn.mImage = R.drawable.memoryboostnap;
        result.add(mbn);

        NapInfo tpn = new NapInfo();
        tpn.name = getString(R.string.nap_4_name);
        tpn.duration = getString(R.string.nap_4_duration);
        tpn.info = getString(R.string.nap_4_info);
        tpn.mImage = R.drawable.perfectnap;
        result.add(tpn);

        NapInfo plcn = new NapInfo();
        plcn.name = getString(R.string.nap_5_name);
        plcn.duration = getString(R.string.nap_5_duration);
        plcn.info = getString(R.string.nap_5_info);
        plcn.mImage = R.drawable.poorlifechoice;
        result.add(plcn);
        return result;
    }



}
