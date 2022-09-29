package apachePOI;

import java.util.Random;

public class RradDataFromxls {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String name() {
		String fn;
		String text = "abcdefghijklmnopqrstuvwxyz";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 4) {
			int index = (int) (rnd.nextFloat() * text.length());
			salt.append(text.charAt(index));
		}
		fn = salt.toString();
		return fn;
	}

	public String phoneNum() {
		String phone;
		String nums = "0123456789";
		StringBuilder salt1 = new StringBuilder();
		Random rnd = new Random();
		while (salt1.length() < 10) {
			int index = (int) (rnd.nextFloat() * nums.length());
			salt1.append(nums.charAt(index));
		}
		phone = salt1.toString();
		return phone;
	}
}
