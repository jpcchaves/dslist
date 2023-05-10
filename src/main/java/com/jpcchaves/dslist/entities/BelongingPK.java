package com.jpcchaves.dslist.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
public class BelongingPK implements Serializable {
    private static final long serialVersionUID = 4272565552167487356L;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;
    @ManyToOne
    @JoinColumn(name = "list_id")
    private GameList list;

    public BelongingPK() {
    }

    public BelongingPK(Game game, GameList list) {
        this.game = game;
        this.list = list;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public GameList getList() {
        return list;
    }

    public void setList(GameList list) {
        this.list = list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BelongingPK that = (BelongingPK) o;

        if (!game.equals(that.game)) return false;
        return list.equals(that.list);
    }

    @Override
    public int hashCode() {
        int result = game.hashCode();
        result = 31 * result + list.hashCode();
        return result;
    }
}
