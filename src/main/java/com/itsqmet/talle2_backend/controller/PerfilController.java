package com.itsqmet.talle2_backend.controller;

import com.itsqmet.talle2_backend.model.Perfil;
import com.itsqmet.talle2_backend.service.PerfilService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("*/api/perfil")
@CrossOrigin("*")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @GetMapping
    public ResponseEntity<List<Perfil>> obtenerTodos(){
        List<Perfil> perfiles = perfilService.obtenerTodo();
        return ResponseEntity.ok(perfiles);
    }

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody Perfil perfil, BindingResult result) {

        if (result.hasErrors()) {
            Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(error ->
                    errores.put(error.getField(), error.getDefaultMessage())
            );
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errores);
        }

        Perfil nuevo = perfilService.crearperfil(perfil);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        if (perfilService.eliminar(id)) {
            return ResponseEntity.ok(Map.of("mensaje", "Perfil eliminado correctamente")); // 200
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("error", "Perfil con id " + id + " no encontrado")); // 404
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody Perfil perfil,
            BindingResult result) {

        if (result.hasErrors()) {
            Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(error ->
                    errores.put(error.getField(), error.getDefaultMessage())
            );
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errores);
        }

        return perfilService.actualizar(id, perfil)
                .map(actualizado -> ResponseEntity.ok((Object) actualizado))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(Map.of("error", "Perfil con id " + id + " no encontrado")));
    }

}
