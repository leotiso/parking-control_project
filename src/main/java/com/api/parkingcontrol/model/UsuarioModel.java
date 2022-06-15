package com.api.parkingcontrol.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TB_USUARIO")
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID documento;
    @Column(nullable = false, unique = true, length = 50)
    private String responsibleName;
    @Column(nullable = false)
    private LocalDateTime registrationData;

    @OneToOne(cascade = CascadeType.ALL)
    private ApartamentoModel apartamento;

    @OneToMany
    private List<ParkingSpotModel> parkingSpotModelList;

    public UUID getDocumento() {
        return documento;
    }

    public void setDocumento(UUID documento) {
        this.documento = documento;
    }

    public String getResponsibleName() {
        return responsibleName;
    }

    public void setResponsibleName(String responsibleName) {
        this.responsibleName = responsibleName;
    }

    public LocalDateTime getRegistrationData() {
        return registrationData;
    }

    public void setRegistrationData(LocalDateTime registrationData) {
        this.registrationData = registrationData;
    }

    public ApartamentoModel getApartamento() {
        return apartamento;
    }

    public void setApartamento(ApartamentoModel apartamento) {
        this.apartamento = apartamento;
    }
}
