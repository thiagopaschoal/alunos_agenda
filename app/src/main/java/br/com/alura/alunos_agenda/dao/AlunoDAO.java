package br.com.alura.alunos_agenda.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.alunos_agenda.model.Aluno;

public class AlunoDAO {

    private final static List<Aluno> alunos = new ArrayList<>();

    public void save(Aluno aluno) {
        alunos.add(aluno);
    }

    public List<Aluno> find() {
        return alunos;
    }
}
