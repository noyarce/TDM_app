package com.example.nicols.myapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    }

    public void clickcheck (View v){

        EditText user = (EditText) findViewById(R.id.txt_Username);
        EditText pass = (EditText) findViewById(R.id.txt_password);
        String strUser;
        String strPass;

        strUser = user.getText().toString();
        strPass = pass.getText().toString();

        BDUsuarios BDU = new BDUsuarios(getApplicationContext(),"Usuarios",null, 1);
        SQLiteDatabase bd = BDU.getReadableDatabase();

       String query = new String("select * From Usuarios where username = '"+strUser+"' and password = '"+strPass+"'");

        Cursor c = bd.rawQuery (query,null);

        if(c.getCount()>0){
            Intent newvista = new Intent(getApplicationContext(), pantalla2.class);
            startActivity(newvista);
            }
            else{
            Intent niwista = new Intent(getApplicationContext(),ErrorScreen.class);
            startActivity(niwista);
        }

    }
    public void clickRegister (View v){
        Intent nuevaVista = new Intent(getApplicationContext(), pantallaReg.class);
        startActivity(nuevaVista);
    }

}
