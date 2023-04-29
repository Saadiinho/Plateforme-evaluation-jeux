package projet;

import java.util.ArrayList;

public class GameBank {

	private ArrayList<JeuxVideo> listeJeu;
	
	//Constructeurs
	public GameBank() {
		listeJeu = new ArrayList<JeuxVideo>();
	}
	
	//Guetteurs
	public ArrayList<JeuxVideo> getListeJeu(){
		return listeJeu;
	}
	
	//Méthode
	public void chargerListeJeu() {
		
		Support support = new Support("Wii", 2006, 82.53);
		JeuxVideo j0 = new JeuxVideo("Wii Sports.","Sports","Nintendo", Classement.E, support);
		support.setNbVente(40.24);
		support.setAnneeSorite(1985);
		support.setPlateforme("NES");
		JeuxVideo j1 = new JeuxVideo("Super Mario Bros.","Platform","Nintendo", Classement.UNKNOWN ,support);
		support.setNbVente(35.52);
		support.setAnneeSorite(2008);
		support.setPlateforme("Wii");
		JeuxVideo j2 = new JeuxVideo("Mario Kart Wii.","Racing","Nintendo", Classement.E ,support);
		support.setNbVente(31.37);
		support.setAnneeSorite(1996);
		support.setPlateforme("GB");
		JeuxVideo j3 = new JeuxVideo("Pokemon Red/Pokemon Blue.","Role-playing","Nintendo", Classement.UNKNOWN ,support);
		support.setNbVente(30.26);
		support.setAnneeSorite(1989);
		support.setPlateforme("GB");
		JeuxVideo j4 = new JeuxVideo("Tetris.","Puzzle","Nintendo", Classement.UNKNOWN ,support);
		Evaluation evaluation = new Evaluation(20230129, "Un jeu palpitant, digne d'un bon vieux Mario Party !", 2.10);
		j4.getEnsembleEvaluation().add(evaluation);
		support.setNbVente(29.8);
		support.setAnneeSorite(2006);
		support.setPlateforme("DS");
		JeuxVideo j5 = new JeuxVideo("New Super Mario Bros.","Platform","Nintendo", Classement.E ,support);
		support.setNbVente(28.92);
		support.setAnneeSorite(2006);
		support.setPlateforme("Wii");
		JeuxVideo j6 = new JeuxVideo("Wii Play","Misc","Nintendo", Classement.E ,support);
		listeJeu.add(j0);
		listeJeu.add(j1);
		listeJeu.add(j2);
		listeJeu.add(j3);
		listeJeu.add(j4);
		listeJeu.add(j5);
		listeJeu.add(j6);
	}
	public boolean presenceJeux(String nomJeu) {
	    for (JeuxVideo jeu : listeJeu) {
	        if (jeu.getNom().equals(nomJeu)) {
	            return true;
	        }
	    }
	    return false;
	}
	public JeuxVideo recupererJeu(String nomJeu) {
		for (JeuxVideo jeu : listeJeu){
			if (jeu.getNom().equals(nomJeu)) {
				return jeu;
			}
		}
		return null;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
