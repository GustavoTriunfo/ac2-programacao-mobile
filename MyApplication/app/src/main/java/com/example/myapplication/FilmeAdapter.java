package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class FilmeAdapter extends RecyclerView.Adapter<FilmeAdapter.FilmeViewHolder> {

    private Context context;
    private List<Filme> filmes;

    public FilmeAdapter(Context context, List<Filme> filmes) {
        this.context = context;
        this.filmes = filmes;
    }

    public static class FilmeViewHolder extends RecyclerView.ViewHolder {
        TextView titulo, ano, diretor;
        ImageView imagem;
        Button buttonSinopse;

        public FilmeViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.textViewTitulo);
            ano = itemView.findViewById(R.id.textViewAno);
            diretor = itemView.findViewById(R.id.textViewDiretor);
            imagem = itemView.findViewById(R.id.imageViewPoster);
            buttonSinopse = itemView.findViewById(R.id.buttonSinopse);
        }
    }

    @NonNull
    @Override
    public FilmeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_filme, parent, false);
        return new FilmeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmeViewHolder holder, int position) {
        Filme filme = filmes.get(position);
        holder.titulo.setText(filme.getTitulo());
        holder.ano.setText(String.valueOf(filme.getAno()));
        holder.diretor.setText(filme.getDiretor());
        holder.imagem.setImageResource(filme.getImagem());

        holder.buttonSinopse.setOnClickListener(v ->
                Toast.makeText(context, filme.getSinopse(), Toast.LENGTH_SHORT).show()
        );
    }

    @Override
    public int getItemCount() {
        return filmes.size();
    }
}
