package com.jpcchaves.dslist.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "tb_belonging")
public class Belonging implements Serializable {

    private static final long serialVersionUID = 3156594342481496053L;

    @EmbeddedId
    private BelongingPK id = new BelongingPK();
    private Integer position;

    public Belonging() {
    }

    public Belonging(Game game, GameList gameList, Integer position) {
        id.setGame(game);
        id.setList(gameList);
        this.position = position;
    }

    public BelongingPK getId() {
        return id;
    }

    public void setId(BelongingPK id) {
        this.id = id;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Belonging belonging = (Belonging) o;

        return id.equals(belonging.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
