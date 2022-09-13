package test.java.edu.chalmers.projecttemplate.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import main.java.edu.chalmers.projecttemplate.model.Project;
import org.junit.jupiter.api.Test;

public class ProjectTest {
	private static final int NUM_INCREMENTATIONS = 128;

	@Test
	public void testIncrementResult() {
		final var project = new Project();
		//fixa packages

		for (var i = 0; i < ProjectTest.NUM_INCREMENTATIONS; i++) {
			project.incrementPresses();
		}

		assertEquals(ProjectTest.NUM_INCREMENTATIONS, project.getPresses());
	}
}
