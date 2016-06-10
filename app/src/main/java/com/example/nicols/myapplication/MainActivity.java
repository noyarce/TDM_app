package com.example.nicols.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


    }

    public void clicklogin (View v){

        EditText user = (EditText) findViewById(R.id.e_username);
        EditText pass = (EditText) findViewById(R.id.e_password);
        String strUser= user.getText().toString();
        String strPass= pass.getText().toString();

        BDUsuariosHelper BDU = new BDUsuariosHelper(getApplicationContext(),"bd_usuarios",null, 1);
        SQLiteDatabase bd = BDU.getReadableDatabase();

       String query = ("select * from usuarios where username = '"+strUser+"' and password = '"+strPass+"'");

        Cursor c = bd.rawQuery (query,null);

        if(c.getCount()>0){
            Intent newvista = new Intent(getApplicationContext(), pantalla2.class);
            c.close();
            startActivity(newvista);
        }
            else{
            Intent newvista = new Intent(getApplicationContext(),ErrorScreen.class);
            c.close();
            startActivity(newvista);

        }

    }

    public void clickRegister (View v){
        Intent nuevaVista = new Intent(getApplicationContext(), pantallaReg.class);
        startActivity(nuevaVista);
    }

}
