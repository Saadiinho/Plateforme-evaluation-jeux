package projet;

public class Test {
	private String pseudo;
	private int date;
	private String test;
	private float numVersion;
	private String categorieTestee;
	private int noteCategorieTestee;
	private String genreTestee;
	private int noteGenre;
	
	//Constructeur
	public Test(int date, String test, float numVersion, String categorieTestee, int noteCategorieTestee, String genreTestee, int noteGenre) {
		this.date = date;
		this.test = test;
		this.numVersion = numVersion;
		this.categorieTestee = categorieTestee;
		this.noteCategorieTestee = noteCategorieTestee;
		this.noteGenre = noteGenre;
		this.genreTestee = genreTestee;
	}
	
	//Guetteurs et Setteurs
	public int getDate() {
		return date;
	}
	public String getTest() {
		return test;
	}
	public float getNumVersion() {
		return numVersion;
	}
	public int getNoteCategorieTestee() {
		return noteCategorieTestee;
	}
	public int getNoteGenre() {
		return noteGenre;
	}
	
	//Méthodes 
	@Override
	public String toString() {
		return "Test effectue par " + pseudo + " : [date = " + date + "\ntest = " + test + "\nnumVersion = " + numVersion + "\ncategorieTestee = "
				+ categorieTestee + "\nnoteCategorieTestee = " + noteCategorieTestee + "\ngenreTestee = " + genreTestee
				+ "\nnoteGenre = " + noteGenre + "]";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
