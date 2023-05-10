package com.jpcchaves.dslist.service;

import com.jpcchaves.dslist.payload.dtos.game.GameDto;
import com.jpcchaves.dslist.payload.dtos.game.GameMinDto;

import java.util.List;

public interface GameService {
    GameMinDto create(GameDto requestDto);

    List<GameMinDto> getAll();

    List<GameMinDto> getAllByList(Long id);

    GameDto getById(Long id);

    GameDto update(Long id, GameDto requestDto);

    void delete(Long id);
}
