package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.dominio;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Members {
	private final Queue<String> emails = new ArrayBlockingQueue<>(10);
	private final ReentrantLock lock = new ReentrantLock();
	private final Condition condition = lock.newCondition();
	private boolean open = true;

	public boolean isOpen() {
		return open;
	}

	public int pendingEmails() {
		lock.lock();
		try {
			return this.emails.size();
		} finally {
			lock.unlock();
		}
	}

	public void addMemberEmail(String email) {
		lock.lock();
		try {
			String threadName = Thread.currentThread().getName();
			this.emails.add(email);
			System.out.println(threadName + " adicionou email na lista");
			condition.signalAll();
		} finally {
			lock.unlock();
		}
	}

	public String retrieveEmail() throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " checking if there are emails");
		lock.lock();
		try {
			while (this.emails.size() == 0) {
				if (!open)
					return null;
				System.out.println(Thread.currentThread().getName()
						+ " Não tem email disponível na lista, entrando em modo de espera");
				this.emails.wait();
			}
			return this.emails.poll();
		} finally {
			lock.unlock();
		}
	}

	public void close() {
		open = false;
		lock.lock();
		try {
			System.out.println(
					Thread.currentThread().getName() + " Notificando todo mundo que não estamos mais pegando emails");
			condition.signalAll();
		} finally {
			lock.unlock();
		}
	}
}
