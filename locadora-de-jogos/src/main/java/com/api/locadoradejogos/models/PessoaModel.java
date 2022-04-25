package com.api.locadoradejogos.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_Pessoa")
public class PessoaModel implements Serializable {
    private static final long serialVersionUID = 1L;


    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 11)
    private String cpf;

    @Column(nullable = false, length = 20)
    private String rg;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 150)
    private String endereco;



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return cpf;
    }

    public void setCPF(String cpf) {
        this.cpf= cpf;
    }

    public String getRG() {
        return rg;
    }

    public void setRG(String rg) {
        this.rg= rg;
    }

    public String getEmail() {
        return rg;
    }

    public void setEmail(String email) {
        this.email= email;
    }
}