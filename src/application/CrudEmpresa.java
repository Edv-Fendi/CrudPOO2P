package application;

import java.util.Scanner;
import model.entities.Porte;

public class CrudEmpresa extends Funcoes {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int escolha;

        do {
            System.out.println("\nEscolha uma das opções abaixo ou digite 0 para sair:");
            System.out.println("0 - Sair\n" +
                    "1 - Selecionar pelo ID \n" +
                    "2 - Selecionar todas as Empresas\n" +
                    "3 - Inserir um nova Empresa\n" +
                    "4 - Deletar uma Eempresa\n" +
                    "5 - Atualizar uma Empresa\n" +
                    "Digite o numero:");
            escolha = sc.nextInt();

            switch (escolha){
                case 1:
                    findIdEmpresa();
                    break;
                case 2:
                    findAllEmpresa();
                    break;
                case 3:
                    insertEmpresa();
                    break;
                case 4:
                    findAllEmpresa();
                    deleteEmpresa();
                    break;
                case 5:
                    findAllEmpresa();
                    updateEmpresa();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Escolha inválida");
            }
        } while (escolha != 0);

        sc.close(); // Close the scanner only once here, after the loop
        System.out.println("Programa encerrado.");
    }
}
