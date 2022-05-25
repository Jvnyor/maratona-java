package academy.devdojo.maratonajava.javacore.Oexception.runtime.test;

import java.io.IOException;
import java.sql.SQLException;

public class RuntimeExceptionTest04 {

	public static void main(String[] args) {
		try {
			throw new RuntimeException();
		} catch (ArrayIndexOutOfBoundsException | IllegalArgumentException | ArithmeticException e) {
			// TODO: handle exception
			System.out.println("Dentro do ArrayIndexOutOfBoundsException | IllegalArgumentException | ArithmeticException");
		} catch (RuntimeException e) {
			System.out.println("Dentro do RuntimeException");
		}
		
		try {
			talvezLanceException();
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void talvezLanceException() throws SQLException,IOException{
		
	}
}
