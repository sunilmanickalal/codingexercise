package com.sunil.sorting.sources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.sunil.sorting.sources.comparator.PersonComparator;
import com.sunil.sorting.sources.comparator.domains.Person;

public class PersonApp {

	public static void main(String[] args) {
		List<Person> lperson = loadPersonData();
		System.out.println("Before Sorting");
		System.out.println("==============");
		displayPersonList(lperson);
		Collections.sort(lperson, new PersonComparator("asc", "age"));
		System.out.println("After Sorting");
		System.out.println("==============");
		displayPersonList(lperson);
	}

	private static void displayPersonList(List<Person> lperson) {
		for(Person p: lperson) {
			System.out.println(p.toString());
		}
	}

	private static List<Person> loadPersonData() {
		List<Person> plist = new ArrayList<Person>(Arrays.asList(	new Person("tintin", 17), 
																	new Person("abba", 40),
																	new Person("disco", 30)));
		return plist;
	}

}
