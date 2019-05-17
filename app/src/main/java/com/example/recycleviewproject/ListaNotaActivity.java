package com.example.recycleviewproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.recycleviewproject.dao.NotaDAO;
import com.example.recycleviewproject.model.Nota;
import com.example.recycleviewproject.ui.adapter.ListaNotasAdapter;

import java.util.Arrays;
import java.util.List;

public class ListaNotaActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_notas);

        ListView listView = (ListView) findViewById(R.id.listView);
        NotaDAO dao = new NotaDAO();
        for (int i = 0; i < 1000; i++)
            dao.insere(new Nota("Titulo "+i, "Decricao "+i));

        List<Nota> notas = dao.todos();

        listView.setAdapter(new ListaNotasAdapter(this, notas));

    }
}
