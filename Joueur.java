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
	public JeuxVideo recupererJeu(String nomJeu) {
		for (JeuxVideo jeu : jeuxPossedee){
			if (jeu.getNom().equals(nomJeu)) {
				return jeu;
			}
		}
		return null;
	}
	public void placerJeton() {
	    Scanner scanner = new Scanner(System.in);
	    try {
	        System.out.println("Sur quel jeu, voulez-vous placer des jetons ?");
	        String nomJeu = scanner.nextLine();
	        JeuxVideo jeu = recupererJeu(nomJeu);
	        System.out.print("Combien de jetons voulez-vous mettre pour ce jeu ? ");
	        int nombre = scanner.nextInt();
	        while (nombre > nbJetons) {
	            System.out.println("Désolé, vous n'avez pas assez de jetons...");
	            System.out.println("Veuillez réessayer : ");
	            nombre = scanner.nextInt();
	        }
	        jeu.ajouteJeton(nombre);
	        System.out.println("Jetons placés !");
	        nbJetons = nbJetons - nombre;
	        System.out.println("Il vous reste " + nbJetons + " jetons.");
	    } catch (NoSuchElementException e) {
	        System.out.println("Erreur : Entrée invalide.");
	    } finally {
	        scanner.close();
	    }
	}

	public void ecrireEvaluation() {
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Sur quel jeu voulez-vous écrire une évaluation ?");
	    String nomJeu = scanner.nextLine();
	    JeuxVideo jeu = recupererJeu(nomJeu);

	    if (jeu == null) {
	        System.out.println("Le jeu spécifié n'existe pas.");
	        return;
	    }

	    System.out.println("Donnez votre évaluation :");
	    String texte = scanner.nextLine();

	    if (texte.trim().isEmpty()) {
	        System.out.println("L'évaluation ne peut pas être vide.");
	        return;
	    }

	    System.out.println("Entrez la date de l'évaluation :");
	    double date;
	    if (!scanner.hasNextDouble()) {
	        System.out.println("La date doit être un nombre.");
	        return;
	    }
	    date = scanner.nextDouble();

	    System.out.println("Entrez la version du jeu :");
	    double numVersion;
	    if (!scanner.hasNextDouble()) {
	        System.out.println("La version doit être un nombre.");
	        return;
	    }
	    numVersion = scanner.nextDouble();

	    scanner.close();
	    Evaluation evaluation = new Evaluation(date, texte ,numVersion);
	    jeu.ajouteEvaluation(evaluation);
	    nbEvaluation++;
	}

	public void ajouteJeux(String nomJeu) {
		GameBank listeJeu = new GameBank();
		listeJeu.chargerListeJeu();
		JeuxVideo nouveauJeu = listeJeu.recupererJeu(nomJeu); 
		jeuxPossedee.add(nouveauJeu);
	}
	public void consulterTest() {
		Scanner scanner = new Scanner(System.in);
		String nomJeu = scanner.nextLine();
		GameBank listeJeu = new GameBank();
		listeJeu.chargerListeJeu();
		JeuxVideo jeu = listeJeu.recupererJeu(nomJeu); 
		for (int i = 0; i < jeu.getEnsembleTest().size(); i++) {
			System.out.println(jeu.getEnsembleTest().get(i) + "\n");
		}
		scanner.close();
	}
	
	
	
	@Override
	public String toString() {
		return "Bienvenue " + pseudo + " ! Vous avez " + nbJetons + " jetons. Vos jeux sont " + arrayListToString()
				+ ". Vous avez ecrit " + nbEvaluation + " evaluations.";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
