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
        Project project = new Project();
        myFirstForm projectView = new myFirstForm(project);
        Smurf smurf = new Smurf(project.board.getHexagon(1));

        final List<Integer> expectedResult = Arrays.asList(5,5,5,5);
        ArrayList<Integer> result = smurf.calculateRoute();

        assertEquals(expectedResult, result);
    }


    @Test
    public void testRouteCalculation2() {
        Project project = new Project();
        myFirstForm projectView = new myFirstForm(project);
        Smurf smurf = new Smurf(project.board.getHexagon(1));

        smurf.setyPos(6);
        smurf.setxPos(10);
        final List<Integer> expectedResult = Arrays.asList(5,1,9,5);
        ArrayList<Integer> result = smurf.calculateRoute();

        assertEquals(expectedResult, result);
    }
}
