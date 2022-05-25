package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class StoreService {
	private static final ExecutorService ex = Executors.newCachedThreadPool();
	
	public double getPriceSync(String storeName) {
		System.out.printf("Getting price sync for store %s%n", storeName);
		return priceGenerator();
	}
	
	public Future<Double> getPricesAsyncFuture(String storeName) {
		System.out.printf("Getting price async for store %s%n", storeName);
		return ex.submit(this::priceGenerator);
	}
	
	public CompletableFuture<Double> getPricesAsyncCompletableFuture(String storeName) {
		System.out.printf("Getting price async for store %s%n", storeName);
		return CompletableFuture.supplyAsync(this::priceGenerator);
	}
	
	private double priceGenerator() {
		System.out.printf("%s generating price %n", Thread.currentThread().getName());
		delay();
		return ThreadLocalRandom.current().nextInt(1, 500) * 10;
	}
	
	public static void shutdown() {
		ex.shutdown();
	}
	
	private void delay() {
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
