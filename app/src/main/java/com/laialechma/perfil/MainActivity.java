package com.laialechma.perfil;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextInputEditText agregarname;
    TextView agregarfecha;
    TextInputEditText agregartelefono;
    TextInputEditText agregarmaill;
    TextInputEditText agregardescripcion;
    private DatePickerDialog fromDatePickerDialog;
    private SimpleDateFormat dateFormatter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this,getResources().getString(R.string.oncreate), Toast.LENGTH_LONG).show();


        agregarname = (TextInputEditText) findViewById(R.id.txtname);
        String name = agregarname.getText().toString();

        agregartelefono = (TextInputEditText) findViewById(R.id.txttelephone);
        String phone = agregartelefono.getText().toString();

        agregardescripcion = (TextInputEditText) findViewById(R.id.txtdescripcion);
        String descripcion = agregardescripcion.getText().toString();

        agregarmaill= (TextInputEditText) findViewById(R.id.txtmail);
        String email = agregarmaill.getText().toString();

        agregarfecha= (TextView) findViewById(R.id.fecha);

        dateFormatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

        agregarfecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar newCalendar = Calendar.getInstance();
                fromDatePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {

                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        Calendar newDate = Calendar.getInstance();
                        newDate.set(year, monthOfYear, dayOfMonth);
                        agregarfecha.setText(dateFormatter.format(newDate.getTime()));
                    }

                },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
                fromDatePickerDialog.show();
            }
        });


        Bundle parametros = getIntent().getExtras();
        if(parametros != null) {
            agregarname.setText(parametros.getString("Nombre"));
            agregardescripcion.setText(parametros.getString("Descripcion"));
            agregartelefono.setText(parametros.getString("Telefono"));
            agregarmaill.setText(parametros.getString("Mail"));
            agregarfecha.setText(parametros.getString("Fecha"));
        }


        Button botonGuardar = (Button) findViewById(R.id.botonGuardar);
        botonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,PantallaResultados.class);

                intent.putExtra(getResources().getString(R.string.pname), agregarname.getText().toString());
                intent.putExtra(getResources().getString(R.string.ptelefono), agregartelefono.getText().toString());
                intent.putExtra(getResources().getString(R.string.pmail), agregarmaill.getText().toString());
                intent.putExtra(getResources().getString(R.string.pdescripcion), agregardescripcion.getText().toString());
                intent.putExtra("Fecha", agregarfecha.getText().toString());

                startActivity(intent);
            }


        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,getResources().getString(R.string.onstart), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,getResources().getString(R.string.onrestart), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,getResources().getString(R.string.onresume), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this,getResources().getString(R.string.onpause), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,getResources().getString(R.string.onstop), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,getResources().getString(R.string.ondestroy), Toast.LENGTH_LONG).show();
    }



}
