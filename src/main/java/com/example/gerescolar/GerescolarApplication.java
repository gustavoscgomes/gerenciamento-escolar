package com.example.gerescolar;

import com.example.gerescolar.menu.MenuAluno;
import com.example.gerescolar.menu.MenuFuncionario;
import com.example.gerescolar.menu.MenuProfessor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class GerescolarApplication implements CommandLineRunner {
	private final MenuAluno menuAluno;

	private final MenuFuncionario menuFuncionario;

	private final MenuProfessor menuProfessor;

	public GerescolarApplication(MenuAluno menuAluno, MenuFuncionario menuFuncionario, MenuProfessor menuProfessor) {
		this.menuAluno = menuAluno;
		this.menuFuncionario = menuFuncionario;
		this.menuProfessor = menuProfessor;
	}

	public static void main(String[] args) {
		SpringApplication.run(GerescolarApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		boolean isTrue = true;
		Scanner scanner = new Scanner(System.in);

		while (isTrue) {
			System.out.println("Qual entidade você deseja interagir?");
			System.out.println("0 - Sair");
			System.out.println("1 - Aluno");
			System.out.println("2 - Funcionario");
			System.out.println("3 - Professor");
			int opcao = scanner.nextInt();

			switch (opcao) {
				case 1 -> this.menuAluno.menu(scanner);
				case 2 -> this.menuFuncionario.menu(scanner);
				case 3 -> this.menuProfessor.menu(scanner);
				default -> isTrue = false;
			}
		}
	}
}