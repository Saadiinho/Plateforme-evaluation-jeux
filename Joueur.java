package projet;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Joueur extends Invite{

	private String pseudo;
	private int nbJetons = 3;
	private static ArrayList<JeuxVideo> jeuxPossedee;
	private int nbEvaluation;
	private boolean connectee;
	
	
	//Constructeurs
	public Joueur(String pseudo) {
		this.pseudo = pseudo;
		jeuxPossedee = new ArrayList<JeuxVideo>();
	}
	

	//Guetteurs et Setteurs
	public String getPseudo() {
		return pseudo;
	}
	public int getnbJetons() {
		return nbJetons;
	}
	public ArrayList<JeuxVideo> getjeuxPossedee(){
		return jeuxPossedee;
	}
	public void setJeuxPossedee(ArrayList<JeuxVideo> jeuxPossedee) {
		this.jeuxPossedee = jeuxPossedee;
	}
	public void setNbEvaluation(int nbEvaluation) {
		this.nbEvaluation = nbEvaluation;
	}
	public static String arrayListToString() {
	    String resultat = "";
	    for (JeuxVideo element : jeuxPossedee) {
	        resultat += element.getNom() + " ";
	    }
	    return resultat.trim();
	}
	public boolean getConnectee() {
		return connectee;
	}
	public void seConnecter() {
		connectee = true;
	}
	public void seDeconnecter() {
		connectee = false;
	}
	
	//Méthodes
	
	public void placerJeton(GameBank listeJeu) {
	    Scanner scanner = new Scanner(System.in);
	    try {
	    	System.out.println("Sur quel jeu, voulez-vous place des jetons ?");
	    	String nomJeu = scanner.nextLine();
	        JeuxVideo jeu = listeJeu.recupererJeu(nomJeu);
	        if (jeu == null) {
		        System.out.println("Le jeu specifie n'existe pas.");
		        return;
		    }
	        System.out.println("Combien de jetons voulez-vous placer ? ");
	        int nombre = scanner.nextInt();
	        while ((nombre > nbJetons) || (nombre < 0)) {
	        	if (nombre > nbJetons) {
	        		System.out.println("Vous n'avez pas assez de jetons, veuillez reessayer : ");
	        	}
	        	if (nombre < 0) {
	        		System.out.println("Erreur de saisie, veuillez reessayer : ");
	        	}
	        	nombre = scanner.nextInt();
	        }
	        jeu.ajouteJeton(nombre);
	        System.out.println("Le nombre de jetons est de " + jeu.getNbJetons() + " jetons.");
	        nbJetons = nbJetons - nombre;
	    } catch (NoSuchElementException e) {
	        System.out.println("Erreur : Entree invalide.");
	    }
	}
	public JeuxVideo recupererJeu(String nomJeu) {
		for (JeuxVideo jeu : jeuxPossedee) {
			if (jeu.getNom().equals(nomJeu)) {
				return jeu;
			}
		}
		return null;
	}
	public void ecrireEvaluation() {
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Sur quel jeu voulez-vous ecrire une evaluation ?");
	    String nomJeu = scanner.nextLine();
	    JeuxVideo jeu = recupererJeu(nomJeu);
	    if (jeu == null) {
	        System.out.println("Vous ne possede pas le jeu specifie.");
	        return;
	    }
	    System.out.println("Donnez votre évaluation :");
	    String texte = scanner.nextLine();

	    if (texte.trim().isEmpty()) {
	        System.out.println("L'évaluation ne peut pas être vide.");
	        return;
	    }

	    System.out.println("Entrez la date de l'évaluation : (AAAAMMJJ)");
	    double date;
	    if (!scanner.hasNextDouble()) {
	        System.out.println("La date doit être un nombre.");
	        return;
	    }
	    date = scanner.nextDouble();

	    System.out.println("Entrez la version du jeu :");
	    float numVersion;
	    if (!scanner.hasNextFloat()) {
	        System.out.println("La version doit être un nombre.");
	        return;
	    }
	    numVersion = scanner.nextFloat();
	    Evaluation evaluation = new Evaluation(date, texte , numVersion, pseudo);
	    nbEvaluation++;
	    jeu.ajouteEvaluation(evaluation);
	}
	public boolean presenceJeu(JeuxVideo nouveauJeu) {
		for (JeuxVideo jeu : jeuxPossedee) {
			if (jeu.equals(nouveauJeu)) {
				return true;
			}
		}
		return false;
	}
	public void ajouteJeux(String nomJeu, GameBank listeJeu) {
		JeuxVideo nouveauJeu = listeJeu.recupererJeu(nomJeu);
		if (nouveauJeu != null) {
			if (presenceJeu(nouveauJeu)) {
				System.out.println("Vous possede deja le jeu.");
				return;
			}
			else {
				jeuxPossedee.add(nouveauJeu);
				System.out.println("Jeu ajoute avec succes !");
				return;
			}			
		}
		else {
			System.out.println("Le jeu specifie n'existe pas.");
			return;
		}
	}
	public void consulterTest(GameBank listeJeu) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Sur quel jeu voulez-vous consulter les tests ?");
		String nomJeu = scanner.nextLine();
		JeuxVideo jeu = listeJeu.recupererJeu(nomJeu); 
		if (jeu == null) {
			System.out.println("Le jeu specifie n'existe pas.");
	        return;
		}
		for (int i = 0; i < jeu.getEnsembleTest().size(); i++) {
			System.out.println(jeu.getEnsembleTest().get(i) + "\n");
		}
	}
	
	
	
	@Override
	public String toString() {
		if (jeuxPossedee.size() > 0) {
			return "Bienvenue " + pseudo + " ! Vous avez " + nbJetons + " jetons. Vos jeux sont " + arrayListToString()
					+ ". Vous avez ecrit " + nbEvaluation + " evaluations.";
		}
		else {
			return "Bienvenue " + pseudo + " ! Vous avez " + nbJetons + " jetons. Vous n'avez pas encore de jeux"
			+ ". Vous avez ecrit " + nbEvaluation + " evaluations.";
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
