package br.com.ada.pablo.utils;

import java.text.DecimalFormat;

public class ValidaCpf {

    public static boolean validarCpf(String cpf) {
        if (cpf == null || cpf.length() != 11) {
            return false;
        }

        int[] numeros = new int[11];
        for (int i = 0; i < 11; i++) {
            char c = cpf.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
            numeros[i] = Character.getNumericValue(c);
        }

        int soma1 = 0;
        int soma2 = 0;
        for (int i = 0; i < 9; i++) {
            soma1 += numeros[i] * (10 - i);
            soma2 += numeros[i] * (11 - i);
        }

        int digito1 = 11 - (soma1 % 11);
        if (digito1 > 9) {
            digito1 = 0;
        }

        soma2 += digito1 * 2;
        int digito2 = 11 - (soma2 % 11);
        if (digito2 > 9) {
            digito2 = 0;
        }

        return numeros[9] == digito1 && numeros[10] == digito2;
    }

    public static String formatarCpf(String cpf) {
        DecimalFormat format = new DecimalFormat("###.###.###-##");
        return format.format(Long.parseLong(cpf));
    }
}
