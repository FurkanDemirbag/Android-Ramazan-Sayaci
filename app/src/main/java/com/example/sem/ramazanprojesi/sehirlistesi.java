package com.example.sem.ramazanprojesi;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import me.anwarshahriar.calligrapher.Calligrapher;

/**
 * Created by Sem on 7.03.2018.
 */

public class sehirlistesi extends Activity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.sehirlistesi);
        super.onCreate(savedInstanceState);

        TextView txSehir;
        txSehir=(TextView) findViewById(R.id.txSehir);

        Typeface type = Typeface.createFromAsset(getAssets(),"fonts/avefedan.ttf");
        txSehir.setTypeface(type);


    }
}
