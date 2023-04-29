package projet;

public class Test {
	private double date;
	private String test;
	private double numVersion;
	private int noteCategorieTestee;
	private int noteGenre;
	
	//Constructeur
	public Test(double date, String test, double numVersion, int noteCategorieTestee, int noteGenre) {
		this.date = date;
		this.test = test;
		this.numVersion = numVersion;
		this.noteCategorieTestee = noteCategorieTestee;
		this.noteGenre = noteGenre;
	}
	
	//Guetteurs et Setteurs
	public double getDate() {
		return date;
	}
	public String getTest() {
		return test;
	}
	public double getNumVersion() {
		return numVersion;
	}
	public int getNoteCategorieTestee() {
		return noteCategorieTestee;
	}
	public int getNoteGenre() {
		return noteGenre;
	}
	
	//Méthodes 
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
