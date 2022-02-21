package es.studium.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Activity_bienvenida extends AppCompatActivity implements View.OnClickListener
{
    Button btn_borrar;

    public static final String MyPREFERENCES = "LoginCredentials";
    public static final String Nombre = "nombreKey";
    public static final String Clave = "claveKey";

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);

        btn_borrar = findViewById(R.id.btn_borrar);
        btn_borrar.setOnClickListener(this);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
    }

    @Override
    public void onClick(View view)
    {
        if(view.getId()==R.id.btn_borrar)
        {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.clear();
            editor.commit();
            Toast.makeText(Activity_bienvenida.this, "Credenciales eliminadas", Toast.LENGTH_SHORT).show();
        }
    }
}