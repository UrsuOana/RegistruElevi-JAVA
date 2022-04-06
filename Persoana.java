
public class Persoana {
	
	String nume;
	String prenume;
	Gen gen;
	
	@Override
	public String toString () {
	return "Persoana {" + "nume =" + nume + ", prenume =" + prenume + ", gen = " + gen + " }";
	}
	
	public String getNume() {	return nume;	}
	public void setNume(String nume) {	this.nume = nume;	}
		
	public String getPrenume() {	return prenume;		}
	public void setPrenume(String prenume) {	this.prenume = prenume;		}
	
	public Gen getGen() {	return gen;		}
	public void setGen(Gen gen) {	this.gen = gen;		}
}
