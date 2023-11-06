package application;

import java.util.Scanner;

import model.entities.Porte;

public class CrudRamo extends Funcoes {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Escolha uma das opções abaixo");
        System.out.println("0 - findId\n" +
                "1 - findAll\n" +
                "2 - insert\n" +
                "3 - delete\n" +
                "4 - update\n" +
                "Digite o numero:");
        Integer escolha = sc.nextInt();

        switch (escolha){
            case 0:
                findIdRamo();
                break;
            case 1:
                findAllRamo();
                break;
            case 2:
                insertRamo();
                break;
            case 3:
                deleteRamo();
                break;
            case 4:
                updateRamo();
                break;
            default:
                System.out.println("escolha invalida");
        }
    }
}
