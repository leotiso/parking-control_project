package com.api.parkingcontrol.model;


import javax.persistence.*;
import java.util.UUID;


@Entity
@Table(name = "TB_APARTAMENTO")
public class ApartamentoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID identificadorApartamento;
    @Column(nullable = false,unique = true, length = 10)
    private String apartamento;
    @Column(nullable = false, length = 5)
    private String block;

    public UUID getIdentificadorApartamento() {
        return identificadorApartamento;
    }

    public void setIdentificadorApartamento(UUID identificadorApartamento) {
        this.identificadorApartamento = identificadorApartamento;
    }

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
