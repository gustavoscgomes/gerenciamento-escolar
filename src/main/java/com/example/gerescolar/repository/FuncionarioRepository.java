package com.example.gerescolar.repository;

import com.example.gerescolar.model.entity.Aluno;
import com.example.gerescolar.model.entity.Funcionario;
import com.example.gerescolar.model.enums.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    public List<Funcionario> findByCargo(Cargo cargo);

    @Query("SELECT f FROM Funcionario f WHERE f.name = :name ")
    public List<Funcionario> findByName(String name);

}