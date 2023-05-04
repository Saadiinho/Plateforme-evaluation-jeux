package projet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JeuxVideo {

	private String nom;
	private String support;
	private String anneeSortie;
	private String categorie;
	private String editeur;
	private String naSales;
	private String euSales;
	private String jpSales;
	private String otherSales;
	private String globalSales;
	private String Critic_Score;
	private String Critic_Count;
	private String User_Score;
	private String userCount;
	private String developpeur;
	private String classement;
	private int nbJetons = 0;

	private ArrayList<Evaluation> ensembleEvaluation;
	private ArrayList<Test> ensembleTest;
	
	//Constructeur
	
	public JeuxVideo(String nom, String support, String anneeSortie, String categorie, String editeur, String naSales,
			String euSales, String jpSales, String otherSales, String globalSales, String critic_Score, String critic_Count,
			String user_Score, String userCount,String developpeur, String classment) {
		super();
		this.nom = nom;
		this.support = support;
		this.anneeSortie = anneeSortie;
		this.categorie = categorie;
		this.editeur = editeur;
		this.naSales = naSales;
		this.euSales = euSales;
		this.jpSales = jpSales;
		this.otherSales = otherSales;
		this.globalSales = globalSales;
		Critic_Score = critic_Score;
		Critic_Count = critic_Count;
		User_Score = user_Score;
		this.userCount = userCount;
		this.developpeur = developpeur;
		this.classement = classement;
		ensembleEvaluation = new ArrayList<Evaluation>();
		ensembleTest = new ArrayList<Test>();
	}



	//Guetteurs et Setteurs

	public String getNom() {
		return nom;
	}
	public String getSupport() {
		return support;
	}
	public String getAnneeSortie() {
		return anneeSortie;
	}
	public String getCategorie() {
		return categorie;
	}
	public String getEditeur() {
		return editeur;
	}
	public String getNaSales() {
		return naSales;
	}
	public String getEuSales() {
		return euSales;
	}
	public String getJpSales() {
		return jpSales;
	}
	public String getOtherSales() {
		return otherSales;
	}
	public String getGlobalSales() {
		return globalSales;
	}
	public String getCritic_Score() {
		return Critic_Score;
	}
	public String getCritic_Count() {
		return Critic_Count;
	}
	public String getUser_Score() {
		return User_Score;
	}
	public String getUserCount() {
		return userCount;
	}
	public String getDeveloppeur() {
		return developpeur;
	}
	public String getClassement() {
		return classement;
	}
	public int getNbJetons() {
		return nbJetons;
	}
	public ArrayList<Evaluation> getEnsembleEvaluation() {
		return ensembleEvaluation;
	}
	public ArrayList<Test> getEnsembleTest() {
		return ensembleTest;
	}
	
	
	//Méthodes
	public void ajouteJeton(int nombre) {
		//Permet d'ajouter un nombre choisi de jetons dans le jeu.
		nbJetons += nombre;
		System.out.println("Le nombre de jetons pour ce jeu video est : " + getNbJetons());
	}
	public void libereJetons() {
		//Permet d'enlever tous les jetons du jeu.
		nbJetons = 0;
	}
	public void ajouteEvaluation(Evaluation evaluation) {
		//Permet d'ajouter une evaluation
		ensembleEvaluation.add(evaluation);
	}
	public void supprimeEvaluation(int i) {
		//Permet de supprimer une évaluation
		ensembleEvaluation.remove(i);
	}
	
	public void ajouteTest(Test test) {
		ensembleTest.add(test);
	}
	public void supprimeTest(int i) {
		ensembleTest.remove(i);
	}
	public void consulteEvaluation() {
		for (Evaluation e : this.getEnsembleEvaluation()) {
			System.out.println(e.toString());
		}
	}
	
	
	
	@Override
	public String toString() {
		return "Nom= " + nom + ", Plateforme= " + support + ", Annee_de_sortie= " + anneeSortie + ", Categorie= "
				+ categorie + ", Editeur= " + editeur + "\nNa_Sales= " + naSales + ", Eu_Sales= " + euSales + ", Jp_Sales= "
				+ jpSales + ", Other_Sales= " + otherSales + ", Global_Sales= " + globalSales + "\nCritic_Score= "
				+ Critic_Score + ", Critic_Count= " + Critic_Count + ", User_Score= " + User_Score + ", User_Count= "
				+ userCount + "\nDeveloppeur= " + developpeur + ", Classement= " + classement + ", nombre de jetons = " + nbJetons;
	}




}
