package com.example.gerescolar.model.entity;

import com.example.gerescolar.model.enums.Cargo;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "funcionario")
public class Funcionario {

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

    @Enumerated(EnumType.STRING)
    private Cargo cargo;

    @Column(name = "data_de_contratacao")
    private LocalDate dataDeContratacao;

    @Override
    public String toString() {
        return "Matricula= " + matricula +
                ", Name= " + name +
                ", Data De Nascimento= " + dataDeNascimento +
                ", Endereco= " + endereco +
                ", Telefone= " + telefone +
                ", Email= " + email +
                ", Cargo= " + cargo +
                ", Data De Contratacao= " + dataDeContratacao;
    }
}
