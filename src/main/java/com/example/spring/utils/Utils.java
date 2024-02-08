package com.example.spring.utils;

import com.example.spring.domain.enumation.Position;

/**
 * @project spring
 * @author: bekruziqulov on 08.02.2024 10:35 .
 */
public class Utils {
    public static boolean checkPosition(Position firstPosition, Position secondPosition) {
        int first;
        int second;
        switch (firstPosition) {
            case LOWEST -> first = 1;
            case JUNIOR -> first = 2;
            case MIDDLE -> first = 3;
            case SENIOR -> first = 4;
            default -> throw new IllegalStateException("Unexpected value: " + firstPosition);
        }
        switch (secondPosition) {
            case LOWEST -> second = 1;
            case JUNIOR -> second = 2;
            case MIDDLE -> second = 3;
            case SENIOR -> second = 4;
            default -> throw new IllegalStateException("Unexpected value: " + secondPosition);
        }
        return first > second;
    }
}
