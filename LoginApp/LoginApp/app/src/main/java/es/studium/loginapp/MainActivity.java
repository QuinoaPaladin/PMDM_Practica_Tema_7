package es.studium.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    EditText ed_login, ed_clave;
    Button btn_login;
    Switch sw_guardar;

    public static final String MyPREFERENCES = "LoginCredentials";
    public static final String Nombre = "nombreKey";
    public static final String Clave = "claveKey";

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed_login = findViewById(R.id.et_nombre);
        ed_clave = findViewById(R.id.et_clave);
        btn_login = findViewById(R.id.btn_entrar);
        sw_guardar = findViewById(R.id.sw_guardar);
        sw_guardar.setOnClickListener(this);
        btn_login.setOnClickListener(this);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        // ¿Hay ya información en las Shared Preferences?
        String compartido = sharedpreferences.getString(Nombre, null);
        if(compartido!=null)
        {
            Intent intent = new Intent(MainActivity.this,Activity_bienvenida.class);
            startActivity(intent);
        }
    }

    @Override
    public void onClick(View view)
    {
        if(view.getId() == R.id.btn_entrar)
        {
            if(sw_guardar.isChecked())
            {
                if ((ed_login.getText().toString().equals("Álvaro") && (ed_clave.getText().toString().equals("53965539"))))
                {
                    String n = ed_login.getText().toString();
                    String c = ed_clave.getText().toString();

                    SharedPreferences.Editor editor = sharedpreferences.edit();

                    editor.putString(Nombre, n);
                    editor.putString(Clave, c);
                    editor.commit();
                    Toast.makeText(MainActivity.this, "Datos guardados", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(MainActivity.this, Activity_bienvenida.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Credenciales incorrectos", Toast.LENGTH_LONG).show();
                }
            }
            else if(sw_guardar.isChecked()==false)
            {
                if ((ed_login.getText().toString().equals("Álvaro") && (ed_clave.getText().toString().equals("53965539"))))
                {
                    Intent intent = new Intent(MainActivity.this, Activity_bienvenida.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Credenciales incorrectos", Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}