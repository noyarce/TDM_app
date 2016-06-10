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

public void clickRegistro (View v) {
    EditText user = (EditText) findViewById(R.id.e_username);
    EditText pass = (EditText) findViewById(R.id.e_password);
    EditText nombre = (EditText) findViewById(R.id.e_name);

    String strUser;
    String strPass;
    String strNombre;

    strUser = user.getText().toString();
    strPass = pass.getText().toString();
    strNombre = nombre.getText().toString();

    if (TextUtils.isEmpty(strUser)) {
        String falta = getString(R.string.falta, "User");
        Toast.makeText(this,falta, Toast.LENGTH_LONG).show();
    return;
    }
    if (TextUtils.isEmpty(strPass)) {
        String falta = getString(R.string.falta, "Password");
        Toast.makeText(this, falta, Toast.LENGTH_LONG).show();
        return;
    }
    if (TextUtils.isEmpty(strNombre)) {
        String falta = getString(R.string.falta, "Nombre");
        Toast.makeText(this, falta , Toast.LENGTH_LONG).show();
        return;
    }

    BDUsuariosHelper BDU = new BDUsuariosHelper(getApplicationContext(), "bd_usuarios", null, 1);
    SQLiteDatabase bd = BDU.getWritableDatabase();

    Cursor c = bd.rawQuery("select * from usuarios where username = '"+strUser+"'", null);


        if (c.getCount() > 0) {
            String user_existe = getString(R.string.user_existe, strUser);
            Toast.makeText(getApplicationContext(), user_existe, Toast.LENGTH_SHORT).show();
            return;
            /*c.close(); */
        }

            ContentValues Nr = new ContentValues();

            Nr.put("username", strUser);
            Nr.put("password", strPass);
            Nr.put("user", strNombre);

            bd.insert("usuarios", null, Nr);
            Toast.makeText(getApplicationContext(), "Usuario creado", Toast.LENGTH_SHORT).show();

    }
}

