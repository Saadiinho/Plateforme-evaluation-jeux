package projet;

import java.util.List;
import java.util.Scanner;

public class Invite {
	
	//Constructeurs
	public Invite() {
		
	}
	//Guetteurs et Setteurs
	
	//Méthodes
	
	public JeuxVideo rechercherJeu(GameBank listeJeu) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Quel jeu voulez-vous rechercher ?");
		String nomJeu = scanner.nextLine();
		if (listeJeu.recupererJeu(nomJeu) != null) {
			return listeJeu.recupererJeu(nomJeu);
		}
		else {
			System.out.println("Le jeu specifie n'existe pas.");
			return null;
		}
	}
	public void consulterEvaluation(GameBank listeJeu) {
		JeuxVideo jeu = rechercherJeu(listeJeu);
		if (jeu != null) {
			jeu.consulteEvaluation();
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
