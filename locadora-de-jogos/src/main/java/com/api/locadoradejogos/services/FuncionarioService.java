package com.api.locadoradejogos.services;

import com.api.locadoradejogos.models.FuncionarioModel;
import com.api.locadoradejogos.models.JogosModel;
import com.api.locadoradejogos.repositories.FuncionarioRepository;
import com.api.locadoradejogos.repositories.JogosRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FuncionarioService {

    final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @Transactional
    public FuncionarioModel save(FuncionarioModel jogosModel){
        return funcionarioRepository.save(jogosModel);
    }

    public List<FuncionarioModel> findAll() {
        return funcionarioRepository.findAll();
    }

}
