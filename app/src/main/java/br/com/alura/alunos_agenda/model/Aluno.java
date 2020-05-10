package br.com.alura.alunos_agenda.model;

import androidx.annotation.NonNull;

public class Aluno {

    private String nome;
    private String telefone;
    private String email;

    public Aluno(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    @NonNull
    @Override
    public String toString() {
        return this.getNome();
    }
}
