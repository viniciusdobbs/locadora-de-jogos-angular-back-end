package com.api.locadoradejogos.controllers;

import com.api.locadoradejogos.dtos.LocacaoDto;
import com.api.locadoradejogos.models.LocacaoModel;
import com.api.locadoradejogos.services.LocacaoService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/locacao")
public class LocacaoController {

    final LocacaoService locacaoService;

    public LocacaoController(LocacaoService locacaoService) {
        this.locacaoService = locacaoService;
    }

    @PostMapping
    public ResponseEntity<Object> saveLocacao(@RequestBody @Valid LocacaoDto locacaoDto){
        Date dataLocacao = new Date();
        LocacaoModel locacaoModel = new LocacaoModel();
        BeanUtils.copyProperties(locacaoDto, locacaoModel);
        locacaoModel.setDataLocacao(dataLocacao);
        locacaoModel.setValorDia(locacaoService.valorDia(locacaoDto.getValor(), locacaoDto.getDia()));
        long quantidadeJogos = locacaoService.validarLocacao(locacaoModel.getCliente());
        if(quantidadeJogos >= 3){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Cliente ja esgotou o limite de locações");
        }
        else {
            return ResponseEntity.status(HttpStatus.CREATED).body(locacaoService.save(locacaoModel));
        }
    }

    @GetMapping
    public ResponseEntity<List<LocacaoModel>> getTodasLocacoes(){
        return ResponseEntity.status(HttpStatus.OK).body(locacaoService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateLocacao(@PathVariable(value = "id") UUID id,
                                              @RequestBody @Valid Date dataDevolucao){
        Optional<LocacaoModel> locacaoModelOptional = locacaoService.findById(id);
        if(!locacaoModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Locação não encontrada.");
        }
        LocacaoModel locacaoModel = locacaoModelOptional.get();
        locacaoModel.setDataDevolucao(dataDevolucao);
        return ResponseEntity.status(HttpStatus.OK).body(locacaoService.save(locacaoModel));
    }
}
