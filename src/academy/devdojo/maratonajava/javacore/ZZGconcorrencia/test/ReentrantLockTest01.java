package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.util.concurrent.locks.ReentrantLock;

class Worker implements Runnable {

	private String name;
	private ReentrantLock lock;
	
	public Worker(String name, ReentrantLock lock) {
		this.name = name;
		this.lock = lock;
	}

	@Override
	public void run() {
		lock.lock();
		try {
			if (lock.isHeldByCurrentThread()) {
				System.out.printf("Thread %s entrou em uma sessão crítica%n", name);
			}
			System.out.printf("%d Threads esperando na fila%n", lock.getQueueLength());
			System.out.printf("Thread %s vai esperar 2s%n", name);
			Thread.sleep(2000);
			System.out.printf("Thread %s finalizou a espera", name);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
}

public class ReentrantLockTest01 {

	public static void main(String[] args) {
		new Thread(new Worker("A", null));
	}

}
