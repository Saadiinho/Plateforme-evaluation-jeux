# Plateforme-evaluation-jeux
Création d'une plateforme d'évaluation collaborative de jeux vidéo.


Documentation

Classe JeuxVideo :
  -	public void ajouteJeton(int nombre) : permet d’ajouter le nombre voulu de jetons pour tester le jeu video. Le nombre est choisi dans une méthode de la classe Joueur.
  -	public void libereJetons() : permet de libérer le jeu de ses jetons. Elle est appelé lorsqu’un testeur teste le jeu.
  -	public void ajouteEvalution(Evaluation evaluation) : permet d’ajouter une évaluation à ce jeu précis. L’évaluation est écrit dans la classe Joueur.
  -	public void supprimeEvaluation(int i) : permet à l’administrateur de supprimer une évaluation spécifique. Elle est utilisée seulement par l’administrateur.
  -	public void String toString() : permet d’afficher toutes les informations du jeu.

Classe Evaluation :
  -	public void ajoutePouceBleu() : permet d’aimer une évaluation.
  -	public void ajoutePouceRouge() : permet de ne pas aimer une évaluation.
  -	public void String toString() : permet d’afficher toutes les informations de l’évaluation.

Classe Test
  -	public void String toString() : permet d’afficher toutes les informations du test.

Classe GameBank
Cette classe est ce que l’on peut appeler la base de donnée. Elle récupère toutes les données existantes dans le fichier donneeJeu.csv pour les traité et les exploité dans notre code. Dans le constructeur, chaque élément du fichier csv est découpé puis permet de construire une variable de type JeuxVideo. Cette variable est ensuite inscrit dans une liste nommé listeJeu (cette liste nous sert de base de donnée).
  -	public JeuxVideo recupérerJeu(String nomJeu) : permet de récupérer un jeu dont le nom est passé en paramètre.

Classe Invite 
  -	public JeuxVideo rechercherJeu(GameBank listeJeu) : permet de rechercher un jeu dans la base de donnée passé en paramètre. Elle retourne le jeu, donc de type JeuxVideo.
  -	public void consulterEvaluation(GameBank listeJeu) : permet de consulter les évaluations d’un jeu recherché grâce à la méthode precédente..
Classe Joueur 
  -	public void placeJeton(GameBank listeJeu) : permet de placer un nombre de jeton inférieur ou égale au nombre de jeton possédé par le joueur à un jeu qu’on récupère dans la base de donnée passé en paramètre.
  -	public JeuxVideo recupererJeu(String nomJeu) : permet de récupérer un jeu dans la liste de jeu que le joueur possède. 
  -	public void ecrireEvaluation() : permet d’écrire une évaluation qui est mis dans une variable de type Evaluation avant  d’être ajouté au jeu trouvé grâce à la méthode précédente.
  -	Public boolean presenceJeu(JeuxVideo nouveauJeu) : permet de savoir si le nouveauJeu est présent dans la liste des jeux possédés par le joueur.
  -	Public void ajouteJeu(String nomJeu, gameBank listeJeu) : recherche nomJeu dans la base de donnée listeJeu grâce à sa méthode recupererJeu. Elle vérifie ensuite si le nouveauJeu est présent dans la liste des jeux possédés par le joueur grâce à la méthode précédente presenceJeu . Enfin, elle ajoute le nouveau jeu dans la liste de jeux possédés par le joueur. 

Classe Testeur
  -	Public void ecrireTest(GameBank listeJeu) : permet d’écrire un test pour un jeu dans la base de donnée.

Classe Administrateur 
  -	public void supprimerEvaluation(String nomJeu, GameBank listeJeu) : Cette méthode permet de consulter chaque évaluation d’un jeu. Ensuite, il choisit l’évaluation problématique, pour, enfin, le supprimer.

Classe Connexion
Cette classe est le point où toutes les méthodes, utiles au fonctionnement de la plateforme, sont appelés. Elle permet donc de se connecter, d’écrire des évaluations, de placer de jetons, d’écrire ou modifier des tests, de consulter des évaluations ou des tests, de promouvoir des membres… en fonction de l’autorisation qu’a le membre.
  -	Public static void seConnecter(GameBank listeJeu, Joueur joueurConnecte) : permet l’utilisation de la plateforme pour un joueur. 
  -	Public static void connexion() : permet l’utilisation de la plateforme.
  -	Public static void main() : permet le lancement de la plateforme.
