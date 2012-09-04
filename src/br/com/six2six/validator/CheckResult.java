package br.com.six2six.validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckResult {
	
	private Map<String, List<ValidationIssue>> groupedIssues = new HashMap<String, List<ValidationIssue>>();
	
	public CheckResult(String groupName, List<ValidationIssue> issues) {
		this.addGroup(groupName, issues);
	}
	
	public CheckResult(List<ValidationIssue> issues) {
		this.addGroup(null, issues);
	}	
	
	public CheckResult addGroup(String groupName, List<ValidationIssue> issues) {
		addToGroup(groupName, issues);
		return this;
	}
	
	public CheckResult addToGroup(String groupName, List<ValidationIssue> issues) {
		if (groupName == null) {
			groupName = "default";
		}
		
		List<ValidationIssue> issuesOnMap = groupedIssues.get(groupName);
		if (issuesOnMap == null) {
			issuesOnMap = new ArrayList<ValidationIssue>();
			groupedIssues.put(groupName, issuesOnMap);
		}
		
		if (issues != null && !issues.isEmpty()) {
			issuesOnMap.addAll(issues);
		}

		return this;
	}	
	
	public boolean isValid() {
		return getErrorsCount() == 0;
	}
	
	public boolean hasErrors() {
		return !isValid();
	}

	public List<ValidationIssue> getIssues() {
		List<ValidationIssue> issues = new ArrayList<ValidationIssue>();
		for (String group : groupedIssues.keySet()) {
			if (!groupedIssues.get(group).isEmpty()) {
				issues.addAll(groupedIssues.get(group));
			}
		}
		return issues;
	}
	
	public Map<String, List<ValidationIssue>> getIssuesGroups() {
		return groupedIssues;
	}
	
	public int getErrorsCount() {
		return this.getIssues().size();
	}
	
	public int getGroupsCount() {
		return this.groupedIssues.keySet().size();
	}

}
