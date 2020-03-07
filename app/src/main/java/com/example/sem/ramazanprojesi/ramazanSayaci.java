package com.example.sem.ramazanprojesi;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import java.util.Random;


public class ramazanSayaci extends AppCompatActivity
{

    public static final int[] resimler;
    static {resimler=new int[]{R.drawable.o1,R.drawable.o2,R.drawable.o3,R.drawable.o4};}

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_ramazan_sayaci);

        ImageView imageView=(ImageView) findViewById(R.id.imageView);

        Random rnd=new Random(System.currentTimeMillis());

        imageView.setImageResource(resimler[rnd.nextInt(resimler.length-1)]);

        new Handler().postDelayed(new MyHandler(),2000);
    }

    public class MyHandler implements Runnable
    {
        public MyHandler()
        {

        }

        @Override
        public void run()
        {
            aktiviteyeGit();
        }
    }
    private void aktiviteyeGit()
    {
        Intent intent=new Intent(ramazanSayaci.this,Main2Activity.class);
        startActivity(intent);

        overridePendingTransition(R.anim.iceri,R.anim.disari);
        super.finish();
    }
}


