package academy.devdojo.maratonajava.javacore.Gassociacao.test;

import academy.devdojo.maratonajava.javacore.Gassociacao.dominio.Aluno;
import academy.devdojo.maratonajava.javacore.Gassociacao.dominio.Local;
import academy.devdojo.maratonajava.javacore.Gassociacao.dominio.Professor;
import academy.devdojo.maratonajava.javacore.Gassociacao.dominio.Seminario;

public class SeminarioTest03 {
	public static void main(String[] args) {
		Local local = new Local("Recife");
		
		Aluno aluno = new Aluno("Junior", 18);
		
		Professor professor = new Professor("João","Java");
		
		Aluno[] alunos = {aluno};
		Seminario seminario = new Seminario("Impacto do desenvolvimento de software",alunos, local);
		Seminario[] seminarios = {seminario};
		
		professor.setSeminarios(seminarios);
		
		professor.imprime();
	}
}
