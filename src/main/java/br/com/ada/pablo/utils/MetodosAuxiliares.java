package br.com.ada.pablo.utils;

import br.com.ada.pablo.model.Pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MetodosAuxiliares {
    private static List<Pessoa> listaCpf = new ArrayList<>();

    public static void adicionarCpf(Pessoa pessoa) {
        listaCpf.add(pessoa);
    }

    public static boolean contemCpf(String cpf) {
        return listaCpf.stream().map(Pessoa::getCpf).findFirst().equals(cpf);

    }

    public static Pessoa retornaPessoa(String cpf) {
        return listaCpf.stream().filter(pessoa -> pessoa.getCpf().equals(cpf)).findFirst().get();
    }

}
