package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txtnPeso;
    EditText txtnEdad;
    EditText txtnEstatura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtnPeso = findViewById(R.id.txtnPeso);
        txtnEdad = findViewById(R.id.txtnEdad);
        txtnEstatura = findViewById(R.id.txtnEstatura);

    }
    @SuppressLint("SetTextI18n")
    public void imc(View vista) {
        String nPeso = txtnPeso.getText().toString();
        String nEdad = txtnEdad.getText().toString();
        String nEstatura = txtnEstatura.getText().toString();

        if (nPeso.equals("") || nEdad.equals("") || nEstatura.equals("")) {
            Toast.makeText(getApplicationContext(), "Por favor llene los datos", Toast.LENGTH_LONG).show();
        } else {
            float n1Peso = Float.parseFloat(nPeso);
            int n2Edad = Integer.parseInt(nEdad);
            float n3Estatura = Float.parseFloat(nEstatura);
            n3Estatura = n3Estatura / 100;
            float imc = n1Peso / (n3Estatura * n3Estatura);
            String imcTexto = String.format("%.1f", imc);

            TextView txtnResultado = findViewById(R.id.txtResultado);

            if (imc < 18.5f) {
                txtnResultado.setText("Edad: " + n2Edad + "\n" + "Masa corporal: " + imcTexto + "\n" + "Usted está desnutrido");
            } else if (imc >= 18.5f && imc < 25) {
                txtnResultado.setText("Edad: " + n2Edad + "\n" + "Masa corporal: " + imcTexto + "\n" + "Usted está normal");
            } else if (imc >= 25 && imc < 30) {
                txtnResultado.setText("Edad: " + n2Edad + "\n" + "Masa corporal: " + imcTexto + "\n" + "Usted tiene sobrepeso");
            } else if (imc >= 30 && imc < 35) {
                txtnResultado.setText("Edad: " + n2Edad + "\n" + "Masa corporal: " + imcTexto + "\n" + "Usted tiene sobrepeso nivel 1");
            } else if (imc >= 35 && imc < 40) {
                txtnResultado.setText("Edad: " + n2Edad + "\n" + "Masa corporal: " + imcTexto + "\n" + "Usted tiene sobrepeso nivel 2");
            } else {
                txtnResultado.setText("Edad: " + n2Edad + "\n" + "Masa corporal: " + imcTexto + "\n" + "Usted tiene sobrepeso nivel 3");
            }
        }
    }
}