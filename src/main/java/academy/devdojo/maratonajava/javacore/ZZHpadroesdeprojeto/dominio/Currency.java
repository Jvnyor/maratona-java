package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio;

public interface Currency {

	String getSymbol();
}

class Real implements Currency {

	private final String symbol = "R$";
	
	@Override
	public String getSymbol() {
		// TODO Auto-generated method stub
		return symbol;
	}

	@Override
	public String toString() {
		return symbol;
	}
	
	
}

class UsDollar implements Currency {

	private final String symbol = "$";
	
	@Override
	public String getSymbol() {
		// TODO Auto-generated method stub
		return symbol;
	}

	@Override
	public String toString() {
		return symbol;
	}
	
}