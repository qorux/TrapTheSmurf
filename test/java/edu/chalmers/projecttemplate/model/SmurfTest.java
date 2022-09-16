package test.java.edu.chalmers.projecttemplate.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import main.java.edu.chalmers.projecttemplate.model.Smurf;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmurfTest {

    @Test
    public void testRouteCalculation() {
        Smurf smurf = new Smurf();

        final List<Integer> expectedResult = Arrays.asList(5,5,5,5);
        ArrayList<Integer> result = smurf.calculateRoute();

        assertEquals(expectedResult, result);
    }


    @Test
    public void testRouteCalculation2() {
        Smurf smurf = new Smurf();

        smurf.setyPos(6);
        smurf.setxPos(10);
        final List<Integer> expectedResult = Arrays.asList(5,1,9,5);
        ArrayList<Integer> result = smurf.calculateRoute();

        assertEquals(expectedResult, result);
    }
}
