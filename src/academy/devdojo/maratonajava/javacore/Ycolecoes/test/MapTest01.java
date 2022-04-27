package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.HashMap;
import java.util.Map;

public class MapTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<>();
		map.put("teklado", "teclado");
		map.put("mouze", "mouse");
		map.put("vc", "você");
		map.putIfAbsent("vc2", "você2");
		System.out.println(map);
		for (String key : map.keySet()) {
			System.out.println(key + " : " + map.get(key));
		}
	}

}
