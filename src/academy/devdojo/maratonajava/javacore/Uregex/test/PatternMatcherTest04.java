package academy.devdojo.maratonajava.javacore.Uregex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTest04 {
    public static void main(String[] args) {
        // \d = Todos os d�gitos
        // \D = Tudo o que n�o for d�gito
        // \s = Espa�os em branco \t \n \f \r
        // \S = Todos os caracters excluindo os brancos
        // \w = a-ZA-Z, d�gitos, _
        // \W = Tudo o que n�o for incluso no \w
    	// []
    	// ? Zero ou uma
    	// * zero ou mais
    	// + uma ou mais
    	// {n,m} de n at� m
    	// ()
    	// |
    	// $
//    	String regex = "[a-zA-C]";
        String regex = "0[xX]([0-9a-fA-F])+(\\s|$)";
//        String texto = "abaaba";
        String texto2 = "12 0x 0X 0xFFABC 0x109G 0x1 ";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto2);
        System.out.println("texto:  "+texto2);
        System.out.println("indice: 0123456789");
        System.out.println("regex "+regex);
        System.out.println("Posicoes encontradas");
        while (matcher.find()){
            System.out.print(matcher.start()+" "+matcher.group()+"\n");
        }
    }
}