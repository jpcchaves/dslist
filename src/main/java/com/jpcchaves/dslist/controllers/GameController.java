package com.jpcchaves.dslist.controllers;

import com.jpcchaves.dslist.payload.dtos.game.GameDto;
import com.jpcchaves.dslist.payload.dtos.game.GameMinDto;
import com.jpcchaves.dslist.service.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/games")
public class GameController {

    private final GameService service;

    public GameController(GameService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<GameMinDto>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameDto> getById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<GameMinDto> create(@RequestBody GameDto gameDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(gameDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GameDto> update(@PathVariable Long id, @RequestBody GameDto gameDto) {
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id, gameDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.getById(id);
        return ResponseEntity.noContent().build();
    }
}
