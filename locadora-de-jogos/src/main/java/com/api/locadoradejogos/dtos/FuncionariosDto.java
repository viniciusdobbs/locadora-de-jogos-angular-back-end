package com.api.locadoradejogos.dtos;

import javax.validation.constraints.NotBlank;

public class FuncionariosDto {

    @NotBlank
    private String nome;

    @NotBlank
    private String genero;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
