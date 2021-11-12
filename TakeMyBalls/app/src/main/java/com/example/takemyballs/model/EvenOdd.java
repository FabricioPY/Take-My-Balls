package com.example.takemyballs.model;

public class EvenOdd {
    private  final String evenOdd;

    public EvenOdd(String evenOdd){
        this.evenOdd = evenOdd;
    }

    public String getEvenOdd() {
        return evenOdd;
    }

    @Override
    public String toString() {
        return evenOdd;
    }
}