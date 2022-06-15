package com.api.parkingcontrol.services;


import com.api.parkingcontrol.model.ApartamentoModel;
import com.api.parkingcontrol.repositories.ApartamentoRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ApartamentoService {
    final
    ApartamentoRepository apartamentoRepository;

    public ApartamentoService(ApartamentoRepository apartamentoRepository) {
        this.apartamentoRepository = apartamentoRepository;
    }

    public boolean existsByApartamento(String apartamento) {
        return ApartamentoRepository.existsByApartamento(apartamento);
    }

    @Transactional
    public ApartamentoModel save(ApartamentoModel apartamentoModel) {
        return apartamentoRepository.save(apartamentoModel);

    }

    public List<ApartamentoModel> findAll() {
        return apartamentoRepository.findAll();
    }

    public Optional<ApartamentoModel> findById(UUID identificadorApartamento) {
        return apartamentoRepository.findById(identificadorApartamento);
    }

    @Transactional
    public void delete(ApartamentoModel apartamentoModel) {
        apartamentoRepository.delete(apartamentoModel);
    }
}