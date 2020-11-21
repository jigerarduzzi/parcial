package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    static List<String> vars = new ArrayList<>();

    EditText nombre ;
    RadioGroup sexo ;
    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre = findViewById(R.id.editTextNombrePersona);
        sexo = findViewById(R.id.GrbG1);
        boton = findViewById(R.id.button);

        BroadcastReceiver br = new MyReceiver();
        IntentFilter filtro = new IntentFilter();
        filtro.addAction(MyReceiver.parcial);
        getApplication().getApplicationContext().registerReceiver(br, filtro);


        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("corrio","corrio");
                Runnable r = new Runnable() {
                    @Override
                    public void run() {

                        vars.add(nombre.getText().toString());
                        if(sexo.getCheckedRadioButtonId()==1){
                            vars.add("masculino");

                        }else{
                            vars.add("femenino");

                        }
                        NotificationManagerCompat nm;
                        NotificationManagerCompat.from(getApplicationContext());
                       // NotificationManagerCompat.notify(99,mBuilder.build());
                        //ACA TENGO QUE ENVIAR LA NOTIFICACION PERO ME QUEDE SIN TIEMPO!!!!!

                    }
                };


            }
        });
    }


}