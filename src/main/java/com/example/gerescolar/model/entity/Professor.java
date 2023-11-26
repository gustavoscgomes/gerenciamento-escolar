package com.example.gerescolar.model.entity;

import com.example.gerescolar.model.enums.Cargo;
import com.example.gerescolar.model.enums.Disciplina;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "professor")
public class Professor extends Funcionario {

    @Enumerated(EnumType.STRING)
    private Disciplina disciplina;

    public Professor() {
        this.setCargo(Cargo.PROFESSOR);
    }

    @Override
    public String toString() {
        return super.toString() +
                "Disciplina= " + disciplina;
    }
}
