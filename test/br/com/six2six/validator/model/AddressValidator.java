package br.com.six2six.validator.model;

import static br.com.six2six.validator.ValidationIssue.required;

import java.util.ArrayList;
import java.util.List;

import br.com.six2six.validator.CheckResult;
import br.com.six2six.validator.ValidationIssue;
import br.com.six2six.validator.Validator;

public class AddressValidator implements Validator<Address> {

	@Override
	public CheckResult validate(Address address, String context) {
		List<ValidationIssue> issues = new ArrayList<ValidationIssue>();
		if (address.getCity() == null || address.getCity().isEmpty()) {
			required(issues, "city");
		}
		if (address.getStreet() == null || address.getStreet().isEmpty()) {
			required(issues, "street");
		}		
		return new CheckResult(issues);
	}


}
