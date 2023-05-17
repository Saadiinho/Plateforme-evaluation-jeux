package projet;
import java.util.*;

public class Connexion {
    
	private static ArrayList<Joueur> listeJoueurs;
	private static ArrayList<Testeur> listeTesteur;
	private static ArrayList<Administrateur> listeAdmin;
	
	//Constructeurs
	public Connexion() {
		listeJoueurs = new ArrayList<Joueur>();
		listeTesteur = new ArrayList<Testeur>();
		listeAdmin = new ArrayList<Administrateur>();
	}
	//Guetteur et Setteur
	public static ArrayList<Joueur> getListeJoueurs() {
		return listeJoueurs;
	}
	public static ArrayList<Testeur> getListeTesteur() {
		return listeTesteur;
	}
	public static ArrayList<Administrateur> getListeAdmin() {
		return listeAdmin;
	}
	
	//Méthodes
	public void ajouteNouveauJoueur(Joueur joueur) {
		listeJoueurs.add(joueur);
	}
	public static void afficherlisteJoueur() {
		int i = 1;
		if (listeJoueurs.size() > 0) {
			for (Joueur j : listeJoueurs) {
				System.out.println(i + " " + j.toString());
				i++;
			}
		}
		else {
			System.out.println("Il n'y a pas encore de joueurs inscrits.");
		}
	}
	public static void ajouteNouveauTesteur(Testeur test) {
		listeTesteur.add(test);
	}
	public static void afficherListeTesteur() {
		int i = 1;
		if (listeTesteur.size() > 0) {
			for (Testeur t : listeTesteur) {
				System.out.println(i + " " + t.toString());
				System.out.println("Nombre de test : " + t.getNbTest());
				i++;
			}
		}
		else {
			System.out.println("Il n'y a pas encore de testeurs inscrits.");
		}
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
        	System.out.println("5 - Donner votre avis dans une evaluation");
        	System.out.println("6 - Ajouter un jeu a votre liste de jeu");
        	System.out.println("7 - Consulter la liste de jeu");
        	System.out.println("8 - Voir les informations du profil");
        	System.out.println("0 - Quitter");
        	System.out.print("Entrez votre choix: ");
        	String input = scanner.nextLine();
        	int choix = Integer.parseInt(input);
        	while ((choix < 0) || (choix > 8) ) {
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
        	else if (choix == 5) {
        		joueurConnecte.avisEvaluation(listeJeu);
        	}
        	else if (choix == 6){
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
        	else if (choix == 7) {
        		listeJeu.consulterListeJeu();
        	}
        	else {
        		System.out.println(joueurConnecte.toString());
        	}
    	}
	}
	public static void seConnecterTesteur(GameBank listeJeu, Testeur joueur) {
	    Scanner scanner = new Scanner(System.in);
	    joueur.seConnecter();
	    joueur.toString();
	    while (true) {
	        System.out.println("1 - Passage en mode joueur");
	        System.out.println("2 - Passage en mode testeur");
	        System.out.println("0 - Quitter");
	        System.out.println("Entrez votre choix : ");
	        int choix = scanner.nextInt();
	        while (choix < 0 || choix > 2) {
	            System.out.println("Erreur de saisie, veuillez réessayer.");
	            choix = scanner.nextInt();
	        }
	        if (choix == 0) {
	            return;
	        } else if (choix == 1) {
	            seConnecterJoueur(listeJeu, joueur);
	        } else {
	            // Mode testeur
	            while (true) {
	                System.out.println("1 - Ecrire un test");
	                System.out.println("2 - Signaler une évaluation problématique");
	                System.out.println("0 - Quitter");
	                System.out.println("Entrez votre choix : ");
	                int choixS = scanner.nextInt();
	                while (choixS < 0 || choixS > 2) {
	                    System.out.println("Erreur de saisie, veuillez réessayer.");
	                    choixS = scanner.nextInt();
	                }
	                if (choixS == 0) {
	                    break; // Ajout de l'instruction break ici
	                } else if (choixS == 1) {
	                    joueur.ecrireTest(listeJeu);
	                } else {
	                    joueur.evaluationProblematique(listeJeu);
	                }
	            }
	        }
	    }
	}

	public static void seConnecterAdmin(GameBank listeJeu, Administrateur admin) {
		Scanner scanner = new Scanner(System.in);
		admin.seConnecter();
		admin.toString();
		while (true) {
			System.out.println("1 - Passage en mode testeur");
			System.out.println("2 - Passage en mode administrateur");
			System.out.println("0 - Se deconnecter");
			System.out.println("Entrez votre choix : ");
			int choix = scanner.nextInt();
			while (choix < 0 || choix > 2) {
				System.out.println("Erreur de saise, veuillez reessayer.");
				choix = scanner.nextInt();
			}
			while (choix != 0) {
				if (choix == 1) {
					seConnecterTesteur(listeJeu, admin);
					break;
				}
				else {
					//Mode Administrateur
					System.out.println("1 - Promouvoir un testeur");
					System.out.println("2 - Promouvoir un joueur");
					System.out.println("3 - Supprimer une evaluation");
					System.out.println("0 - Quitter");
					System.out.println("Entrez votre choix");
					int choixS = scanner.nextInt();
					while (choixS < 0 || choixS > 3) {
						System.out.println("erreur de saisie, veuillez reessayer.");
						choixS = scanner.nextInt();
					}
					if (choixS == 0) {
						break;
					}
					else if (choixS == 2) {
						System.out.println("Quel joueur voulez-vous promouvoir ?");
						afficherlisteJoueur();
						if (listeJoueurs.size() == 0) {
							System.out.println("Il n'y a pas de joueur a promouvoir");
							break;
						}
						System.out.println("Quel joueur voulez vous pomouvoir ? (donnez un numero)");
						int numero = scanner.nextInt();
						while (numero <= 0 || numero > listeJoueurs.size()) {
							System.out.println("Erreur de saisie, veuillez reessayer.");
							numero = scanner.nextInt();
						}
						admin.promouvoirJoueur(listeJoueurs.get(numero - 1));
					}
					else if (choixS == 1) {
						System.out.println("Quel testeur voulez-vous promouvoir ?");
						afficherListeTesteur();
						if (listeTesteur.size() == 0) {
							System.out.println("Il n'y a pas de testeurs a promouvoir");
							break;
						}
						System.out.println("Quel testeur voulez vous pomouvoir ? (donnez un numero)");
						int numero = scanner.nextInt();
						while (numero <= 0 || numero > listeTesteur.size()) {
							System.out.println("Erreur de saisie, veuillez reessayer.");
							numero = scanner.nextInt();
						}
						admin.promouvoirTesteur(listeTesteur.get(numero - 1));
					}
					else {
						admin.supprimerEvaluation(listeJeu);
					}
				}
			}
			if (choix == 0) {
				System.out.println("Merci de votre visite.");
				return;
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
	        	if (!joueurConnecte.getPseudo().equals("admin")) {
	        		if (joueurConnecte instanceof Testeur) {
	        			seConnecterTesteur(listeJeu, (Testeur) joueurConnecte);
	        		}
	        	}
	        	else {
	        		Administrateur admin = new Administrateur();
	        		seConnecterAdmin(listeJeu, admin);
	        	}
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
	            	   Joueur j = new Joueur(pseudo);
	            	   listeJoueurs.add(j);
	            	   System.out.println("Compte cree avec succes !");
	            	   connexion();
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
		Administrateur j2 = new Administrateur();
		Testeur j3 = new Testeur("Saad");
		GameBank listeJeu = new GameBank();
		j1.setNbEvaluation(3);
		Connexion test = new Connexion();
		test.ajouteNouveauJoueur(j1);
		test.ajouteNouveauTesteur(j2);
		test.ajouteNouveauJoueur(j3);
		connexion();
	}
    
}
