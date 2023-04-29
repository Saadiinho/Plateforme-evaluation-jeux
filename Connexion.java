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
	
	public static void connexion() {
	    GameBank listeJeu = new GameBank();
	    listeJeu.chargerListeJeu();
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
	            System.out.println(joueurConnecte.toString());
	            joueurConnecte.seConnecter();
	            int choix = -1;
	            while (choix != 0) {
	                System.out.println("1 - Placer des jetons sur un jeu");
	                System.out.println("2 - Ecrire une evaluation sur jeu");
	                System.out.println("3 - Consulter le test d'un jeu");
	                System.out.println("0 - Quitter");
	                System.out.print("Entrez votre choix: ");
	                String input = scanner.nextLine();
	                choix = Integer.parseInt(input);
	                switch (choix) {
	                    case 1:
	                        joueurConnecte.placerJeton();
	                        break;
	                    case 2:
	                        joueurConnecte.ecrireEvaluation();
	                        break;
	                    case 3:
	                        joueurConnecte.consulterTest();
	                        break;
	                    case 0:
	                        System.out.println("A bientôt !");
	                        joueurConnecte.seDeconnecter();
	                        break;
	                    default:
	                        System.out.println("Choix invalide, veuillez réessayer.");
	                        break;
	                }
	            }
	        } else {
	            if (pseudo == "") {
	                //Mode Invite
	                Invite invite = new Invite();
	                invite.consulterEvaluation();
	            } else {
	                System.out.println("Vous n'avez pas de compte.");
	                System.out.println("Voulez-vous en créer un ? (y/n)");
	                String reponse = scanner.nextLine();
	                if (reponse.equals("y")) {
	                    //Créer un compte
	                    //Un joueur est construit
	                    //Son pseudo est ajouté à la liste de joueurs inscrits
	                } else {
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
		listeJeu.chargerListeJeu();
		j1.ajouteJeux("Tetris.");
		j1.ajouteJeux("Pokemon Red/Pokemon Blue.");
		j1.setNbEvaluation(3);
		Connexion test = new Connexion();
		test.ajouteNouveauJoueur(j1);
		connexion();
	}
    
}
