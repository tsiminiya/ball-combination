package com.examples.balls.core;

public enum BallColor {

    YELLOW(1), BLUE(2), GREEN(3), RED(4), BLACK(5);

    private int point;

    BallColor(int point) {
        this.point = point;
    }

    public int getPoint() {
        return point;
    }

}
