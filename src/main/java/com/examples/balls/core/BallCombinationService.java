package com.examples.balls.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BallCombinationService {

    private final BallDrawer ballDrawer;
    private final BallDrawResultReporter ballDrawResultReporter;

    public BallCombinationService(BallDrawer ballDrawer, BallDrawResultReporter ballDrawResultReporter) {
        this.ballDrawer = ballDrawer;
        this.ballDrawResultReporter = ballDrawResultReporter;
    }

    public void drawBallsAndComputePoints() {
        List<Ball> balls = ballDrawer.drawBalls();
        Integer points = computePoints(balls);
        ballDrawResultReporter.reportDrawResult(new BallDrawResult(balls, points));
    }

    private Integer computePoints(List<Ball> balls) {
        if (balls == null || balls.isEmpty()) {
            throw new BallCombinationEmptyException();
        }

        if (balls.size() != 3) {
            throw new InvalidBallCombinationException(balls.size());
        }

        Map<BallColor, Integer> ballColorCountMap = new HashMap<>();
        for (Ball ball : balls) {
            Integer ballCount = ballColorCountMap.getOrDefault(ball.getColor(), 0);
            ballColorCountMap.put(ball.getColor(), ballCount + 1);
        }

        Set<Map.Entry<BallColor, Integer>> entries = ballColorCountMap.entrySet();
        for (Map.Entry<BallColor, Integer> entry : entries) {
            if (entry.getValue() >= 2) {
                return entry.getKey().getPoint() * entry.getValue();
            }
        }

        return 0;
    }

}
