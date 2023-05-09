package com.jpcchaves.dslist.controllers;

import com.jpcchaves.dslist.payload.dtos.game.GameMinDto;
import com.jpcchaves.dslist.service.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
