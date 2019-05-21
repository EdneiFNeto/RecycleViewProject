package com.example.recycleviewproject.ui.adapter;

import android.content.Context;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.recycleviewproject.R;
import com.example.recycleviewproject.model.Nota;

import java.util.List;

public class RecycleviewNotasAdapter extends RecyclerView.Adapter<RecycleviewNotasAdapter.NotaViewHolder> {

    public static final String TAG = "LogRecycleview";
    private final Context context;
    private final List<Nota> notas;

    public RecycleviewNotasAdapter(Context context, List<Nota> notas) {

        this.context    = context;
        this.notas      = notas;
    }

    //create layout
    @Override
    public RecycleviewNotasAdapter.NotaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        //instance layout item_nota
        View view = LayoutInflater.from(context).inflate(R.layout.item_nota, viewGroup, false);
        //instance class holder
        return new NotaViewHolder(view);
    }


    //cada interacao com a lista ele sera executado varias vezes
    @Override
    public void onBindViewHolder(@NonNull RecycleviewNotasAdapter.NotaViewHolder holder, int position) {
        //get class Nota
        Nota nota = notas.get(position);
        //chama o metodo da class NotaViewHolder
        holder.addNota(nota);

    }

    @Override
    public int getItemCount() {
        return this.notas.size();
    }


    //class interna
    class NotaViewHolder extends RecyclerView.ViewHolder {

        private final TextView titulo;
        private final TextView descr;

        public NotaViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo  = itemView.findViewById(R.id.item_nota_titulo);
            descr   = itemView.findViewById(R.id.item_nota_descricao);
        }

        public void addNota(Nota nota){

            titulo.setText(nota.getTitulo());
            descr.setText(nota.getDescricao());
        }
    }
}
