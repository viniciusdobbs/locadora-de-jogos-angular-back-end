package com.api.locadoradejogos.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_CLIENTE")
public class ClienteModel extends PessoaModel {

    @Column(name = "TE_TELEFONE", nullable = false, length = 11)
    private String telefoneCliente;

    @OneToMany(mappedBy="cliente")
    private List<LocacaoModel> locacao;

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
