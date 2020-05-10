package br.com.alura.alunos_agenda.helper;

import android.app.Activity;
import android.content.Context;
import android.widget.EditText;

import br.com.alura.alunos_agenda.R;
import br.com.alura.alunos_agenda.model.Aluno;

public class FormularioAlunoHelper {

    private EditText inputName;
    private EditText inputPhone;
    private EditText inputEmail;

    public FormularioAlunoHelper(Activity context) {
        this.inputName = context.findViewById(R.id.input_nome);
        this.inputEmail = context.findViewById(R.id.input_email);
        this.inputPhone = context.findViewById(R.id.input_telefone);
    }

    public Aluno getAluno() {
        return new Aluno(this.inputName.getText().toString(),
                this.inputPhone.getText().toString(),
                this.inputEmail.getText().toString());
    }

}
