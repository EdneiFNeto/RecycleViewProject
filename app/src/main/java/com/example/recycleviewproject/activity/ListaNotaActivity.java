package com.example.recycleviewproject.activity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.recycleviewproject.R;
import com.example.recycleviewproject.dao.NotaDAO;
import com.example.recycleviewproject.model.Nota;
import com.example.recycleviewproject.ui.adapter.RecycleviewNotasAdapter;
import java.util.List;

public class ListaNotaActivity extends AppCompatActivity {

    public static final String TAG = "LogMain";
    private RecyclerView recycleview;
    private TextView inserir_notas;
    private RecycleviewNotasAdapter adapter;
    private List<Nota> todasNotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_lista_notas);

        todasNotas = carregarListaDeNota();
        recycleview = findViewById(R.id.recycle_view);
        createRecycleView(todasNotas);

        inserir_notas = findViewById(R.id.inserir_nota);
        inserir_notas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iniciarFormularioNota = new Intent(ListaNotaActivity.this, FormularioNotaActivity.class );
                startActivityForResult(iniciarFormularioNota, 1);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void createRecycleView(List<Nota> notas) {
        adapter = new RecycleviewNotasAdapter(this, notas);
        recycleview.setAdapter(adapter);
    }

    private List<Nota> carregarListaDeNota() {
        NotaDAO dao = new NotaDAO();
        dao.insere(new Nota("Titulo ", "Decricao 1"), new Nota("Titulo ", "Decricao 2"));
        List<Nota> notas = dao.todos();
        return notas;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        //codigo enviado, codigo recebido, extra
        if (requestCode == 1 && resultCode == 2 && data.hasExtra("nota")){
            Nota notaRecebida = (Nota) data.getSerializableExtra("nota");
            new NotaDAO().insere(notaRecebida);
            adiciona(notaRecebida);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void adiciona(Nota nota){
        todasNotas.add(nota);
        adapter.notifyDataSetChanged();//atualiza a nota
    }
}
