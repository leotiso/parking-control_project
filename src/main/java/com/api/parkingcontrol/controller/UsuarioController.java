package com.api.parkingcontrol.controller;


import com.api.parkingcontrol.dto.UsuarioDto;
import com.api.parkingcontrol.model.UsuarioModel;
import com.api.parkingcontrol.services.UsuarioService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/usuario")
public class UsuarioController {
    final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Object> saveUsuario (@RequestBody @Valid UsuarioModel usuarioModel) {
        if (usuarioService.existsByResponsibleName(usuarioModel.getResponsibleName())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Ja existe um usuario cadastrado com esse nome");
        }
        usuarioModel.setRegistrationData(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuarioModel));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioModel>> getAllUsuario() {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneUsuario(@PathVariable(value = "id") UUID documento) {
        Optional<UsuarioModel> usuarioModelOptional = usuarioService.findById(documento);
        if (!usuarioModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Documento nao encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(usuarioModelOptional.get());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteParkingSpot(@PathVariable(value = "id") UUID documento) {
        Optional<UsuarioModel> usuarioModelOptional = usuarioService.findById(documento);
        if (!usuarioModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O documento nao foi encontrado.");
        }
        usuarioService.delete(usuarioModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Usuario deletado com sucesso.");

    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUsuario(@PathVariable(value = "id") UUID documento,
                                                    @RequestBody @Valid UsuarioDto usuarioDto) {

        Optional<UsuarioModel> usuarioModelOptional = usuarioService.findById(documento);
        if (!usuarioModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O documento nao foi encontrado.");
        }
        var usuarioModel = new UsuarioModel();
        BeanUtils.copyProperties(usuarioDto, usuarioModel);
        usuarioModel.setDocumento(usuarioModelOptional.get().getDocumento());
        usuarioModel.setRegistrationData(usuarioModelOptional.get().getRegistrationData());
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.save(usuarioModel));

    }
}
