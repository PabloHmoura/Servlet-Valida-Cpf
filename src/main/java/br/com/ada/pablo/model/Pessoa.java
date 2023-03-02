package br.com.ada.pablo.model;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {
    private String nome;
    private String cpf;

    public Pessoa (String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return "nome: " + nome  +
                ", cpf:" + cpf;
    }
}
