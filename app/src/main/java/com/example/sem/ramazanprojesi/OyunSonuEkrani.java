package com.example.sem.ramazanprojesi;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class OyunSonuEkrani extends AppCompatActivity
{
    Button btnBasla,btnCikis;
    TextView txSkor;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_oyun_sonu_ekrani);

        btnBasla=(Button) findViewById(R.id.btnBastanBasla);
        btnCikis=(Button) findViewById(R.id.btnCikis);
        txSkor=(TextView) findViewById(R.id.txSkor);

        Intent intent=getIntent();
        int skor=intent.getIntExtra("score",1);
        txSkor.setText(" "+skor);

        btnBasla.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent=new Intent(OyunSonuEkrani.this,OyunEkrani.class);
                startActivity(intent);
            }
        });

        btnCikis.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                final AlertDialog.Builder builder = new AlertDialog.Builder(OyunSonuEkrani.this);
                builder.setTitle("Çıkış");
                builder.setMessage("Çıkış yapmak İstediğinizden Eminmisiniz ??");
                builder.setPositiveButton("Evet, Hemen Çıkış ", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        uygulamaCikis();
                    }
                });

                builder.setNegativeButton("Hayır Çıkış Yapma ", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        dialogInterface.dismiss();
                    }
                });

                builder.setNeutralButton("Uygulamaya Geri Dön ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        Intent intent=new Intent(OyunSonuEkrani.this,Main2Activity.class);
                        startActivity(intent);
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

    }

    public void uygulamaCikis()
    {
        this.finish();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }
}
