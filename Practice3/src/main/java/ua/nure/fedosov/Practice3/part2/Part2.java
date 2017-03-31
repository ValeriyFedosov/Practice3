package ua.nure.fedosov.Practice3.part2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Part2 {

	private static final String INPUT = "When I was younger, so much younger than today\n"
			+ "I never needed anybody's help in any way\n"
			+ "But now these days are gone, I'm not so self-assured\n"
			+ "Now I find I've changed my mind\n"
			+ "I've opened up the doors";
	
	private static String[] withoutTheSameWords(String[] s) {
		Set<String> set = new HashSet<>();
		for (String string : s) {
			set.add(string);
		}
		String[] result = new String[set.size()];
		Iterator<String> iterator = set.iterator();
		int  i = 0;
		while(iterator.hasNext()) {
			result[i++] = iterator.next();
		}
		return result;
	}
	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		String[] strings = withoutTheSameWords(INPUT.split("\\s|\\,\\s|-|'"));
		Arrays.sort(strings, new Comparator<String>() {
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});
		sb.append("Min: ").append(strings[0]).append(", ");
		for (int i = 1; i < strings.length; i++) {
			if(!strings[0].equals(strings[i]) && strings[0].length() == strings[i].length()) {
				sb.append(strings[i] + ", ");
			}
		}
		sb.append(System.lineSeparator()).append("Max: ").append(strings[strings.length - 1]).append(", ");
		for (int i = 0; i < strings.length; i++) {
			if(!strings[strings.length - 1].equals(strings[i]) && strings[strings.length - 1].length() == strings[i].length()) {
				sb.append(strings[i] + ", ");
			}
		}
		System.out.println(sb);
	}

}
