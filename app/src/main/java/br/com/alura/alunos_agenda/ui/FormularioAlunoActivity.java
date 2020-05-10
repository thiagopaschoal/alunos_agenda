package br.com.alura.alunos_agenda.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.com.alura.alunos_agenda.R;
import br.com.alura.alunos_agenda.dao.AlunoDAO;
import br.com.alura.alunos_agenda.helper.FormularioAlunoHelper;
import br.com.alura.alunos_agenda.model.Aluno;

public class FormularioAlunoActivity extends AppCompatActivity {

    private FormularioAlunoHelper alunoHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        setTitle("Novo aluno");

        this.alunoHelper = new FormularioAlunoHelper(this);

        Button salvarAluno = findViewById(R.id.btn_salvar_aluno);
        salvarAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Aluno aluno = alunoHelper.getAluno();
                final AlunoDAO alunoDAO = new AlunoDAO();
                alunoDAO.save(aluno);
                String msg = "%s cadastrado com sucesso.";
                Toast.makeText(FormularioAlunoActivity.this, String.format(msg, aluno.getNome()), Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
