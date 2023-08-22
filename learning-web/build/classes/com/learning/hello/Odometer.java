package com.learning.hello;


public class Odometer {

    private int reading;
    private int length;

    public Odometer(int length) {
        this.length = length;
        this.reading = 0;
    }

    public int getReading() {
        return reading;
    }

    public int getLength() {
        return length;
    }

    public int distance() {
        return reading;
    }

    public int previousReading() {
        int previous = reading - 1;
        if (previous < 0) {
            previous = length - 1;
        }
        return previous;
    }

    public int nextReading() {
        int next = reading + 1;
        if (next >= length) {
            next = 0;
        }
        return next;
    }

    public void addDistance(int distance) {
        if (distance >= 0) {
            int newReading = (reading + distance) % length;
            this.reading = newReading;
        } else {
            System.out.println("Invalid distance. Distance should be a non-negative value.");
        }
    }

    public void reset() {
        this.reading = 0;
    }
}
