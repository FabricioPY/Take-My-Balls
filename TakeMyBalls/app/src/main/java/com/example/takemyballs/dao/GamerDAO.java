package com.example.takemyballs.dao;

import com.example.takemyballs.model.EvenOdd;

public class GamerDAO {

    private static EvenOdd gameEvenOdd;
    private static int totalBalls;

    public void save(EvenOdd evenorodd) {
        gameEvenOdd = evenorodd;
    }

    public EvenOdd choice() {
        return gameEvenOdd;

    }public int getBalls() {
        return totalBalls;
    }

    public void add(int balls) {
        totalBalls += balls;
    }

    public void subtract(int balls) {
        totalBalls -= balls;
    }

    public void init10() {
        totalBalls = 10;
    }
}