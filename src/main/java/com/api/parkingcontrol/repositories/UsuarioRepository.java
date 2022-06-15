package com.api.parkingcontrol.repositories;
import com.api.parkingcontrol.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;


@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, UUID> {
    public boolean existsByResponsibleName(String responsibleName);

}
