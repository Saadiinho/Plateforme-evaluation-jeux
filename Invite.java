package projet;

import java.util.List;
import java.util.Scanner;

public class Invite {
	private GameBank listeJeu;

	//Constructeurs
	public Invite() {
		listeJeu = new GameBank();
		listeJeu.chargerListeJeu();
	}
	//Guetteurs et Setteurs
	
	//Méthodes
	
	public void consulterEvaluation() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Quel jeu voulez-vous rechercher ? ");
		String nomJeu = scanner.nextLine();
		if (listeJeu.presenceJeux(nomJeu)) {
			System.out.println("Voici les evaluations de " + nomJeu + " : ");
			JeuxVideo jeu = listeJeu.recupererJeu(nomJeu);
			List<Evaluation> evaluation = jeu.getEnsembleEvaluation();
			for (Evaluation eval : evaluation) {
				System.out.println(eval.getEvaluation());
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
