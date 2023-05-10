package com.jpcchaves.dslist.controllers;

import com.jpcchaves.dslist.payload.dtos.game.GameDto;
import com.jpcchaves.dslist.payload.dtos.game.GameMinDto;
import com.jpcchaves.dslist.payload.dtos.gamelist.GameListDto;
import com.jpcchaves.dslist.service.GameListService;
import com.jpcchaves.dslist.service.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/gamelists")
public class GameListController {

    private final GameListService service;

    public GameListController(GameListService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<GameListDto>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameListDto> getById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<GameListDto> create(@RequestBody GameListDto gameDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(gameDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GameListDto> update(@PathVariable Long id, @RequestBody GameListDto gameDto) {
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id, gameDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.getById(id);
        return ResponseEntity.noContent().build();
    }
}
