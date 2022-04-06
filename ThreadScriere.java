import java.util.ArrayList;

class ThreadScriere extends ManagerCursCSV implements Runnable{

	ArrayList <Student> studenti;
	ArrayList <Profesor> profesori;
	ManagerCursuri cursuri;
	
	Thread t;
	
	ThreadScriere(ArrayList<Student> s, ArrayList<Profesor> p, ManagerCursuri c)
	{
		t = new Thread(this);
		studenti = s;
		profesori = p;
		cursuri = c;
		System.out.println("		Thread-ul de scriere date a fost creat.\n");
		t.start();
	}
	
	public void run() 
	{
		try
		{
			Thread.sleep(1000);	
			ManagerCursCSV.ScrieCursuriInFisier(cursuri);
			ManagerCursCSV.AddStudent(studenti);
			ManagerCursCSV.AddProfesor(profesori);
		} 
		catch (InterruptedException e) {
			System.out.println("		Thread-ul de scriere de date s-a intrerupt.");
		}
		System.out.println("		Thread-ul de scriere de date s-a terminat.");
	}
}

