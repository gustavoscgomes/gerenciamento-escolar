package com.example.gerescolar.controller;

import com.example.gerescolar.model.entity.Aluno;
import com.example.gerescolar.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlunoController {

    @Autowired
    private AlunoService service;

    @PostMapping("/addAluno")
    public Aluno addAluno(@RequestBody Aluno aluno) {
        return service.alunoSave(aluno);
    }

    @GetMapping("/alunos")
    public List<Aluno> findAllAluno() {
        return service.getAlunos();
    }

    @GetMapping("/alunoById/{id}")
    public Aluno findProductById(@PathVariable Long id) {
        return service.getAlunoById(id);
    }

    @GetMapping("/alunoByName/{name}")
    public List<Aluno> findProductByName(@PathVariable String name) {
        return service.getAlunoByName(name);
    }
    

    @DeleteMapping("/delete/{id}")
    public String deleteAluno(@PathVariable Long id) {
        return service.deleteAluno(id);
    }
}
