package com.example.gerescolar.service;

import com.example.gerescolar.model.entity.Aluno;
import com.example.gerescolar.model.entity.Funcionario;
import com.example.gerescolar.model.enums.Cargo;
import com.example.gerescolar.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository repository;

    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    public FuncionarioService(FuncionarioRepository repository) {
        this.repository = repository;
    }

    public Funcionario funcionarioSave(Funcionario funcionario) {
        return repository.save(funcionario);
    }

    public List<Funcionario> getFuncionarios() {
        return repository.findAll();
    }

    public Funcionario getFuncionarioById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Funcionario> getFuncionarioByName(String name) {
        return repository.findByName(name);
    }

    public List<Funcionario> getFuncionarioByCargo(Cargo cargo) {
        return repository.findByCargo(cargo);
    }

    public String deleteFuncionario(Long id) {
        repository.deleteById(id);
        return "Funcionario removido !! " + id;
    }

    public Funcionario updateFuncionario(Funcionario funcionario) {
        Funcionario existingFuncionario = repository.findById(funcionario.getMatricula()).orElse(null);
        existingFuncionario.setName(funcionario.getName());
        existingFuncionario.setEmail(funcionario.getEmail());
        existingFuncionario.setTelefone(funcionario.getTelefone());
        existingFuncionario.setDataDeNascimento(funcionario.getDataDeNascimento());
        existingFuncionario.setDataDeContratacao(funcionario.getDataDeContratacao());
        existingFuncionario.setCargo(funcionario.getCargo());
        existingFuncionario.getEndereco().setCep(funcionario.getEndereco().getCep());
        existingFuncionario.getEndereco().setLogradouro(funcionario.getEndereco().getLogradouro());
        existingFuncionario.getEndereco().setNumero(funcionario.getEndereco().getNumero());
        existingFuncionario.getEndereco().setBairro(funcionario.getEndereco().getBairro());
        existingFuncionario.getEndereco().setCidade(funcionario.getEndereco().getCidade());
        existingFuncionario.getEndereco().setEstado(funcionario.getEndereco().getEstado());
        return repository.save(existingFuncionario);
    }
}
