import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Curs implements OperatiiCurs {
	
	String nume;
	String descriere;
	Profesor profu;
	ArrayList<Student> studenti;
	Nota[] note;

//SUPRAINCARCAREA CONSTRUCTORULUI
	public Curs()
	{
		this.nume = "";
		this.descriere = "";
		this.profu = null;
		this.studenti = new ArrayList<Student>();
		this.note = new Nota [0];
	}
	
	public Curs(String nume, String descriere, Profesor profi, ArrayList<Student> studenti, Nota[] note)
	{
		this.nume = nume;
		this.descriere = descriere;
		this.profu = profi;
		this.studenti  = studenti;
		this.note = note;
	}

//CHEIE UNICA STUDENTI
	public void cheieUnica ()
	{
		for(Student s : studenti)
			System.out.println("Cheia unica pentru studentul " + s.nume + " " + s.prenume + " este:\n" + s.hashCode());
		System.out.println();
	}
	
	
//ORDONARE STUDENTI
	
	public void sortareStudenti()
	{	
		System.out.println("Raportul studentilor dupa sortare:");
		Collections.sort(this.studenti, new ComparatorStudenti());
		int i=1;
		for (Student s : studenti) 
		{
			System.out.println(i+". " + s.nume + " " + s.prenume);
			i=i+1;
		}
		System.out.println();
	}
	
//OPERATII GEN
	public void medieNoteStudentiGen(Gen gen)
	{
		double medie = 0;
		int nrStudenti=0;
		for (Nota n : note)
		{
			for ( Student s : studenti)
			{
				if (s.gen == gen)	
				{
					medie += n.nota;
					nrStudenti++;
				}
			}
		}

		System.out.println("Media notelor studentilor de gen " + gen + " la cursul: " + nume );
		
		if ((medie == 0) || (nrStudenti == 0))
			System.out.println("A aparut o eroare. Verificati daca exista studenti de genul " + gen + " inscrisi la curs.\n");
		else
			System.out.println( medie/nrStudenti + "\n");
	}


	
//OPERATII NOTE	
//ADD NOTE
	public void AddNota(Nota nota)
	{
		if (nota == null) 
		{	throw new IllegalArgumentException("Nota nu poate fi de tip null. Va rugam reintroduceti nota.");	}
		
		int noualungime = note.length+1;		
		Nota[] aux = new Nota[noualungime];
		
		int index =0;
		for(Nota n : note)
		{
			aux[index++] = n;
		}
		aux[index] = nota;
		this.note = new Nota[noualungime];
		System.arraycopy(aux, 0, note, 0, noualungime);
	}
	
//RAPORT NOTE
	public void RaportNote() 
	{
		System.out.println("Raportul notelor la cursul: " + nume);
		int i=1;
		for (Nota n : note) 
		{
			System.out.println(i+". " + n);
			i=i+1;
		}
		System.out.println();
	}

//RAPORT MEDIE
	public void RaportMedie() 
	{
		System.out.println("Media notelor la cursul: " + nume);
		int i=0;
		double medie=0;
		for (Nota n : note) 
		{
			medie = medie + n.nota;
			i=i+1;
		}
		medie = medie / i;
		System.out.println(medie + "\n");
	}
	
	
	
//OPERATII STUDENTI	
//ADD STUDENTI	
    public void AddStudent(Student student)
	{  
		studenti.add(student);
	}
	
//REMOVE STUDENTI
    public void RemoveStudent(Student student)
	{
		studenti.remove(student);
	}

//UPDATE STUDENTI
	public void UpdateStudent(Student student)
	{
		System.out.print("\nIntroduceti de la tastatura modificarile pentru STUDENTUL ");
	    if (student.nume == "")
	    	{System.out.println("creat cu ajutorul constructorului default.");}
	    else
	    	{System.out.println(student.nume + " " + student.prenume);}
	    	
		Scanner in = new Scanner(System.in);		
		try
		{
			System.out.print("Noul nume: ");
			String nume = in.nextLine();
			student.nume = nume;
			
			System.out.print("Noul prenume: ");
			String prenume = in.nextLine();
			student.prenume = prenume;
				
			System.out.print("Noua grupa: ");
			int grupa = in.nextInt();
			student.grupa = grupa;
			
			System.out.println("Numele si grupa studentului au fost modificate cu succes.");
		}
		catch(Exception e)
		{
			System.out.println("A aparut o eroare. Va rugam sa verificati ca ati introdus corect numele, prenumele si grupa studentului.");
		}
		in.close();
	}

//RAPORT STUDENTI
	public void RaportStudenti() 
	{
		System.out.println("Raportul studentilor la cursul: " + nume);
		int i=1;
		for (Student s : studenti) 
		{
			System.out.print(i+". " + s);
			i=i+1;
		}
		System.out.println();
	}
	
	
	
//OPERATII PROFESOR
//ADD PROFESOR
	public void AddProfesor(Profesor prof)
	{
		if (this.profu == null)
		{
			this.profu = prof;
			if ((prof.nume=="")||(prof.prenume==""))
				System.out.println("Un obiect de tip 'profesor' a fost creat folosind constructorul default.");
			else
				System.out.println("\nProfesorul " + prof.nume + " " + prof.prenume + " a fost adaugat cu succes.");
		}
		else
		{
			System.out.println("Cursul la care inercati sa adaugati un nou profesor deja are profesor."
						+ "\nStergeti profesorul vechi si incercati din nou.");
		}
	}
	
//REMOVE PROFESOR
	public void RemoveProfesor(Profesor profesor)
	{
//		System.out.println("\nProfesorul " + profesor.nume + " " + profesor.prenume + " a fost sters cu succes.\n");
		this.profu = null;
	}

//UPDATE PROFESOR
	public void UpdateProfesor(Profesor profesor)
	{
		System.out.print("\nIntroduceti de la tastatura modificarile pentru PROFESORUL ");
	    if ((profesor.nume == "")||(profesor.prenume == ""))
	    	{System.out.println("creat cu ajutorul constructorului default.");}
	    else
	    	{System.out.println(profesor.nume + " " + profesor.prenume);}
		
		try
		{
			Scanner in = new Scanner(System.in);
			System.out.print("Noul nume: ");
			String nume = in.nextLine();
			profesor.nume = nume;
			
			System.out.print("Noul prenume: ");
			String prenume = in.nextLine();
			profesor.prenume = prenume;
			System.out.println("Numele profesorului a fost modificat cu succes.");
			in.close();
		}
		catch(Exception e)
		{
			System.out.println("A aparut o eroare. Va rugam sa verificati ca ati introdus corect numele si prenumele profesorului.");
		}
		
	}

	
	
	
	public void UpdateCurs(String nume, String descriere) 
	{
		this.nume = nume;
		this.descriere = descriere;		
	}
	
	@Override public String toString() 
	{
		String str = "CURSUL: " + "\nNume = " + nume + "\nDescriere = " + descriere + "\n\nPROFESOR:\n" + profu + "\n\nSTUDENTI:\n" ;
		
		for(Student s : studenti)
		{
			str+= s + "\n";
			
	/*		if(i<note.length)
				str+= note[i] + "\n";
			else
				str+= "Nu exista nota pentru acest student. \n";
			
			i++;*/
		}
		
		return str;
	}

}

class ComparareCursuri implements Comparator<Curs> 
{
	public int compare(Curs curs1, Curs curs2) 
	{
		String cursul1 = curs1.nume+curs1.descriere+curs1.profu+curs1.studenti;
		String cursul2 = curs2.nume+curs2.descriere+curs2.profu+curs2.studenti;
		return cursul1.compareTo(cursul2);
	}
}