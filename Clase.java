import java.util.*;

public class Clase {
@SuppressWarnings("static-access")
public static void main(String[] args){

//DEFINIRE STUDENTI
	ArrayList<Student> studenti = new ArrayList<Student>();
	
	Student student1 = new Student ("Ion", "Andreea", 603, Gen.FEMININ);
	Student student2 = new Student("Nastase", "Cristina", 603, Gen.FEMININ);
	Student student3 = new Student ("Tabacaru", "Iulian", 603, Gen.MASCULIN);
	Student student4 = new Student("Ursu", "Oana", 603, Gen.FEMININ);
	Student student5 = new Student ("Negoita", "Andrei", 2231, Gen.MASCULIN);
//	Student studentDefault = new Student();

//DEFINIRE PROFESORI
	ArrayList<Profesor> profesori = new ArrayList<Profesor>();
	Profesor profesor1 = new Profesor ("Voicu", "Nicoleta", Gen.FEMININ);
	Profesor profesor2 = new Profesor ("Aciu", "Lia", Gen.FEMININ);
//	Profesor profesorDefault = new Profesor ();

//DEFINIRE NOTE
	Nota[] note1 = new Nota[0];
	Nota nota1 = new Nota(9);
	Nota nota2 = new Nota(10);
	Nota nota3 = new Nota(9);
	Nota nota4 = new Nota(3);
	Nota nota5 = new Nota(7);
	
	Nota[] note2 = new Nota[0];
	Nota nota2_1 = new Nota(9);
	Nota nota2_2 = new Nota(8);
	Nota nota2_3 = new Nota(7);
	Nota nota2_4 = new Nota(6);
	Nota nota2_5 = new Nota(2);
	
	
//DEFINIRE CURSURI NOI
	ManagerCursuri cursuri = new ManagerCursuri();
	
	Curs curs1 = new Curs("ALGAD", "Algebra liniara si geometrie analitica si diferentiala", profesor1, studenti, note1);
	Curs curs2 = new Curs("EFM", "Ecuatiile fizicii matematice", profesor2, studenti, note2);
	
//	Curs cursDefault = new Curs();
 

			//	OPERATII DE ADAUGARE
	
	
//ADAUGARE CURSURI
	    cursuri.AddCurs(curs2);
		cursuri.AddCurs(curs1);

//		cursuri.AddCurs(cursDefault);
//ADAUGARE STUDENTI
	
		studenti.add(student1);
		studenti.add(student2);
		studenti.add(student3);
		studenti.add(student4);
		studenti.add(student5);
	
//		cursDefault.AddStudent(studentDefault);
//ADAUGARE PROFESORI
		profesori.add(profesor1);
		profesori.add(profesor2);
//		profesori.add(profesorDefault);
		
//		cursDefault.AddProfesor(profesorDefault);		
//ADAUGARE NOTE
		curs1.AddNota(nota1);
		curs1.AddNota(nota2);
		curs1.AddNota(nota3);
		curs1.AddNota(nota4);
		curs1.AddNota(nota5);
		
		curs2.AddNota(nota2_1);
		curs2.AddNota(nota2_2);
		curs2.AddNota(nota2_3);
		curs2.AddNota(nota2_4);
		curs2.AddNota(nota2_5);

		
			//	OPERATII DE MODIFICARE
				
//MODIFICARE CURS
//		cursuri.UpdateCurs(cursDefault);	

		
	//	System.out.println("\n\n" + cursDefault + "\n");
		
		
			//	OPERATII DE STERGERE
		
//STERGERE STUDENTI
//		cursDefault.RemoveStudent(studentDefault);
//STERGERE PROFESORI
//		cursDefault.RemoveProfesor(profesor2);
//STERGERE CURSURI
//		cursuri.DeleteCurs(cursDefault);	
				
		
		//	OPERATII DE RAPORTARE
		
//RAPORTARE CURSURI
		cursuri.RaportCursuri();	

//SORTARE CURSURI
		cursuri.sortareCursuri();

		
//RAPORT STUDENTI
		curs1.RaportStudenti();
		curs2.RaportStudenti();
		curs1.sortareStudenti();
		
//RAPORT NOTE
		curs1.RaportNote();
		curs2.RaportNote();
//RAPORT MEDIE	
		curs1.RaportMedie();
		curs2.RaportMedie();

//MEDIE NOTE
		curs1.medieNoteStudentiGen(Gen.MASCULIN);
		curs1.medieNoteStudentiGen(Gen.FEMININ);
		curs1.medieNoteStudentiGen(Gen.NESPECIFICAT);
	
//CHEIE UNICA
		curs1.cheieUnica();		
		
//PROCENTAJ INTEGRALISTI
		cursuri.procentajIntegralistiDupaGen(Gen.FEMININ);
		cursuri.procentajIntegralistiDupaGen(Gen.MASCULIN);
		
//VALIDARE PARAMETRI METODE PENTRU NOTA
//		curs1.AddNota(null);
		
	
		ManagerCursCSV managerCursCSV = new ManagerCursCSV();
		ManagerCursCSV.CitesteDateDinFisiere();
		managerCursCSV.AddStudent(studenti);
		managerCursCSV.AddProfesor(profesori);
		managerCursCSV.ScrieCursuriInFisier(cursuri);
		
		System.out.println();
//		new ThreadCitire();	
//		new ThreadScriere(studenti,profesori,cursuri);		
		
		@SuppressWarnings("unused")
	
		AWT f = new AWT(); 		
		Autentificare a = new Autentificare();
		
	}
}