package com.example.sem.ramazanprojesi;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by Sem on 7.03.2018.
 */

public class CustomListAdapter extends BaseAdapter
{

    Activity act;
    int[] resimlerr;
    String[] sehirler;

    public CustomListAdapter(Activity act,String[] sehirler,int[] resimlerr)
    {
        this.act=act;
        this.sehirler=sehirler;
        this.resimlerr=resimlerr;
    }


    @Override
    public int getCount()
    {
        return sehirler.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        LayoutInflater inflater=act.getLayoutInflater();
        View satir=inflater.inflate(R.layout.sehirlistesi,null,true);

        ImageView img=(ImageView) satir.findViewById(R.id.img);
        TextView tx=(TextView) satir.findViewById(R.id.txSehir);

        img.setImageResource(resimlerr[i]);
        tx.setText(sehirler[i]);

        return satir;


    }

}
