package application;

import java.util.Scanner;

public class CrudEndereco extends Funcoes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int escolha;
        do {
        System.out.println("Escolha uma das opções abaixo");
        System.out.println("0 - Sair do sistema\n" +
                "1 - findId\n" +
                "2 - findAll\n" +
                "3 - insert\n" +
                "4 - delete\n" +
                "5 - update\n" +
                "Digite o numero:");
            escolha = sc.nextInt();

            switch (escolha) {
                case 0:
                    System.out.println("Saindo do sistema...");
                    // Você pode adicionar qualquer lógica de saída aqui, se necessário.
                    break;
                case 1:
                    findIdEndereco();
                    break;
                case 2:
                    findAllEndereco();
                    break;
                case 3:
                    insertEndereco();
                    break;
                case 4:
                    findAllEndereco();
                    deleteEndereco();
                    break;
                case 5:
                    findAllEndereco();
                    updateEndereco();
                    break;
                default:
                    System.out.println("Escolha inválida");
            }
        } while (escolha != 0);
    }
}
