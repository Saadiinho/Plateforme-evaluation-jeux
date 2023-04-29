package projet;

public class Evaluation {
	private double date;
	private String evaluation;
	private double numVersion;
	private int nbPouceBleu = 0;
	private int nbPouceRouge = 0;
	private boolean signale = false;
	
	//Constructeurs
	public Evaluation(double date, String evaluation, double numVersion) {
		this.date = date;
		this.evaluation = evaluation;
		this.numVersion = numVersion;
		this.nbPouceBleu = nbPouceBleu;
		this.nbPouceRouge = nbPouceRouge;
	}
	
	//Guetteurs et Setteurs
	public String getEvaluation() {
		return evaluation;
	}
	public int getnbPouceBleu() {
		return nbPouceBleu;
	}
	public int getnbPouceRouge() {
		return nbPouceRouge;
	}
	public boolean getSignale() {
		return signale;
	}
	public double getNumVersion() {
		return numVersion;
	}

	public double getDate() {
		return date;
	}

	public void setSignale(boolean signalement) {
		signale = signalement;
	}
	
	//Méthodes
	public void ajoutePouceBleu() {
		nbPouceBleu += 1;
		System.out.println("Le nombre de 'J'aime' pour cette évaluation est : " + getnbPouceBleu());
	}
	public void ajoutePouceRouge() {
		nbPouceRouge += 1;
		System.out.println("Le nombre de 'Je n'aime pas' pour cette évaluation est : " + getnbPouceRouge());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
