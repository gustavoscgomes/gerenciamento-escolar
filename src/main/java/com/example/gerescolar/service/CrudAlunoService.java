package com.example.gerescolar.service;

import com.example.gerescolar.model.entity.Aluno;
import com.example.gerescolar.model.entity.Endereco;
import com.example.gerescolar.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Scanner;

@Service
public class CrudAlunoService {
    private final AlunoRepository alunoRepository;
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public CrudAlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public void menu(Scanner scanner) {
        Boolean isTrue = true;

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
                case 1:
                    this.cadastrar(scanner);
                    break;
                case 2:
                    this.listagemGeral();
                    break;
                case 3:
                    this.listagemPorNome(scanner);
                    break;
                case 4:
                    this.listagemPorMatricula(scanner);
                    break;
                case 5:
                    this.atualizar(scanner);
                    break;
                default:
                    isTrue = false;
                    break;
            }
        }
        System.out.println();
    }


    private void cadastrar(Scanner scanner) {
        Endereco endereco = new Endereco();

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

        Aluno aluno = new Aluno();

        System.out.print("Digite o nome: ");
        aluno.setName(scanner.next());
        System.out.print("Digite a data de nascimento: (dd/mm/aaaa): ");
        aluno.setDataDeNascimento(LocalDate.parse(scanner.next(), dtf));
        System.out.print("Digite o telefone: ");
        aluno.setTelefone(scanner.next());
        System.out.print("Digite o email: ");
        aluno.setEmail(scanner.next());

        aluno.setEndereco(endereco);

        this.alunoRepository.save(aluno);
        System.out.println("Aluno salvo no Banco!!!\n");
    }

    private void listagemGeral() {
        Iterable<Aluno> alunos = this.alunoRepository.findAll();

        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }
    }

    private void listagemPorNome(Scanner scanner) {
        System.out.print("Digite o nome do aluno a ser consultado: ");
        String name = scanner.next();

        Iterable<Aluno> alunos = this.alunoRepository.findByName(name);

        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }
    }

    private void listagemPorMatricula(Scanner scanner) {
        System.out.print("Digite a matricula do aluno: ");
        Long matricula = scanner.nextLong();

        Optional<Aluno> optional = this.alunoRepository.findById(matricula);

        System.out.println(optional);

    }
    private void atualizar(Scanner scanner) {
        System.out.print("Digite a matricula do aluno a ser atualizado: ");
        Long matricula = scanner.nextLong();

        Optional<Aluno> optional = this.alunoRepository.findById(matricula);

        if (optional.isPresent()) {
            Aluno aluno = optional.get();

            System.out.print("Digite o nome: ");
            aluno.setName(scanner.next());
            System.out.print("Digite o telefone: ");
            aluno.setTelefone(scanner.next());
            System.out.print("Digite o email: ");
            aluno.setEmail(scanner.next());

            alunoRepository.save(aluno);
        }
        else {
            System.out.println("A matricula do aluno informado: " + matricula + " é inválida\n");
        }
    }
    }
