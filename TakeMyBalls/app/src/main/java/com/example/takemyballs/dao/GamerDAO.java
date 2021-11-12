package com.example.takemyballs.dao;

import com.example.takemyballs.model.EvenOdd;

import java.util.ArrayList;
import java.util.List;

public class GamerDAO {

    private static EvenOdd gameEvenOdd;

    public void save(EvenOdd evenorodd) {
        gameEvenOdd = evenorodd;
    }

    public EvenOdd choice() {
        return gameEvenOdd;
    }
}
