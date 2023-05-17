package projet;
import java.util.ArrayList;
import java.util.Scanner;

public class Administrateur extends Testeur{
	private Connexion connexion;

	//Constructeurs
	public Administrateur() {
		super("admin");
		connexion = new Connexion();
	}
	
	//Guetteurs et Setteurs
	
	//Méthodes
	@SuppressWarnings("resource")
	public void supprimerEvaluation(GameBank listeJeu) {
		this.consulterEvaluation(listeJeu);
		JeuxVideo jeu = this.rechercherJeu(listeJeu);
		if (jeu == null) {
			return;
		}
		System.out.println("Quel évaluation voulez-vous supprimez ? ");
		Scanner scanner = new Scanner(System.in);
		 int nombre = scanner.nextInt();
		 if ((nombre > jeu.getEnsembleEvaluation().size()) || (nombre < -1)) {
			 System.out.println("Cette évaluation n'existe pas !");
			 return;
		 }
		 jeu.supprimeEvaluation(nombre - 1);
	     scanner.close();
	}/*
	public void promouvoirJoueur(Joueur joueur) {
		Testeur testeur = (Testeur) joueur;
		System.out.println("Joueur promu avec succes !");
	}*/
	public void promouvoirJoueur(Joueur joueur) {
		if (joueur instanceof Testeur) {
		    // Le joueur est déjà un testeur, pas besoin de conversion
		    Testeur testeur = (Testeur) joueur;
		} else {
		    // Le joueur n'est pas un testeur, vous devez effectuer la conversion
		    Testeur testeur = new Testeur(joueur.getPseudo()); // Créez un nouvel objet Testeur avec le même pseudo que le joueur
		    testeur.setNbJetons(joueur.getnbJetons());
		    testeur.setJeuxPossedee(joueur.getjeuxPossedee());
		    testeur.setNbEvaluation(joueur.getNbEvaluation());
		    // Utilisez ensuite l'objet Testeur converti pour effectuer les actions spécifiques au testeur
		}

	}
	
	public void promouvoirTesteur(Testeur testeur) {
		Administrateur adminnistrateur = (Administrateur) testeur;
		testeur.setPseudoAdmin();
		System.out.println("Testeur promu avec succes !");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
