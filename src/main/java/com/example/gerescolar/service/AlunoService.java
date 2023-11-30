package com.example.gerescolar.service;

import com.example.gerescolar.model.entity.Aluno;
import com.example.gerescolar.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
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

}
