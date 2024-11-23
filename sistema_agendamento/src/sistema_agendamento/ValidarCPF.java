/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema_agendamento;

/**
 *
 * @author T-GAMER
 */
public class ValidarCPF {
    public static boolean isCPF(String cpf) {
        // Remove caracteres não numéricos
        cpf = cpf.replaceAll("[^0-9]", "");
        
        // Verifica se tem 11 dígitos e não é uma sequência repetida (ex.: "11111111111")
        if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        try {
            // Cálculo do primeiro dígito verificador
            int soma = 0;
            for (int i = 0; i < 9; i++) {
                soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
            }
            int primeiroVerificador = (soma * 10) % 11;
            if (primeiroVerificador == 10) primeiroVerificador = 0;

            // Cálculo do segundo dígito verificador
            soma = 0;
            for (int i = 0; i < 10; i++) {
                soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
            }
            int segundoVerificador = (soma * 10) % 11;
            if (segundoVerificador == 10) segundoVerificador = 0;

            // Verifica os dígitos calculados com os dígitos fornecidos
            return primeiroVerificador == Character.getNumericValue(cpf.charAt(9)) &&
                   segundoVerificador == Character.getNumericValue(cpf.charAt(10));
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public static String maskCpf(String cpf){
        return cpf.substring(0, 3) + "." +
               cpf.substring(3, 6) + "." +
               cpf.substring(6, 9) + "-" +
               cpf.substring(9, 11);
    }
    
    public static String sanitizeCpf(String cpf){
        return cpf.replace(".", "").replace("-", "");
    }
}
