package com.example.gerescolar.menu;

import com.example.gerescolar.model.entity.Endereco;
import com.example.gerescolar.model.entity.Funcionario;
import com.example.gerescolar.model.enums.Cargo;
import com.example.gerescolar.service.FuncionarioService;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
@Component
public class MenuFuncionario {

    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private FuncionarioService service;

    public MenuFuncionario(FuncionarioService service) {
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
            System.out.println("4 - Listagem por Cargo");
            System.out.println("5 - Listagem por Matricula");
            System.out.println("6 - Atualizar");
            System.out.println("7 - Deletar");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> this.cadastrar(scanner);
                case 2 -> this.listagemGeral();
                case 3 -> this.listagemPorNome(scanner);
                case 4 -> this.listagemPorCargo(scanner);
                case 5 -> this.listagemPorMatricula(scanner);
                case 6 -> this.atualizar(scanner);
                case 7 -> this.deletar(scanner);
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

        Funcionario funcionario = new Funcionario();

        funcionario.setEndereco(endereco);

        System.out.print("Digite o nome: ");
        funcionario.setName(scanner.next());

        System.out.print("Digite a data de nascimento: (dd/mm/aaaa): ");
        funcionario.setDataDeNascimento(LocalDate.parse(scanner.next(), dtf));

        System.out.print("Digite a data de contratacao: (dd/mm/aaaa): ");
        funcionario.setDataDeContratacao(LocalDate.parse(scanner.next(), dtf));

        System.out.print("Digite o telefone: ");
        funcionario.setTelefone(scanner.next());

        System.out.print("Digite o email: ");
        funcionario.setEmail(scanner.next());

        System.out.println("Escolha o cargo:");
        //for para listar todos os cargos
        for (Cargo cargo : Cargo.values()) {
            System.out.println(cargo.ordinal() + ". " + cargo.name());
        }

        System.out.print("Digite o número correspondente ao cargo: ");
        int escolhaCargo = scanner.nextInt();

        if (escolhaCargo >= 0 && escolhaCargo < Cargo.values().length) {
            Cargo cargoEscolhido = Cargo.values()[escolhaCargo];
            funcionario.setCargo(cargoEscolhido);
        }

        this.service.funcionarioSave(funcionario);
        System.out.println("Funcionario salvo no Banco!!!\n");
    }

    private void listagemGeral() {
        List<Funcionario> funcionarios = service.getFuncionarios();

        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario);
        }
    }

    private void listagemPorNome(Scanner scanner) {
        System.out.print("Digite o nome do funcionario a ser consultado: ");
        String name = scanner.next();

        List<Funcionario> funcionarios = service.getFuncionarioByName(name);

        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario);
        }
    }

    private void listagemPorCargo(Scanner scanner) {
        Cargo cargoEscolhido = null;

        //exibe todos os cargos
        for (Cargo cargo : Cargo.values()) {
            System.out.println(cargo.ordinal() + ". " + cargo.name());
        }
        System.out.print("Digite o número correspondente ao cargo: ");
        int escolhaCargo = scanner.nextInt();

        //checa se o indice digitado corresponde a algum cargo existente
        if (escolhaCargo >= 0 && escolhaCargo < Cargo.values().length) {
            cargoEscolhido = Cargo.values()[escolhaCargo];
        }
        List<Funcionario> funcionarios = service.getFuncionarioByCargo(cargoEscolhido);

        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario);
        }
    }

    private void listagemPorMatricula (Scanner scanner){
        System.out.print("Digite a matricula: ");
        Long matricula = scanner.nextLong();

        Funcionario funcionario = service.getFuncionarioById(matricula);

        if (funcionario != null) {
            System.out.println(funcionario);
        }
        else {
            System.out.println("A matricula do funcionario informado: " + matricula + " é inválida\n");
        }

    }

    private void atualizar(Scanner scanner) {
        System.out.print("Digite a matricula do funcionario a ser atualizado: ");
        Long matricula = scanner.nextLong();

        Funcionario funcionario = this.service.getFuncionarioById(matricula);

        if (funcionario != null) {

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


            funcionario.setEndereco(endereco);

            System.out.print("Digite o nome: ");
            funcionario.setName(scanner.next());

            System.out.print("Digite a data de nascimento: (dd/mm/aaaa): ");
            funcionario.setDataDeNascimento(LocalDate.parse(scanner.next(), dtf));

            System.out.print("Digite a data de contratacao: (dd/mm/aaaa): ");
            funcionario.setDataDeContratacao(LocalDate.parse(scanner.next(), dtf));

            System.out.print("Digite o telefone: ");
            funcionario.setTelefone(scanner.next());

            System.out.print("Digite o email: ");
            funcionario.setEmail(scanner.next());

            System.out.println("Escolha o cargo:");
            //for para listar todos os cargos
            for (Cargo cargo : Cargo.values()) {
                System.out.println(cargo.ordinal() + ". " + cargo.name());
            }

            System.out.print("Digite o número correspondente ao cargo: ");
            int escolhaCargo = scanner.nextInt();
            Cargo cargoEscolhido = Cargo.values()[escolhaCargo];
            funcionario.setCargo(cargoEscolhido);

            service.funcionarioSave(funcionario);

        } else {
            System.out.println("A matricula do funcionario informado: " + matricula + " é inválida\n");
        }
    }

    public void deletar(Scanner scanner) {
        System.out.print("Digite a matricula: ");
        Long matricula = scanner.nextLong();

        Funcionario funcionario = service.getFuncionarioById(matricula);

        if (funcionario != null) {
            service.deleteFuncionario(matricula);
        }
        else {
            System.out.println("A matricula do funcionario informado: " + matricula + " é inválida\n");
        }

    }
}
