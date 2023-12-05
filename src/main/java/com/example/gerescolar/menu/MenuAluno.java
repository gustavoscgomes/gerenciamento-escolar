package com.example.gerescolar.menu;

import com.example.gerescolar.model.entity.Aluno;
import com.example.gerescolar.model.entity.Endereco;
import com.example.gerescolar.service.AlunoService;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
@Component
public class MenuAluno {

    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private final AlunoService service;

    public MenuAluno(AlunoService service) {
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
            System.out.println("6 - Delete");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> this.cadastrar(scanner);
                case 2 -> this.listagemGeral();
                case 3 -> this.listagemPorNome(scanner);
                case 4 -> this.listagemPorMatricula(scanner);
                case 5 -> this.atualizar(scanner);
                case 6 -> this.delete(scanner);
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

        Aluno aluno = new Aluno();

        System.out.print("Digite o nome: ");
        aluno.setName(scanner.next());
        System.out.print("Digite a data de nascimento: (dd/mm/aaaa): ");
        aluno.setDataDeNascimento(LocalDate.parse(scanner.next(), dtf));
        System.out.print("Digite a data de ingresso: (dd/mm/aaaa): ");
        aluno.setDataDeIngresso(LocalDate.parse(scanner.next(), dtf));
        System.out.print("Digite o telefone: ");
        aluno.setTelefone(scanner.next());
        System.out.print("Digite o email: ");
        aluno.setEmail(scanner.next());

        aluno.setEndereco(endereco);

        this.service.alunoSave(aluno);
        System.out.println("Aluno salvo no Banco!!!\n");
    }

    private void listagemGeral() {
        Iterable<Aluno> alunos = this.service.getAlunos();

        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }
    }

    private void listagemPorNome(Scanner scanner) {
        System.out.print("Digite o nome do aluno a ser consultado: ");
        String name = scanner.next();

        Iterable<Aluno> alunos = this.service.getAlunoByName(name);

        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }
    }

    private void listagemPorMatricula(Scanner scanner) {
        System.out.print("Digite a matricula do aluno: ");
        Long matricula = scanner.nextLong();

        Aluno aluno = this.service.getAlunoById(matricula);

        System.out.println(aluno);

    }
    private void atualizar(Scanner scanner) {
        System.out.print("Digite a matricula do Aluno a ser atualizado: ");
        Long matricula = scanner.nextLong();

        Aluno aluno = this.service.getAlunoById(matricula);

        if (aluno != null) {


            System.out.print("Cep: ");
            aluno.getEndereco().setCep(scanner.next());

            System.out.print("Logradouro: ");
            aluno.getEndereco().setLogradouro(scanner.next());

            System.out.print("Numero: ");
            aluno.getEndereco().setNumero(scanner.next());

            System.out.print("Bairro: ");
            aluno.getEndereco().setBairro(scanner.next());

            System.out.print("Cidade: ");
            aluno.getEndereco().setCidade(scanner.next());

            System.out.print("Estado: ");
            aluno.getEndereco().setEstado(scanner.next());

            System.out.print("Digite o nome: ");
            aluno.setName(scanner.next());

            System.out.print("Digite a data de nascimento: (dd/mm/aaaa): ");
            aluno.setDataDeNascimento(LocalDate.parse(scanner.next(), dtf));


            System.out.print("Digite o telefone: ");
            aluno.setTelefone(scanner.next());

            System.out.print("Digite o email: ");
            aluno.setEmail(scanner.next());

            service.alunoSave(aluno);

        } else {
            System.out.println("A matricula do aluno informado: " + matricula + " é inválida\n");
        }
    }

//    private void atualizar(Scanner scanner) {
//        System.out.print("Digite a matricula do Aluno a ser atualizado: ");
//        Long matricula = scanner.nextLong();
//
//        Aluno novoAluno = new Aluno();
//
//
//        System.out.print("Cep: ");
//        novoAluno.getEndereco().setCep(scanner.next());
//
//        System.out.print("Logradouro: ");
//        novoAluno.getEndereco().setLogradouro(scanner.next());
//
//        System.out.print("Numero: ");
//        novoAluno.getEndereco().setNumero(scanner.next());
//
//        System.out.print("Bairro: ");
//        novoAluno.getEndereco().setBairro(scanner.next());
//
//        System.out.print("Cidade: ");
//        novoAluno.getEndereco().setCidade(scanner.next());
//
//        System.out.print("Estado: ");
//        novoAluno.getEndereco().setEstado(scanner.next());
//
//        System.out.print("Digite o nome: ");
//        novoAluno.setName(scanner.next());
//
//        System.out.print("Digite a data de nascimento: (dd/mm/aaaa): ");
//        novoAluno.setDataDeNascimento(LocalDate.parse(scanner.next(), dtf));
//
//
//        System.out.print("Digite o telefone: ");
//        novoAluno.setTelefone(scanner.next());
//
//        System.out.print("Digite o email: ");
//        novoAluno.setEmail(scanner.next());
//
//        service.updateAluno(matricula, novoAluno);
//
//    }

    public void delete(Scanner scanner) {
        System.out.print("Digite a matricula do aluno a ser deletado: ");
        Long matricula = scanner.nextLong();

        Aluno aluno = this.service.getAlunoById(matricula);

        if (aluno != null) {
            service.deleteAluno(matricula);
        }
        else {
            System.out.println("A matricula do aluno informado: " + matricula + " é inválida\n");
        }
    }
}
