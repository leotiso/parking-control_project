package com.api.parkingcontrol.services;

import com.api.parkingcontrol.model.UsuarioModel;
import com.api.parkingcontrol.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {
    final 
    UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    public boolean existsByResponsibleName(String responsibleName) {
        return usuarioRepository.existsByResponsibleName(responsibleName);
    }
    @Transactional
    public UsuarioModel save(UsuarioModel usuarioModel) {
            return usuarioRepository.save(usuarioModel);
    }

    public List<UsuarioModel> findAll() {
        return usuarioRepository.findAll();
    }

    public Optional<UsuarioModel> findById(UUID documento) {
        return usuarioRepository.findById(documento);
    }

    @Transactional
    public void delete(UsuarioModel parkingSpotModel) {
        usuarioRepository.delete(parkingSpotModel);
    }
}

