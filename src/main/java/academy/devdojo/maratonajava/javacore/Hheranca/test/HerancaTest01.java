package academy.devdojo.maratonajava.javacore.Hheranca.test;

import academy.devdojo.maratonajava.javacore.Hheranca.dominio.Endereco;
import academy.devdojo.maratonajava.javacore.Hheranca.dominio.Funcionario;
import academy.devdojo.maratonajava.javacore.Hheranca.dominio.Pessoa;

public class HerancaTest01 {
	public static void main(String[] args) {
		Endereco endereco = new Endereco();
		endereco.setRua("Rua Trinta");
		endereco.setCep("54580-000");
		Pessoa pessoa = new Pessoa("Josias");
		pessoa.setCpf("12345678910");
		pessoa.setEndereco(endereco);
		
		pessoa.imprime();
		
		Funcionario funcionario = new Funcionario("Oda Nobunaga");
		funcionario.setCpf("12345678911");
		funcionario.setEndereco(endereco);
		funcionario.setSalario(20000);
		
		System.out.println("-----------------");
		
		funcionario.imprime();
		System.out.println("-----------------");
		funcionario.relatorioPagamento();
	}
}
