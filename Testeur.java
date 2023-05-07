package projet;

import java.util.Scanner;
import java.util.Date;

public class Testeur extends Joueur{
	
	private int nbTest = 0;
	
	public Testeur(String pseudo) {
		super(pseudo);
		// TODO Auto-generated constructor stub
	}

	//Constructeurs

	
	//Guetteurs et Setteurs
	public int getNbTest() {
		return nbTest;
	}
	//Méthodes
	
	public void ecrireTest(GameBank listeJeu) {
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Quel jeu voulez-vous tester ?");
	    String nomJeu = scanner.nextLine();
	    JeuxVideo jeu = listeJeu.recupererJeu(nomJeu);
	    if (jeu == null) {
	        System.out.println("Le jeu spécifié n'existe pas.");
	        return;
	    }
	    System.out.println("Entrez votre test : ");
	    String test = scanner.nextLine();
	    if (test.trim().isEmpty()) {
	        System.out.println("Le test ne peut pas être vide.");
	        return;
	    }
	    System.out.println("Entrez la date de réalisation du test (AAAAMMJJ) : ");
	    String dateStr = scanner.nextLine();
	    int date;
	    try {
	        date = Integer.parseInt(dateStr);
	    } catch (NumberFormatException e) {
	        System.out.println("La date doit être un nombre.");
	        return;
	    }
	    System.out.println("Entrez le numéro de version du test : ");
	    float numVersion;
	    if (!scanner.hasNextFloat()) {
	        System.out.println("Le numéro de version doit être un nombre.");
	        return;
	    }
	    numVersion = scanner.nextFloat();
	    scanner.nextLine(); // Lire la fin de la ligne après avoir lu le float
	    
	    System.out.println("Entrez la catégorie testée : ");
	    String categorieTestee = scanner.nextLine();
	    if (categorieTestee.trim().isEmpty()) {
	        System.out.println("La catégorie testée ne peut pas être vide.");
	        return;
	    }
	    System.out.println("Entrez la note de la catégorie : ");
	    int noteCategorie;
	    if (!scanner.hasNextInt()) {
	        System.out.println("La note doit être un nombre.");
	        return;
	    }
	    noteCategorie = scanner.nextInt();
	    scanner.nextLine(); // Lire la fin de la ligne après avoir lu l'entier
	    
	    System.out.println("Entrez le genre testé : ");
	    String genreTeste = scanner.nextLine();
	    if (genreTeste.trim().isEmpty()) {
	        System.out.println("Le genre testé ne peut pas être vide.");
	        return;
	    }
	    System.out.println("Entrez la note du genre : ");
	    int noteGenre;
	    if (!scanner.hasNextInt()) {
	        System.out.println("La note doit être un nombre.");
	        return;
	    }
	    noteGenre = scanner.nextInt();
	    scanner.nextLine(); // Lire la fin de la ligne après avoir lu l'entier
	    
	    Test testJeu = new Test(date, test, numVersion, categorieTestee, noteCategorie, genreTeste, noteGenre);
	    nbTest++;
	    this.setNbJetons(this.getnbJetons() + 5);
	    jeu.ajouteTest(testJeu);
	    jeu.libereJetons();
	    System.out.println("Test ajoute avec succes !");
	}
	
	public void evaluationProblematique(GameBank listeJeu) {
		this.consulterEvaluation(listeJeu);
		JeuxVideo jeu = this.rechercherJeu(listeJeu);
		System.out.println("Quel évaluation voulez-vous signale ? ");
		Scanner scanner = new Scanner(System.in);
		 int nombre = scanner.nextInt();
		 if ((nombre > jeu.getEnsembleEvaluation().size()) || (nombre < 1)) {
			 System.out.println("Cette évaluation n'hésite pas !");
		 }
		 jeu.getEnsembleEvaluation().get(nombre - 1).ajoutSignalement();
		 System.out.println("Evaluation signale avec succes !");
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
