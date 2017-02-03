package com.sunil.sorting.sources;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimpleListSorting {

	public static void main(String[] args) {
		List<String> lStrings = loadList();
		System.out.println("\nBefore Sorting");
		System.out.println("==============");
		displayListContents(lStrings);
		Collections.sort(lStrings);
		System.out.println("\n\nAfter Sorting");
		System.out.println("==============");
		displayListContents(lStrings);
	}

	private static void displayListContents(List<String> lStrings) {
		for(String val : lStrings) {
			System.out.println(val);
		}
	}

	private static List<String> loadList() {
		List<String> lStrings = new ArrayList<String>();
		lStrings.add("camel");
		lStrings.add("tintin");
		lStrings.add("snowy");
		lStrings.add("captain");
		lStrings.add("xavier");
		lStrings.add("abba");
		lStrings.add("banana");
		return lStrings;
	}

}
