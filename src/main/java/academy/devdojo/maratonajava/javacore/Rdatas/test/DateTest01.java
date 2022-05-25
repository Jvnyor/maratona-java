package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.util.Date;

public class DateTest01 {
	public static void main(String[] args) {
		Date date = new Date(1647968256965l);// long 1000000000
		date.setTime(date.getTime() + 3_800_000);
		System.out.println(date);
	}
}
