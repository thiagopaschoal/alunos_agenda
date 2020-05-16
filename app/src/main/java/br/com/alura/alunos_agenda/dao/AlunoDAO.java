package br.com.alura.alunos_agenda.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.alunos_agenda.model.Aluno;

public class AlunoDAO {

    private final static List<Aluno> alunos = new ArrayList<>();

    private static long contadorDeIds = 1;

    public void save(Aluno aluno) {
        aluno.setId(contadorDeIds);
        alunos.add(aluno);
        contadorDeIds++;
    }

    public void update(Long id, Aluno aluno) {
        Aluno alunoEncontrado = null;
        for (Aluno a: alunos) {
            if (a.getId().intValue() == id.intValue()) {
                alunoEncontrado = a;
            }
        }
        final int index = alunos.indexOf(alunoEncontrado);

        aluno.setId(id);
        alunos.set(index, aluno);
    }

    public List<Aluno> find() {
        return alunos;
    }

    public void remove(Aluno aluno) {
        Aluno alunoEncontrado = null;
        for (Aluno a : alunos) {
            if (a.getId().intValue() == aluno.getId().intValue()) {
                alunoEncontrado = a;
            }
        }

        alunos.remove(alunoEncontrado);
    }
}
