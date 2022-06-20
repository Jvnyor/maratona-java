package academy.devdojo.maratonajava.javacore.Pwrapper.test;

public class WrapperTest01 {

	public static void main(String[] args) {
		byte byteP = 1;
		short shortP = 1;
		int intP = 1;
		long longP = 10L;
		float floatP = 10F;
		double doubleP = 10D;
		char charP = 'W';
		boolean booleanP = false;
		
		Byte byteW = 1;
		Short shortW = 1;
		Integer intW = 1; // autoboxing
		Long longW = 10L;
		Float floatW = 10F;
		Double doubleW = 10D;
		Character charW = 'W';
		Boolean booleanW = false;
		
		int i = intW; // unboxing
		Integer intW2 = Integer.parseInt("1");
		boolean verdadeiro = Boolean.parseBoolean("TrUE");
		System.out.println(verdadeiro);
		
		System.out.println(charW.isDigit('A'));
		System.out.println(charW.isDigit('1'));
		System.out.println(charW.isLetterOrDigit('!'));
		System.out.println(charW.isUpperCase('A'));
		System.out.println(charW.isLowerCase('a'));
		System.out.println(charW.toUpperCase('a'));
		System.out.println(charW.toLowerCase('A'));
	}
}