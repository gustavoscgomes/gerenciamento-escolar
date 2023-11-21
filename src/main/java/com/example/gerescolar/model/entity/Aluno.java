package com.example.gerescolar.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "aluno")
public class Aluno extends Pessoa{

    @Column(name = "data_de_ingresso")
    private LocalDate dataDeIngresso;

    public LocalDate getDataDeIngresso() {
        return dataDeIngresso;
    }

    public void setDataDeIngresso(LocalDate dataDeIngresso) {
        this.dataDeIngresso = dataDeIngresso;
    }
}
