package com.api.locadoradejogos.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_FUNCIONARIO")
public class FuncionarioModel extends PessoaModel{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idFunc;

    @Column(nullable = false)
    private double salario;



    public UUID getId() {
        return idFunc;
    }

    public void setId(UUID id) {
        this.idFunc = id;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
}
