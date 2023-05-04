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
	
	//Méthodes
	public void ecrireTest(GameBank listeJeu) {
		Scanner scanner = new Scanner(System.in);
		String nomJeu = scanner.nextLine();
		JeuxVideo jeu = listeJeu.recupererJeu(nomJeu);
		if (jeu == null) {
			System.out.println("Le jeu specifie n'existe pas.");
			return;
		}
		System.out.println("Entrez votre test : ");
		String test = scanner.nextLine();
		if (test.trim().isEmpty()) {
			System.out.println("Le test ne peut pas etre vide.");
			return;
		}
		System.out.println("Entrez la date de realisation du test : (AAAAMMJJ");
		int date;
		if (!scanner.hasNextInt()) {
			System.out.println("La date doit etre un nombre");
			return;
		}
		date = scanner.nextInt();
		System.out.println("Entrez le numero de version du test : ");
		float numVersion;
		if (!scanner.hasNextFloat()) {
			System.out.println("Le numero de version doit etre un nombre.");
			return;
		}
		numVersion = scanner.nextFloat();
		System.out.println("Entrez la categorie testee : ");
		String categorieTestee = scanner.nextLine();
		if (categorieTestee.trim().isEmpty()) {
			System.out.println("La categorie teste ne peut pas etre vide.");
			return;
		}
		System.out.println("Entrez la note du test de la categorie : ");
		int noteCategorie;
		if (!scanner.hasNextInt()) {
			System.out.println("La note doit etre un nombre.");
		}
		noteCategorie = scanner.nextInt();
		String genreTestee = scanner.nextLine();
		if (genreTestee.trim().isEmpty()) {
			System.out.println("Le genre testee ne peut pas etre vide.");
			return;
		}
		int noteGenre;
		if (!scanner.hasNextInt()) {
			System.out.println("La note doit etre un nombre.");
			return;
		}
		noteGenre = scanner.nextInt();
		Test testJeu = new Test(date, test, numVersion,categorieTestee, noteCategorie, genreTestee, noteGenre);
		nbTest++;
		jeu.ajouteTest(testJeu);
		jeu.libereJetons();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
