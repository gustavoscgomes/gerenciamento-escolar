package com.example.gerescolar.model.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private Integer matricula;

    private String name;

    @Column(name = "data_de_nascimentos")
    private LocalDate dataDeNascimento;

    @Embedded
    private Endereco endereco;

    private String telefone;

    private String email;

    @Column(name = "data_de_ingresso")
    private LocalDate dataDeIngresso;

    @Override
    public String toString() {
        return  "Matricula= " + matricula +
                ", Name= " + name  +
                ", Data De Nascimento= "  + dataDeNascimento +
                ", Endereco= " + endereco +
                ", Telefone= " + telefone +
                ", Email= " + email +
                ", Data De Ingresso= " + dataDeIngresso;
    }
}
