package com.freshmeat.gd.util;

public class Time {

    public static double timeStartet = System.nanoTime();

    public static double getElapsedTime() {
        return (System.nanoTime() - timeStartet) * 1E-9;
    }
}
