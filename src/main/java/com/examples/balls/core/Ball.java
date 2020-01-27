package com.examples.balls.core;

import java.util.Objects;

public class Ball {

    private int number;

    private BallColor color;

    public Ball(int number, BallColor color) {
        this.number = number;
        this.color = color;
    }

    public int getNumber() {
        return number;
    }

    public BallColor getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return number == ball.number &&
                color == ball.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, color);
    }

}
