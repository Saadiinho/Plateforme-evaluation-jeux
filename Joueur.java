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
	public int getNbEvaluation() {
		return nbEvaluation;
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
	public void setNbJetons(int nbJetons) {
		this.nbJetons = nbJetons;
	}
	public void setPseudoAdmin() {
		this.pseudo = "admin";
	}
	
	//Méthodes
	public void ajoutJetons() {
		this.setNbJetons(nbJetons + 1);
	}
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
	        nbJetons = nbJetons - nombre;
	        System.out.println("Le nombre de vos jetons est de " + nbJetons + " jetons.");
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
	    System.out.println("Donnez votre evaluation :");
	    String texte = scanner.nextLine();

	    if (texte.trim().isEmpty()) {
	        System.out.println("L'evaluation ne peut pas être vide.");
	        return;
	    }

	    System.out.println("Entrez la date de l'evaluation : (AAAAMMJJ)");
	    double date;
	    if (!scanner.hasNextDouble()) {
	        System.out.println("La date doit être un nombre.");
	        return;
	    }
	    date = scanner.nextDouble();

	    System.out.println("Entrez la version du jeu : (un nombre entier)");
	    float numVersion;
	    if (!scanner.hasNextFloat()) {
	        System.out.println("La version doit tre un nombre.");
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
	public void avisEvaluation(GameBank listeJeu) {
		Scanner scanner = new Scanner(System.in);
		this.consulterEvaluation(listeJeu);
		JeuxVideo jeu = this.rechercherJeu(listeJeu);
		System.out.println("Dans quel evaluation voulez vous donner votre avis ? (Donnez le numero)");
		int numEval = scanner.nextInt();
		Evaluation evaluation = jeu.getEnsembleEvaluation().get(numEval - 1);
		System.out.println("Aimez-vous cette evaluation ? (y/n)");
		String rep = scanner.next();
		while (!rep.equals("y") && !rep.equals("n")){
			System.out.println("Erreur de saisie, veuillez reessayer : ");
			rep = scanner.next();
		}	
		if (rep.equals("y")) {
			evaluation.ajoutePouceBleu();
			if (evaluation.verifJaime()) {
				ajoutJetons();
			}
		}
		else if (rep.equals("n")){
			evaluation.ajoutePouceRouge();
		}
		System.out.println("Ajout reussi avec succes !");
	}
	
	
	@Override
	public String toString() {
		if (jeuxPossedee.size() > 0) {
			return pseudo + " : nombre de jetons :  " + nbJetons + "\nListe jeu " + arrayListToString()
					+ " \nnombre evaluation : " + nbEvaluation;
		}
		else {
			return pseudo + " : nombre de jetons :  " + nbJetons + "\nListe jeu " + arrayListToString()
			+ "\nnombre evaluation : " + nbEvaluation;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
