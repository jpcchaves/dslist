package com.jpcchaves.dslist.service.impl;

import com.jpcchaves.dslist.payload.dtos.game.GameDto;
import com.jpcchaves.dslist.payload.dtos.game.GameMinDto;
import com.jpcchaves.dslist.repositories.GameRepository;
import com.jpcchaves.dslist.service.GameService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository repository;

    // TODO: Create mapper config and mapper utils class to convert dtos into db entities to persist data

    public GameServiceImpl(GameRepository repository) {
        this.repository = repository;
    }

    @Override
    public GameMinDto create(GameDto requestDto) {
        return null;
    }

    @Override
    public List<GameMinDto> getAll() {
        return null;
    }

    @Override
    public GameMinDto getById(Long id) {
        return null;
    }

    @Override
    public GameMinDto update(Long id, GameDto requestDto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
