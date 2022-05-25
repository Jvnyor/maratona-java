package academy.devdojo.maratonajava.javacore.Oexception.exception.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import academy.devdojo.maratonajava.javacore.Oexception.exception.dominio.Leitor1;
import academy.devdojo.maratonajava.javacore.Oexception.exception.dominio.Leitor2;

public class TryWithResourcesTest01 {

	public static void main(String[] args) {
		lerArquivo();
	}
	
	public static void lerArquivo() {
		try (Leitor1 leitor1 = new Leitor1();
			 Leitor2 leitor2 = new Leitor2()){
			
			
			
		} catch(IOException e) {
			
		}
	}
	
	public static void lerArquivo2() {
		Reader reader = null;
		
		try {
			reader = new BufferedReader(new FileReader("teste.txt"));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				if (reader != null) {
					reader.close();
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
