package com.util;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		addToLinkedList();
		hashSetToTreeSet();
		checkIfKeyExists();
	}

	public static void addToLinkedList() {
		LinkedList<String> l_list = new LinkedList<String>();
		l_list.add("Red");
		l_list.add("Green");
		l_list.add("Black");
		System.out.println("Original linked list:" + l_list);
		l_list.addFirst("White");

		l_list.addLast("Pink");
		System.out.println("Final linked list:" + l_list);
	}

	public static void hashSetToTreeSet() {
		Set<String> setobj = new HashSet<>();
		setobj.add("Welcome");
		setobj.add("To");
		setobj.add("ITWorx");
		setobj.add("Java");
		setobj.add("Fast");
		setobj.add("Track");

		System.out.println("HashSet: " + setobj);

		TreeSet<String> hashSetToTreeSet = new TreeSet<>(setobj);

		System.out.println("Last element is: " + hashSetToTreeSet.pollLast());
		System.out.println("TreeSet: " + hashSetToTreeSet.toString());
	}

	public static void checkIfKeyExists() {
		Map<String, String> map = Collections.singletonMap("key", "value");

		if (map.containsKey("key")) {
			System.out.println("value of key from map : " + map.get("key"));
		}
	}

}
