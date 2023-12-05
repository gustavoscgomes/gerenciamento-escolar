package com.example.gerescolar.controller;

import com.example.gerescolar.model.entity.Aluno;
import com.example.gerescolar.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public Aluno findAlunoById(@PathVariable Long id) {
        return service.getAlunoById(id);
    }

    @GetMapping("/alunoByName/{name}")
    public List<Aluno> findAlunoByName(@PathVariable String name) {
        return service.getAlunoByName(name);
    }


    @DeleteMapping("/deleteAluno/{id}")
    public String deleteFuncionario(@PathVariable Long id) {
        service.deleteAluno(id);
        return "Aluno removido" + id;
    }

    @PutMapping("/updateAluno")
    public Aluno updateAluno(@RequestBody Aluno aluno) {
        return service.updateAluno(aluno);
    }

//    @PutMapping("/update/{id}")
//    public ResponseEntity<Aluno> updateAluno(@PathVariable Long matricula, @RequestBody Aluno novoAluno) {
//        Aluno alunoAtualizado = service.updateAluno(matricula, novoAluno);
//        return new ResponseEntity<>(alunoAtualizado, HttpStatus.OK);
//    }
}
