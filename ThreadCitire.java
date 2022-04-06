
public class ThreadCitire extends ManagerCursCSV implements Runnable {

	Thread t;
	
	ThreadCitire()
	{
		t = new Thread(this);
		System.out.println("\n\n\n		Thread-ul de citire date a fost creat.");
		t.start();
	}
	
	public void run() 
	{
		ManagerCursCSV.CitesteDateDinFisiere();
		
		System.out.println("		Thread-ul de citire de date s-a terminat.");
	}

}