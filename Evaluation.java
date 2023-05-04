package projet;

public class Evaluation {
	private String pseudo;
	private double date;
	private String evaluation;
	private float numVersion;
	private int nbPouceBleu = 0;
	private int nbPouceRouge = 0;
	private boolean signale = false;
	
	//Constructeurs
	public Evaluation(double date, String evaluation, float numVersion, String pseudo) {
		this.date = date;
		this.evaluation = evaluation;
		this.numVersion = numVersion;
		this.pseudo = pseudo;
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
	public float getNumVersion() {
		return numVersion;
	}
	public String getPseudo() {
		return pseudo;
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
	@Override
	public String toString() {
		return "Evaluation de " + pseudo + " : [date = " + date + ", evaluation = " + evaluation + ", numVersion = " + numVersion
				+ ", nbPouceBleu = " + nbPouceBleu + ", nbPouceRouge = " + nbPouceRouge + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
