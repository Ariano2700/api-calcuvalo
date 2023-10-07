package com.algoritmo.apirest_video.servicios;

import com.algoritmo.apirest_video.modelos.Players;

import java.util.List;

public interface PlayersServicio {
    public List<Players> obtenerTodo();
    public Players guardar(Players players);
    public Players obtenerPorId(long id);
    public void eliminar (long id);
    public Players obtenerPorNombre(String nombre);
}
