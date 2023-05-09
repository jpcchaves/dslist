package com.jpcchaves.dslist.service.impl;

import com.jpcchaves.dslist.entities.Game;
import com.jpcchaves.dslist.payload.dtos.game.GameDto;
import com.jpcchaves.dslist.payload.dtos.game.GameMinDto;
import com.jpcchaves.dslist.repositories.GameRepository;
import com.jpcchaves.dslist.service.GameService;
import com.jpcchaves.dslist.utils.mapper.MapperUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository repository;
    private final MapperUtils mapper;

    public GameServiceImpl(GameRepository repository,
                           MapperUtils mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public GameMinDto create(GameDto requestDto) {
        Game game = mapper.parseObject(requestDto, Game.class);
        Game savedGame = repository.save(game);

        GameMinDto gameMinDto = mapper.parseObject(savedGame, GameMinDto.class);
        return gameMinDto;
    }

    @Override
    public List<GameMinDto> getAll() {
        List<Game> gameList = repository.findAll();
        List<GameMinDto> gameMinDtoList = mapper.parseListObjects(gameList, GameMinDto.class);
        return gameMinDtoList;
    }

    @Override
    public GameMinDto getById(Long id) {
        Game game = repository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Could not find game " + id));
        GameMinDto gameMinDto = mapper.parseObject(game, GameMinDto.class);
        return gameMinDto;
    }

    @Override
    public GameMinDto update(Long id, GameDto requestDto) {
        Game game = repository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Could not find game " + id));

        game.setTitle(requestDto.getTitle());
        game.setYear(requestDto.getYear());
        game.setGenre(requestDto.getGenre());
        game.setPlatforms(requestDto.getPlatforms());
        game.setScore(requestDto.getScore());
        game.setImgUrl(requestDto.getImgUrl());
        game.setShortDescription(requestDto.getShortDescription());
        game.setLongDescription(requestDto.getLongDescription());

        Game updatedGame = repository.save(game);

        GameMinDto gameMinDto = mapper.parseObject(updatedGame, GameMinDto.class);

        return gameMinDto;
    }

    @Override
    public void delete(Long id) {
        
        if (!repository.existsById(id)) {
            throw new RuntimeException("Could not find game " + id);
        }

        repository.deleteById(id);
    }
}
