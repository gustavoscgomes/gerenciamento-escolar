package com.example.gerescolar.repository;

import com.example.gerescolar.model.entity.Funcionario;
import com.example.gerescolar.model.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    public List<Professor> findByName(String name);
}
