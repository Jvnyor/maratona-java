package academy.devdojo.maratonajava.javacore.ZZFthreads.dominio;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Members {
	private final Queue<String> emails = new ArrayBlockingQueue<>(10);

	private boolean open = true;

	public boolean isOpen() {
		return open;
	}

	public int pendingEmails() {
		synchronized (this.emails) {
			return this.emails.size();
		}
	}

	public void addMemberEmail(String email) {
		synchronized (this.emails) {
			String threadName = Thread.currentThread().getName();
			this.emails.add(email);
			System.out.println(threadName + " adicionou email na lista");
			this.emails.notifyAll();
		}
	}

	public String retrieveEmail() throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " checking if there are emails");
		synchronized (this.emails) {
			while (this.emails.size() == 0) {
				if (!open)
					return null;
				System.out.println(Thread.currentThread().getName()
						+ " N?o tem email dispon?vel na lista, entrando em modo de espera");
				this.emails.wait();
			}
			return this.emails.poll();
		}
	}

	public void close() {
		open = false;
		synchronized (this.emails) {
			System.out.println(
					Thread.currentThread().getName() + " Notificando todo mundo que n?o estamos mais pegando emails");
			this.emails.notifyAll();
		}
	}
}
