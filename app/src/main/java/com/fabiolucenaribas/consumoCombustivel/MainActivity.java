package com.fabiolucenaribas.consumoCombustivel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.fabiolucenaribas.consumoCombustivel.R;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    String resultado = null;
    EditText gasolina;
    EditText alcool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gasolina = (EditText) findViewById(R.id.gasolina);
        alcool = (EditText) findViewById(R.id.alcool);
        Locale mLocale = new Locale("pt", "BR");
        gasolina.addTextChangedListener(new MoneyTextWatcher(gasolina, mLocale));
        alcool.addTextChangedListener(new MoneyTextWatcher(alcool, mLocale));
        if (savedInstanceState != null) {
            resultado = savedInstanceState.getString("RESULTADO");
            //Toast.makeText(this, resultado, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("RESULTADO", resultado);
        super.onSaveInstanceState(outState);
    }

    public void onClickBtn(View v) {

        Double valorGasolina = MoneyTextWatcher.removerMascaraMonetaria(gasolina.getText().toString());
        Double valorAlcool = MoneyTextWatcher.removerMascaraMonetaria(alcool.getText().toString());
        if (!valorAlcool.equals(0.0) && !valorGasolina.equals(0.0)) {
            Double valor;
            valor = valorAlcool / valorGasolina;
            if (valor > 0.70) {
                resultado = getString(R.string.gasolina);
            } else {
                resultado = getString(R.string.alcool);
            }

            Intent i = new Intent(MainActivity.this, DisplayResultadoActivity.class);
            i.putExtra("RESULTADO", resultado);
            startActivity(i);
        }else {
            Toast.makeText(this, getString(R.string.informarValor), Toast.LENGTH_SHORT).show();
        }
    }


}
