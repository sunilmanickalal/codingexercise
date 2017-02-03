package com.sunil.sorting.sources.comparator;

import java.util.Comparator;

import com.sunil.sorting.sources.comparator.domains.Person;

public class PersonComparator implements Comparator<Person> {
	
	private String sortOrder;
	private String sortColumn;
	public PersonComparator() {
		super();
		this.sortOrder = "asc";
		this.sortColumn = "name";
	}
	public PersonComparator(String sortOrder, String sortColumn) {
		super();
		this.sortOrder = sortOrder;
		this.sortColumn = sortColumn;
	}
	public String getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}
	public String getSortColumn() {
		return sortColumn;
	}
	public void setSortColumn(String sortColumn) {
		this.sortColumn = sortColumn;
	}
	public int compare(Person p1, Person p2) {
		int result = 0;
		if(sortOrder.equalsIgnoreCase("asc")) {
			result = personcomparing(p1, p2);
		} else {
			result = personcomparing(p2, p1);
		}
		return result;
	}
	private int personcomparing(Person p1, Person p2) {
		int result = 0;
		if(sortColumn.equalsIgnoreCase("name")) {
			result = p1.getName().compareTo(p2.getName());
		} if(sortColumn.equalsIgnoreCase("age")) {
			result = p1.getAge() - (p2.getAge());
		}
		return result;
	}
}
