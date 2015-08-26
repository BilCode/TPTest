package bil.learn.tutpoint;

public class SimpleTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**Daemon**/
		System.out.println("Entering main Method");

        DaemonThread t = new DaemonThread();
        t.setDaemon(true);
        t.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException x) {}

        System.out.println("Leaving main method");

	}

}
