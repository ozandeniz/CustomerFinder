package com.intercom.distance;

public class HaversineFormula extends GreatCircleDistanceCalculator {
    @Override
    public double calculate(Coordinate coordinate1, Coordinate coordinate2) {
        double angle1 = Math.toRadians(coordinate1.getLatitude());
        double angle2 = Math.toRadians(coordinate2.getLatitude());

        double deltaAngle1 = Math.toRadians(coordinate1.getLatitude() - coordinate2.getLatitude());
        double deltaAngle2 = Math.toRadians(coordinate1.getLongitude() - coordinate2.getLongitude());

        double tmp = Math.pow(Math.sin(deltaAngle1 / 2), 2) +
                Math.cos(angle1) * Math.cos(angle2) * Math.pow(Math.sin(deltaAngle2 / 2), 2);

        double angle = 2 * Math.atan2(Math.sqrt(tmp), Math.sqrt(1-tmp));
        return angleToKm(angle);
    }
}