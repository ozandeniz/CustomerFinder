package distance;

import com.intercom.distance.Coordinate;
import com.intercom.distance.HaversineFormula;
import com.intercom.distance.SphericalLawOfCosinesFormula;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;

@RunWith(PowerMockRunner.class)
public class SphericalLawOfCosinesTest {
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
    public void testSpherical() throws Exception {
        SphericalLawOfCosinesFormula sphericalLawOfCosinesFormula = new SphericalLawOfCosinesFormula();

        double distance = sphericalLawOfCosinesFormula.calculate(coordinate1, coordinate2);
        assertEquals(157.23, distance, 0.001);
        distance = sphericalLawOfCosinesFormula.calculate(coordinate3, coordinate4);
        assertEquals(157.11, distance, 0.001);
    }
}