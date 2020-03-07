package com.example.sem.ramazanprojesi;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class muzikActivity extends AppCompatActivity
{

    public static MediaPlayer player1,player2,player3,player4,player5;
    boolean bayrak = false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_muzik);

        player1=MediaPlayer.create(muzikActivity.this,R.raw.beethoven);
        player2=MediaPlayer.create(muzikActivity.this,R.raw.mozart);
        player3=MediaPlayer.create(muzikActivity.this,R.raw.thehunt);
        player4=MediaPlayer.create(muzikActivity.this,R.raw.fairytail);
        player5=MediaPlayer.create(muzikActivity.this,R.raw.onepiece);


        ImageView geriDon=(ImageView) findViewById(R.id.geriDon);
        geriDon.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent1 = new Intent(muzikActivity.this,Main2Activity.class);
                startActivity(intent1);
            }
        });

        ImageView bethovenMuzikBaslat=(ImageView) findViewById(R.id.bethovenMuzikBaslat);
        bethovenMuzikBaslat.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                player1.setLooping(true);
                player1.setVolume(4.0f,4.0f);
                player1.start();

                bayrak=true;

                if(bayrak==true)
                {
                    if(player2.isPlaying()) {
                        player2.pause();
                    }
                    if(player3.isPlaying()){
                        player3.pause();
                    }
                    if(player4.isPlaying()){
                        player4.pause();
                    }
                    if(player5.isPlaying()){
                        player5.pause();
                    }
                    bayrak = false;
                }

            }
        });

        ImageView bethovenMuzikDurdur=(ImageView) findViewById(R.id.bethovenMuzikDurdur);
        bethovenMuzikDurdur.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                player1.pause();
            }
        });

        ImageView mozartMuzikBaslat=(ImageView) findViewById(R.id.mozartMuzikBaslat);
        mozartMuzikBaslat.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                player2.setLooping(true);
                player2.setVolume(4.0f,4.0f);
                player2.start();

                bayrak=true;

                if(bayrak==true)
                {
                    if(player1.isPlaying()) {
                        player1.pause();
                    }
                    if(player3.isPlaying()){
                        player3.pause();
                    }
                    if(player4.isPlaying()){
                        player4.pause();
                    }
                    if(player5.isPlaying()){
                        player5.pause();
                    }
                    bayrak = false;
                }

            }
        });

        ImageView mozartMuzikDurdur=(ImageView) findViewById(R.id.mozartMuzikDurdur);
        mozartMuzikDurdur.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                player2.pause();
            }
        });

        ImageView thehuntMuzikBaslat=(ImageView) findViewById(R.id.thehuntMuzikBaslat);
        thehuntMuzikBaslat.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                player3.setLooping(true);
                player3.setVolume(4.0f,4.0f);
                player3.start();

                bayrak=true;

                if(bayrak==true)
                {
                    if(player2.isPlaying()) {
                        player2.pause();
                    }
                    if(player1.isPlaying()){
                        player1.pause();
                    }
                    if(player4.isPlaying()){
                        player4.pause();
                    }
                    if(player5.isPlaying()){
                        player5.pause();
                    }
                    bayrak = false;
                }

            }
        });

        ImageView thehuntMuzikDurdur=(ImageView) findViewById(R.id.thehuntMuzikDurdur);
        thehuntMuzikDurdur.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                player3.pause();
            }
        });

        ImageView fairytailMuzikBaslat=(ImageView) findViewById(R.id.fairytailMuzikBaslat);
        fairytailMuzikBaslat.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                player4.setLooping(true);
                player4.setVolume(4.0f,4.0f);
                player4.start();

                bayrak=true;

                if(bayrak==true)
                {
                    if(player2.isPlaying()) {
                        player2.pause();
                    }
                    if(player3.isPlaying()){
                        player3.pause();
                    }
                    if(player1.isPlaying()){
                        player1.pause();
                    }
                    if(player5.isPlaying()){
                        player5.pause();
                    }
                    bayrak = false;
                }

            }
        });

        ImageView fairytailMuzikDurdur=(ImageView) findViewById(R.id.fairytailMuzikDurdur);
        fairytailMuzikDurdur.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                player4.pause();
            }
        });

        ImageView onepieceMuzikBaslat=(ImageView) findViewById(R.id.onepieceMuzikBaslat);
        onepieceMuzikBaslat.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                player5.setLooping(true);
                player5.setVolume(4.0f,4.0f);
                player5.start();

                bayrak=true;

                if(bayrak==true)
                {
                    if(player2.isPlaying()) {
                        player2.pause();
                    }
                    if(player3.isPlaying()){
                        player3.pause();
                    }
                    if(player4.isPlaying()){
                        player4.pause();
                    }
                    if(player1.isPlaying()){
                        player1.pause();
                    }
                    bayrak = false;
                }

            }
        });

        ImageView onepieceMuzikDurdur=(ImageView) findViewById(R.id.onepieceMuzikDurdur);
        onepieceMuzikDurdur.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                player5.pause();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();

        if(player1.isPlaying()) {
           player1.pause();
           player1.start();
        }
        if(player2.isPlaying()) {
            player2.pause();
            player2.start();
        }
        if(player3.isPlaying()){
            player3.pause();
            player3.start();
        }
        if(player4.isPlaying()){
            player4.pause();
            player4.start();
        }
        if(player5.isPlaying()){
            player5.pause();
            player5.start();
        }

        // Intent intent  = new Intent(getApplicationContext(), muzikActivity.this);

        //ActivityCompat.finishAffinity(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        /*if(player1.isPlaying()) {
            player1.pause();
        }
        if(player2.isPlaying()) {
            player2.pause();
        }
        if(player3.isPlaying()){
            player3.pause();
        }
        if(player4.isPlaying()){
            player4.pause();
        }
        if(player5.isPlaying()){
            player5.pause();
        }*/
    }
}
