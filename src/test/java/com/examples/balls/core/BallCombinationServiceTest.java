package com.examples.balls.core;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class BallCombinationServiceTest {

    private BallCombinationService ballCombinationService;

    @Before
    public void initialize() {
        ballCombinationService = new BallCombinationService();
    }

    @Test(expected = BallCombinationEmptyException.class)
    public void testShouldThrowBallCombinationEmptyExceptionWhenNullList() {
        ballCombinationService.computePoints(null);
    }

    @Test(expected = BallCombinationEmptyException.class)
    public void testShouldThrowBallCombinationEmptyExceptionWhenEmptyList() {
        ballCombinationService.computePoints(Collections.emptyList());
    }

    @Test(expected = InvalidBallCombinationException.class)
    public void testShouldReturnThrowExceptionWhenBallCountIsMoreThan3() {
        Ball ball1 = new Ball(BallColor.YELLOW);
        Ball ball2 = new Ball(BallColor.YELLOW);
        Ball ball3 = new Ball(BallColor.RED);
        Ball ball4 = new Ball(BallColor.RED);

        ballCombinationService.computePoints(Arrays.asList(ball1, ball2, ball3, ball4));
    }

    @Test
    public void testShouldReturnTwoWhenTwoYellow() {
        Ball ball1 = new Ball(BallColor.YELLOW);
        Ball ball2 = new Ball(BallColor.YELLOW);
        Ball ball3 = new Ball(BallColor.RED);

        int result = ballCombinationService.computePoints(Arrays.asList(ball1, ball2, ball3));

        Assert.assertEquals(2, result);
    }

    @Test
    public void testShouldReturnZeroWhenAllBallsHaveDifferentColors() {
        Ball ball1 = new Ball(BallColor.YELLOW);
        Ball ball2 = new Ball(BallColor.BLUE);
        Ball ball3 = new Ball(BallColor.RED);

        int result = ballCombinationService.computePoints(Arrays.asList(ball1, ball2, ball3));

        Assert.assertEquals(0, result);
    }

}
