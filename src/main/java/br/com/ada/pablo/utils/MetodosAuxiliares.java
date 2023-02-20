package br.com.ada.pablo.utils;

import java.util.ArrayList;
import java.util.List;

public class MetodosAuxiliares {
    private static List<String> listaCpf = new ArrayList<>();

    public static void adicionarCpf(String cpf) {
        listaCpf.add(cpf);
    }

    public static boolean contemCpf(String cpf) {
        return listaCpf.contains(cpf);
    }
}
