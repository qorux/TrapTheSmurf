package test.java.edu.chalmers.projecttemplate.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import main.java.edu.chalmers.projecttemplate.controller.ProjectController;
import main.java.edu.chalmers.projecttemplate.view.myFirstForm;
import main.java.edu.chalmers.projecttemplate.model.Project;
import main.java.edu.chalmers.projecttemplate.model.Smurf;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoardTest {

    @Test
    public void testForOutofBoundsError() {
        Project project = new Project();
        myFirstForm projectView = new myFirstForm(project);
        for(int i =0; i<=121;i++){
            project.board.blockTile(i);
        }
        ProjectController.create(project, projectView);
        projectView.setVisible(true);

        assertEquals(true,true);
    }


}
