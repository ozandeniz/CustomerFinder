package com.intercom.distance;

public abstract class GreatCircleDistanceCalculator implements DistanceCalculator {
    final double SPHERE_OF_RADIUS = 6371.2;

    public double angleToKm(double angle){
        return angle*SPHERE_OF_RADIUS;
    }
}
