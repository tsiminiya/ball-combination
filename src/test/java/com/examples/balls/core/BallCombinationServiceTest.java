package com.examples.balls.core;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;

public class BallCombinationServiceTest {

    private BallCombinationService ballCombinationService;

    private BallDrawer ballDrawer = Mockito.mock(BallDrawer.class);
    private BallDrawResultReporter ballDrawResultReporter = Mockito.mock(BallDrawResultReporter.class);

    @Before
    public void initialize() {
        ballCombinationService = new BallCombinationService(ballDrawer, ballDrawResultReporter);
    }

    @Test(expected = BallCombinationEmptyException.class)
    public void testShouldThrowBallCombinationEmptyExceptionWhenNullList() {
        Mockito.when(ballDrawer.drawBalls()).thenReturn(null);
        ballCombinationService.drawBallsAndComputePoints();
    }

    @Test(expected = BallCombinationEmptyException.class)
    public void testShouldThrowBallCombinationEmptyExceptionWhenEmptyList() {
        Mockito.when(ballDrawer.drawBalls()).thenReturn(Collections.emptyList());
        ballCombinationService.drawBallsAndComputePoints();
    }

    @Test(expected = InvalidBallCombinationException.class)
    public void testShouldReturnThrowExceptionWhenBallCountIsMoreThan3() {
        Ball ball1 = new Ball(BallColor.YELLOW);
        Ball ball2 = new Ball(BallColor.YELLOW);
        Ball ball3 = new Ball(BallColor.RED);
        Ball ball4 = new Ball(BallColor.RED);

        ballCombinationService.drawBallsAndComputePoints();
    }

    @Test
    public void testShouldReturnTwoWhenTwoYellow() {
        Ball ball1 = new Ball(BallColor.YELLOW);
        Ball ball2 = new Ball(BallColor.YELLOW);
        Ball ball3 = new Ball(BallColor.RED);

        ballCombinationService.drawBallsAndComputePoints();
    }

    @Test
    public void testShouldReturnZeroWhenAllBallsHaveDifferentColors() {
        Ball ball1 = new Ball(BallColor.YELLOW);
        Ball ball2 = new Ball(BallColor.BLUE);
        Ball ball3 = new Ball(BallColor.RED);

        ballCombinationService.drawBallsAndComputePoints();
    }

}
