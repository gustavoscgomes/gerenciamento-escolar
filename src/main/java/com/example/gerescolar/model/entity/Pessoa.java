package com.example.gerescolar.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
@Entity
public abstract class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer matricula;

    private String name;

    @Column(name = "data_de_nascimentos")
    private LocalDate dataDeNascimento;

    @Embedded
    private Endereco endereco;

    private String telefone;

    private String email;

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return  "Matricula= " + matricula +
                ", Nome= " + name +
                ", Data De Nascimentos= " + dataDeNascimento +
                ", Endereco= " + endereco +
                ", Telefone= " + telefone +
                ", Email= " + email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pessoa pessoa = (Pessoa) o;

        return matricula.equals(pessoa.matricula);
    }

    @Override
    public int hashCode() {
        return matricula.hashCode();
    }
}
