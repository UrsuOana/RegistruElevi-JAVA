
public interface OperatiiCurs {

	public void UpdateProfesor (Profesor p);
	public void AddStudent (Student student);
	public void RemoveStudent (Student student);
	public void UpdateStudent (Student student);
	public void UpdateCurs (String nume, String descriere);
	public void cheieUnica ();
	public void sortareStudenti();
	public void RaportStudenti();
	public void RaportMedie();
	public void RaportNote();
	public void AddNota(Nota nota);
	public void medieNoteStudentiGen(Gen gen);
	
}
