package com.api.parkingcontrol.repositories;


import com.api.parkingcontrol.model.ApartamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.rmi.server.UID;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface ApartamentoRepository extends JpaRepository<ApartamentoModel, UUID > {
    public static boolean existsByApartamento(String apartamento) {
        return false;
    }

    Optional<ApartamentoModel> findById(UUID identificadorApartamento);
}

