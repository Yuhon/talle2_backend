package com.itsqmet.talle2_backend.service;

import com.itsqmet.talle2_backend.model.Perfil;
import com.itsqmet.talle2_backend.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;


    public List<Perfil> obtenerTodo(){
        return perfilRepository.findAll();
    }

    public Optional<Perfil> buscarporId(Long id){
        return perfilRepository.findById(id);
    }

    public Perfil crearperfil (Perfil perfil){
        return perfilRepository.save(perfil);
    }

    public boolean eliminar(Long id){
        if (perfilRepository.existsById(id)){
            perfilRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Perfil> actualizar(Long id, Perfil perfilActualizado){
        return perfilRepository.findById(id).map(perfil -> {
            perfil.setNombre(perfilActualizado.getNombre());

            return perfilRepository.save(perfil);
        });
    }

}
