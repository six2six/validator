package br.com.six2six.validator;

import java.util.List;

public class ValidationIssueGroup {

	private String groupName;
	private List<ValidationIssue> issues;
	
	public ValidationIssueGroup(String groupName, List<ValidationIssue> issues) {
		this.groupName = groupName;
		this.issues = issues;
	}
	
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public List<ValidationIssue> getIssues() {
		return issues;
	}
	public void setIssues(List<ValidationIssue> issues) {
		this.issues = issues;
	}
	
	public int getErrorsCount() {
		return issues.size();
	}
	
	public static ValidationIssueGroup defaultGroup(List<ValidationIssue> issues) {
		return new ValidationIssueGroup("0", issues);
	}
	
}
