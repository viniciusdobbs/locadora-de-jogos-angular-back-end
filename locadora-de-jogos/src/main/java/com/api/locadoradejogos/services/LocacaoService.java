package com.api.locadoradejogos.services;

import com.api.locadoradejogos.models.ClienteModel;
import com.api.locadoradejogos.models.LocacaoModel;
import com.api.locadoradejogos.repositories.LocacaoRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
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

    public String valorFinal(@NotNull LocacaoModel locacaoModel){
        Date data_inicial = locacaoModel.getDataLocacao();
        Date data_final = locacaoModel.getDataDevolucao();
        long difference_In_Time = data_final.getTime() - data_inicial.getTime();
        long difference_In_Days = (difference_In_Time / (1000 * 60 * 60 * 24)) % 365;
        double valor = difference_In_Days * locacaoModel.getValorDia();
        return "Total a pagar " + valor;
    }

    public long validarLocacao(@NotNull ClienteModel clienteModel) {
        return locacaoRepository.countCliente(clienteModel.getIdPessoa());
    }
}
