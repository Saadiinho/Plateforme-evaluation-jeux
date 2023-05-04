package projet;
import java.util.*;

public class Connexion {
    
	private static ArrayList<Joueur> listeJoueurs;
	
	//Constructeurs
	public Connexion() {
		listeJoueurs = new ArrayList<Joueur>();
	}
	
	//Méthodes
	public void ajouteNouveauJoueur(Joueur joueur) {
		listeJoueurs.add(joueur);
	}
	public static void seConnecterJoueur(GameBank listeJeu, Joueur joueurConnecte) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(joueurConnecte.toString());
        joueurConnecte.seConnecter();
        while (true) {
        	System.out.println("\n1 - Placer des jetons sur un jeu");
        	System.out.println("2 - Ecrire une evaluation sur jeu");
        	System.out.println("3 - Consulter le test d'un jeu");
        	System.out.println("4 - Consulter l'evaluation d'un jeu");
        	System.out.println("5 - Ajouter un jeu a votre liste de jeu");
        	System.out.println("0 - Quitter");
        	System.out.print("Entrez votre choix: ");
        	String input = scanner.nextLine();
        	int choix = Integer.parseInt(input);
        	while ((choix < 0) || (choix > 5) ) {
        		System.out.println("Erreur de saisie, veuillez réessayer : ");
        		input = scanner.nextLine();
        		choix = Integer.parseInt(input);
        	}
        	if (choix == 0) {
        		joueurConnecte.seDeconnecter();
        		System.out.println("Merci de votre visite, a bientot !");
        		return;
        	}
        	else if (choix == 1) {
        	    //Méthode de placement de jetons
        		joueurConnecte.placerJeton(listeJeu);
        	}
        	else if (choix == 2) {
        		//Méthode d'écriture d'évaluation
        		joueurConnecte.ecrireEvaluation();
        	}
        	else if (choix == 3){
        		//Méthode de consultation de test
        		joueurConnecte.consulterTest(listeJeu);
        	}
        	else if (choix == 4){
        		//Méthode de consultation d'évaluation
        		joueurConnecte.consulterEvaluation(listeJeu);
        	}
        	else {
        		//Méthode d'ajout de jeu
        		System.out.println("Quel est votre nouveau jeu ?");
        		String nouveauJeu = scanner.nextLine();
        		if (listeJeu.recupererJeu(nouveauJeu) != null) {
        			joueurConnecte.ajouteJeux(nouveauJeu, listeJeu);
        		}
        		else {
        			System.out.println("Le jeu specifie n'existe pas.");
        		}
        	}
    	}
	}
	public static void connexion() {
	    GameBank listeJeu = new GameBank();
	    Scanner scanner = new Scanner(System.in);
	    try {
	        System.out.print("Pseudo : ");
	        String pseudo = scanner.nextLine();
	        Joueur joueurConnecte = null;
	        for (Joueur j : listeJoueurs) {
	            if (j.getPseudo().equals(pseudo)) {
	                joueurConnecte = j;
	                break;
	            }
	        }
	        if (joueurConnecte != null) {
	            seConnecterJoueur(listeJeu, joueurConnecte);
	        } 
	        else {
	           if (pseudo == "") {
	               //Mode Invite
	               //Méthode de consultation d'évaluation
	        	   Invite invite = new Invite();
	        	   invite.consulterEvaluation(listeJeu);
	           } 
	           else {
	               System.out.println("Vous n'avez pas de compte.");
	               System.out.println("Voulez-vous en créer un ? (y/n)");
	               String reponse = scanner.nextLine();
	               if (reponse.equals("y")) {
	                   //Créer un compte
	                   //Un joueur est construit
	                   //Son pseudo est ajouté à la liste de joueurs inscrits
	               } 
	               else {
	                   System.out.println("Merci au revoir !");
	               }
	           }
	        }
	    } catch (NoSuchElementException e) {
	        System.out.println("Erreur : Entrée invalide.");
	    } finally {
	        scanner.close();
	    }

	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Joueur j1 = new Joueur("test");
		GameBank listeJeu = new GameBank();
		j1.setNbEvaluation(3);
		j1.ajouteJeux("Tetris", listeJeu);
		Connexion test = new Connexion();
		test.ajouteNouveauJoueur(j1);
		connexion();
	}
    
}
