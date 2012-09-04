package br.com.six2six.validator.model;

import static br.com.six2six.validator.ValidationIssue.required;

import java.util.ArrayList;
import java.util.List;

import br.com.six2six.validator.CheckResult;
import br.com.six2six.validator.ValidationIssue;
import br.com.six2six.validator.Validator;

public class DefaultPersonValidator implements Validator<Person> {

	@Override
	public CheckResult validate(Person target, String context) {
		List<ValidationIssue> issues = new ArrayList<ValidationIssue>();
		if (context == null || "basic_data".equals(context)) {
			if (target.getName() == null || target.getName().isEmpty()) {
				required(issues, "name");
			}
		}
		return new CheckResult(issues);
	}


}
