package academy.devdojo.maratonajava.javacore.Fmodificadorestatico.dominio;

public class Anime {

	private String nome;
	private static int[] episodios;
	// 0 - Bloco de inicializa��o est�tico � executado quando a JVM carregar a classe
	// 1 - Alocado espa�o em mem�ria pro objeto
	// 2 - Cada atributo da classe � criado e inicializado com valores default ou o que for passado
	// 3 - Bloco de inicializa��o � executado
	// 4 - Construtor � executado
	static {
		System.out.println("Dentro do bloco de inicializa��o est�tico");
		episodios = new int[100];
		for (int i = 0; i < episodios.length; i++) {
			episodios[i] =i+1;
		}
	}
	
	static {
		System.out.println("Dentro do bloco de inicializa��o est�tico 2");
		
	}
	
	static {
		System.out.println("Dentro do bloco de inicializa��o est�tico 3");
		
	}
	{
		System.out.println("Dentro do bloco de inicializa��o n�o est�tico");
	}
	public Anime(String nome) {
		super();
		this.nome = nome;
	}

	public Anime() {
		
		for(int episodio:Anime.episodios) {
			System.out.print(episodio+" ");
		}
		System.out.println();
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int[] getEpisodios() {
		return Anime.episodios;
	}
	
}
