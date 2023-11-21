package com.example.gerescolar;

import com.example.gerescolar.service.CrudAlunoService;
import com.example.gerescolar.service.CrudFuncionarioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class GerescolarApplication implements CommandLineRunner {
	private CrudAlunoService alunoService;

	private CrudFuncionarioService funcionarioService;

	public GerescolarApplication(CrudAlunoService alunoService, CrudFuncionarioService funcionarioService) {
		this.alunoService = alunoService;
		this.funcionarioService = funcionarioService;
	}

	public static void main(String[] args) {
		SpringApplication.run(GerescolarApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Boolean isTrue = true;
		Scanner scanner = new Scanner(System.in);

		while (isTrue) {
			System.out.println("Qual entidade você deseja interagir?");
			System.out.println("0 - Sair");
			System.out.println("1 - Aluno");
			System.out.println("2 - Funcionario");
			int opcao = scanner.nextInt();

			switch (opcao) {
				case 1:
					this.alunoService.menu(scanner);
					break;
				case 2:
					this.funcionarioService.menu(scanner);
					break;
				default:
					isTrue = false;
					break;
			}
		}
	}
}