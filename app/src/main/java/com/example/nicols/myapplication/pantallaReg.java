package com.example.nicols.myapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class pantallaReg extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_reg);
    }

    public void clickvolver (View v){
    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
    startActivity(intent);
}

public void clickRegistro (View v){

    BDUsuarios BDU = new BDUsuarios(getApplicationContext(),"Usuarios",null, 1);
    SQLiteDatabase bd = BDU.getWritableDatabase();

    EditText user = (EditText) findViewById(R.id.e_username);
    EditText pass = (EditText) findViewById(R.id.e_password);
    EditText nombre = (EditText) findViewById(R.id.e_name);

    String strUser;
    String strPass;
    String strNombre;

    strUser = user.getText().toString();
    strPass = pass.getText().toString();
    strNombre = nombre.getText().toString();

   if (TextUtils.isEmpty(strUser)){
        Toast.makeText(this, "falta User", Toast.LENGTH_LONG).show();
    }
    if (TextUtils.isEmpty(strPass)){
        Toast.makeText(this, "falta Password", Toast.LENGTH_LONG).show();
    }
    if (TextUtils.isEmpty(strNombre)){
        Toast.makeText(this, "falta Nombre", Toast.LENGTH_LONG).show();
    }

    String sqlquery = "select * from usuarios where username = '" + strUser + "'";
    Cursor c = bd.rawQuery (sqlquery,null);

    if (c.getCount() > 0) {
        ContentValues Nr = new ContentValues();
        Nr.put("username", strUser);
        Nr.put("password", strPass);
        Nr.put("user", strNombre);

        bd.insert("Usuarios", null, Nr);
        Toast.makeText(getApplicationContext(), "Usuario creado", Toast.LENGTH_SHORT);
    }
    else {
        Toast.makeText(getApplicationContext(), "Usuario ya existe", Toast.LENGTH_SHORT);
        return;
        }
}

}
