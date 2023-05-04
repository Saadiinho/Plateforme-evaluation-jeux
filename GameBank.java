package projet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;


public class GameBank {
	private static ArrayList<JeuxVideo> listeJeu;
	
	public GameBank() {
		listeJeu = new ArrayList<JeuxVideo>();
		String fichierCSV = "C:\\Users\\saadr\\OneDrive\\Documents\\Ecole\\Informatique\\Java\\Projet_ecole\\src\\projet\\donneeJeu.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(fichierCSV))) {
            
            String line;
        	String nom;
        	String plateforme;
        	String anneeSortie;
        	String categorie;
        	String editeur;
        	String naSales;
        	String euSales;
        	String jpSales;
        	String otherSales;
        	String globalSales;
        	String Critic_Score;
        	String Critic_Count;
        	String User_Score;
        	String userCount;
        	String developpeur;
        	String classement;
            while ((line = br.readLine()) != null) {
            	String[] donnee = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
                
                nom = donnee[1];
            	plateforme = donnee[2];
            	anneeSortie = donnee[3];
            	categorie = donnee[4];
            	editeur = donnee[5];
            	naSales = donnee[6];
            	euSales = donnee[7];
            	jpSales = donnee[8];
            	otherSales = donnee[9];
            	globalSales = donnee[10];
            	if (donnee.length >= 12) {
            		Critic_Score = donnee[11];
            	}
            	else {
            		Critic_Score = null;
            	}
            	if (donnee.length >= 13) {
            		Critic_Count = donnee[12];
            	}
            	else {
            		Critic_Count = null;
            	}
            	if (donnee.length >= 14) {
            		User_Score = donnee[13];
            	}
            	else {
            		User_Score = null;
            	}
            	if (donnee.length >= 15) {
            		userCount = donnee[14];
            	}
            	else {
            		userCount = null;
            	}
            	if (donnee.length >= 16) {
            		developpeur = donnee[15];
            	}
            	else {
            		developpeur = null;
            	}
            	if (donnee.length >= 17) {
            		classement = donnee[16];
            	}
            	else {
            		classement = null;
            	}
            	JeuxVideo jeu = new JeuxVideo(nom, plateforme, anneeSortie, categorie, editeur, 
            			naSales, euSales, jpSales, otherSales, globalSales, 
            			Critic_Score, Critic_Count, User_Score, userCount, 
            			developpeur, classement);
            	listeJeu.add(jeu);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
    
    public JeuxVideo recupererJeu(String nomJeu) {
    	for (JeuxVideo jeu : listeJeu) {
    		if (nomJeu.equals(jeu.getNom())) {
    		return jeu;	
    		}
    	}
    	return null;
    }
}
