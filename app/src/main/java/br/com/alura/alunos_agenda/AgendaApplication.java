package br.com.alura.alunos_agenda;

import android.app.Application;

import br.com.alura.alunos_agenda.dao.AlunoDAO;
import br.com.alura.alunos_agenda.model.Aluno;

@SuppressWarnings("unused")
class AgendaApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AlunoDAO alunoDAO = new AlunoDAO();
        alunoDAO.save(new Aluno("Thiago Sakurai Paschoal", "1122312995", "thiagopaschoal076@gmail.com"));
    }
}
