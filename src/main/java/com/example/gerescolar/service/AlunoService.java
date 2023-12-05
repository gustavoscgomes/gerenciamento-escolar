package com.example.gerescolar.service;

import com.example.gerescolar.model.entity.Aluno;
import com.example.gerescolar.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository repository;

    public Aluno alunoSave(Aluno aluno) {
        return repository.save(aluno);
    }

    public List<Aluno> getAlunos() {
        return repository.findAll();
    }

    public Aluno getAlunoById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Aluno> getAlunoByName(String name) {
        return repository.findByName(name);
    }

    public String deleteAluno(Long id) {
        repository.deleteById(id);
        return "aluno removido !! " + id;
    }

    public Aluno updateAluno(Aluno aluno) {
        Aluno existingAluno = repository.findById(aluno.getMatricula()).orElse(null);
        existingAluno.setName(aluno.getName());
        existingAluno.setEmail(aluno.getEmail());
        existingAluno.setTelefone(aluno.getTelefone());
        existingAluno.setDataDeNascimento(aluno.getDataDeNascimento());
        existingAluno.setDataDeIngresso(aluno.getDataDeIngresso());
        existingAluno.getEndereco().setCep(aluno.getEndereco().getCep());
        existingAluno.getEndereco().setLogradouro(aluno.getEndereco().getLogradouro());
        existingAluno.getEndereco().setNumero(aluno.getEndereco().getNumero());
        existingAluno.getEndereco().setBairro(aluno.getEndereco().getBairro());
        existingAluno.getEndereco().setCidade(aluno.getEndereco().getCidade());
        existingAluno.getEndereco().setEstado(aluno.getEndereco().getEstado());
        return repository.save(existingAluno);
    }


}
