package br.com.alura.alunos_agenda.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Arrays;
import java.util.List;

import br.com.alura.alunos_agenda.R;
import br.com.alura.alunos_agenda.dao.AlunoDAO;
import br.com.alura.alunos_agenda.model.Aluno;

public class ListaAlunosActivity extends AppCompatActivity /* Ajuda a dar suporte a versões anteriores do Android */ {

    private ListView viewAlunos;

    private ArrayAdapter<Aluno> adapterDeAlunos;

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

        viewAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> alunosAdapter, View view, int position, long id) {
                Aluno alunoSelecionado = (Aluno) viewAlunos.getItemAtPosition(position);
                Intent alterarAlunoActivity = new Intent(ListaAlunosActivity.this, FormularioAlunoActivity.class);
                alterarAlunoActivity.putExtra("aluno", alunoSelecionado);
                startActivity(alterarAlunoActivity);
            }
        });

        registerForContextMenu(viewAlunos);
        init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        init();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_context_lista, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo)
                item.getMenuInfo();

        if (item.getItemId() == R.id.menu_remover) {
            AlunoDAO alunoDAO = new AlunoDAO();
            Aluno aluno = adapterDeAlunos.getItem(menuInfo.position);
            alunoDAO.remove(aluno);
        }

        init();

        return super.onContextItemSelected(item);
    }

    private void init() {

        final List<Aluno> alunos = new AlunoDAO().find();
        adapterDeAlunos = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                alunos);

        viewAlunos.setAdapter(adapterDeAlunos);
    }
}
