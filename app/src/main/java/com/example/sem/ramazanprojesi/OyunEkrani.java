package com.example.sem.ramazanprojesi;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import java.util.Timer;
import java.util.TimerTask;

public class OyunEkrani extends AppCompatActivity
{
    GameView gameView;
    Handler handler=new Handler();
    final static long TIMER_INTERVAL=30;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_oyun_ekrani);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        gameView=new GameView(this);
        setContentView(gameView);


        Timer timer =new Timer();
        timer.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                handler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        gameView.invalidate();
                    }
                });
            }
        },0,TIMER_INTERVAL);
    }
}
