package com.example.gescom;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DataBaseManager extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "gescom";
    private static final int DATABASE_VERSION = 1;

    public DataBaseManager(Context context) {
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String requete = "create table categorie( idCat integer primary key autoincrement,libelle text not null)";

        db.execSQL(requete);

        Log.i("DB","Création ok");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertCategorie(String libelle){

        String req = "INSERT INTO categorie(libelle) values('"+libelle+"')";

        this.getReadableDatabase().execSQL(req);

        Log.i("DB","Insert ok");

    }

    public List<Categorie> getAllCategorie(){

        List<Categorie>listeCat = new ArrayList<>();
        String req = "select * from Categorie";
        Cursor cursor = this.getReadableDatabase().rawQuery(req,null);
    cursor.moveToFirst();
    while(!cursor.isAfterLast()){
        Categorie cat = new Categorie(cursor.getInt(0),cursor.getString(1));
        listeCat.add(cat);
        cursor.moveToNext();
    }
    cursor.close();
    return listeCat;

    }

    public void deleteCategorie(int idCat){

        String req = "DELETE FROM categorie where idCat('"+idCat+"')";
        this.getReadableDatabase().execSQL(req);
        Log.i("DB","Delete OK");
    }

        public void updatecategorie(Categorie cat){
            Categorie catOld =  new Categorie();
            String req = "UPDATE categorie set libelle ='"+ cat.getLibelle()+ "'  WHERE idCat ='"+ cat.getIdCat()+ "'";
            this.getReadableDatabase().execSQL(req);
            Log.i("DB", "modification ok");

    }
}
