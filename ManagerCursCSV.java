import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ManagerCursCSV extends ManagerCursuri {
	
	File studenti , profesori, cursuri;

	
//	CONSTRUCTORI
	public ManagerCursCSV ()
	{
		try
		{
			studenti = new File("studenti.csv");
			profesori = new File("profesori.csv");
			cursuri = new File("cursuri.csv");
		} 
		catch (Exception e) 
		{
			System.out.println("A aparut o eroare la constructorul ManagerCursCSV");
		}
	}
	public ManagerCursCSV (File studenti , File profesori, File cursuri)
	{
		this.studenti = studenti;
		this.profesori = profesori;
		this.cursuri = cursuri;
	}
	
	
//	CITIRE / SCRIERE IN FISIERE
	public static void CitesteDateDinFisiere ()
	{
		try
		{
			ArrayList <Student> studentlist = PopuleazaStudenti();
			ArrayList <Profesor> proflist = PopuleazaProfesori ();
			ArrayList <Curs> lista = PopuleazaCursuri (proflist , studentlist) ;
			System.out.println("\nStudentii cititi din fisier: \n" + studentlist + "\n");
			System.out.println("Profesorii cititi din fisier: \n" + proflist + "\n");
			System.out.println("Cursurile citite din fisier: \n" + lista);		

				
		}
		catch(Exception e) 
		{
			System.out.println("A aparut o eroare la functia CitesteDateDinFisiere()");
		}
		
	}

	public static ArrayList<Curs> PopuleazaCursuri(ArrayList<Profesor> proflist, ArrayList<Student> studentlist)
	{
		ArrayList <Curs> lista_curs = new ArrayList<Curs>();
		try
		{
			File f = new File( "cursuri.csv" );
			BufferedReader br = new BufferedReader (new FileReader (f));
		    String line = br.readLine();
		    
			while(line!=null)
			{
				for(int i=0; i<proflist.size(); i++)
				{	
					String[] splituri = line.split(",");
					Curs c = new Curs(splituri[0], splituri[1].trim(), proflist.get(i), studentlist, new Nota[0]);
					lista_curs.add(c);
					line=br.readLine();
				}
			}		
			
			br.close();
		}	 
		catch (Exception ex) 
		{
			System.out.println("Eroare la functia PopuleazaCursuri()");
		}
		return lista_curs;
	}	
	public static ArrayList<Student> PopuleazaStudenti ()
	{
		ArrayList <Student> lista_stud = new ArrayList<Student>();
		try
		{
			File f = new File( "studenti.csv" );
			BufferedReader br = new BufferedReader (new FileReader (f));
		    String line = br.readLine();
		
			while(line!=null)
			{
				String[] splituri = line.split(",");
				Student s = new Student(splituri[0], splituri[1].trim(), Integer.parseInt(splituri[2].trim()), Gen.NESPECIFICAT);
				lista_stud.add(s);
				line=br.readLine();
			}
			br.close();
		}	 
		catch (Exception ex) 
		{
			System.out.println("Eroare la functia PopuleazaStudenti()");
		}
		return lista_stud;
	}
	public static ArrayList<Profesor> PopuleazaProfesori ()
	{
		ArrayList <Profesor> lista_prof = new ArrayList<Profesor>();
		try
		{
			File f = new File( "profesori.csv" );
			BufferedReader br = new BufferedReader (new FileReader (f));
		    String line = br.readLine();
		
			while(line!=null)
			{
				String[] splituri = line.split(",");
				Profesor p = new Profesor(splituri[0], splituri[1].trim(), Gen.NESPECIFICAT);
				lista_prof.add(p);
				line=br.readLine();
			}	
			br.close();
		}	 
		catch (Exception ex) 
		{
			System.out.println("Eroare la functia PopuleazaProfesori()");
		}
		return lista_prof;
	}
	
	public static void ScrieListaCursuri()
	{
		try {		
			BufferedReader c = new BufferedReader(new FileReader("cursuri.csv"));
			BufferedReader p = new BufferedReader(new FileReader("profesori.csv"));
			BufferedWriter scriere= new BufferedWriter(new FileWriter("listacursuri.txt"));
			ArrayList<String> cFile = new ArrayList<String>();
			String line;
			while ((line = c.readLine())!=null) {
				cFile.add(line);
			}
			
			BufferedReader s = new BufferedReader(new FileReader("studenti.csv"));
			String st = "";
			String linest ="";
			while(linest!=null)
			{
				linest=s.readLine();
				if (linest!=null) 
					st = st + linest + "\n";
			}
			int i=0;
			while((line=p.readLine())!=null) 
			{
				String curs = cFile.get(i);
				scriere.write("CURSUL "  + "\n" + curs+ "\nProfesor: " +line+ "\nStudenti:" + st + "\n\n" );
				i++;
			}
		c.close();
		p.close();
		s.close();
		scriere.close();
		}
		catch (IOException e) {
			System.out.println("Eroare");
		}
			
	}
	
	public static void ScrieCursuriInFisier(ManagerCursuri curs)
	{
		File f = new File("cursuri.csv");
		try
		{
			BufferedWriter bw = new BufferedWriter (new FileWriter(f,true));
			try
			{
				for(int i=0; i<curs.cursuri.size(); i++ )
				{
					bw.write(curs.cursuri.get(i).nume+","+curs.cursuri.get(i).descriere);
					bw.write("\n");
				}
					
			}
			catch (IOException e) 
			{
				System.out.println("Eroare la scrierea in fisier in functia ScrieCursuriInFisier");
			}
			bw.close();
		}
		catch(Exception ex)
		{
			System.out.println("Eroare la scrierea in fisier in functia ScrieCursuriInFisier");
		}
		
	}
	public static void AddStudent(ArrayList<Student> stud) 
	{
		try
		{
			File f = new File("studenti.csv");
			BufferedWriter bw = new BufferedWriter (new FileWriter (f, true));
			try
			{
				stud.add(new Student( "Ionescu", "Dan", 3, Gen.MASCULIN));
	
		
				for (Student s : stud )
				{
					bw.write(s.nume+","+s.prenume+","+s.grupa+","+s.gen);
					bw.write("\n");
				}
				bw.flush();
				System.out.println("Lista studentilor a fost adaugata cu succes in fisier!");
			} 
			catch (IOException e) 
			{
				System.out.println("Eroare la scrierea in fisier in functia AddStudent");
			}
			finally
			{
			bw.close();
			}
		} 
		catch (Exception ex) 
		{
			System.out.println("Eroare la scrierea in fisier in functia AddStudent");
		}	
	}
	public static void AddProfesor(ArrayList<Profesor> prof) 
	{
		try
		{
			File f = new File("profesori.csv");
			BufferedWriter bw = new BufferedWriter (new FileWriter (f, true));
			try
			{	
				for (Profesor p : prof)
				{
					bw.write(p.nume+","+p.prenume+","+p.gen);
					bw.write("\n");
				}
				bw.flush();
				System.out.println("Lista profesorilor a fost adaugata cu succes in fisier!");
			} 
			catch (IOException e) 
			{
				System.out.println("Eroare la scrierea in fisier in functia AddProfesor");
			}
			finally
			{
			bw.close();
			}
		} 
		catch (Exception ex) 
		{
			System.out.println("Eroare la scrierea in fisier in functia AddProfesor");
		}	

	}

	
}

	
	



