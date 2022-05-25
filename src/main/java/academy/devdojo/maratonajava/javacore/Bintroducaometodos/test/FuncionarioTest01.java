package academy.devdojo.maratonajava.javacore.Bintroducaometodos.test;

import academy.devdojo.maratonajava.javacore.Bintroducaometodos.dominio.Funcionario;

public class FuncionarioTest01 {

	public static void main(String[] args) {
		Funcionario funcionario = new Funcionario();
		
		funcionario.setNome("Josias");
		funcionario.setIdade(19);
		funcionario.setSalarios(new double[] {2000,3000,4000});
		funcionario.imprime();
		System.out.println(funcionario.getMedia());
	}
}
