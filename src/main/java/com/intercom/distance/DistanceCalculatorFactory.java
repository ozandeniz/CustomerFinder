package com.intercom.distance;

import com.intercom.finder.Methods;

public interface DistanceCalculatorFactory {

    static DistanceCalculator getDistanceCalculator(String method){
        DistanceCalculator distanceCalculator;

        if (method.equals(Methods.HAVERSINE.method())) {
            distanceCalculator = new HaversineFormula();
        } else if (method.equals(Methods.SPHERICAL_LAW_OF_COSINES.method())) {
            distanceCalculator = new SphericalLawOfCosinesFormula();
        } else {
            throw new RuntimeException("There is no valid method name.");
        }

        return distanceCalculator;
    }
}
