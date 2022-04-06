import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class ManagerCursuri implements OperatiiManagerCursuri {
	
	ArrayList <Curs> cursuri; 

	public ManagerCursuri()
	{
		cursuri = new ArrayList<Curs>();
	}
	
//SORTARE CURSURI	
	public void sortareCursuri() 
	{
		System.out.println("Raportul cursurilor dupa sortare:");
		Collections.sort(this.cursuri, new ComparareCursuri());
		int i=1;
		for (Curs c : cursuri) 
		{
			System.out.println(i+". " + c.nume);
			i=i+1;
		}
		System.out.println();		
	}
		
	
//PROCENT STUDENTI INTEGRALISTI
	public void procentajIntegralistiDupaGen(Gen gen)
	{
		double iterator = 0;
		double nrStudGen = 0;
		double procentaj = 0;
		
		for (Curs c : cursuri)
		{
			for (int i=0; i<c.studenti.size() ; i++)
			{ 
				if (c.studenti.get(i).gen == gen)
				{
					nrStudGen ++;
					if (c.note[i].nota < 4.5)
						iterator++;
				}
			}
		}
		nrStudGen = nrStudGen/cursuri.size();
	
		procentaj = ((nrStudGen-iterator)/nrStudGen)*100; 	
		System.out.println(procentaj +"% dintre studentii de genul  " + gen + "  sunt integralisti.");	
	}
	
	
//OPERATII CURS
//ADD CURSURI

	public void AddCurs(Curs curs)
	{
		cursuri.add(curs);
	}

//DELETE CURSURI
	public void DeleteCurs (Curs curs)
	{
		cursuri.remove(curs);
	}

//UPDATE CURSURI
	public void UpdateCurs(Curs curs) 
	{
	    System.out.print("\nIntroduceti de la tastatura modificarile pentru CURSUL ");
	    if (curs.nume == "")
	    	{System.out.println("creat cu ajutorul constructorului default.");}
	    else
	    	{System.out.println(curs.nume);}
		
		try
		{
			Scanner in = new Scanner(System.in);
			System.out.print("Noul nume: ");
			String nume_nou = in.nextLine();
			curs.nume = nume_nou;
			
			System.out.print("Noua descriere: ");
			String descriere_noua = in.nextLine();
			curs.descriere = descriere_noua;
			System.out.println("Numele si descrierea cursului au fost modificate cu succes.\n");
			in.close();
		}
		catch(Exception e)
		{
			System.out.println("A aparut o eroare. Va rugam sa verificati ca ati introdus corect numele si descrierea cursului.");
		}
	}

//RAPORTARE CURSURI
	public void RaportCursuri() 
	{
		System.out.println("\nRaportul cursurilor:");
		int i=1;
		for (Curs c : cursuri) 
		{
			System.out.println(i+". " + c.nume);
			i=i+1;
		}
		System.out.println();
	}

//AFISARE CURSURI 
	public void AfiseazaCursuriLaConsola()
	{
		System.out.println("\n	~AFISARE CURSURI LA CONSOLA~ \n");
		for(Curs c : cursuri)
			System.out.println(c + "\n");
	}

	
}
