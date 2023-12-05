package com.example.gerescolar.controller;

import com.example.gerescolar.model.entity.Aluno;
import com.example.gerescolar.model.entity.Funcionario;
import com.example.gerescolar.model.enums.Cargo;
import com.example.gerescolar.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FuncionarioController {
    @Autowired
    private FuncionarioService service;

    @PostMapping("/addFuncionario")
    public Funcionario addFuncionario(@RequestBody Funcionario funcionario) {
        return service.funcionarioSave(funcionario);
    }

    @GetMapping("/funcionarios")
    public List<Funcionario> findAllFuncionario() {
        return service.getFuncionarios();
    }

    @GetMapping("/funcionarioById/{id}")
    public Funcionario findFuncionarioById(@PathVariable Long id) {
        return service.getFuncionarioById(id);
    }

    @GetMapping("/funcionarioByCargo/{cargo}")
    public List<Funcionario> findFuncionarioByCargo(@PathVariable Cargo cargo) {
        return service.getFuncionarioByCargo(cargo);
    }


    @DeleteMapping("/deleteFuncionario/{id}")
    public String deleteFuncionario(@PathVariable Long id) {
        service.deleteFuncionario(id);
        return "Funcionario removido " + id;
    }

    @PutMapping("/updateFuncionario")
    public Funcionario updateAluno(@RequestBody Funcionario funcionario) {
        return service.updateFuncionario(funcionario);
    }
}
