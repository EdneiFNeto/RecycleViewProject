package com.example.recycleviewproject.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import com.example.recycleviewproject.R;
import com.example.recycleviewproject.dao.NotaDAO;
import com.example.recycleviewproject.model.Nota;

public class FormularioNotaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_nota);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.item_done:
                salvar();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void salvar() {
        EditText titulo     = findViewById(R.id.formulario_nota_titulo);
        EditText descricao  = findViewById(R.id.formulario_nota_titulo);
        Nota nota = new Nota(titulo.getText().toString(), descricao.getText().toString());

        Intent resultadoInsercao = new Intent();
        resultadoInsercao.putExtra("nota", nota);
        //devolve a nota para a activity
        setResult(2, resultadoInsercao);
        finish();
    }
}
