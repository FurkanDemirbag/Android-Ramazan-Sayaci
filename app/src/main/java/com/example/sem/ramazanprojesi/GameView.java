package com.example.sem.ramazanprojesi;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Sem on 4.05.2018.
 */

public class GameView extends View
{
    OyunEkrani context=(OyunEkrani) getContext();

    private SoundPlayer sound;

    int canvasWidth;
    int canvasHeight;

    Bitmap bird[]=new Bitmap[2];
    int birdX=10;
    int birdY;
    int birdSpeed;

    Bitmap bgImage;
    Paint scorePaint=new Paint();
    int score;
    Paint levelPaint=new Paint();
    Bitmap[] life = new Bitmap[2];
    int lifeCount;
    int levelCount;

    boolean touchFlg=false;

    Bitmap[] gelenCisimler=new Bitmap[2];

    int meteorX;
    int meteorY;
    int meteorSpeed=20;

    int yemX;
    int yemY;
    int yemSpeed=15;


    public GameView(Context context)
    {
        super(context);

        sound=new SoundPlayer(context);

        bird[0]= BitmapFactory.decodeResource(getResources(),R.drawable.bird1);
        bird[1]= BitmapFactory.decodeResource(getResources(),R.drawable.bird2);

        gelenCisimler[0]=BitmapFactory.decodeResource(getResources(),R.drawable.asteroid);
        gelenCisimler[1]=BitmapFactory.decodeResource(getResources(),R.drawable.meteorr);

        bgImage=BitmapFactory.decodeResource(getResources(),R.drawable.uzay);

        scorePaint.setColor(Color.WHITE);
        scorePaint.setTextSize(32);
        scorePaint.setTypeface(Typeface.DEFAULT_BOLD);
        scorePaint.setAntiAlias(true);

        levelPaint.setColor(Color.WHITE);
        levelPaint.setTextSize(32);
        levelPaint.setTypeface(Typeface.DEFAULT_BOLD);
        levelPaint.setTextAlign(Paint.Align.CENTER);
        levelPaint.setAntiAlias(true);

        life[0]=BitmapFactory.decodeResource(getResources(),R.drawable.heart);
        life[1]=BitmapFactory.decodeResource(getResources(),R.drawable.heart_g);


        birdY=500;
        score=0;
        lifeCount=3;
        levelCount=1;


    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        canvasWidth=canvas.getWidth();
        canvasHeight=canvas.getHeight();

        canvas.drawBitmap(bgImage,0,0,null);

        int minBirdY=bird[0].getHeight();
        int maxBirdY=canvasHeight-bird[0].getHeight()*2;

        birdY+=birdSpeed;
        if(birdY<minBirdY)
        {
            birdY=minBirdY;
        }
        if(birdY>maxBirdY)
        {
            birdY=maxBirdY;
        }
        birdSpeed+=2;

        if(touchFlg)
        {
            canvas.drawBitmap(bird[1],birdX,birdY,null);
            touchFlg=false;
        }
        else
        {
            canvas.drawBitmap(bird[0],birdX,birdY,null);
        }


        yemX-=yemSpeed;

        if(hitCheck(yemX,yemY))
        {
            sound.playHitSound();
            score+=10;
            yemX =-100;
        }

        if(yemX<0)
        {
            yemX=canvasWidth+20;
            yemY=(int) Math.floor(Math.random()*(maxBirdY-minBirdY))+minBirdY;
        }
        canvas.drawBitmap(gelenCisimler[1],yemX,yemY,null);


        meteorX-=meteorSpeed;
        if(hitCheck(meteorX,meteorY))
        {
            sound.playOverSound();
            meteorX=-100;
            lifeCount--;
            if(lifeCount==0)
            {
                Intent intent=new Intent(context,OyunSonuEkrani.class);
                intent.putExtra("score",score);
                context.startActivity(intent);
                canvas.drawText("Skor : "+score,20,60,scorePaint);
                score=0;
                levelCount=1;
            }
        }
        if(meteorX<0)
        {
            meteorX=canvasWidth+200;
            meteorY=(int) Math.floor(Math.random()*(maxBirdY-minBirdY))+minBirdY;
        }


        if(score/50==0)
        {
            canvas.drawBitmap(gelenCisimler[0],meteorX,meteorY,null);
            levelCount=1;
        }
        if(score/50==1)
        {
            canvas.drawBitmap(gelenCisimler[0],meteorX,meteorY,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-50,meteorY-250,null);
            levelCount=2;
        }
        if(score/50==2)
        {
            canvas.drawBitmap(gelenCisimler[0],meteorX,meteorY,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-50,meteorY-250,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-25,meteorY-400,null);
            levelCount=3;
        }
        if(score/50==3)
        {
            canvas.drawBitmap(gelenCisimler[0],meteorX,meteorY,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-50,meteorY-200,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-35,meteorY-500,null);
            levelCount=4;
        }
        if(score/50==4)
        {
            canvas.drawBitmap(gelenCisimler[0],meteorX,meteorY,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-50,meteorY-200,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-35,meteorY-500,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-10,meteorY-350,null);

            levelCount=5;
        }
        if(score/50==5)
        {
            canvas.drawBitmap(gelenCisimler[0],meteorX,meteorY,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-50,meteorY-200,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-35,meteorY-500,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-20,meteorY-650,null);
            levelCount=6;
        }
        if(score/50==6)
        {
            canvas.drawBitmap(gelenCisimler[0],meteorX,meteorY,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-50,meteorY-200,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-35,meteorY-500,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-20,meteorY-650,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-05,meteorY-100,null);
            levelCount=7;
        }
        if(score/50==7)
        {
            canvas.drawBitmap(gelenCisimler[0],meteorX,meteorY,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-50,meteorY-200,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-35,meteorY-300,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-20,meteorY-400,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-05,meteorY-100,null);
            levelCount=8;
        }
        if(score/50==8)
        {
            canvas.drawBitmap(gelenCisimler[0],meteorX,meteorY,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-60,meteorY-150,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-50,meteorY-300,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-40,meteorY-450,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-30,meteorY-600,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-20,meteorY-750,null);
            levelCount=9;
        }
        if(score/50==9)
        {
            canvas.drawBitmap(gelenCisimler[0],meteorX,meteorY,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-60,meteorY-150,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-50,meteorY-300,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-40,meteorY-500,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-30,meteorY-650,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-20,meteorY-850,null);
            levelCount=10;
        }
        if(score/50==10)
        {
            canvas.drawBitmap(gelenCisimler[0],meteorX,meteorY,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-05,meteorY-150,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-10,meteorY-300,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-15,meteorY-425,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-30,meteorY-600,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-20,meteorY-800,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-25,meteorY-700,null);
            levelCount=11;
        }
        if(score/50==11)
        {
            canvas.drawBitmap(gelenCisimler[0],meteorX,meteorY,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-05,meteorY-100,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-10,meteorY-200,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-15,meteorY-300,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-30,meteorY-400,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-20,meteorY-500,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-25,meteorY-600,null);
            levelCount=12;
        }
        if(score/50==12)
        {
            canvas.drawBitmap(gelenCisimler[0],meteorX,meteorY,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-80,meteorY-150,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-15,meteorY-245,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-10,meteorY-325,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-50,meteorY-450,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-30,meteorY-550,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-45,meteorY-700,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-25,meteorY-800,null);
            levelCount=13;
        }
        if(score/50==13)
        {
            canvas.drawBitmap(gelenCisimler[0],meteorX,meteorY,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-80,meteorY-900,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-15,meteorY-125,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-10,meteorY-250,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-50,meteorY-450,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-30,meteorY-550,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-45,meteorY-700,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-25,meteorY-800,null);
            levelCount=14;
        }
        if(score/50==14)
        {
            canvas.drawBitmap(gelenCisimler[0],meteorX,meteorY,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-65,meteorY-350,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-80,meteorY-850,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-15,meteorY-150,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-10,meteorY-275,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-50,meteorY-375,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-30,meteorY-475,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-45,meteorY-575,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-25,meteorY-675,null);

            levelCount=15;
        }
        if(score/50==15)
        {
            canvas.drawBitmap(gelenCisimler[0],meteorX,meteorY,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-65,meteorY-900,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-80,meteorY-800,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-15,meteorY-700,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-10,meteorY-600,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-50,meteorY-500,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-30,meteorY-400,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-45,meteorY-300,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-75,meteorY-200,null);
            levelCount=16;
        }
        if(score/50==16)
        {
            canvas.drawBitmap(gelenCisimler[0],meteorX,meteorY,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-50,meteorY-100,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-65,meteorY-900,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-80,meteorY-800,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-15,meteorY-700,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-10,meteorY-600,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-50,meteorY-500,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-30,meteorY-400,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-45,meteorY-300,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-75,meteorY-200,null);
            levelCount=17;
        }
        if(score/50==17)
        {
            canvas.drawBitmap(gelenCisimler[0],meteorX,meteorY,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-50,meteorY-150,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-65,meteorY-250,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-80,meteorY-350,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-15,meteorY-450,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-10,meteorY-550,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-50,meteorY-645,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-30,meteorY-750,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-45,meteorY-850,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-75,meteorY-950,null);
            levelCount=18;
        }
        if(score/50==18)
        {
            canvas.drawBitmap(gelenCisimler[0],meteorX,meteorY,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-10,meteorY-670,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-50,meteorY-925,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-65,meteorY-850,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-80,meteorY-725,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-15,meteorY-625,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-10,meteorY-525,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-50,meteorY-450,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-30,meteorY-325,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-45,meteorY-225,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-75,meteorY-125,null);
            levelCount=19;
        }
        if(score/50==19)
        {
            canvas.drawBitmap(gelenCisimler[0],meteorX,meteorY,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-10,meteorY-950,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-50,meteorY-850,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-65,meteorY-750,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-80,meteorY-650,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-15,meteorY-550,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-10,meteorY-450,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-50,meteorY-350,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-30,meteorY-250,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-45,meteorY-150,null);
            canvas.drawBitmap(gelenCisimler[0],meteorX-75,meteorY-50,null);
            levelCount=20;
        }

        canvas.drawText("Skor : "+score,20,60,scorePaint);

        canvas.drawText("Level : "+levelCount,canvasWidth/2,60,levelPaint);


        for(int i=0; i<3; i++)
        {
            int x=(int) (760+life[0].getWidth()*1.5*i);
            int y=30;

            if(i<lifeCount)
            {
                canvas.drawBitmap(life[0],x,y,null);
            }
            else
            {
                canvas.drawBitmap(life[1],x,y,null);
            }
        }

    }

    public boolean hitCheck(int x, int y)
    {
        if(birdX < x && x < (birdX+bird[0].getWidth()) &&  birdY < y && y < (birdY+bird[0].getHeight()))
        {
            return true;
        }
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        if(event.getAction()==MotionEvent.ACTION_DOWN)
        {
            touchFlg=true;
            birdSpeed=-20;
        }

        return true;
    }

}
