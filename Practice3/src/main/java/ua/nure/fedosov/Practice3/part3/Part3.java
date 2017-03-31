package ua.nure.fedosov.Practice3.part3;

public class Part3 {

	private static final String INPUT = "When I was younger\nI never needed";

	public static void main(String[] args) {
		String[] strings = INPUT.split("\\s");
		StringBuilder sb = new StringBuilder();
		for (String string : strings) {
			if (Character.isLowerCase(string.charAt(0))) {
				sb.append(string.replace(string.substring(0, 1), string.substring(0, 1).toUpperCase())).append(" ");
			} else
				sb.append(string).append(" ");
		}
		System.out.println(sb);
	}

}
