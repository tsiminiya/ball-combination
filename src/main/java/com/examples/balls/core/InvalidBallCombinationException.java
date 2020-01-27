package com.examples.balls.core;

public class InvalidBallCombinationException extends IllegalArgumentException {

    private final int ballCount;

    public InvalidBallCombinationException(int ballCount) {
        this.ballCount = ballCount;
    }

}
