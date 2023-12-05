package com.example.gerescolar.controller;

import com.example.gerescolar.model.entity.Funcionario;
import com.example.gerescolar.model.entity.Professor;
import com.example.gerescolar.model.enums.Cargo;
import com.example.gerescolar.service.FuncionarioService;
import com.example.gerescolar.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfessorController {
    @Autowired
    private ProfessorService service;

    @PostMapping("/addProfessor")
    public Professor addProfessor(@RequestBody Professor professor) {
        return service.professorSave(professor);
    }

    @GetMapping("/professores")
    public List<Professor> findAllProfessores() {
        return service.getProfessores();
    }

    @GetMapping("/professorById/{id}")
    public Professor findProfessorById(@PathVariable Long id) {
        return service.getProfessorById(id);
    }


    @DeleteMapping("/deleteProfessor/{id}")
    public String deleteProfessor(@PathVariable Long id) {
        service.deleteProfessor(id);
        return "Professor removido " + id;
    }

    @PutMapping("/updateProfessor")
    public Professor updateProfessor(@RequestBody Professor professor) {
        return service.updateProfessor(professor);
    }
}
