package br.com.six2six.validator.model;

import br.com.six2six.validator.CheckResult;
import br.com.six2six.validator.Validator;


public class FullPersonValidator implements Validator<Person> {
	
	private DefaultPersonValidator defaultValidator = new DefaultPersonValidator();
	private AddressValidator addressValidator = new AddressValidator();

	@Override
	public CheckResult validate(Person person, String context) {
		return new 
			CheckResult("basic", defaultValidator.validate(person, "basic_data").getIssues())
			.addGroup("home", addressValidator.validate(person.getHomeAddress(), context).getIssues())
			.addGroup("work", addressValidator.validate(person.getWorkingAddress(), context).getIssues());
	}

}
