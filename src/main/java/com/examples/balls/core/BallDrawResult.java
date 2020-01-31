package com.examples.balls.core;

import java.util.List;
import java.util.Objects;

public class BallDrawResult {

    private List<Ball> balls;
    private Integer points;

    public BallDrawResult(List<Ball> balls, Integer points) {
        this.balls = balls;
        this.points = points;
    }

    public List<Ball> getBalls() {
        return balls;
    }

    public Integer getPoints() {
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallDrawResult that = (BallDrawResult) o;
        return Objects.equals(balls, that.balls) &&
                Objects.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balls, points);
    }

    @Override
    public String toString() {
        return "BallDrawResult{" +
                "balls=" + balls +
                ", points=" + points +
                '}';
    }
}
