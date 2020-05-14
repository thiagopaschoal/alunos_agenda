package br.com.alura.alunos_agenda.model;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Aluno implements Serializable {

    private Long id;
    private String nome;
    private String telefone;
    private String email;

    public Aluno() {
    }

    public Aluno(String id, String nome, String telefone, String email) {
        this.id = Long.parseLong(id);
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public Aluno(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public boolean hasId() {
        return id.intValue() > 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
