package com.intercom.finder;

import com.intercom.customer.CustomerInfo;
import com.intercom.distance.Coordinate;
import com.intercom.distance.DistanceCalculator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Finder {
    private final Coordinate baseCoordinate;
    private DistanceCalculator distanceCalculator;
    private List<CustomerInfo> customerInfoList;

    public Finder(DistanceCalculator distanceCalculator, List<CustomerInfo> customerInfoList, Coordinate baseCoordinate) {
        this.distanceCalculator = distanceCalculator;
        this.customerInfoList = customerInfoList;
        this.baseCoordinate = baseCoordinate;
    }

    public List<CustomerInfo> findNearest(double maxDistance) {
        List<CustomerInfo> nearestCustomers = new ArrayList<>();
        for (CustomerInfo customerInfo : customerInfoList) {
            Coordinate customerCoordinate = new Coordinate(customerInfo.getLatitude(), customerInfo.getLongitude());

            double distance = distanceCalculator.calculate(baseCoordinate, customerCoordinate);
            if(distance<maxDistance){
                nearestCustomers.add(customerInfo);
            }
        }
        nearestCustomers.sort(Comparator.comparingInt(CustomerInfo::getUserId));
        return nearestCustomers;
    }
}