
public class Profesor extends Persoana{

//SUPRAINCARCAREA CONSTRUCTORULUI
	public Profesor ()
	{
		this.nume = "";
    	this.prenume = "";
    	this.gen = Gen.NESPECIFICAT;
	}
	
	public Profesor(String nume, String prenume, Gen gen)
	{
		this.nume = nume;
		this.prenume = prenume;
		this.gen = gen;
	}
	
	@Override
	public String toString() 
	{
		return "NUME = " + nume + ", PRENUME = " + prenume + ", GEN = " + gen +"\n";
	}

}
