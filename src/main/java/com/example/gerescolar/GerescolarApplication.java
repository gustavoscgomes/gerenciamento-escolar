package com.example.gerescolar;

import com.example.gerescolar.service.CrudAlunoService;
import com.example.gerescolar.service.CrudFuncionarioService;
import com.example.gerescolar.service.CrudProfessorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class GerescolarApplication implements CommandLineRunner {
	private CrudAlunoService alunoService;

	private CrudFuncionarioService funcionarioService;

	private CrudProfessorService professorService;

	public GerescolarApplication(CrudAlunoService alunoService, CrudFuncionarioService funcionarioService,
								 CrudProfessorService professorService) {
		this.alunoService = alunoService;
		this.funcionarioService = funcionarioService;
		this.professorService = professorService;
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
			System.out.println("3 - Professor");
			int opcao = scanner.nextInt();

			switch (opcao) {
				case 1 -> this.alunoService.menu(scanner);
				case 2 -> this.funcionarioService.menu(scanner);
				case 3 -> this.professorService.menu(scanner);
				default -> isTrue = false;
			}
		}
	}
}