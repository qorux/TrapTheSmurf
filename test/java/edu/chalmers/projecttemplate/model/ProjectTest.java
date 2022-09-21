package test.java.edu.chalmers.projecttemplate.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import main.java.edu.chalmers.projecttemplate.model.Project;
import main.java.edu.chalmers.projecttemplate.model.Smurf;
import main.java.edu.chalmers.projecttemplate.view.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ProjectTest {
	private static final int NUM_INCREMENTATIONS = 128;

	@Test
	public void testIncrementResult() {
		final var projectView = new myFirstForm();
		final var project = new Project(projectView);
		//fixa packages

		for (var i = 0; i < ProjectTest.NUM_INCREMENTATIONS; i++) {
			project.incrementPresses();
		}

		assertEquals(ProjectTest.NUM_INCREMENTATIONS, project.getPresses());
	}
}
