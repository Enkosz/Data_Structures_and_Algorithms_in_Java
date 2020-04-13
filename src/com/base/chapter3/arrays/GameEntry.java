package com.base.chapter3.arrays;

public class GameEntry {
    private int score;
    private String player;

    public GameEntry(int score, String player) {
        this.score = score;
        this.player = player;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return "(" + "player: " + player + ", score: " + score + ")";
    }
}
