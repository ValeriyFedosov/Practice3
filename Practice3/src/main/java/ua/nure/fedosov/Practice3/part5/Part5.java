package ua.nure.fedosov.Practice3.part5;


public class Part5 {

	public static Object[][] map = { { 100, "\u216d" }, { 90, "\u2169\u216d" }, { 50, "\u216c" },
			{ 40, "\u2169\u216c" }, { 10, "\u2169" }, { 9, "\u2160\u2169" }, { 5, "\u2164" }, { 4, "\u2160\u2164" },
			{ 1, "\u2160" } };

	public static String decimal2Roman(int n) {
		StringBuilder result = new StringBuilder();
		for (Object[] item : map)
			while (n - (Integer) item[0] >= 0) {
				result.append((String) item[1]);
				n -= (Integer) item[0];
			}
		return result.toString();
	}

	public static int roman2Decimal(String s) {
		int result = 0;
		for (Object[] item : map) {
			while (s.startsWith((String) item[1])) {
				result += (Integer) item[0];
				s = s.replaceFirst((String) item[1], "");
			}
		}
		return result;
	}

	public static void main(String[] args) {
		for (int i = 1; i <= 100; i++) {
            System.out.println(i + " ====> " + decimal2Roman(i) + " ====> " + roman2Decimal(decimal2Roman(i)));
        }
	}
}
