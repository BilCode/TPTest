package bil.learn.tutpoint;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class hello
 */
@WebServlet("/HelloBWorld")
public class hello extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public hello() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println(request.getRequestedSessionId());
		
		if(request.getParameter("sorting")!=null&&(request.getParameter("sorting").equals("true")))
		{
			int[] data = new int[]{4,6,46,10,7,3,9,1,5,2};
			Sorting sortData = new Sorting();
			response.getWriter().println("Orignal data: "+Arrays.toString(data));
			sortData.setNumbers(data);
			///int[] sorted = sortData.Insertion();
			//int[] sorted =sortData.Selection();
			int[] sorted =sortData.MergeSort(data);
			response.getWriter().println("Sorted data: "+Arrays.toString(sorted));
		}else if(request.getParameter("thread")!=null&&(request.getParameter("thread").equals("true")))
		{
			/**Thread in runable**/
			Counter counter = new Counter();
			RunnableDemo R1 = new RunnableDemo( "Thread-1");
			R1.setCounter(counter);
			R1.start();

			RunnableDemo R2 = new RunnableDemo( "Thread-2");
			R2.setCounter(counter);
			R2.start();
			
			/**Thread**/
			/*PrintDemo PD = new PrintDemo();

			ThreadDemo T1 = new ThreadDemo( "Thread - 1 ", PD );
			ThreadDemo T2 = new ThreadDemo( "Thread - 2 ", PD );

			T1.start();
			T2.start();*/
		}else
		{
			Cookie firstName = new Cookie("first_name",
					request.getParameter("first_name"));
			String title="Btitle";
			firstName.setMaxAge(60*60*24); 
			response.addCookie( firstName );
			PrintWriter out = response.getWriter();

			Cookie cookie = null;
			Cookie[] cookies = null;
			// Get an array of Cookies associated with this domain
			cookies = request.getCookies();

			String docType =
					"<!doctype html public \"-//w3c//dtd html 4.0 " +
							"transitional//en\">\n";
			out.println(docType +
					"<html>\n" +
					"<head><title>" + title + "</title></head>\n" +
					"<body bgcolor=\"#f0f0f0\">\n" +
					"<h1 align=\"center\">" + title + "</h1>\n" +
					"<ul>\n" +
					"  <li><b>First Name</b>: "
					+ request.getParameter("first_name") + "\n" +
					"  <li><b>Last Name</b>: "
					+ request.getParameter("last_name") + "\n" +
					"</ul>\n");

			if( cookies != null ){
				out.println("<h2> Cookies Name and Value</h2>");
				for (int i = 0; i < cookies.length; i++){
					cookie = cookies[i];
					if((cookie.getName( )).compareTo("first_name") == 0 ){
						cookie.setMaxAge(0);
						response.addCookie(cookie);
						out.print("Deleted cookie : " + 
								cookie.getName( ) + "<br/>");
					}
					out.print("Name : " + cookie.getName( ) + ",  ");
					out.print("Value: " + cookie.getValue( )+" <br/>");
				}
			}else{
				out.println(
						"<h2>No cookies founds</h2>");
			}
			out.println(docType +"</body></html>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

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
