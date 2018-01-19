package distance;

import com.intercom.customer.CustomerInfo;
import com.intercom.distance.Coordinate;
import com.intercom.distance.DistanceCalculator;
import com.intercom.distance.HaversineFormula;
import com.intercom.finder.Finder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(PowerMockRunner.class)
public class FinderTest {
    List<CustomerInfo> customerInfoList;

    @Before
    public void setUp() throws Exception {
        customerInfoList = new ArrayList<>();
        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setLatitude(1);
        customerInfo.setLongitude(1);
        customerInfo.setUserId(1);
        customerInfo.setName("test1");
        customerInfoList.add(customerInfo);

        customerInfo = new CustomerInfo();
        customerInfo.setLatitude(4);
        customerInfo.setLongitude(4);
        customerInfo.setUserId(2);
        customerInfo.setName("test2");
        customerInfoList.add(customerInfo);

        customerInfo = new CustomerInfo();
        customerInfo.setLatitude(8);
        customerInfo.setLongitude(8);
        customerInfo.setUserId(3);
        customerInfo.setName("test3");
        customerInfoList.add(customerInfo);

        customerInfo = new CustomerInfo();
        customerInfo.setLatitude(12);
        customerInfo.setLongitude(12);
        customerInfo.setUserId(4);
        customerInfo.setName("test4");
        customerInfoList.add(customerInfo);
    }

    @Test
    public void testFinder() throws Exception {
        DistanceCalculator distanceCalculator = new HaversineFormula();
        Coordinate baseCoordinate = new Coordinate(1, 1);

        Finder finder = new Finder(distanceCalculator, customerInfoList, baseCoordinate);
        List<CustomerInfo> customerInfoList = finder.findNearest(1000);

        assertEquals(customerInfoList.get(0).getUserId(), 1);
        assertEquals(customerInfoList.get(0).getName(), "test1");
        assertEquals(customerInfoList.get(1).getUserId(), 2);
        assertEquals(customerInfoList.get(1).getName(), "test2");
    }

}
