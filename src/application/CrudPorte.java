package application;

import java.util.Scanner;
import model.entities.Porte;

public class CrudPorte extends Funcoes {
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

			switch (escolha){
				case 1:
					findIdPorte();
					break;
				case 2:
					findAllPorte();
					break;
				case 3:
					insertPorte();
					break;
				case 4:
					deletePorte();
					break;
				case 5:
					findAllPorte();
					updatePorte();
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
