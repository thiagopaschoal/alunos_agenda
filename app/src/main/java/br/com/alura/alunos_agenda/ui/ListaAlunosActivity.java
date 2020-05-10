package br.com.alura.alunos_agenda.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Arrays;
import java.util.List;

import br.com.alura.alunos_agenda.R;
import br.com.alura.alunos_agenda.dao.AlunoDAO;
import br.com.alura.alunos_agenda.model.Aluno;

public class ListaAlunosActivity extends AppCompatActivity /* Ajuda a dar suporte a versões anteriores do Android */ {

    private ListView viewAlunos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Lista de Alunos");

        viewAlunos = findViewById(R.id.alunos);
        FloatingActionButton fabNovoAluno = findViewById(R.id.fab_novo_aluno);

        fabNovoAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent novoFormularioActivity = new Intent(ListaAlunosActivity.this, FormularioAlunoActivity.class);
                startActivity(novoFormularioActivity);
            }
        });

        init();

    }

    @Override
    protected void onResume() {
        super.onResume();
        init();
    }

    private void init() {

        final List<Aluno> alunos = new AlunoDAO().find();

        final ArrayAdapter<Aluno> adapterDeAlunos = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                alunos);

        viewAlunos.setAdapter(adapterDeAlunos);
    }
}
