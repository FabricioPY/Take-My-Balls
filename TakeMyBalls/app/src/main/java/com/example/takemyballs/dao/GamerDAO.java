package com.example.takemyballs.dao;

import com.example.takemyballs.model.EvenOdd;

import java.util.ArrayList;
import java.util.List;

public class GamerDAO {

    private final static List<EvenOdd> gameEvenOdd = new ArrayList<>();

    public void save(EvenOdd evenorodd) {
        gameEvenOdd.clear();
        gameEvenOdd.add(evenorodd);
    }


    public EvenOdd choice() {
        return gameEvenOdd.get(0);
    }
}
