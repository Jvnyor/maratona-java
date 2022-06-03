package academy.devdojo.maratonajava.introducao;

/*
 Prática
 
 Crie variáveis para os campos descritos abaixo entre <> e imprima a seguinte mensagem:
 
 Eu <nome>, morando no endereço <endereço>,
 confirmo que recebi o salário de <salário>, na data <data>
 */
public class Aula03TiposPrimitivosExercicio {

	public static void main(String[] args) {
		String nome = "Josias Junior";
		String endereco = "Rua Trinta, 24, Ponte dos Carvalhos, Cabo de Santo Agostinho - PE";
		double salario = 1200.00;
		String dataRecebimentoSalario = "01/12/2021";
		String relatorio = "Eu "+nome+" morando no endereço "+endereco+
				", confirmo que recebi o salário de "+salario+" na data "+dataRecebimentoSalario;
		System.out.println(relatorio);
	}
	
}
