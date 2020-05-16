package br.com.alura.alunos_agenda.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.alura.alunos_agenda.R;
import br.com.alura.alunos_agenda.model.Aluno;

public class AlunosAdapter extends BaseAdapter {

    private final List<Aluno> alunos;

    private final Context context;

    public AlunosAdapter(Context context, List<Aluno> alunos) {
        this.alunos = alunos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.alunos.size();
    }

    @Override
    public Object getItem(int position) {
        return this.alunos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.alunos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final View view = getView(parent);
        final Aluno aluno = this.alunos.get(position);
        attach(view, aluno);
        return view;
    }

    private View getView(ViewGroup parent) {
       return LayoutInflater.from(context).inflate(R.layout.item_alunos, parent, false);
    }

    private void attach(View view, Aluno aluno) {

        TextView nome = view.findViewById(R.id.item_aluno_nome);
        TextView telefone = view.findViewById(R.id.item_aluno_telefone);

        if (aluno != null) {
            nome.setText(aluno.getNome());
            telefone.setText(aluno.getTelefone());
        }
    }
}
