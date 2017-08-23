package com.fabiolucenaribas.consumoCombustivel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.fabiolucenaribas.consumoCombustivel.R;

/**
 * Created by Fábio Lucena Ribas on 20/08/2017.
 */

public class DisplayResultadoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_resultado);
        Intent i = this.getIntent();
        EditText viewResultado = (EditText) findViewById(R.id.resultado);
        viewResultado.setText(i.getStringExtra("RESULTADO"));
        disableEditText(viewResultado);
    }

    private void disableEditText(EditText editText) {
        editText.setFocusable(false);
        editText.setEnabled(false);
        editText.setCursorVisible(false);
        editText.setKeyListener(null);
    }

}
