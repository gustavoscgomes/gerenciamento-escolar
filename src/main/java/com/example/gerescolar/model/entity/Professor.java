package com.example.gerescolar.model.entity;

import com.example.gerescolar.model.enums.Cargo;
import com.example.gerescolar.model.enums.Disciplina;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "professor")
public class Professor extends Funcionario {
    
    @Enumerated(EnumType.STRING)
    private Disciplina disciplina;

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public String toString() {
        return super.toString() +
                " disciplina= " + disciplina;
    }
}
