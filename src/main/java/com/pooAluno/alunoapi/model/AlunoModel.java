package com.pooAluno.alunoapi.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "alunos")
public class AlunoModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idAluno;
    private Date nascimento;
    private String ra;
    private String nome;

    @Override
    public String toString() {
        return "AlunoModel{" + "idAluno=" + idAluno + ", nascimento=" + nascimento + ", ra='" + ra + '\'' + ", nome='" + nome + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlunoModel that = (AlunoModel) o;
        return Objects.equals(idAluno, that.idAluno) && Objects.equals(nascimento, that.nascimento) && Objects.equals(ra, that.ra) && Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAluno, nascimento, ra, nome);
    }

    public UUID getIdAluno() {
        return idAluno;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public String getRa() {
        return ra;
    }

    public String getNome() {
        return nome;
    }

    public void setIdAluno(UUID idAluno) {
        this.idAluno = idAluno;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}