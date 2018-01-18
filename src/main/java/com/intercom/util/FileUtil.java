package com.intercom.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.intercom.customer.CustomerInfo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface FileUtil {
    static List<CustomerInfo> readCustomerData(String fileName) throws IOException {
        List<CustomerInfo> customerInfoList = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            ObjectMapper objectMapper = new ObjectMapper();

            while ((line = bufferedReader.readLine()) != null) {
                customerInfoList.add(objectMapper.readValue(line, CustomerInfo.class));
            }
        }
        return customerInfoList;
    }
}