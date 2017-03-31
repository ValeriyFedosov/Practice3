package ua.nure.fedosov.Practice3.part1;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {
	private static final String INPUT = "Login;Name;Email\nivanov;Ivan Ivanov;ivanov@mail.ru\n"
			+ "petrov;Petr Petrov;petrov@google.com\nobama;Barack Obama;obama@google.com\n"
			+ "bush;George Bush;bush@mail.ru";

	private static final String lineSeparator = System.lineSeparator();
	StringBuilder sb = new StringBuilder();
	Pattern pattern = Pattern.compile("(\\w+);(\\p{L}+)\\s(\\p{L}+);(\\w+@(\\w+\\.\\w{2,3}))");

	public String convert1() {
		sb = new StringBuilder();
		Matcher matcher = pattern.matcher(INPUT);
		while (matcher.find()) {
			sb.append(matcher.group(1)).append(" ==> ").append(matcher.group(4)).append(lineSeparator);
		}
		return sb.toString();
	}

	public String convert2() {
		sb = new StringBuilder();
		Matcher matcher = pattern.matcher(INPUT);
		while (matcher.find()) {
			sb.append(matcher.group(3)).append(" ").append(matcher.group(2)).append(" (email: ")
					.append(matcher.group(4)).append(")").append(lineSeparator);
		}
		return sb.toString();
	}

	public String convert3() {
		String result = new String();
		for (String str : INPUT.replaceFirst(".*?\n", "").split("\n")) {
			String login = str.split(";")[0];
			String domen = str.replaceFirst(".*@", "");
			result = result.contains(domen) ? result.replaceFirst(domen + ".*?(?=\n)", "$0, " + login)
					: String.format("%s%s ==> %s\n", result, domen, login);
		}
		return result;
	}
//
	public String convert4() {
		sb = new StringBuilder();
		Pattern patternForTitle = Pattern.compile("\\w+;\\w+;\\w+");
		Matcher matcherForTitle = patternForTitle.matcher(INPUT);
		Matcher matcher = pattern.matcher(INPUT);
		matcherForTitle.find();
		Random random = new Random();
		sb.append(matcherForTitle.group()).append(";Password").append(lineSeparator);
		while(matcher.find()) {
			sb.append(matcher.group()).append(";").append(random.nextInt(9)).append(random.nextInt(9)).
			append(random.nextInt(9)).append(random.nextInt(9)).append(lineSeparator);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Part1 part1 = new Part1();
		System.out.println("Output of convert1" + lineSeparator + part1.convert1());
		System.out.println("Output of convert2" + lineSeparator + part1.convert2());
		System.out.println("Output of convert3" + lineSeparator + part1.convert3());
		System.out.println("Output of convert4" + lineSeparator + part1.convert4());

	}

}
