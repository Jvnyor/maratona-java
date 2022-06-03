package academy.devdojo.maratonajava.javacore.Minterfaces.dominio;

public class FileLoader implements DataLoader, DataRemover {

	@Override
	public void load() {
		// TODO Auto-generated method stub
		System.out.println("Carregando dados de um arquivo");
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		System.out.println("Removendo dados de um arquivo");
	}

	@Override
	public void checkPermission() {
		// TODO Auto-generated method stub
		System.out.println("Checando permissões no arquivo");
	}
	
}
