package bil.learn.tutpoint;


class PrintDemo {
	public  void printCount(String threadname){
		try {
			for(int i = 50; i > 0; i--) {
				System.out.println("Counter   ---   "  + i +" Thread name "+threadname);
			}
		} catch (Exception e) {
			System.out.println("Thread  interrupted.");
		}
	}

}

class ThreadDemo extends Thread {
	private Thread t;
	private String threadName;
	PrintDemo  PD;

	ThreadDemo( String name,  PrintDemo pd){
		threadName = name;
		PD = pd;
	}

	public void run() {
		PD.printCount(threadName);
		/*synchronized(PD) {
		        PD.printCount(threadName);
		     }*/
		System.out.println("Thread " +  threadName + " exiting.");
	}

	public void start ()
	{
		System.out.println("Starting " +  threadName );
		if (t == null)
		{
			t = new Thread (this, threadName);
			t.start ();
		}
	}

}

class Counter{
	long count = 0;
	private String threadName="";

	public String getThreadName() {
		return threadName;
	}

	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}

	public synchronized void add(long value,String threadname){
		setThreadName(threadname);
		for(int a =0;a<50;a++){
			//this.count += value;
			System.out.println("count " +  (count++) +" Thread Name "+threadname );
		}
	}
}

class RunnableDemo implements Runnable {
	private Thread t;
	private String threadName;
	int k=0,g=0;

	private Counter counter ;

	public Counter getCounter() {
		return counter;
	}

	public void setCounter(Counter counter) {
		this.counter = counter;
	}

	RunnableDemo( String name){
		threadName = name;
		System.out.println("Creating " +  threadName );
	}

	public void run() {
		System.out.println("Running " +  threadName );
		runinside();
		System.out.println("Thread " +  threadName + " exiting.");
	}

	void runinside()
	{
		//for(int i = 40; i > 0; i--) {
		//System.out.println("Thread: " + threadName + ", " + i+ " g= "+g++ );
		//counter.setThreadName(threadName);
		counter.add(1,threadName);
		// Let the thread sleep for a while.
		/*try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
		//}
	}

	public void start ()
	{
		System.out.println("Starting " +  threadName );
		if (t == null)
		{
			t = new Thread (this, threadName);
			t.start ();
		}
	}

}

class Chat {
	boolean flag = false;

	public synchronized void Question(String msg) {
		if (flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(msg);
		flag = true;
		notify();
	}

	public synchronized void Answer(String msg) {
		if (!flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println(msg);
		flag = false;
		notify();
	}
}

class T1 implements Runnable {
	Chat m;
	String[] s1 = { "Hi", "How are you ?", "I am also doing fine!" };

	public T1(Chat m1) {
		this.m = m1;
		new Thread(this, "Question").start();
	}

	public void run() {
		for (int i = 0; i < s1.length; i++) {
			m.Question(s1[i]);
		}
	}
}

class T2 implements Runnable {
	Chat m;
	String[] s2 = { "Hi", "I am good, what about you?", "Great!" };

	public T2(Chat m2) {
		this.m = m2;
		new Thread(this, "Answer").start();
	}

	public void run() {
		for (int i = 0; i < s2.length; i++) {
			m.Answer(s2[i]);
		}
	}
}

class DaemonThread extends Thread {
	public void run() {
		System.out.println("Entering run method");

		try {
			System.out.println("In run Method: currentThread() is" + Thread.currentThread());
			while (true) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException x) {}
				System.out.println("In run method: woke up again");
			}
		} finally {
			System.out.println("Leaving run Method");
		}
	}
}
