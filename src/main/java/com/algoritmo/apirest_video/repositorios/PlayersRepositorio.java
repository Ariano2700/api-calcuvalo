package com.algoritmo.apirest_video.repositorios;

import com.algoritmo.apirest_video.modelos.Players;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayersRepositorio extends JpaRepository<Players, Long> {
    Players findByNombre(String nombre);
}
