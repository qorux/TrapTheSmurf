package test.java.edu.chalmers.projecttemplate.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import main.java.edu.chalmers.projecttemplate.view.myFirstForm;
import main.java.edu.chalmers.projecttemplate.model.Project;
import main.java.edu.chalmers.projecttemplate.model.Smurf;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmurfTest {

    @Test
    public void testRouteCalculation() {
        myFirstForm projectView = new myFirstForm();
        Project project = new Project();
        Smurf smurf = new Smurf(project.getTile(1));

        final List<Integer> expectedResult = Arrays.asList(5,5,5,5);
        ArrayList<Integer> result = smurf.calculateRoute();

        assertEquals(expectedResult, result);
    }


    @Test
    public void testRouteCalculation2() {
        myFirstForm projectView = new myFirstForm();
        Project project = new Project();
        Smurf smurf = new Smurf(project.getTile(1));

        smurf.setyPos(6);
        smurf.setxPos(10);
        final List<Integer> expectedResult = Arrays.asList(5,1,9,5);
        ArrayList<Integer> result = smurf.calculateRoute();

        assertEquals(expectedResult, result);
    }
}
