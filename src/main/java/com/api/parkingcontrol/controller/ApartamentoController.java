package com.api.parkingcontrol.controller;

import com.api.parkingcontrol.dto.ApartamentoDto;
import com.api.parkingcontrol.model.ApartamentoModel;
import com.api.parkingcontrol.model.ParkingSpotModel;
import com.api.parkingcontrol.model.UsuarioModel;
import com.api.parkingcontrol.services.ApartamentoService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/apartamento")
public class ApartamentoController {
    private final ApartamentoService apartamentoService;

    public ApartamentoController(ApartamentoService apartamentoService) {
        this.apartamentoService = apartamentoService;
    }

    @PostMapping
    public ResponseEntity<Object> saveApartamento (@RequestBody @Valid ApartamentoModel apartamentoModel) {
        if (apartamentoService.existsByApartamento(apartamentoModel.getApartamento())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito:Apartamento ja cadastrado");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(apartamentoService.save(apartamentoModel));
    }


    @GetMapping
    public ResponseEntity<List<ApartamentoModel>> getAllUsuario() {
        return ResponseEntity.status(HttpStatus.OK).body(apartamentoService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteApartamento(@PathVariable(value = "id") UUID identificadorApartamento) {
        Optional<ApartamentoModel> apartamentoModelOptional = apartamentoService.findById(identificadorApartamento);
        if (!apartamentoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Apartamento nao foi encontrado.");
        }
        apartamentoService.delete(apartamentoModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Apartamento deletado com sucesso.");

    }

}
