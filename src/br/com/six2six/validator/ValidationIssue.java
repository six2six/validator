package br.com.six2six.validator;

import java.util.List;

public class ValidationIssue {
	
	private String field;
	private String message;
	private Object[] params;
	
	public String getField() {
		return field;
	}

	public String getMessage() {
		return message;
	}

	public Object[] getParams() {
		return params;
	}

	public ValidationIssue(String field, String message, Object[] params) {
		this.field = field;
		this.message = message;
		this.params = params;
	}

	public static ValidationIssue generateIssue(String field, String message) {
		return new ValidationIssue(field, message, null);
	}
	
	public static ValidationIssue generateIssue(String field, String message, Object[] params) {
		return new ValidationIssue(field, message, params);
	}	
	
	public static void generateIssue(List<ValidationIssue> issues, String field, String message) {
		generateIssue(issues, field, message, null);
	}
	
	public static void generateIssue(List<ValidationIssue> issues, String field, String message, Object[] params) {
		ValidationIssue issue = generateIssue(field, message);
		if (issue != null) {
			issues.add(issue);
		}
	}
	
	public static ValidationIssue required(String field) {
		return new ValidationIssue(field, IssueType.REQUIRED.getKey(), null);
	}	
	
	public static void required(List<ValidationIssue> issues, String field) {
		generateIssue(issues, field, IssueType.REQUIRED.getKey(), null);
	}	
	
	
	public static enum IssueType {
		REQUIRED("required"),
		MAX_LENGTH("max.length"),
		MIN_LENGTH("min.length"),
		NULL_TARGET("null.target");
		
		private String key;

		private IssueType(String key) {
			this.key = key;
		}

		public String getKey() {
			return key;
		}
		
	}
	
}
