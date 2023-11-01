package application;

import java.util.Scanner;

import model.entities.Porte;

public class CrudPorte extends Funcoes {
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
				findIdPorte();
				break;
			case 1:
				findAllPorte();
				break;
			case 2:
				insertPorte();
				break;
			case 3:
				deletePorte();
				break;
			case 4:
				updatePorte();
				break;
			default:
				System.out.println("escolha invalida");
		}
	}
}
