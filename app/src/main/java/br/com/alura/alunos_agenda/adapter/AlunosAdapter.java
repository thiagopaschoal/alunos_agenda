package br.com.alura.alunos_agenda.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import br.com.alura.alunos_agenda.model.Aluno;

public class AlunosAdapter extends BaseAdapter {

    private final List<Aluno> alunos;

    public AlunosAdapter(List<Aluno> alunos) {
        this.alunos = alunos;
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
        return null;
    }
}
