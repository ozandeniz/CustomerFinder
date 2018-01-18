package com.intercom.finder;

import com.beust.jcommander.JCommander;
import com.intercom.customer.CustomerInfo;
import com.intercom.distance.Coordinate;
import com.intercom.distance.DistanceCalculator;
import com.intercom.distance.HaversineFormula;
import com.intercom.distance.SphericalLawOfCosinesFormula;
import com.intercom.util.FileUtil;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Arguments arguments = new Arguments();
        JCommander.newBuilder()
                .addObject(arguments)
                .build()
                .parse(args);

        String fileName = arguments.getFileName();
        String method = arguments.getMethod();

        DistanceCalculator distanceCalculator;

        if (method.equals(Methods.HAVERSINE.method())) {
            distanceCalculator = new HaversineFormula();
        } else if (method.equals(Methods.SPHERICAL_LAW_OF_COSINES.method())) {
            distanceCalculator = new SphericalLawOfCosinesFormula();
        } else {
            throw new RuntimeException("There is no valid method name.");
        }

        double maxDistance = arguments.getMaxDistance();
        Coordinate baseCoordinate = new Coordinate(arguments.getBaseCoordinateLatitude(), arguments.getBaseCoordinateLongitude());

        List<CustomerInfo> customerInfoList = FileUtil.readCustomerData(fileName);

        Finder finder = new Finder(distanceCalculator, customerInfoList, baseCoordinate);
        List<CustomerInfo> sortedNearestCustomers = finder.findNearest(maxDistance);

        for(CustomerInfo customerInfo:sortedNearestCustomers){
            System.out.println(customerInfo);
        }
    }
}
