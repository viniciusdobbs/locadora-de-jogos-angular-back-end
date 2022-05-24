package com.api.locadoradejogos.services;

import com.api.locadoradejogos.models.ClienteModel;
import com.api.locadoradejogos.models.LocacaoModel;
import com.api.locadoradejogos.repositories.LocacaoRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LocacaoService {

    final LocacaoRepository locacaoRepository;

    public LocacaoService(LocacaoRepository locacaoRepository) {
        this.locacaoRepository = locacaoRepository;
    }

    @Transactional
    public LocacaoModel save(LocacaoModel locacaoModel){
        return locacaoRepository.save(locacaoModel);
    }

    public List<LocacaoModel> findAll() {
        return locacaoRepository.findAll();
    }

    public Optional<LocacaoModel> findById(UUID id){
        return locacaoRepository.findById(id);
    }

    @Transactional
    public void delete(LocacaoModel locacaoModel){
        locacaoRepository.delete(locacaoModel);
    }

    public double valorDia(double valor, int dia) {
        return valor/dia;
    }

    public long validarLocacao(@NotNull ClienteModel clienteModel) {
        return locacaoRepository.countCliente(clienteModel.getIdPessoa());
    }
}
