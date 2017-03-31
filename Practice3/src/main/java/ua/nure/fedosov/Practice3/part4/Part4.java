package ua.nure.fedosov.Practice3.part4;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part4 {

	public static String hash(String input, String algorithm) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance(algorithm);
		digest.update(input.getBytes());
		byte[] hash = digest.digest();
		int[] ints = new int[hash.length];
		for (int i = 0; i < ints.length; i++) {
			ints[i] = hash[i];
		}
		StringBuilder sb = new StringBuilder();
		Pattern pattern = Pattern.compile("\\w{1,2}$");
		Matcher matcher = pattern.matcher(Integer.toHexString(ints[0]).toUpperCase());
		matcher.find();
		sb.append(matcher.group()).append(" ");
		for (int i = 1; i < ints.length; i++) {
			matcher.reset(Integer.toHexString(ints[i]).toUpperCase());
			matcher.find();
			sb.append(matcher.group()).append(" ");
		}
		System.out.println(Arrays.toString(hash));
		return sb.toString();
	}

	public static void main(String[] args) throws NoSuchAlgorithmException {
		System.out.println(hash("password", "SHA-256"));

	}
}
