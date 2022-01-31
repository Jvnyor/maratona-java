package academy.devdojo.maratonajava.javacore.Oexception.exception.test;

import java.io.FileNotFoundException;

import academy.devdojo.maratonajava.javacore.Oexception.exception.dominio.Funcionario;
import academy.devdojo.maratonajava.javacore.Oexception.exception.dominio.LoginInvalidoException;
import academy.devdojo.maratonajava.javacore.Oexception.exception.dominio.Pessoa;

public class SobrescritaComExceptionTest01 {

	public static void main(String[] args) {
		Pessoa pessoa = new Pessoa();
		Funcionario funcionario = new Funcionario();
		
		try {
			funcionario.salvar();
		} catch (LoginInvalidoException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
