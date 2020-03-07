package com.example.sem.ramazanprojesi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sem on 5.05.2018.
 */

public class LokasyonVeriTabani extends SQLiteOpenHelper
{
    public LokasyonVeriTabani(Context context)
    {
        super(context,"lokasyon.db",null,7);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {

        db.execSQL("CREATE TABLE sehirler(_id INTEGER PRIMARY KEY AUTOINCREMENT, sehir TEXT)");
        db.execSQL("CREATE TABLE sahurAlarmTablosu(_id INTEGER PRIMARY KEY AUTOINCREMENT, sahurAlarmi TEXT)");
        db.execSQL("CREATE TABLE iftarAlarmTablosu(_id INTEGER PRIMARY KEY AUTOINCREMENT, iftarAlarmi TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1)
    {
        db.execSQL("DROP TABLE IF EXISTS sehirler");
        db.execSQL("DROP TABLE IF EXISTS sahurAlarmTablosu");
        db.execSQL("DROP TABLE IF EXISTS iftarAlarmTablosu");
        onCreate(db);
    }

    public void lokasyonEkle(String sehir)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete("sehirler",null,null);
        ContentValues deger=new ContentValues();

        deger.put("sehir",sehir);

        db.insert("sehirler",null,deger);
        db.close();
    }

    public void sahurAlarmEkle(String sahurAlarmi)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete("sahurAlarmTablosu",null,null);
        ContentValues deger=new ContentValues();

        deger.put("sahurAlarmi",sahurAlarmi);

        db.insert("sahurAlarmTablosu",null,deger);
        db.close();
    }

    public void iftarAlarmEkle(String iftarAlarmi)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete("iftarAlarmTablosu",null,null);
        ContentValues deger=new ContentValues();

        deger.put("iftarAlarmi",iftarAlarmi);

        db.insert("iftarAlarmTablosu",null,deger);
        db.close();
    }



    public List<String> lokasyonSorgusu()
    {
        String sorgu="SELECT sehir FROM sehirler";

        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(sorgu,null);

        ArrayList<String> liste=new ArrayList<String>();

        //Log.v("Sehirler", cursor.getCount() + "");

        while(cursor.moveToNext()){
            String sehir = cursor.getString(cursor.getColumnIndex("sehir"));
            liste.add(sehir);
        }

        db.close();
        return liste;
    }

    public List<String> iftarSorgusu()
    {
        String sorgu="SELECT iftarAlarmi FROM iftarAlarmTablosu";

        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(sorgu,null);

        ArrayList<String> liste=new ArrayList<String>();

        while(cursor.moveToNext())
        {
            String iftarAlarmi=cursor.getString(cursor.getColumnIndex("iftarAlarmi"));
            liste.add(iftarAlarmi);
        }
        db.close();
        return liste;
    }

    public List<String> sahurSorgusu()
    {
        String sorgu="SELECT sahurAlarmi FROM sahurAlarmTablosu";

        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(sorgu,null);

        ArrayList<String> liste=new ArrayList<String>();

        while(cursor.moveToNext())
        {
            String sahurAlarmi=cursor.getString(cursor.getColumnIndex("sahurAlarmi"));
            liste.add(sahurAlarmi);
        }
        db.close();
        return liste;
    }


    public void iftarTablosuTemizle(String iftarAlarmim)
    {

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("iftarAlarmTablosu", "iftarAlarmi = ?",
                new String[] {iftarAlarmim });
        db.close();
        /*SQLiteDatabase db = this.getWritableDatabase();

        db.delete("iftarAlamTablosu", null, null);*/
    }

    public void sahurTablosuTemizle(String sahurAlarmim)
    {

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("sahurAlarmTablosu", "sahurAlarmi" + " = ?",
                new String[] { String.valueOf(sahurAlarmim) });
        db.close();

        /*SQLiteDatabase db = this.getWritableDatabase();
        db.delete("sahurAlamTablosu", null, null);*/
    }



}
