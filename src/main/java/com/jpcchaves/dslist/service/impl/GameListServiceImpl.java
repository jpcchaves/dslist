package com.jpcchaves.dslist.service.impl;

import com.jpcchaves.dslist.entities.GameList;
import com.jpcchaves.dslist.payload.dtos.gamelist.GameListDto;
import com.jpcchaves.dslist.repositories.GameListRepository;
import com.jpcchaves.dslist.service.GameListService;
import com.jpcchaves.dslist.utils.mapper.MapperUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameListServiceImpl implements GameListService {

    private final GameListRepository repository;
    private final MapperUtils mapper;

    public GameListServiceImpl(GameListRepository repository, MapperUtils mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public GameListDto create(GameListDto requestDto) {
        return null;
    }

    @Override
    public List<GameListDto> getAll() {
        List<GameList> gameList = repository.findAll();
        List<GameListDto> gameListDtos = mapper.parseListObjects(gameList, GameListDto.class);
        return gameListDtos;
    }

    @Override
    public GameListDto getById(Long id) {
        return null;
    }

    @Override
    public GameListDto update(Long id, GameListDto requestDto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
