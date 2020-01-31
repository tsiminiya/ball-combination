package com.examples.balls.core;

import java.util.EnumSet;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;

public enum BallColor {

    YELLOW(1), BLUE(2), GREEN(3), RED(4), BLACK(5);

    private static EnumSet<BallColor> ballColors = EnumSet.allOf(BallColor.class);
    private static Map<Integer, BallColor> valueColorMap = ballColors.stream()
            .collect(Collectors.toMap(BallColor::getPoint, identity()));

    private int point;

    BallColor(int point) {
        this.point = point;
    }

    public int getPoint() {
        return point;
    }

    public static Optional<BallColor> toBallColor(int number) {
        return Optional.ofNullable(valueColorMap.get(number));
    }
}
