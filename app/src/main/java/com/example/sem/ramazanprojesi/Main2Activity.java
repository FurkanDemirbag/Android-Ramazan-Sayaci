package com.example.sem.ramazanprojesi;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import me.anwarshahriar.calligrapher.Calligrapher;


public class Main2Activity extends AppCompatActivity {


    String[] sehirler = {"Tokat","Kocaeli", "Adana","Adıyaman","Afyon","Ağrı","Amasya","Ankara",
            "Antalya","Artvin","Aydın","Balıkesir","Bilecik","Bingöl","Bitlis","Bolu","Burdur","Bursa",
            "Çanakkale","Çankırı","Çorum","Denizli","Diyarbakır","Edirne","Elazığ","Erzincan","Erzurum",
            "Eskişehir","Gaziantep","Giresun","Gümüşhane","Hakkari","Hatay","Isparta","Mersin","İstanbul",
            "İzmir","Kars","Kastamonu","Kayseri","Kırklareli","Kırşehir","Konya","Kütahya","Malatya","Manisa",
            "Maraş","Mardin","Muğla","Muş","Nevşehir","Niğde","Ordu","Rize","Sakarya","Samsun","Siirt",
            "Sinop","Sivas","Tekirdağ","Trabzon","Tunceli","Şanlıurfa","Uşak","Van","Yozgat","Zonguldak","Aksaray",
            "Bayburt","Karaman","Kırıkkale","Batman","Şırnak","Bartın","Ardahan","Iğdır","Yalova","Karabük","Kilis",
            "Osmaniye","Düzce"};

    int[] resimlerr = {R.drawable.tokat, R.drawable.kocaeli,R.drawable.adana,R.drawable.adiyaman,R.drawable.afyonkarahisar,
            R.drawable.agri,R.drawable.pamasya, R.drawable.ankara, R.drawable.antalya,R.drawable.artvin,R.drawable.aydin,
            R.drawable.pbalikesir,R.drawable.bilecik,R.drawable.bingol,R.drawable.bitlis,R.drawable.pbolu,R.drawable.burdur,
            R.drawable.bursa, R.drawable.pcanakkale, R.drawable.pcankiri,R.drawable.corum,R.drawable.pdenizli,
            R.drawable.pdiyarbakir, R.drawable.edirne,R.drawable.elazig,R.drawable.erzincan,R.drawable.erzurum,
            R.drawable.peskisehir, R.drawable.pgaziantep,R.drawable.giresun,R.drawable.gumushane,R.drawable.hakkari,
            R.drawable.hatay,R.drawable.isparta,R.drawable.pmersin,R.drawable.istanbul,R.drawable.izmir,
            R.drawable.kars,R.drawable.kastamonu,R.drawable.kayseri,R.drawable.kirklareli,R.drawable.kirsehir,
            R.drawable.konya,R.drawable.kutahya,R.drawable.malatya,R.drawable.manisa,
            R.drawable.kahramanmaras,R.drawable.mardin, R.drawable.mugla,R.drawable.mus,R.drawable.nevsehir,
            R.drawable.nigde,R.drawable.ordu,R.drawable.rize, R.drawable.sakarya,R.drawable.samsun,
            R.drawable.siirt,R.drawable.sinop,R.drawable.sivas,R.drawable.tekirdag,R.drawable.trabzon,
            R.drawable.tunceli,R.drawable.sanliurfa,R.drawable.usak,R.drawable.van,R.drawable.yozgat,
            R.drawable.zonguldak,R.drawable.aksaray,R.drawable.bayburt,R.drawable.karaman,R.drawable.kirikkale,
            R.drawable.batman,R.drawable.sirnak,R.drawable.bartin,R.drawable.ardahan,R.drawable.igdir,R.drawable.yalova,
            R.drawable.karabuk,R.drawable.kilis,R.drawable.osmaniye,R.drawable.pduzce};


    ListView listeEkran;
    CustomListAdapter adapter;
    TextView filterEditText;
    String[] filtrelenen;
    int[] filtrelenenResim;
    String[] filtrelenen2;
    int[] filtrelenenResim2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main2);



        listeEkran = (ListView) findViewById(R.id.liste);

        adapter = new CustomListAdapter(Main2Activity.this, sehirler, resimlerr);
        listeEkran.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(Main2Activity.this, sehirler[i], Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                intent.putExtra("sehir", sehirler[i]);
                startActivity(intent);

            }
        });

        listeEkran.setAdapter(adapter);
        filterEditText = findViewById(R.id.editArama);

        listeEkran.requestFocus();


        filterEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int k, int i1, int i2) {
                filtrelenen = new String[sehirler.length];
                filtrelenenResim = new int[resimlerr.length];
                for (int i = 0; i < sehirler.length; i++) {
                    if (sehirler[i].contains(filterEditText.getText().toString())) {
                        filtrelenen[i] = sehirler[i];
                        filtrelenenResim[i] = resimlerr[i];
                    }
                }
                int uzunluk = 0;
                for (int i = 0; i < filtrelenen.length; i++) {
                    if (filtrelenen[i] != null) {
                        uzunluk++;
                    }
                }
                filtrelenen2 = new String[uzunluk];
                filtrelenenResim2 = new int[uzunluk];
                int j = 0;
                for (int i = 0; i < filtrelenen.length; i++) {
                    if (filtrelenen[i] != null) {
                        filtrelenen2[j] = filtrelenen[i];
                        filtrelenenResim2[j] = filtrelenenResim[i];
                        j++;
                    }
                }
                adapter = new CustomListAdapter(Main2Activity.this, filtrelenen2, filtrelenenResim2);
                listeEkran.setAdapter(adapter);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (filtrelenen2.length == 0) {
                    listeEkran.setAdapter(new CustomListAdapter(Main2Activity.this, sehirler, resimlerr));

                    listeEkran.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            Toast.makeText(Main2Activity.this, sehirler[i], Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                            intent.putExtra("sehir", sehirler[i]);
                            startActivity(intent);
                        }
                    });
                } else {
                    listeEkran.setAdapter(new CustomListAdapter(Main2Activity.this, filtrelenen2, filtrelenenResim2));

                    listeEkran.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            Toast.makeText(Main2Activity.this, filtrelenen2[i], Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                            intent.putExtra("sehir", filtrelenen2[i]);
                            startActivity(intent);
                        }
                    });
                }
            }
        });
    }
}
