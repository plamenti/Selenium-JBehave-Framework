package com.plamenti.runners;

import java.util.Arrays;
import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.PrintStreamStepMonitor;
import org.junit.runner.RunWith;

import com.github.valfirst.jbehave.junit.monitoring.JUnitReportingRunner;
import com.plamenti.step_definitions.GoogleSearchStepsDefinitions;

@RunWith(JUnitReportingRunner.class)
public class StoryRunner extends JUnitStories {

	@Override
	public Configuration configuration() {
		return new MostUsefulConfiguration().useStoryLoader(new LoadFromClasspath(this.getClass().getClassLoader()))
				.useStepMonitor(new PrintStreamStepMonitor()).useStoryReporterBuilder(new StoryReporterBuilder()
						.withDefaultFormats().withFormats(Format.HTML, Format.CONSOLE, Format.TXT, Format.XML));
	}

	// Here we specify the step definition classes.
	@Override
	public InjectableStepsFactory stepsFactory() {
		return new InstanceStepsFactory(configuration(), new GoogleSearchStepsDefinitions());
	}

	// Here we specify the stories
	// StoryFinder() class findPaths() method finds all files drilling down from the
	// directory returned from CodeLocations.codeLocationFromClass(this.getClass()
	// that match the pattern **/*.story. For more info search for DirectoryScanner.
	@Override
	protected List<String> storyPaths() {
		return new StoryFinder().findPaths(CodeLocations.codeLocationFromClass(this.getClass()),
				Arrays.asList("**/*.story"), Arrays.asList(""));
	}

	// @Override
	// @Test
	// public void run() {
	// try {
	// super.run();
	// } catch (Throwable e) {
	// 
	// e.printStackTrace();
	// }
	// }
}
