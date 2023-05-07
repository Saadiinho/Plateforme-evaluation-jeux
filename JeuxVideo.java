package projet;
import java.util.Scanner;

public class Administrateur extends Testeur{

	//Constructeurs
	public Administrateur() {
		super("admin");
	}
	
	//Guetteurs et Setteurs
	
	//Méthodes
	public void supprimerEvaluation(GameBank listeJeu) {
		this.consulterEvaluation(listeJeu);
		JeuxVideo jeu = this.rechercherJeu(listeJeu);
		System.out.println("Quel évaluation voulez-vous supprimez ? ");
		Scanner scanner = new Scanner(System.in);
		 int nombre = scanner.nextInt();
		 if ((nombre > jeu.getEnsembleEvaluation().size()) || (nombre < -1)) {
			 System.out.println("Cette évaluation n'hésite pas !");
		 }
		 jeu.supprimeEvaluation(nombre);
	     scanner.close();
	}
	public void promouvoirJoueur(Joueur joueur) {
		Testeur testeur = (Testeur) joueur;
		System.out.println("Joueur promu avec succes !");
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
