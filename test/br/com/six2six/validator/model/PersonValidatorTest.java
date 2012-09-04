package br.com.six2six.validator.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import br.com.six2six.validator.CheckResult;
import br.com.six2six.validator.Validator;


public class PersonValidatorTest {

	@Test
	public void simpleValidationMustValidateWithNameAndAge() {
		Validator<Person> validator = new DefaultPersonValidator();
		Person person = new Person("Jill Valentine", 26);
		CheckResult result = validator.validate(person, "basic_data");
		assertNotNull(result);
		assertTrue(result.isValid());
	}
	
	@Test
	public void simpleValidationMustNotValidateWithoutName() {
		Validator<Person> validator = new DefaultPersonValidator();
		Person person = new Person("", 26);
		CheckResult result = validator.validate(person, "basic_data");
		assertFalse(result.isValid());
		assertEquals(1, result.getIssues().size());
	}
	
	@Test
	public void compositeValidationMustWithValidateFullData() {
		Validator<Person> validator = new FullPersonValidator();
		Person person = new Person("Jill Valentine", 26);
		Address homeAddress = new Address("5th Av.", "435", "New York");
		Address workingAddress = new Address("5th Av.", "435", "New York");
		person.setHomeAddress(homeAddress);
		person.setWorkingAddress(workingAddress);
		
		CheckResult result = validator.validate(person, null);
		assertNotNull(result);
		assertTrue(result.isValid());
	}	
	
	@Test
	public void compositeValidationMustNotValidateMissingData() {
		Validator<Person> validator = new FullPersonValidator();
		Person person = new Person(null, 26);
		Address homeAddress = new Address("5th Av.", "435", null);
		Address workingAddress = new Address("5th Av.", "435", null);
		person.setHomeAddress(homeAddress);
		person.setWorkingAddress(workingAddress);
		
		CheckResult result = validator.validate(person, null);
		assertFalse(result.isValid());
		assertEquals(3, result.getIssues().size());
		assertEquals(3, result.getGroupsCount());
	}	
}
