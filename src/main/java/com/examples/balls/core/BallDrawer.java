package com.examples.balls.core;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BallDrawer {

    public List<Ball> drawBalls() {
        return Arrays.asList(drawBall(), drawBall(), drawBall());
    }

    private Ball drawBall() {
        Random random = new Random();
        return BallColor.toBallColor(random.nextInt(5) + 1)
                .map(Ball::new)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected Error: Ball Color value not supported"));
    }

}
