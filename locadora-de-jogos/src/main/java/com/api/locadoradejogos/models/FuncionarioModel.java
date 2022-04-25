package com.api.locadoradejogos.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_FUNCIONARIO")
public class FuncionarioModel extends PessoaModel{

    @Column(nullable = false)
    private double salario;

    public FuncionarioModel() {
        super();
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
