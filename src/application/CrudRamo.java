package application;

import java.util.Scanner;

public class CrudRamo extends Funcoes {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int escolha;

        do {
            System.out.println("\nEscolha uma das opções abaixo ou digite 0 para sair:");
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
                    System.out.println("Saindo...");
                    break;
                case 1:
                    findIdRamo();
                    break;
                case 2:
                    findAllRamo();
                    break;
                case 3:
                    insertRamo();
                    break;
                case 4:
                    findAllRamo();
                    deleteRamo();
                    break;
                case 5:
                    findAllRamo();
                    updateRamo();
                    break;
                default:
                    System.out.println("Escolha inválida");
            }
        } while (escolha != 0);

        sc.close();
        System.out.println("Programa encerrado.");
    }
}
