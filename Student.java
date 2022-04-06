import java.util.Comparator;

public class Student extends Persoana{
		
		int grupa;
		
		
//SUPRAINCARCAREA CONSTRUCTORULUI:		
		public Student ()
		{
			this.nume = "";
	    	this.prenume = "";
			this.grupa = 0;
			this.gen = Gen.NESPECIFICAT;
		}
		
		public Student (String nume, String prenume, int grupa, Gen gen)
		{
			this.nume = nume;
			this.prenume = prenume;
			this.grupa = grupa;
			this.gen = gen;
		}
		
		@Override
		public String toString() 
		{
			return "Nume = " + nume + ", Prenume = " + prenume + ", Grupa = " + 
							grupa + ", Gen = " + gen + "\n" ;
		}
		
				
		public int getGrupa() {	return grupa;	}
		public void setGrupa(int grupa) {	this.grupa = grupa;		}
	

	}

	class ComparatorStudenti implements Comparator<Student>
	{	
		public int compare(Student student1, Student student2) 
		{
			String stud1 = student1.nume+student1.prenume+student1.grupa;
			String stud2 = student2.nume+student2.prenume+student2.grupa;
			return stud1.compareTo(stud2);
		}
	}
	

