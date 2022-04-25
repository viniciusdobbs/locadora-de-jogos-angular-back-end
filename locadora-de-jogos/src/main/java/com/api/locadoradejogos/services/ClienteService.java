package com.api.locadoradejogos.services;

import com.api.locadoradejogos.models.ClienteModel;
import com.api.locadoradejogos.models.FuncionarioModel;
import com.api.locadoradejogos.repositories.ClienteRepository;
import com.api.locadoradejogos.repositories.FuncionarioRepository;

import javax.transaction.Transactional;
import java.util.List;

public class ClienteService {



    final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public ClienteModel save(ClienteModel clienteModel){
        return clienteRepository.save(clienteModel);
    }

    public List<ClienteModel> findAll() {
        return clienteRepository.findAll();
    }

}
