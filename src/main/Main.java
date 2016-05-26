package main;

import java.util.Scanner;

import br.com.es.model.AnimalDAO;
import br.com.es.view.Animal;

public class Main {

	public static void main(String[] args) {
		int option;
		boolean end = false;
		String nome, tipo, raca;
		int id, idade;
		Animal animal;
		AnimalDAO animalDAO = new AnimalDAO();
		Scanner sc = new Scanner(System.in);
		
		while (!end) {
			System.out.println("0 - Cadastrar algo");
			System.out.println("2 - Cadastrar animal");
			System.out.println("3 - Listar um animal");
			System.out.println("4 - Apagar animal");
			System.out.println("6 - Sair");
			System.out.println("Selecione a opcao:");
			option = sc.nextInt();
			
			switch (option) {
			case 0: {
				break;
			}
			case 1: {
				break;
			}
			case 2: {
				System.out.println("Digite a idade do animal:");
				idade = sc.nextInt();
				System.out.println("Digite o nome do animal:");
				nome = sc.next();
				System.out.println("Digite o tipo do animal:");
				tipo = sc.next();
				System.out.println("Digite a raça do animal:");
				raca = sc.next();
				animal = new Animal(nome, idade, tipo, raca);
				animalDAO.addAnimal(animal);
				break;
			}
			case 3: {
				System.out.println("Digite o id o animal:");
				int idAnimal = sc.nextInt();
				animal = animalDAO.getAnimal(idAnimal);
				System.out.println("Id " + animal.getId());
				System.out.println("Nome " + animal.getNome());
				System.out.println("Idade " + animal.getIdade());
				System.out.println("Tipo " + animal.getTipo());
				System.out.println("Raça " + animal.getRaca());
				break;
			}
			case 4: {
				System.out.println("Digite o identificador do animal");
				id = sc.nextInt();
				animalDAO.removeAnimal(id);
				break;
			}
			case 5: {
				break;
			}
			case 6: {
				end = true;
				break;
			}
			}
		}
	}
}
