package com.example.gerescolar.service;

import com.example.gerescolar.model.entity.Endereco;
import com.example.gerescolar.model.entity.Professor;
import com.example.gerescolar.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Scanner;

@Service
public class CrudProfessorService {

    private ProfessorRepository professorRepository;

    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    public CrudProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
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
//                case 3 -> this.listagemPorNome(scanner);
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

        System.out.print("Complemento: ");
        endereco.setComplemento(scanner.next());

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

        this.professorRepository.save(professor);
        System.out.println("professor salvo no Banco!!!\n");
    }

    private void listagemGeral() {
        Iterable<Professor> professores = this.professorRepository.findAll();

        for (Professor professor : professores) {
            System.out.println(professor);
        }
    }

//    private void listagemPorNome(Scanner scanner) {
//        System.out.print("Digite o nome do professor a ser consultado: ");
//        String name = scanner.next();
//
//        Iterable<Professor> professores = this.professorRepository.findByName(name);
//
//        for (Professor professor : professores) {
//            System.out.println(professor);
//        }
//    }

    private void listagemPorMatricula (Scanner scanner){
        System.out.print("Digite a matricula: ");
        Long matricula = scanner.nextLong();

        Optional<Professor> optional = this.professorRepository.findById(matricula);

        if (optional.isPresent()) {
            System.out.println(optional);
        }
        else {
            System.out.println("A matricula do professor informado: " + matricula + " é inválida\n");
        }

    }

    private void atualizar(Scanner scanner) {
        System.out.print("Digite a matricula do professor a ser atualizado: ");
        Long matricula = scanner.nextLong();

        Optional<Professor> optional = this.professorRepository.findById(matricula);

        if (optional.isPresent()) {
            Professor professor = optional.get();

            System.out.print("Digite o nome: ");
            professor.setName(scanner.next());
            System.out.print("Digite o telefone: ");
            professor.setTelefone(scanner.next());
            System.out.print("Digite o email: ");
            professor.setEmail(scanner.next());

            professorRepository.save(professor);
        } else {
            System.out.println("A matricula do professor informado: " + matricula + " é inválida\n");
        }
    }
}
