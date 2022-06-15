package com.api.parkingcontrol.dto;

import javax.validation.constraints.NotBlank;
public class UsuarioDto {
    @NotBlank
    private String responsibleName;
    private ApartamentoDto apartamento;

    public ApartamentoDto getApartamento() {
        return apartamento;
    }

    public void setApartamento(ApartamentoDto apartamento) {
        this.apartamento = apartamento;
    }

    public String getResponsibleName() {
        return responsibleName;
    }

    public void setResponsibleName(String responsibleName) {
        this.responsibleName = responsibleName;
    }

}
