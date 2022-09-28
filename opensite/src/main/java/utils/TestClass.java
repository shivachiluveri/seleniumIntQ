package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
enum Gfg {
	CODE, LEARN, CONTRIBUTE, QUIZ, MCQ
};
public class TestClass {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hi");
	}
	public static void setExamples() {
		Set<String> hash_Set = new HashSet<String>();
		Set<String> lh_Set = new LinkedHashSet<String>();
		EnumSet<Gfg> set1, set2, set3, set4;
		// TreeSet is one of the most important implementations of the SortedSet
		// interface
		TreeSet ts = new TreeSet();
		Set syncSet = Collections.synchronizedSet(ts);
		hash_Set.add("Geeks");
	}
	public static void mapExamples() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "Amit");
		// just like HashMap with an additional feature of maintaining an order of
		// elements inserted into it.
		// public class LinkedHashMap<K,​V> extends HashMap<K,​V> implements Map<K,​V>
		LinkedHashMap<String, String> lhm = new LinkedHashMap<String, String>();
		lhm.put("one", "practice.geeksforgeeks.org");
		lhm.put("two", "code.geeksforgeeks.org");
		// Creating an empty TreeMap
		TreeMap<Integer, String> tree_map = new TreeMap<Integer, String>();
	}
	public static void listExamples() {
		List ls = new ArrayList<Integer>();
		List lls = new LinkedList<Integer>();
		List stk = new Stack<Integer>();
		List vctr = new Vector<Integer>();
		ls.add(7);
		System.out.println(ls);
	}
	public static void colExamples() {
	}
}