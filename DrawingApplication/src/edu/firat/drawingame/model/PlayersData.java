package edu.firat.drawingame.model;

import java.io.Serializable;

public class PlayersData implements Serializable {

    public String nickname;
    public int point;

    public PlayersData(String nickname, int point) {
        this.nickname = nickname;
        this.point = point;
    }
}
