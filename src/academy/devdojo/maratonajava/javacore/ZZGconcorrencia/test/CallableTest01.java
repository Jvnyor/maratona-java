package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

class RandomNumberCallable implements Callable<String> {

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		int count = ThreadLocalRandom.current().nextInt(1, 11);
		return null;
	}

}

public class CallableTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
