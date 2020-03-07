package com.example.sem.ramazanprojesi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import java.util.List;

public class ayarlarEkrani extends AppCompatActivity
{

    LokasyonVeriTabani vt = new LokasyonVeriTabani(ayarlarEkrani.this);
    ImageView geriDonn;
    Spinner spLokasyon;
    Switch swIftar,swSahur;
    Button btnAyarlariKaydet;
    List<String> sahurDurumu,iftarDurumu;


    String[] sehir={"...","Adana","Adıyaman","Afyon","Ağrı","Amasya","Ankara",
            "Antalya","Artvin","Aydın","Balıkesir","Bilecik","Bingöl","Bitlis","Bolu","Burdur","Bursa",
            "Çanakkale","Çankırı","Çorum","Denizli","Diyarbakır","Edirne","Elazığ","Erzincan","Erzurum",
            "Eskişehir","Gaziantep","Giresun","Gümüşhane","Hakkari","Hatay","Isparta","Mersin","İstanbul",
            "İzmir","Kars","Kastamonu","Kayseri","Kırklareli","Kırşehir","Kocaeli","Konya","Kütahya","Malatya","Manisa",
            "Maraş","Mardin","Muğla","Muş","Nevşehir","Niğde","Ordu","Rize","Sakarya","Samsun","Siirt",
            "Sinop","Sivas","Tekirdağ","Tokat","Trabzon","Tunceli","Şanlıurfa","Uşak","Van","Yozgat","Zonguldak","Aksaray",
            "Bayburt","Karaman","Kırıkkale","Batman","Şırnak","Bartın","Ardahan","Iğdır","Yalova","Karabük","Kilis",
            "Osmaniye","Düzce"};


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_ayarlar_ekrani);


        spLokasyon=(Spinner)findViewById(R.id.spLokasyon);
        swIftar=(Switch)findViewById(R.id.swIftar);
        swSahur=(Switch)findViewById(R.id.swSahur);
        btnAyarlariKaydet=(Button)findViewById(R.id.btnAyarlariKaydet);
        geriDonn=(ImageView)findViewById(R.id.geriDonn);

        sahurDurumu = vt.sahurSorgusu();
        iftarDurumu = vt.iftarSorgusu();

        if (sahurDurumu.size() > 0)
        {
            if (sahurDurumu.get(0).equals("true"))
            {
                swSahur.setChecked(true);
            }
            else
            {
                swSahur.setChecked(false);
            }

        }

        if (iftarDurumu.size() > 0)
        {
            if (iftarDurumu.get(0).equals("true"))
            {
                swIftar.setChecked(true);
            }
            else
            {
                swIftar.setChecked(false);
            }
        }


        ArrayAdapter<String> sehirler=new ArrayAdapter<String>(ayarlarEkrani.this,android.R.layout.simple_spinner_dropdown_item,sehir);
        spLokasyon.setAdapter(sehirler);

        List<String> lokasyon = vt.lokasyonSorgusu();
        int yerimi = 0;
        if(lokasyon.size()>0)
        {
             for(int i=0 ; i < sehir.length; i++)
             {
                   if(sehir[i].equals(lokasyon.get(0)))
                   {
                        yerimi =  i;
                   }
             }
        }
        spLokasyon.setSelection(yerimi);

        spLokasyon.setBackgroundColor(Color.WHITE);
        spLokasyon.setGravity(Gravity.CENTER);





        geriDonn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent=new Intent(ayarlarEkrani.this,Main2Activity.class);
                startActivity(intent);
            }
        });

        swIftar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {

                if(swIftar.isChecked())
                {
                    vt.iftarAlarmEkle("true");
                }
                else
                {
                    vt.iftarTablosuTemizle("true");
                }
            }
        });

        swSahur.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                if(swSahur.isChecked())
                {
                    vt.sahurAlarmEkle("true");
                }
                else
                {
                    vt.sahurTablosuTemizle("true");
                }
            }
        });

        btnAyarlariKaydet.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                vt.lokasyonEkle(spLokasyon.getSelectedItem().toString());

                Toast.makeText(ayarlarEkrani.this,"Ayarlarınız Başarıyla Kaydedilmiştir.", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
