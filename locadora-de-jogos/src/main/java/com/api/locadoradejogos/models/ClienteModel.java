package com.api.locadoradejogos.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_CLIENTE")
public class ClienteModel extends PessoaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idCliente;

    @Column(nullable = false, length = 11)
    private String telefoneCliente;

    public UUID getId() {
        return idCliente;
    }

    public void setId(UUID id) {
        this.idCliente = id;
    }



}
