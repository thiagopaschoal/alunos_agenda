package br.com.alura.alunos_agenda.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.com.alura.alunos_agenda.R;
import br.com.alura.alunos_agenda.dao.AlunoDAO;
import br.com.alura.alunos_agenda.helper.FormularioAlunoHelper;
import br.com.alura.alunos_agenda.model.Aluno;

public class FormularioAlunoActivity extends AppCompatActivity {

    private FormularioAlunoHelper alunoHelper;
    private Aluno aluno = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        this.alunoHelper = new FormularioAlunoHelper(this);

        if (getIntent().hasExtra("aluno")) {
            this.aluno = (Aluno) getIntent().getSerializableExtra("aluno");
            this.alunoHelper.preencheFormulario(aluno);
            setTitle("Editar aluno");
        } else {
            setTitle("Novo aluno");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_save, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_save) {

            final AlunoDAO alunoDAO = new AlunoDAO();
            final Aluno aluno = alunoHelper.preencheAlunos();
            String msg = null;

            if (alunoHelper.getAluno() != null && alunoHelper.getAluno().getId() != null) {
                Long id = alunoHelper.getAluno().getId();
                alunoDAO.update(id, aluno);
                msg = "%s atualizado com sucesso.";
            } else {
                alunoDAO.save(aluno);
                msg = "%s cadastrado com sucesso.";
            }

            Toast.makeText(FormularioAlunoActivity.this,
                    String.format(msg, aluno.getNome()),
                    Toast.LENGTH_SHORT).show();

            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
