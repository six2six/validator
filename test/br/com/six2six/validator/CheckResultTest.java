package br.com.six2six.validator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static br.com.six2six.validator.ValidationIssue.required;
import static br.com.six2six.validator.ValidationIssue.generateIssue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class CheckResultTest {
	
	@Test
	public void simpleCheckResultWithOneDefaultGroupAndNoIssues() {
		CheckResult result = new CheckResult(new ArrayList<ValidationIssue>());
		assertTrue(result.isValid());
		assertFalse(result.hasErrors());
		assertEquals(1, result.getGroupsCount());
		assertTrue(result.getIssuesGroups().containsKey("default"));
	}
	
	@Test
	public void simpleCheckResultWithOneNamedGroupAndNoIssues() {
		CheckResult result = new CheckResult("some_group", new ArrayList<ValidationIssue>());
		assertTrue(result.isValid());
		assertFalse(result.hasErrors());
		assertEquals(1, result.getGroupsCount());
		assertTrue(result.getIssuesGroups().containsKey("some_group"));
	}
	
	@Test
	public void checkResultWithOneNamedAppendingIssue() {
		CheckResult result = new CheckResult("some_group", new ArrayList<ValidationIssue>());
		result.addToGroup("some_group", Arrays.asList(required("field.a")));
		assertTrue(result.getIssuesGroups().containsKey("some_group"));
		assertFalse(result.isValid());
		assertTrue(result.hasErrors());
		assertEquals(1, result.getGroupsCount());
		assertEquals(1, result.getErrorsCount());
	}	
	
	@Test
	public void checkResultWithMergedGroupsAndNoIssues() {
		CheckResult result = new CheckResult("some_group", new ArrayList<ValidationIssue>()).addGroup("another_group", null);
		assertTrue(result.isValid());
		assertFalse(result.hasErrors());
		assertEquals(2, result.getGroupsCount());
		assertTrue(result.getIssuesGroups().containsKey("some_group"));
		assertTrue(result.getIssuesGroups().containsKey("another_group"));
	}
	
	@Test
	public void checkResultWithMergedGroupsAndSomeIssues() {
		List<ValidationIssue> someIssue = Arrays.asList(required("field.a"));
		List<ValidationIssue> anotherIssue = Arrays.asList(required("field.b"), generateIssue("field.c", "msg"));
		CheckResult result = new CheckResult("some_group", someIssue).addGroup("another_group", anotherIssue);
		assertFalse(result.isValid());
		assertTrue(result.hasErrors());
		assertEquals(2, result.getGroupsCount());
		assertEquals(3, result.getErrorsCount());
		assertTrue(result.getIssuesGroups().containsKey("some_group"));
		assertTrue(result.getIssuesGroups().containsKey("another_group"));
	}		
	
}
