package com.jpcchaves.dslist.service;

import com.jpcchaves.dslist.payload.dtos.game.GameDto;
import com.jpcchaves.dslist.payload.dtos.game.GameMinDto;
import com.jpcchaves.dslist.payload.dtos.gamelist.GameListDto;

import java.util.List;

public interface GameListService {
    GameListDto create(GameListDto requestDto);

    List<GameListDto> getAll();

    GameListDto getById(Long id);

    GameListDto update(Long id, GameListDto requestDto);

    void delete(Long id);
}
