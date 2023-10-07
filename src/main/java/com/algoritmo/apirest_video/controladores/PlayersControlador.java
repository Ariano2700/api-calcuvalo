package com.algoritmo.apirest_video.controladores;

import com.algoritmo.apirest_video.modelos.Players;
import com.algoritmo.apirest_video.servicios.PlayersServicioImplementacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/valorant/players")
public class PlayersControlador {

    @Autowired
    PlayersServicioImplementacion implementacion;

    @GetMapping("/all")
    public List<Players> obtenerJugadores(){
        return implementacion.obtenerTodo();
    }

    @PostMapping("/guardar/jugador")
    public ResponseEntity<Players> guardarJugador(@RequestBody Players players){
        Players nuevoPY = implementacion.guardar(players);
        return new ResponseEntity<>(nuevoPY, HttpStatus.CREATED);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Players> obtenerPorId (@PathVariable long id){
        Players jugadoresId = implementacion.obtenerPorId(id);
        return ResponseEntity.ok(jugadoresId);
    }

    @PutMapping("/actualizar/jugador/{id}")
    public ResponseEntity<Players> actualizarDatos(@PathVariable long id, @RequestBody Players players){
        Players jugadorActualizar = implementacion.obtenerPorId(id);
        //Actualizacion de datos
        jugadorActualizar.setPj(players.getPj());
        jugadorActualizar.setGanadas(players.getGanadas());
        jugadorActualizar.setPerdidas(players.getPerdidas());
        jugadorActualizar.setKills(players.getKills());
        jugadorActualizar.setMuertes(players.getMuertes());
        jugadorActualizar.setPmc(players.getPmc());
        Players jugadorActualizado = implementacion.guardar(jugadorActualizar);
        return new ResponseEntity<>(jugadorActualizado, HttpStatus.CREATED);
    }

    @DeleteMapping("/jugador/eliminado/{id}")
    public ResponseEntity<HashMap<String, Boolean>> eliminarDatos(@PathVariable long id){
        this.implementacion.eliminar(id);
        HashMap<String, Boolean> estadoJugador = new HashMap<>();
        estadoJugador.put("Eliminado",true);
        return ResponseEntity.ok(estadoJugador);
    }

    @GetMapping("/nombre/jugador/{nombre}")
    public ResponseEntity<Players> obtenerPorNombre(@PathVariable String nombre){
        Players porNombre = implementacion.obtenerPorNombre(nombre);
        return ResponseEntity.ok(porNombre);
    }
}
