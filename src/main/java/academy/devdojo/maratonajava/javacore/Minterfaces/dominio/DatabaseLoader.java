package academy.devdojo.maratonajava.javacore.Minterfaces.dominio;

public class DatabaseLoader implements DataLoader, DataRemover {

	@Override
	public void load() {
		// TODO Auto-generated method stub
		System.out.println("Carregando dados do banco de dados");
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		System.out.println("Removendo dados do banco de dados");
	}

	@Override
	public void checkPermission() {
		// TODO Auto-generated method stub
		System.out.println("Checando permissões no banco de dados");
	}
	
	public static void retrieveMaxDataSize() {
		System.out.println("Dentro do retrieveMaxDataSize na classe DatabaseLoader");
	}
	
}
