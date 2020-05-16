package br.com.alura.alunos_agenda.helper;

import android.app.Activity;
import android.widget.EditText;

import br.com.alura.alunos_agenda.R;
import br.com.alura.alunos_agenda.model.Aluno;

public class FormularioAlunoHelper {

    private final EditText inputName;
    private final EditText inputPhone;
    private final EditText inputEmail;

    private Aluno aluno;

    public FormularioAlunoHelper(Activity context) {
        this.inputName = context.findViewById(R.id.input_nome);
        this.inputEmail = context.findViewById(R.id.input_email);
        this.inputPhone = context.findViewById(R.id.input_telefone);
        this.aluno = new Aluno();
    }

    public Aluno preencheAlunos() {
        return new Aluno(this.inputName.getText().toString(),
                this.inputPhone.getText().toString(),
                this.inputEmail.getText().toString());
    }

    public void preencheFormulario(Aluno aluno) {
        this.inputName.setText(aluno.getNome());
        this.inputPhone.setText(aluno.getTelefone());
        this.inputEmail.setText(aluno.getEmail());
        this.aluno = aluno;
    }

    public Aluno getAluno() {
        return aluno;
    }
}
