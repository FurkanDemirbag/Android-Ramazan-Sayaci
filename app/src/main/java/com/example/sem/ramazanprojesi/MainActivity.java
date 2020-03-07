package com.example.sem.ramazanprojesi;

import android.content.Intent;
import android.media.Image;
import android.os.CountDownTimer;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Date;
import java.util.Random;

import me.anwarshahriar.calligrapher.Calligrapher;

public class MainActivity extends AppCompatActivity
{

    ImageView imageView,imageView2;
    ImageView gameIcon;
    ImageView settingsIcon;
    ImageView funnyIcon;
    TextView txSahurVakti,txIftarVakti;
    TextView txtSehir;
    TextView gununSozu;
    int days,hours,seconds,minutes;
    Date simdikiZaman=new Date();
    long vakitHesabi=0;

    SehirSaatleri sh=new SehirSaatleri();
    SehirSaatlerim ss=new SehirSaatlerim();




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        ImageView homeIcon=(ImageView) findViewById(R.id.homeIcon);
        ImageView musicIcon=(ImageView) findViewById(R.id.musinIcon);
        gameIcon=(ImageView) findViewById(R.id.gameIcon);
        settingsIcon=(ImageView)findViewById(R.id.settingsIcon);
        funnyIcon=(ImageView) findViewById(R.id.funnyIcon);

        homeIcon.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);

                startActivity(intent);

            }
        });

        musicIcon.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent2=new Intent(MainActivity.this,muzikActivity.class);
                // ActivityCompat.finishAffinity(MainActivity.this);
                //intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                //intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                //intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent2);
            }
        });


        gameIcon.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent=new Intent(MainActivity.this,oyunGirisEkrani.class);
                startActivity(intent);
            }
        });

        settingsIcon.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent=new Intent(MainActivity.this,ayarlarEkrani.class);
                startActivity(intent);
            }
        });

        funnyIcon.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent=new Intent(MainActivity.this,SallamaEkrani.class);
                startActivity(intent);
            }
        });




        Intent intent=getIntent();

        String sehirler=intent.getStringExtra("sehir");
        txtSehir=(TextView) findViewById(R.id.txtSehir);
        txtSehir.setText(sehirler);

        switchler(sehirler);


        String[] sozler={
                "Beni bir ben bilirim, bir de Yaradan. Bana bir ben lazımım, bir de Anlayan.",
                "Hedefi olmayan gemiye hiçbir rüzgar yardım edemez.",
                "Ne diye böbürlenip büyükleniyorsun. Doğumun bir damla su, ölümün bir avuç toprak değil mi?",
                "Dünyada görmek istediğiniz değişikliğin kendisi siz olun.",
                "Boş zaman yoktur boşa geçen zaman vardır.",
                "RüyaIarı gerçekIeştirmenin en iyi yoIu uyanmaktır.",
                "Kıyıyı gözden kaybetmeye cesaret edemeyen insan, yeni okyanusIar kesfedemez.",
                "Uzun bir yolculuk tek bir adımla başlar.",
                "Mutluluk doğru ve güzel düşüncelerle düşünebilmeyi bilmektir.",
                "Sonunda düşmanlarımızın sözlerini değil , dostlarımızın sessizliğini hatırlayacağız.",
                "Gerçek hiçbir zaman şiddet tarafından çürütülemez.",
                "İnsanlığın en güzel görevi adalet dağıtmasıdır.",
                "Bіlgi arttıkça huzursuzluk da artar.",
                "İnsanı yaralaуan tek şey gerçektir.",

        };

        Random rnd=new Random();
        gununSozu=(TextView)findViewById(R.id.gununSozu);
        gununSozu.setText(sozler[rnd.nextInt(sozler.length-1)]);

        imageView=(ImageView) findViewById(R.id.imageView);
        imageView2=(ImageView) findViewById(R.id.imageView2);

        txSahurVakti=(TextView) findViewById(R.id.txSahurVakti);
        txIftarVakti=(TextView) findViewById(R.id.txIftarVakti);


    }

    private void switchler(String sehirler) {
        switch(sehirler)
        {
            case "Tokat":
                tokatVakitHesapla(sh.tokatSahurVakitleri, true);
                tokatVakitHesapla(sh.tokatIftarVakitleri, false);
                break;

            case "İstanbul":
                istanbulVakitHesapla(sh.istanbulSahurVakitleri,true);
                istanbulVakitHesapla(sh.istanbulIftarVakitleri,false);
                break;

            case "Ankara":
                ankaraVakitHesapla(sh.ankaraSahurVakitleri,true);
                ankaraVakitHesapla(sh.ankaraIftarVakitleri,false);
                break;

            case "Kocaeli":
                kocaeliVakitHesapla(sh.kocaeliSahurVakitleri,true);
                kocaeliVakitHesapla(sh.kocaeliIftarVakitleri,false);
                break;

            case "İzmir":
                izmirVakitHesapla(sh.izmirSahurVakitleri,true);
                izmirVakitHesapla(sh.izmirIftarVakitleri,false);
                break;

            case "Erzurum":
                erzurumVakitHesapla(sh.erzurumSahurVakitleri,true);
                erzurumVakitHesapla(sh.erzurumIftarVakitleri,false);
                break;

            case "Antalya":
                antalyaVakitHesapla(sh.antalyaSahurVakitleri,true);
                antalyaVakitHesapla(sh.antalyaIftarVakitleri,false);
                break;

            case "Bursa":
                bursaVakitHesapla(sh.bursaSahurVakitleri,true);
                bursaVakitHesapla(sh.bursaIftarVakitleri,false);
                break;

            case "Trabzon":
                trabzonVakitHesapla(sh.trabzonSahurVakitleri,true);
                trabzonVakitHesapla(sh.trabzonIftarVakitleri,false);
                break;

            case "Adana":
                adanaVakitHesapla(sh.adanaSahurVakitleri,true);
                adanaVakitHesapla(sh.adanaIftarVakitleri,false);
                break;

            case "Rize":
                rizeVakitHesapla(sh.rizeSahurVakitleri,true);
                rizeVakitHesapla(sh.rizeIftarVakitleri,false);
                break;

            case "Konya":
                konyaVakitHesapla(sh.konyaSahurVakitleri,true);
                konyaVakitHesapla(sh.konyaIftarVakitleri,false);
                break;

            case "Samsun":
                samsunVakitHesapla(sh.samsunSahurVakitleri,true);
                samsunVakitHesapla(sh.samsunIftarVakitleri,false);
                break;

            case "Sivas":
                sivasVakitHesapla(sh.sivasSahurVakitleri,true);
                sivasVakitHesapla(sh.sivasIftarVakitleri,false);
                break;

            case "Sakarya":
                sakaryaVakitHesapla(sh.sakaryaSahurVakitleri,true);
                sakaryaVakitHesapla(sh.sakaryaIftarVakitleri,false);
                break;

            case "Muğla":
                muglaVakitHesapla(sh.muglaSahurVakitleri,true);
                muglaVakitHesapla(sh.muglaIftarVakitleri,false);
                break;

            case "Kastamonu":
                kastamonuVakitHesapla(sh.kastamonuSahurVakitleri,true);
                kastamonuVakitHesapla(sh.kastamonuIftarVakitleri,false);
                break;

            case "Mersin":
                mersinVakitHesapla(sh.mersinSahurVakitleri,true);
                mersinVakitHesapla(sh.mersinIftarVakitleri,false);
                break;

            case "Amasya":
                amasyaVakitHesapla(sh.amasyaSahurVakitleri,true);
                amasyaVakitHesapla(sh.amasyaIftarVakitleri,false);
                break;

            case "Balıkesir":
                balikesirVakitHesapla(sh.balikesirSahurVakitleri,true);
                balikesirVakitHesapla(sh.balikesirIftarVakitleri,false);
                break;

            case "Bolu":
                boluVakitHesapla(sh.boluSahurVakitleri,true);
                boluVakitHesapla(sh.boluIftarVakitleri,false);
                break;

            case "Çanakkale":
                canakkaleVakitHesapla(sh.canakkaleSahurVakitleri,true);
                canakkaleVakitHesapla(sh.canakkaleIftarVakitleri,false);
                break;

            case "Çankırı":
                cankiriVakitHesapla(sh.cankiriSahurVakitleri,true);
                cankiriVakitHesapla(sh.cankiriIftarVakitleri,false);
                break;

            case "Denizli":
                denizliVakitHesapla(sh.denizliSahurVakitleri,true);
                denizliVakitHesapla(sh.denizliIftarVakitleri,false);
                break;

            case "Diyarbakır":
                diyarbakirVakitHesapla(sh.diyarbakirSahurVakitleri,true);
                diyarbakirVakitHesapla(sh.diyarbakirIftarVakitleri,false);
                break;

            case "Düzce":
                duzceVakitHesapla(sh.duzceSahurVakitleri,true);
                duzceVakitHesapla(sh.duzceIftarVakitleri,false);
                break;

            case "Eskişehir":
                eskisehirVakitHesapla(sh.eskisehirSahurVakitleri,true);
                eskisehirVakitHesapla(sh.eskisehirIftarVakitleri,false);

            case "Gaziantep":
                gaziantepVakitHesapla(sh.gaziantepSahurVakitleri,true);
                gaziantepVakitHesapla(sh.gaziantepIftarVakitleri,false);
                break;

            case "Gümüşhane":
                gumushaneVakitHesapla(sh.gumushaneSahurVakitleri,true);
                gumushaneVakitHesapla(sh.gumushaneIftarVakitleri,false);
                break;

            case "Isparta":
                ispartaVakitHesapla(sh.ispartaSahurVakitleri,true);
                ispartaVakitHesapla(sh.ispartaIftarVakitleri,false);
                break;

            case "Karabük":
                karabukVakitHesapla(sh.karabukSahurVakitleri,true);
                karabukVakitHesapla(sh.karabukIftarVakitleri,false);
                break;

            case "Kayseri":
                kayseriVakitHesapla(sh.kayseriSahurVakitleri,true);
                kayseriVakitHesapla(sh.kayseriIftarVakitleri,false);
                break;

            case "Kütahya":
                kutahyaVakitHesapla(sh.kutahyaSahurVakitleri,true);
                kutahyaVakitHesapla(sh.kutahyaIftarVakitleri,false);
                break;

            case "Manisa":
                manisaVakitHesapla(sh.manisaSahurVakitleri,true);
                manisaVakitHesapla(sh.manisaIftarVakitleri,false);
                break;

            case "Mardin":
                mardinVakitHesapla(sh.mardinSahurVakitleri,true);
                mardinVakitHesapla(sh.mardinIftarVakitleri,false);
                break;

            case "Ordu":
                orduVakitHesapla(sh.orduSahurVakitleri,true);
                orduVakitHesapla(sh.orduIftarVakitleri,false);
                break;

            case "Şanlıurfa":
                sanliurfaVakitHesapla(sh.sanliurfaSahurVakitleri,true);
                sanliurfaVakitHesapla(sh.sanliurfaIftarVakitleri,false);
                break;

            case "Tekirdağ":
                tekirdagVakitHesapla(sh.tekirdagSahurVakitleri,true);
                tekirdagVakitHesapla(sh.tekirdagIftarVakitleri,false);
                break;

            case "Adıyaman":
                adiyamanVakitHesapla(sh.adiyamanSahurVakitleri,true);
                adiyamanVakitHesapla(sh.adiyamanIftarVakitleri,false);
                break;

            case "Afyon":
                afyonkarahisarVakitHesapla(sh.afyonkarahisarSahurVakitleri,true);
                afyonkarahisarVakitHesapla(sh.afyonkarahisarIftarVakitleri,false);
                break;

            case "Ağrı":
                agriVakitHesapla(sh.agriSahurVakitleri,true);
                agriVakitHesapla(sh.agriIftarVakitleri,false);
                break;

            case "Artvin":
                artvinVakitHesapla(sh.artvinSahurVakitleri,true);
                artvinVakitHesapla(sh.artvinIftarVakitleri,false);
                break;

            case "Aydın":
                aydinVakitHesapla(sh.aydinSahurVakitleri,true);
                aydinVakitHesapla(sh.aydinIftarVakitleri,false);
                break;

            case "Bilecik":
                bilecikVakitHesapla(sh.bilecikSahurVakitleri,true);
                bilecikVakitHesapla(sh.bilecikIftarVakitleri,false);
                break;

            case "Bingöl":
                bingolVakitHesapla(ss.bingolSahurVakitleri,true);
                bingolVakitHesapla(ss.bingolIftarVakitleri,false);
                break;

            case "Bitlis":
                bitlisVakitHesapla(ss.bitlisSahurVakitleri,true);
                bitlisVakitHesapla(ss.bitlisIftarVakitleri,false);
                break;

            case "Burdur":
                burdurVakitHesapla(ss.burdurSahurVakitleri,true);
                burdurVakitHesapla(ss.burdurIftarVakitleri,false);
                break;

            case "Çorum":
                corumVakitHesapla(ss.corumSahurVakitleri,true);
                corumVakitHesapla(ss.corumIftarVakitleri,false);
                break;

            case "Edirne":
                edirneVakitHesapla(ss.edirneSahurVakitleri,true);
                edirneVakitHesapla(ss.edirneIftarVakitleri,false);
                break;

            case "Elazığ":
                elazigVakitHesapla(ss.elazigSahurVakitleri,true);
                elazigVakitHesapla(ss.elazigIftarVakitleri,false);
                break;

            case "Erzincan":
                erzincanVakitHesapla(ss.erzincanSahurVakitleri,true);
                erzincanVakitHesapla(ss.erzincanIftarVakitleri,false);
                break;

            case "Giresun":
                giresunVakitHesapla(ss.giresunSahurVakitleri,true);
                giresunVakitHesapla(ss.giresunIftarVakitleri,false);
                break;

            case "Hakkari":
                hakkariVakitHesapla(ss.hakkariSahurVakitleri,true);
                hakkariVakitHesapla(ss.hakkariIftarVakitleri,false);
                break;

            case "Hatay":
                hatayVakitHesapla(ss.hataySahurVakitleri,true);
                hatayVakitHesapla(ss.hatayIftarVakitleri,false);
                break;

            case "Kars":
                karsVakitHesapla(ss.karsSahurVakitleri,true);
                karsVakitHesapla(ss.karsIftarVakitleri,false);
                break;

            case "Malatya":
                malatyaVakitHesapla(ss.malatyaSahurVakitleri,true);
                malatyaVakitHesapla(ss.malatyaIftarVakitleri,false);
                break;

            case "Kırklareli":
                kirklareliVakitHesapla(ss.kirklareliSahurVakitleri,true);
                kirklareliVakitHesapla(ss.kirklareliIftarVakitleri,false);
                break;

            case "Kırşehir":
                kirsehirVakitHesapla(ss.kirsehirSahurVakitleri,true);
                kirsehirVakitHesapla(ss.kirsehirIftarVakitleri,false);
                break;

            case "Muş":
                musVakitHesapla(ss.musSahurVakitleri,true);
                musVakitHesapla(ss.musIftarVakitleri,false);
                break;

            case "Nevşehir":
                nevsehirVakitHesapla(ss.nevsehirSahurVakitleri,true);
                nevsehirVakitHesapla(ss.nevsehirIftarVakitleri,false);
                break;

            case "Maraş":
                kahramanmarasVakitHesapla(ss.kahramanmarasSahurVakitleri,true);
                kahramanmarasVakitHesapla(ss.kahramanmarasIftarVakitleri,false);
                break;

            case "Niğde":
                nigdeVakitHesapla(ss.nigdeSahurVakitleri,true);
                nigdeVakitHesapla(ss.nigdeIftarVakitleri,false);
                break;

            case "Siirt":
                siirtVakitHesapla(ss.siirtSahurVakitleri,true);
                siirtVakitHesapla(ss.siirtIftarVakitleri,false);
                break;

            case "Tunceli":
                tunceliVakitHesapla(ss.tunceliSahurVakitleri,true);
                tunceliVakitHesapla(ss.tunceliIftarVakitleri,false);
                break;

            case "Zonguldak":
                zonguldakVakitHesapla(ss.zonguldakSahurVakitleri,true);
                zonguldakVakitHesapla(ss.zonguldakIftarVakitleri,false);
                break;

            case "Batman":
                batmanVakitHesapla(ss.batmanSahurVakitleri,true);
                batmanVakitHesapla(ss.batmanIftarVakitleri,false);
                break;

            case "Sinop":
                sinopVakitHesapla(ss.sinopSahurVakitleri,true);
                sinopVakitHesapla(ss.sinopIftarVakitleri,false);
                break;

            case "Aksaray":
                aksarayVakitHesapla(ss.aksaraySahurVakitleri,true);
                aksarayVakitHesapla(ss.aksarayIftarVakitleri,false);
                break;

            case "Şırnak":
                sirnakVakitHesapla(ss.sirnakSahurVakitleri,true);
                sirnakVakitHesapla(ss.sirnakIftarVakitleri,false);
                break;

            case "Kilis":
                kilisVakitHesapla(ss.kilisSahurVakitleri,true);
                kilisVakitHesapla(ss.kilisIftarVakitleri,false);
                break;

            case "Uşak":
                usakVakitHesapla(ss.usakSahurVakitleri,true);
                usakVakitHesapla(ss.usakIftarVakitleri,false);
                break;

            case "Bayburt":
                bayburtVakitHesapla(ss.bayburtSahurVakitleri,true);
                bayburtVakitHesapla(ss.bayburtIftarVakitleri,false);
                break;

            case "Bartın":
                bartinVakitHesapla(ss.bartinSahurVakitleri,true);
                bartinVakitHesapla(ss.bartinIftarVakitleri,false);
                break;

            case "Osmaniye":
                osmaniyeVakitHesapla(ss.osmaniyeSahurVakitleri,true);
                osmaniyeVakitHesapla(ss.osmaniyeIftarVakitleri,false);
                break;

            case "Van":
                vanVakitHesapla(ss.vanSahurVakitleri,true);
                vanVakitHesapla(ss.vanIftarVakitleri,false);
                break;

            case "Karaman":
                karamanVakitHesapla(ss.karamanSahurVakitleri,true);
                karamanVakitHesapla(ss.karamanIftarVakitleri,false);
                break;

            case "Ardahan":
                ardahanVakitHesapla(ss.ardahanSahurVakitleri,true);
                ardahanVakitHesapla(ss.ardahanIftarVakitleri,false);
                break;

            case "Yozgat":
                yozgatVakitHesapla(ss.yozgatSahurVakitleri,true);
                yozgatVakitHesapla(ss.yozgatIftarVakitleri,false);
                break;

            case "Kırıkkale":
                kirikkaleVakitHesapla(ss.kirikkaleSahurVakitleri,true);
                kirikkaleVakitHesapla(ss.kirikkaleIftarVakitleri,false);
                break;

            case "Iğdır":
                igdirVakitHesapla(ss.igdirSahurVakitleri,true);
                igdirVakitHesapla(ss.igdirIftarVakitleri,false);
                break;

            case "Yalova":
                yalovaVakitHesapla(ss.yalovaSahurVakitleri,true);
                yalovaVakitHesapla(ss.yalovaIftarVakitleri,false);
                break;


        }
    }


    // Şehir İftar-Sahur Hesapları


    private void tokatVakitHesapla(final Date[] tokatVakitleri, boolean durum)
    {
        Date[] vakitler=tokatVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));


            }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void istanbulVakitHesapla(Date[] istanbulVakitleri , boolean durum)
    {
        Date[] vakitler=istanbulVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));


                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void ankaraVakitHesapla(Date[] ankaraVakitleri , boolean durum)
    {
        Date[] vakitler=ankaraVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));


                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }

                public void onFinish()
                {

                }

            }.start();
        }
    }


    private void kocaeliVakitHesapla(Date[] kocaeliVakitleri, boolean durum)
    {
        Date[] vakitler = kocaeliVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));


                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void izmirVakitHesapla(Date[] izmirVakitleri, boolean durum)
    {
        Date[] vakitler = izmirVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));


                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void erzurumVakitHesapla(Date[] erzurumVakitleri, boolean durum)
    {
        Date[] vakitler = erzurumVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));


                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void antalyaVakitHesapla(Date[] antalyaVakitleri, boolean durum)
    {
        Date[] vakitler = antalyaVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void bursaVakitHesapla(Date[] bursaVakitleri, boolean durum)
    {
        Date[] vakitler = bursaVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void trabzonVakitHesapla(Date[] trabzonVakitleri, boolean durum)
    {
        Date[] vakitler = trabzonVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void adanaVakitHesapla(Date[] adanaVakitleri, boolean durum)
    {
        Date[] vakitler = adanaVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void rizeVakitHesapla(Date[] rizeVakitleri, boolean durum)
    {
        Date[] vakitler = rizeVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void konyaVakitHesapla(Date[] konyaVakitleri, boolean durum)
    {
        Date[] vakitler = konyaVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void samsunVakitHesapla(Date[] samsunVakitleri, boolean durum)
    {
        Date[] vakitler = samsunVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void sivasVakitHesapla(Date[] sivasVakitleri, boolean durum)
    {
        Date[] vakitler = sivasVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void sakaryaVakitHesapla(Date[] sakaryaVakitleri, boolean durum)
    {
        Date[] vakitler = sakaryaVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void muglaVakitHesapla(Date[] muglaVakitleri, boolean durum)
    {
        Date[] vakitler = muglaVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void kastamonuVakitHesapla(Date[] kastamonuVakitleri, boolean durum)
    {
        Date[] vakitler = kastamonuVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void mersinVakitHesapla(Date[] mersinVakitleri, boolean durum)
    {
        Date[] vakitler = mersinVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void amasyaVakitHesapla(Date[] amasyaVakitleri, boolean durum)
    {
        Date[] vakitler = amasyaVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void balikesirVakitHesapla(Date[] balikesirVakitleri, boolean durum)
    {
        Date[] vakitler = balikesirVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void boluVakitHesapla(Date[] boluVakitleri, boolean durum)
    {
        Date[] vakitler = boluVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void canakkaleVakitHesapla(Date[] canakkaleVakitleri, boolean durum)
    {
        Date[] vakitler = canakkaleVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void cankiriVakitHesapla(Date[] cankiriVakitleri, boolean durum)
    {
        Date[] vakitler = cankiriVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void denizliVakitHesapla(Date[] denizliVakitleri, boolean durum)
    {
        Date[] vakitler = denizliVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void diyarbakirVakitHesapla(Date[] diyarbakirVakitleri, boolean durum)
    {
        Date[] vakitler = diyarbakirVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void duzceVakitHesapla(Date[] duzceVakitleri, boolean durum)
    {
        Date[] vakitler = duzceVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void eskisehirVakitHesapla(Date[] eskisehirVakitleri, boolean durum)
    {
        Date[] vakitler = eskisehirVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void gaziantepVakitHesapla(Date[] gaziantepVakitleri, boolean durum)
    {
        Date[] vakitler = gaziantepVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void kutahyaVakitHesapla(Date[] kutahyaVakitleri, boolean durum)
    {
        Date[] vakitler = kutahyaVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void gumushaneVakitHesapla(Date[] gumushaneVakitleri, boolean durum)
    {
        Date[] vakitler = gumushaneVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void ispartaVakitHesapla(Date[] ispartaVakitleri, boolean durum)
    {
        Date[] vakitler = ispartaVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void karabukVakitHesapla(Date[] karabukVakitleri, boolean durum)
    {
        Date[] vakitler = karabukVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void kayseriVakitHesapla(Date[] kayseriVakitleri, boolean durum)
    {
        Date[] vakitler = kayseriVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void manisaVakitHesapla(Date[] manisaVakitleri, boolean durum)
    {
        Date[] vakitler = manisaVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void mardinVakitHesapla(Date[] mardinVakitleri, boolean durum)
    {
        Date[] vakitler = mardinVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void orduVakitHesapla(Date[] orduVakitleri, boolean durum)
    {
        Date[] vakitler = orduVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void sanliurfaVakitHesapla(Date[] sanliurfaVakitleri, boolean durum)
    {
        Date[] vakitler = sanliurfaVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void tekirdagVakitHesapla(Date[] tekirdagVakitleri, boolean durum)
    {
        Date[] vakitler = tekirdagVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void adiyamanVakitHesapla(Date[] adiyamanVakitleri, boolean durum)
    {
        Date[] vakitler = adiyamanVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void afyonkarahisarVakitHesapla(Date[] afyonVakitleri, boolean durum)
    {
        Date[] vakitler = afyonVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void agriVakitHesapla(Date[] agriVakitleri, boolean durum)
    {
        Date[] vakitler = agriVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void artvinVakitHesapla(Date[] artvinVakitleri, boolean durum)
    {
        Date[] vakitler = artvinVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void aydinVakitHesapla(Date[] aydinVakitleri, boolean durum)
    {
        Date[] vakitler = aydinVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void bilecikVakitHesapla(Date[] bilecikVakitleri, boolean durum)
    {
        Date[] vakitler = bilecikVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void bingolVakitHesapla(Date[] bingolVakitleri, boolean durum)
    {
        Date[] vakitler = bingolVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void bitlisVakitHesapla(Date[] bitlisVakitleri, boolean durum)
    {
        Date[] vakitler = bitlisVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void burdurVakitHesapla(Date[] burdurVakitleri, boolean durum)
    {
        Date[] vakitler = burdurVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void corumVakitHesapla(Date[] corumVakitleri, boolean durum)
    {
        Date[] vakitler = corumVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void edirneVakitHesapla(Date[] edirneVakitleri, boolean durum)
    {
        Date[] vakitler = edirneVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void elazigVakitHesapla(Date[] elazigVakitleri, boolean durum)
    {
        Date[] vakitler = elazigVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void erzincanVakitHesapla(Date[] erzincanVakitleri, boolean durum)
    {
        Date[] vakitler = erzincanVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void giresunVakitHesapla(Date[] giresunVakitleri, boolean durum)
    {
        Date[] vakitler = giresunVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void hakkariVakitHesapla(Date[] hakkariVakitleri, boolean durum)
    {
        Date[] vakitler = hakkariVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void hatayVakitHesapla(Date[] hatayVakitleri, boolean durum)
    {
        Date[] vakitler = hatayVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void malatyaVakitHesapla(Date[] malatyaVakitleri, boolean durum)
    {
        Date[] vakitler = malatyaVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void kirsehirVakitHesapla(Date[] kirsehirVakitleri, boolean durum)
    {
        Date[] vakitler = kirsehirVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void kirklareliVakitHesapla(Date[] kirklareliVakitleri, boolean durum)
    {
        Date[] vakitler = kirklareliVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void karsVakitHesapla(Date[] karsVakitleri, boolean durum)
    {
        Date[] vakitler = karsVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void kahramanmarasVakitHesapla(Date[] kahramanmarasVakitleri, boolean durum)
    {
        Date[] vakitler = kahramanmarasVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void nigdeVakitHesapla(Date[] nigdeVakitleri, boolean durum)
    {
        Date[] vakitler = nigdeVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void siirtVakitHesapla(Date[] siirtVakitleri, boolean durum)
    {
        Date[] vakitler = siirtVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void tunceliVakitHesapla(Date[] tunceliVakitleri, boolean durum)
    {
        Date[] vakitler = tunceliVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void zonguldakVakitHesapla(Date[] zonguldakVakitleri, boolean durum)
    {
        Date[] vakitler = zonguldakVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void batmanVakitHesapla(Date[] batmanVakitleri, boolean durum)
    {
        Date[] vakitler = batmanVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void sinopVakitHesapla(Date[] sinopVakitleri, boolean durum)
    {
        Date[] vakitler = sinopVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void aksarayVakitHesapla(Date[] aksarayVakitleri, boolean durum)
    {
        Date[] vakitler = aksarayVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void sirnakVakitHesapla(Date[] sirnakVakitleri, boolean durum)
    {
        Date[] vakitler = sirnakVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void kilisVakitHesapla(Date[] kilisVakitleri, boolean durum)
    {
        Date[] vakitler = kilisVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void usakVakitHesapla(Date[] usakVakitleri, boolean durum)
    {
        Date[] vakitler = usakVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void bayburtVakitHesapla(Date[] bayburtVakitleri, boolean durum)
    {
        Date[] vakitler = bayburtVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void bartinVakitHesapla(Date[] bartinVakitleri, boolean durum)
    {
        Date[] vakitler = bartinVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void osmaniyeVakitHesapla(Date[] osmaniyeVakitleri, boolean durum)
    {
        Date[] vakitler = osmaniyeVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void yalovaVakitHesapla(Date[] yalovaVakitleri, boolean durum)
    {
        Date[] vakitler = yalovaVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void igdirVakitHesapla(Date[] igdirVakitleri, boolean durum)
    {
        Date[] vakitler = igdirVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void kirikkaleVakitHesapla(Date[] kirikkaleVakitleri, boolean durum)
    {
        Date[] vakitler = kirikkaleVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void yozgatVakitHesapla(Date[] yozgatVakitleri, boolean durum)
    {
        Date[] vakitler = yozgatVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void vanVakitHesapla(Date[] vanVakitleri, boolean durum)
    {
        Date[] vakitler = vanVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void karamanVakitHesapla(Date[] karamanVakitleri, boolean durum)
    {
        Date[] vakitler = karamanVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void ardahanVakitHesapla(Date[] ardahanVakitleri, boolean durum)
    {
        Date[] vakitler = ardahanVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void musVakitHesapla(Date[] musVakitleri, boolean durum)
    {
        Date[] vakitler = musVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }

    private void nevsehirVakitHesapla(Date[] nevsehirVakitleri, boolean durum)
    {
        Date[] vakitler = nevsehirVakitleri;

        boolean dizideVarMi = false;

        for (int i = 0; i < vakitler.length; i++)
        {
            if (simdikiZaman.getDay() == vakitler[i].getDay())
            {
                dizideVarMi = true;
                break;
            }
        }

        if (dizideVarMi == false)
        {
            vakitHesabi = simdikiZaman.getTime() - vakitler[0].getTime();
        }
        else
        {
            for (int i = 0; i < vakitler.length; i++)
            {
                if (simdikiZaman.getDay() == vakitler[i].getDay())
                {
                    if(simdikiZaman.getHours() >= vakitler[i].getHours())
                    {
                        if(simdikiZaman.getMinutes() >= vakitler[i].getMinutes())
                        {
                            if(simdikiZaman.getSeconds() >= vakitler[i].getSeconds())
                            {
                                vakitHesabi = vakitler[i + 1].getTime()- simdikiZaman.getTime() ;
                                break;
                            }
                            else
                            {
                                vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                                break;
                            }
                        }
                        else
                        {
                            vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                            break;
                        }
                    }
                    else
                    {
                        vakitHesabi = vakitler[i].getTime()-simdikiZaman.getTime();
                        break;
                    }
                }
            }
        }
        if (durum == true)
        {
            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txSahurVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));

                }
                public void onFinish()
                {

                }
            }.start();
        }
        else
        {

            new CountDownTimer(vakitHesabi, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
                    hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    minutes = (int) ((millisUntilFinished / (1000 * 60) % 60));
                    seconds = (int) (millisUntilFinished / (1000) % 60);

                    txIftarVakti.setText(String.format("%d Gün : %02d:%02d:%02d", days, hours, minutes, seconds));
                }

                public void onFinish()
                {

                }

            }.start();
        }
    }
}

