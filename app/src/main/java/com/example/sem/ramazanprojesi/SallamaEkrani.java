package com.example.sem.ramazanprojesi;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.Image;
import android.os.Build;
import android.os.Vibrator;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

@RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
public class SallamaEkrani extends AppCompatActivity implements SensorEventListener
{
    boolean sallama=false;
    ImageView geriDonus;
    TextView tx1,tx2,tx3,tx4;
    Button btnOzellikleriGetir;
    long simdiki,oncesi;
    int sefer = 1;
    SensorManager sManager;
    Vibrator vb;

    float last_x=0;
    float last_y=0;
    float last_z=0;

    String ugurluEsyalar[]={"Eğurlu Eşyan ; Kalem","Eğurlu Eşyan ; Kolye","Eğurlu Eşyan ; Çakıl Taşı","Eğurlu Eşyan ; Tırnak Makası",
            "Eğurlu Eşyan ; Yüzük","Eğurlu Eşyan ; Çatal","Eğurlu Eşyan ; Nazar Boncuğu",
            "Eğurlu Eşyan ; Eski Para","Eğurlu Eşyan ; Çakmak","Eğurlu Eşyan ; At Nalı"};

    String evlilik[]={"27 Yaşında Evleniceksin","24 Yaşında Aşık Olucaksın","30 Yaşında Nişanlancaksın","29 Yaşında Sözlenceksin",
            "31 Yaşında Yeniden Evleniceksin","33 Yaşında Boşanıcaksın","28 Yaşında Tekrardan Aşık Olucaksın",
            "26 Yaşında Evleniceksin","33 Yaşında Çocuğun Olucak","35 Yaşında Boşanıcaksın"};

    String zenginlik[]={"Çok Zengin Olucaksın","Orta Derecede Hayatın Olucak","Zorluklar Çekip , Güzelliklere Kavuşucaksın",
            "İyi Bir Eşin Olucak","Araban Olucak","Çocukların çok Yaramaz Olucak","Zengin ve Çok Mutlu Olucaksın",
            "Herkesi Kıskandıran Hayatın Olucak","Zorluklara Yüzleşip Üstesinden Geleceksin","Krallara Yakışır Hayatın Olucak"};

    String olumler[]={"Ölüm Tarihin ; 29 Mayıs 2023 - Saat 12:32","Ölüm Tarihin ; 28 Temmuz 2022 - Saat 10:03",
            "Ölüm Tarihin ; 05 Ocak 2048 - Saat 23:54", "Ölüm Tarihin ; 17 Ağustos 2041- Saat 15:01",
            "Ölüm Tarihin ; 23 Mart 2034 - Saat 07:23", "Ölüm Tarihin ; 23 Eylül 2037 - Saat 13:37",
            "Ölüm Tarihin ; 14 Nisan 2071 - Saat 09:30", "Ölüm Tarihin ; 31 Ekim 2029 - Saat 16:46",
            "Ölüm Tarihin ; 12 Haziran 2053 - Saat 18:45", "Ölüm Tarihin ; 01 Aralık 2032 - Saat 20:47"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sallama_ekrani);

        sManager=(SensorManager) getSystemService(Context.SENSOR_SERVICE);
        vb=(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        sManager.registerListener(this, sManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);



        geriDonus=(ImageView) findViewById(R.id.geriDonus);
        tx1=(TextView) findViewById(R.id.tx1);
        tx2=(TextView) findViewById(R.id.tx2);
        tx3=(TextView) findViewById(R.id.tx3);
        tx4=(TextView) findViewById(R.id.tx4);
        btnOzellikleriGetir=(Button) findViewById(R.id.btnOzellikleriGetir);

        geriDonus.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent=new Intent(SallamaEkrani.this,Main2Activity.class);
                startActivity(intent);
            }
        });

        btnOzellikleriGetir.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                final AlertDialog.Builder builder = new AlertDialog.Builder(SallamaEkrani.this);
                builder.setTitle("Şansına Güveniyorsan Dene");
                builder.setMessage("Şansını Denemek istiyorsan Evet e Bastıktan sonra Telefonu Salla fakat bir sonraki şansın için 2 dakika beklemen gerekiyor :)");
                builder.setPositiveButton("Evet, Hemen Dene", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        dialogInterface.dismiss();
                        sallama=true;
                        simdiki = System.currentTimeMillis();
                    }
                });

                builder.setNegativeButton("Uygulamaya Geri Dön ", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        Intent intent=new Intent(SallamaEkrani.this,Main2Activity.class);
                        startActivity(intent);
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


    }

    @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
    @Override
    public void onSensorChanged(SensorEvent event)
    {   if(sallama) {
          if(sefer > 0) {
              Random rnd = new Random(System.currentTimeMillis());

              if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
                  float x = event.values[0];
                  float y = event.values[1];
                  float z = event.values[2];

                  if (z * last_z < 0) {
                      vb.vibrate(300);
                      tx1.setVisibility(View.VISIBLE);
                      tx1.setText(ugurluEsyalar[rnd.nextInt(ugurluEsyalar.length - 1)]);
                      tx2.setVisibility(View.VISIBLE);
                      tx2.setText(evlilik[rnd.nextInt(evlilik.length - 1)]);
                      tx3.setVisibility(View.VISIBLE);
                      tx3.setText(zenginlik[rnd.nextInt(zenginlik.length - 1)]);
                      tx4.setVisibility(View.VISIBLE);
                      tx4.setText(olumler[rnd.nextInt(olumler.length - 1)]);

                      btnOzellikleriGetir.setVisibility(View.INVISIBLE);
                      sefer = sefer -1;
                  }
                  last_x = x;
                  last_y = y;
                  last_z = z;
              }

          }

          long gecen = System.currentTimeMillis() - simdiki;
                  if (gecen > 120000)
                  {
                      sefer = 1;
                      simdiki = System.currentTimeMillis();

                  }
      }
    }
    @Override
    protected void onPause()
    {
        super.onPause();
        sManager.unregisterListener(this);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i)
    {

    }
}
