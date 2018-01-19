package distance;

import com.intercom.distance.Coordinate;
import com.intercom.distance.HaversineFormula;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
public class HaversineFormulaTest {

    private Coordinate coordinate1;
    private Coordinate coordinate2;
    private Coordinate coordinate3;
    private Coordinate coordinate4;

    @Before
    public void setUp() throws Exception {
        coordinate1 = new Coordinate(1, 1);
        coordinate2 = new Coordinate(2, 2);

        coordinate3 = new Coordinate(3, 3);
        coordinate4 = new Coordinate(4, 4);
    }

    @Test
    public void testHaversine() throws Exception {
        HaversineFormula haversineFormula = new HaversineFormula();

        double distance = haversineFormula.calculate(coordinate1, coordinate2);
        assertEquals(157.23, distance, 0.001);
        distance = haversineFormula.calculate(coordinate3, coordinate4);
        assertEquals(157.11, distance, 0.001);
    }
}