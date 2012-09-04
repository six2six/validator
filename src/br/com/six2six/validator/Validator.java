package br.com.six2six.validator;

public interface Validator<T> {

	CheckResult validate(T target, String context);
}
