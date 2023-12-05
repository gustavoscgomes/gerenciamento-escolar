package com.example.gerescolar.menu;

import com.example.gerescolar.model.entity.Endereco;
import com.example.gerescolar.model.entity.Funcionario;
import com.example.gerescolar.model.entity.Professor;
import com.example.gerescolar.model.enums.Cargo;
import com.example.gerescolar.repository.ProfessorRepository;
import com.example.gerescolar.service.ProfessorService;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Scanner;

@Component
public class MenuProfessor {
    private ProfessorService service;
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public MenuProfessor(ProfessorService service) {
        this.service = service;
    }

    public void menu(Scanner scanner) {
        boolean isTrue = true;

        while (isTrue) {
            System.out.println("\nQual ação você quer executar?");
            System.out.println("0 - Voltar ao menu anterior");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listagem Geral");
            System.out.println("3 - Listagem por Nome");
            System.out.println("4 - Listagem por Matricula");
            System.out.println("5 - Atualizar");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> this.cadastrar(scanner);
                case 2 -> this.listagemGeral();
                case 3 -> this.listagemPorNome(scanner);
                case 4 -> this.listagemPorMatricula(scanner);
                case 5 -> this.atualizar(scanner);
                default -> isTrue = false;
            }
        }
        System.out.println();
    }


    private void cadastrar(Scanner scanner) {
        Endereco endereco = new Endereco();

        System.out.print("Cep: ");
        endereco.setCep(scanner.next());

        System.out.print("Logradouro: ");
        endereco.setLogradouro(scanner.next());

        System.out.print("Numero: ");
        endereco.setNumero(scanner.next());

        System.out.print("Bairro: ");
        endereco.setBairro(scanner.next());

        System.out.print("Cidade: ");
        endereco.setCidade(scanner.next());

        System.out.print("Estado: ");
        endereco.setEstado(scanner.next());

        Professor professor = new Professor();

        professor.setEndereco(endereco);

        System.out.print("Digite o nome: ");
        professor.setName(scanner.next());

        System.out.print("Digite a data de nascimento: (dd/mm/aaaa): ");
        professor.setDataDeNascimento(LocalDate.parse(scanner.next(), dtf));

        System.out.print("Digite a data de contratacao: (dd/mm/aaaa): ");
        professor.setDataDeContratacao(LocalDate.parse(scanner.next(), dtf));

        System.out.print("Digite o telefone: ");
        professor.setTelefone(scanner.next());

        System.out.print("Digite o email: ");
        professor.setEmail(scanner.next());

        this.service.professorSave(professor);
        System.out.println("professor salvo no Banco!!!\n");
    }

    private void listagemGeral() {
        Iterable<Professor> professores = this.service.getProfessores();

        for (Professor professor : professores) {
            System.out.println(professor);
        }
    }

    private void listagemPorNome(Scanner scanner) {
        System.out.print("Digite o nome do professor a ser consultado: ");
        String name = scanner.next();

        Iterable<Professor> professores = service.getProfessorByName(name);

        for (Professor professor : professores) {
            System.out.println(professor);
        }
    }

    private void listagemPorMatricula (Scanner scanner){
        System.out.print("Digite a matricula: ");
        Long matricula = scanner.nextLong();

        Professor professor = service.getProfessorById(matricula);

        if (professor != null) {
            System.out.println(professor);
        }
        else {
            System.out.println("A matricula do professor informado: " + matricula + " é inválida\n");
        }

    }

    private void atualizar(Scanner scanner) {
        System.out.print("Digite a matricula do professor a ser atualizado: ");
        Long matricula = scanner.nextLong();

        Professor professor = this.service.getProfessorById(matricula);

        if (professor != null) {


            System.out.print("Cep: ");
            professor.getEndereco().setCep(scanner.next());

            System.out.print("Logradouro: ");
            professor.getEndereco().setLogradouro(scanner.next());

            System.out.print("Numero: ");
            professor.getEndereco().setNumero(scanner.next());

            System.out.print("Bairro: ");
            professor.getEndereco().setBairro(scanner.next());

            System.out.print("Cidade: ");
            professor.getEndereco().setCidade(scanner.next());

            System.out.print("Estado: ");
            professor.getEndereco().setEstado(scanner.next());

            System.out.print("Digite o nome: ");
            professor.setName(scanner.next());

            System.out.print("Digite a data de nascimento: (dd/mm/aaaa): ");
            professor.setDataDeNascimento(LocalDate.parse(scanner.next(), dtf));

            System.out.print("Digite a data de contratacao: (dd/mm/aaaa): ");
            professor.setDataDeContratacao(LocalDate.parse(scanner.next(), dtf));

            System.out.print("Digite o telefone: ");
            professor.setTelefone(scanner.next());

            System.out.print("Digite o email: ");
            professor.setEmail(scanner.next());


            service.professorSave(professor);

        } else {
            System.out.println("A matricula do professor informado: " + matricula + " é inválida\n");
        }
    }
}
