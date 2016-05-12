package com.laialechma.perfil;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PantallaResultados extends AppCompatActivity {

    TextView nameView;
    TextView phoneView;
    TextView mailView;
    TextView descripcionView;
    TextView fechaView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_resultados);


       Bundle parametros = getIntent().getExtras();
        String name = parametros.getString(getResources().getString(R.string.pname));
        String phone = parametros.getString(getResources().getString(R.string.ptelefono));
        String mail = parametros.getString(getResources().getString(R.string.pmail));
        String descripcion = parametros.getString(getResources().getString(R.string.pdescripcion));
        String fecha = parametros.getString(getResources().getString(R.string.pfecha));


        nameView = (TextView) findViewById(R.id.nameView);
        phoneView = (TextView) findViewById(R.id.phoneView);
        mailView = (TextView) findViewById(R.id.mailView);
        descripcionView = (TextView) findViewById(R.id.descripionView);
        fechaView = (TextView) findViewById(R.id.fechaView);

        nameView.setText(name);
        phoneView.setText(phone);
        mailView.setText(mail);
        descripcionView.setText(descripcion);
        fechaView.setText(fecha);


        Button botonModificar = (Button) findViewById(R.id.botonModificar);
        botonModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PantallaResultados.this, MainActivity.class);
                intent.putExtra(getResources().getString(R.string.pname), nameView.getText().toString());
                intent.putExtra(getResources().getString(R.string.ptelefono), phoneView.getText().toString());
                intent.putExtra(getResources().getString(R.string.pmail), mailView.getText().toString());
                intent.putExtra(getResources().getString(R.string.pdescripcion), descripcionView.getText().toString());
                intent.putExtra(getResources().getString(R.string.pfecha), fechaView.getText().toString());
                startActivity(intent);


            }

        });
    }








}

