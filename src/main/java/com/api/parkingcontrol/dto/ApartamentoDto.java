package com.api.parkingcontrol.dto;

import javax.validation.constraints.NotBlank;


public class ApartamentoDto {

    @NotBlank
    private String apartamento;
    @NotBlank
    private String block;

    public String getApartamento() {
        return apartamento;
    }

    public void setApartamento(String apartamento) {
        this.apartamento = apartamento;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }
}
