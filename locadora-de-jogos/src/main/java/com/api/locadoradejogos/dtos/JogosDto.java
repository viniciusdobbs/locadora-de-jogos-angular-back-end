package com.api.locadoradejogos.dtos;

import com.api.locadoradejogos.enums.ConsoleEnum;
import com.api.locadoradejogos.enums.GeneroEnum;

import javax.validation.constraints.NotBlank;

public class JogosDto {

    @NotBlank
    private String nome;


    private GeneroEnum genero;


    private ConsoleEnum console;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public GeneroEnum getGenero() {
        return genero;
    }

    public void setGenero(GeneroEnum genero) {
        this.genero = genero;
    }

    public ConsoleEnum getConsole() {
        return console;
    }

    public void setConsole(ConsoleEnum console) {
        this.console = console;
    }
}
