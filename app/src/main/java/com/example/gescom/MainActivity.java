package com.example.gescom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {
    private DataBaseManager dbm;
    private ListView lvcat;
    private Button btnInsert, btnDelete,btnUpdate, btnReset;
    private TextView txtIdCat, txtLibelle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dbm = new DataBaseManager(this);
        lvcat = findViewById(R.id.lvCat);

        lvcat.setAdapter(new AdapterCat(this,dbm.getAllCategorie()));

       lvcat.setOnItemClickListener(new AdapterView.OnItemClickListener() {

           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

           }
       });

       /* dbm.insertCategorie("DVD");
        dbm.insertCategorie("LIVRES");
        dbm.insertCategorie("ROMAN");*/

        Log.i("ListeCat",""+ dbm.getAllCategorie());

        dbm.deleteCategorie(1);
    }

     @Override
     public void onClick(View v) {

         btnInsert = findViewById(R.id.btnInsert);
         btnDelete = findViewById(R.id.btnDelete);
         btnUpdate = findViewById(R.id.btnUpdate);
         btnReset = findViewById(R.id.btnReset);

         txtIdCat = findViewById(R.id.txtIdCat);
         txtLibelle = findViewById(R.id.txtLibelle);

     }
}
