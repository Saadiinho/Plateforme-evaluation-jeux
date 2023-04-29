package projet;
import java.util.Scanner;

public class Administrateur extends Testeur{

	//Constructeurs
	public Administrateur() {
		super("admin");
	}
	
	//Guetteurs et Setteurs
	
	//Méthodes
	public void supprimerEvaluation(JeuxVideo jeu) {
		System.out.println("Quel évaluation voulez-vous supprimez ? ");
		Scanner scanner = new Scanner(System.in);
		 int nombre = scanner.nextInt();
		 if ((nombre > jeu.getEnsembleEvaluation().size()) || (nombre < -1)) {
			 System.out.println("Cette évaluation n'hésite pas !");
		 }
		 jeu.supprimeEvaluation(nombre);
	     scanner.close();
	}
	public void proumouvoirJoueur(Joueur joueur) {
		Testeur testeur = new Testeur(joueur.getPseudo());
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
