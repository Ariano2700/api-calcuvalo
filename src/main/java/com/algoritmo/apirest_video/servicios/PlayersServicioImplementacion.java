package com.algoritmo.apirest_video.servicios;

import com.algoritmo.apirest_video.modelos.Players;
import com.algoritmo.apirest_video.repositorios.PlayersRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayersServicioImplementacion implements PlayersServicio{

    @Autowired
    PlayersRepositorio repositorio;

    @Override
    public List<Players> obtenerTodo() {
        return repositorio.findAll();
    }

    @Override
    public Players guardar(Players players) {
        return repositorio.save(players);
    }

    @Override
    public Players obtenerPorId(long id) {
        return repositorio.findById(id).orElse(null);
    }

    @Override
    public void eliminar(long id) {
        repositorio.deleteById(id);
    }

    @Override
    public Players obtenerPorNombre(String nombre) {
        return repositorio.findByNombre(nombre);
    }
}
