package com.example.gerescolar.model.entity;

import com.example.gerescolar.model.enums.Cargo;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "funcionario")
public class Funcionario extends Pessoa{
    @Enumerated(EnumType.STRING)
    private Cargo cargo;
    @Column(name = "data_de_contratacao")
    private LocalDate dataDeContratacao;

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public LocalDate getDataDeContratacao() {
        return dataDeContratacao;
    }

    public void setDataDeContratacao(LocalDate dataDeContratacao) {
        this.dataDeContratacao = dataDeContratacao;
    }

    @Override
    public String toString() {
        return super.toString()+
                ", cargo= " + cargo +
                ", dataDeContratacao= " + dataDeContratacao;
    }
}
