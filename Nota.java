
public class Nota {
	
	double nota;

//SUPRAINCARCAREA CONSTRUCTORULUI
	public Nota()
	{
		this.nota = 0;
	}
	
	public Nota(double nota)
	{
		this.nota = nota;
	}

	@Override
	public String toString() 
	{
		return "Nota: {" + nota +"}";
	}
}
