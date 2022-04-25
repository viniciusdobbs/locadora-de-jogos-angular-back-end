package com.api.locadoradejogos.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_CLIENTE")
public class ClienteModel extends PessoaModel {

    @Column(nullable = false, length = 11)
    private String telefoneCliente;

    public ClienteModel() {
        super();
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }
}
