package com.intercom.distance;

public class SphericalLawOfCosinesFormula extends GreatCircleDistanceCalculator {
    @Override
    public double calculate(Coordinate coordinate1, Coordinate coordinate2) {
        double angle1 = Math.toRadians(coordinate1.getLatitude());
        double angle2 = Math.toRadians(coordinate2.getLatitude());

        double delta = Math.toRadians(coordinate1.getLongitude() - coordinate2.getLongitude());

        double angle = Math.acos(Math.sin(angle1) * Math.sin(angle2)
                + Math.cos(angle1) * Math.cos(angle2) * Math.cos(delta));

        return angleToKm(angle);
    }
}