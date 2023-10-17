package com.sample;

import java.time.LocalDate;

public class PessoaModel {
    private int Id;
    private String Nome;
    private LocalDate DataNascimento;
    private int Tipo;

    public PessoaModel(int id, String nome, LocalDate dataNascimento, int tipo) {
        Id = id;
        Nome = nome;
        DataNascimento = dataNascimento;
        Tipo = tipo;
    }

    public PessoaModel() {

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public LocalDate getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        DataNascimento = dataNascimento;
    }

    public int getTipo() {
        return Tipo;
    }

    public void setTipo(int tipo) {
        Tipo = tipo;
    }

    @Override
    public String toString() {
        return "PessoaModel [DataNascimento=" + DataNascimento + ", Id=" + Id + ", Nome=" + Nome + ", Tipo=" + Tipo
                + "]";
    }
}
