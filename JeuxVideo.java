package projet;

import java.util.ArrayList;
import java.util.List;

public class JeuxVideo {

	private String nom;
	private String categorie;
	private String editeur;
	private Classement classement;
	private int nbJetons = 0;
	private Support support;
	private ArrayList<Evaluation> ensembleEvaluation;
	private ArrayList<Test> ensembleTest;
	
	//Constructeur
	public JeuxVideo(String nom) {
		this.nom = nom;
	}
	
	public JeuxVideo(String nom, String categorie, String editeur, Classement classement, Support support) {
		this.nom = nom;
		this.categorie = categorie;
		this.editeur = editeur;
		this.classement = classement;
		this.support = support;
		ensembleEvaluation = new ArrayList<Evaluation>();
		ensembleTest = new ArrayList<Test>();
	}
	
	//Guetteurs et Setteurs
	public String getNom() {
		return nom;
	}
	public String getCategorie() {
		return categorie;
	}
	public String getEditeur() {
		return editeur;
	}
	public Classement getClassement() {
		return classement;
	}
	public int getNbJetons() {
		return nbJetons;
	}
	public Support getEnsembleSupport() {
		return support;
	}
	public List<Evaluation> getEnsembleEvaluation(){
		return ensembleEvaluation;
	}
	public List<Test> getEnsembleTest(){
		return ensembleTest;
	}
	
	
	//Méthodes
	public void ajouteJeton(int nombre) {
		nbJetons += nombre;
		System.out.println("Le nombre de jetons pour ce jeu vidéo est : " + getNbJetons());
	}
	
	
	public void ajouteEvaluation(Evaluation evaluation) {
		ensembleEvaluation.add(evaluation);
	}
	public void supprimeEvaluation(int i) {
		ensembleEvaluation.remove(i);
	}
	
	public void ajouteTest(Test test) {
		ensembleTest.add(test);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
