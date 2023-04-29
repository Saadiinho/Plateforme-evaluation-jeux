package projet;

public class Support {
	private String plateforme;
	private double anneeSorite;
	private double nbVente;
	private double nbCritique;
	private double scoreMoyenCritique;
	private double nbEvaluation;
	private double scoreMoyenEvaluation;
	
	//Constructeurs
	public Support(String plateforme, double anneeSorite, double nbVente) {
		this.plateforme = plateforme;
		this.anneeSorite = anneeSorite;
		this.nbVente = nbVente;
	}
	
	//Guetteurs
	public String getPlateforme() {
		return plateforme;
	}
	public double getAnneeSorite() {
		return anneeSorite;
	}
	public double getNbVente() {
		return nbVente;
	}
	public double getNbCritique() {
		return nbCritique;
	}
	public double getScoreMoyenCritique() {
		return scoreMoyenCritique;
	}
	public double getNbEvaluation() {
		return nbEvaluation;
	}
	public double getScoreMoyenEvaluation() {
		return scoreMoyenEvaluation;
	}
	
	//Méthodes

	public void setPlateforme(String plateforme) {
		this.plateforme = plateforme;
	}

	public void setAnneeSorite(double anneeSorite) {
		this.anneeSorite = anneeSorite;
	}

	public void setNbVente(double nbVente) {
		this.nbVente = nbVente;
	}

	public void setNbCritique(double nbCritique) {
		this.nbCritique = nbCritique;
	}

	public void setScoreMoyenCritique(double scoreMoyenCritique) {
		this.scoreMoyenCritique = scoreMoyenCritique;
	}

	public void setNbEvaluation(double nbEvaluation) {
		this.nbEvaluation = nbEvaluation;
	}

	public void setScoreMoyenEvaluation(double scoreMoyenEvaluation) {
		this.scoreMoyenEvaluation = scoreMoyenEvaluation;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
