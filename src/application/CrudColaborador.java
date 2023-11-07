package application;

import java.util.Scanner;


public class CrudColaborador extends Funcoes {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Escolha uma das opções abaixo:");
        System.out.println("0 - findId\n" +
                "1 - findAll\n" +
                "2 - insert\n" +
                "3 - delete\n" +
                "4 - update\n" +
                "Digite o número:");
        int escolha = sc.nextInt();

        switch (escolha) {
            case 0:
                findIdColaborador();
                break;
            case 1:
                findAllColaborador();
                break;
            case 2:
                insertColaborador();
                break;
            case 3:
                deleteColaborador();
                break;
            case 4:
                updateColaborador();
                break;
            default:
                System.out.println("Escolha inválida");
        }
    }
}

