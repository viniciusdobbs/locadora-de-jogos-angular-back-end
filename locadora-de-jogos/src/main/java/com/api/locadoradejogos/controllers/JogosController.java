package com.api.locadoradejogos.controllers;

import com.api.locadoradejogos.dtos.JogosDto;
import com.api.locadoradejogos.models.JogosModel;
import com.api.locadoradejogos.services.JogosService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/jogos")
public class JogosController {

    final JogosService jogosService;

    public JogosController(JogosService jogosService) {
        this.jogosService = jogosService;
    }

    @PostMapping
    public ResponseEntity<Object> saveJogos(@RequestBody @Valid JogosDto jogosDto){
        JogosModel jogosModel = new JogosModel();
        BeanUtils.copyProperties(jogosDto, jogosModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(jogosService.save(jogosModel));
    }

    @GetMapping
    public ResponseEntity<List<JogosModel>> getTodosJogos(){
        return ResponseEntity.status(HttpStatus.OK).body(jogosService.findAll());
    }
}
