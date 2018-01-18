package com.intercom.finder;

import com.beust.jcommander.Parameter;

import java.util.ArrayList;
import java.util.List;

public class Arguments {
    @Parameter(names = "-method", description = "Method for calculating the distance")
    private String method = Methods.HAVERSINE.method();

    @Parameter(names = "-fileName", required = true, description = "Input file name for customer data")
    private String fileName;

    @Parameter(names = "-distance", description = "Distance to the center in km")
    private double maxDistance = 100;

    @Parameter(names = "-baseCoordinateLatitude", description = "Base coordinate latitude")
    private double baseCoordinateLatitude = 53.339428;

    @Parameter(names = "-baseCoordinateLongitude", description = "Base coordinate longitude")
    private double baseCoordinateLongitude = -6.257664;

    public Arguments() { }

    public double getMaxDistance() {
        return maxDistance;
    }

    public String getMethod() {
        return method;
    }

    public String getFileName() {
        return fileName;
    }

    public double getBaseCoordinateLatitude() {
        return baseCoordinateLatitude;
    }

    public double getBaseCoordinateLongitude() {
        return baseCoordinateLongitude;
    }
}