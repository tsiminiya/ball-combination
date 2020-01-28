package com.examples.balls.core;

import java.util.Objects;

public class Ball {

    private BallColor color;

    public Ball(BallColor color) {
        this.color = color;
    }

    public BallColor getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return color == ball.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }
}
