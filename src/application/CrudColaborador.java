package application;

import java.util.Scanner;

public class CrudColaborador extends Funcoes {
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
                    findIdColaborador();
                    break;
                case 2:
                    findAllColaborador();
                    break;
                case 3:
                    insertColaborador();
                    break;
                case 4:
                    findAllColaborador();
                    deleteColaborador();
                    break;
                case 5:
                    findAllColaborador();
                    updateColaborador();
                    break;
                default:
                    System.out.println("Escolha inválida");
            }
        } while (escolha != 0);
    }
}
