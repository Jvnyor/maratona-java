package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import academy.devdojo.maratonajava.javacore.ZZGconcorrencia.service.StoreService;

public class CompletableFutureTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StoreService storeService = new StoreService();
//		searchPricesSync(storeService);
//		searchPricesAsyncFuture(storeService);
		searchPricesAsyncCompletableFuture(storeService);
	}

	private static void searchPricesSync(StoreService storeService) {
		long start = System.currentTimeMillis();
		System.out.println(storeService.getPriceSync("Store 1"));
		System.out.println(storeService.getPriceSync("Store 2"));
		System.out.println(storeService.getPriceSync("Store 3"));
		System.out.println(storeService.getPriceSync("Store 4"));
		long end = System.currentTimeMillis();
		System.out.printf("Time passed to searchPricesSync %dms%n", (end - start));
	}

	private static void searchPricesAsyncFuture(StoreService storeService) {
		long start = System.currentTimeMillis();
		Future<Double> pricesAsyncFuture1 = storeService.getPricesAsyncFuture("Store 1");
		Future<Double> pricesAsyncFuture2 = storeService.getPricesAsyncFuture("Store 2");
		Future<Double> pricesAsyncFuture3 = storeService.getPricesAsyncFuture("Store 3");
		Future<Double> pricesAsyncFuture4 = storeService.getPricesAsyncFuture("Store 4");
		try {
			System.out.println(pricesAsyncFuture1.get());
			System.out.println(pricesAsyncFuture2.get());
			System.out.println(pricesAsyncFuture3.get());
			System.out.println(pricesAsyncFuture4.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.printf("Time passed to searchPricesAsyncFuture %dms%n", (end - start));
		StoreService.shutdown();
	}
	
	private static void searchPricesAsyncCompletableFuture(StoreService storeService) {
		long start = System.currentTimeMillis();
		CompletableFuture<Double> pricesAsyncCompletableFuture1 = storeService.getPricesAsyncCompletableFuture("Store 1");
		CompletableFuture<Double> pricesAsyncCompletableFuture2 = storeService.getPricesAsyncCompletableFuture("Store 2");
		CompletableFuture<Double> pricesAsyncCompletableFuture3 = storeService.getPricesAsyncCompletableFuture("Store 3");
		CompletableFuture<Double> pricesAsyncCompletableFuture4 = storeService.getPricesAsyncCompletableFuture("Store 4");
		try {
			System.out.println(pricesAsyncCompletableFuture1.get());
			System.out.println(pricesAsyncCompletableFuture2.get());
			System.out.println(pricesAsyncCompletableFuture3.get());
			System.out.println(pricesAsyncCompletableFuture4.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.printf("Time passed to searchPricesAsyncCompletableFuture %dms%n", (end - start));
		StoreService.shutdown();
	}
}
