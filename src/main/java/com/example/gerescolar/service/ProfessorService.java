package com.example.gerescolar.service;

import com.example.gerescolar.model.entity.Funcionario;
import com.example.gerescolar.model.entity.Professor;
import com.example.gerescolar.model.enums.Cargo;
import com.example.gerescolar.repository.FuncionarioRepository;
import com.example.gerescolar.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository repository;

    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    public ProfessorService(ProfessorRepository repository) {
        this.repository = repository;
    }

    public Professor professorSave(Professor professor) {
        return repository.save(professor);
    }

    public List<Professor> getProfessores() {
        return repository.findAll();
    }

    public Professor getProfessorById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Professor> getProfessorByName(String name) {
        return repository.findByName(name);
    }

    public String deleteProfessor(Long id) {
        repository.deleteById(id);
        return "Professor removido !! " + id;
    }

    public Professor updateProfessor(Professor professor) {
        Professor existingProfessor = repository.findById(professor.getMatricula()).orElse(null);
        existingProfessor.setName(professor.getName());
        existingProfessor.setEmail(professor.getEmail());
        existingProfessor.setTelefone(professor.getTelefone());
        existingProfessor.setDataDeNascimento(professor.getDataDeNascimento());
        existingProfessor.setDataDeContratacao(professor.getDataDeContratacao());
        existingProfessor.getEndereco().setCep(professor.getEndereco().getCep());
        existingProfessor.getEndereco().setLogradouro(professor.getEndereco().getLogradouro());
        existingProfessor.getEndereco().setNumero(professor.getEndereco().getNumero());
        existingProfessor.getEndereco().setBairro(professor.getEndereco().getBairro());
        existingProfessor.getEndereco().setCidade(professor.getEndereco().getCidade());
        existingProfessor.getEndereco().setEstado(professor.getEndereco().getEstado());
        return repository.save(existingProfessor);
    }
}
