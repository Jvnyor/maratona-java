package academy.devdojo.maratonajava.javacore.Gassociacao.dominio;

public class Professor {
	private String nome;
	private String especialidade;
	
	private Seminario[] seminarios;

	public void imprime() {
		System.out.println("Professor: "+this.nome);
		System.out.println("Especialidade: "+this.especialidade);
		if (this.seminarios==null) return;
		System.out.println("\nSeminários cadastrados:");
		for (Seminario seminario : this.seminarios) {
			System.out.println(seminario.getTitulo());
			System.out.println("\nLocal: "+seminario.getLocal().getEndereco());
			System.out.println("\nAlunos:");
			if (seminario.getAlunos()==null || seminario.getAlunos().length==0) continue;
			for (Aluno aluno : seminario.getAlunos()) {
				System.out.println("\nAluno: "+aluno.getNome());
				System.out.println("Idade: "+aluno.getIdade());
			}
		}
	}
	
	public Professor(String nome, String especialidade) {
		this.nome = nome;
		this.especialidade = especialidade;
	}

	public Professor(String nome, String especialidade, Seminario[] seminarios) {
		this.nome = nome;
		this.especialidade = especialidade;
		this.seminarios = seminarios;
	}

	public Seminario[] getSeminarios() {
		return seminarios;
	}

	public void setSeminarios(Seminario[] seminarios) {
		this.seminarios = seminarios;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Professor(String nome) {
		this.nome = nome;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	
}
