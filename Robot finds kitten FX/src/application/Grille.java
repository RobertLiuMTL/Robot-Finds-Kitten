package application;
/*Robert Liu 865826
 * */
public class Grille {
	private Case [][] grille;

	/**
	 * Le constructeur de la Grille de jeu.
	 * 
	 * À l'aide des données entrées par l'utilisateur, le constructeur bâtit le jeu. En ce moment, un bogue existe pour les 
	 * dimensions paires. 
	 * 
	 * Le constructeur un nombre d'objets NonKitten déterminé par l'utilisateur. 
	 * Par défaut, le constructeur place une clef par pièce, un Chat sur la carte, ainsi qu'un téléporteur.
	 * 
	 * @param nbrPiecesX : Détermine le nombre de pièces par ligne
	 * @param nbrPiecesY : Détermine le nombre de colonne par colonne
	 * @param largeurPiece : Détermine la largeur d'une pièce
	 * @param hauteurPiece : Détermine la hauteur d'une pièce
	 * @param nbrNonKitten : Détermine le nombre d'objets interactifs NonKittenItems
	 * (non-essentiels au déroulement du jeu)
	 *
	 * @see NonKitten
	 */
	public Grille (int nbrPiecesX, int nbrPiecesY,
			int largeurPiece, int hauteurPiece, int nbrNonKitten) {
		/*Les attributs du Constructeur.
		 * 
		 * Les deux attributs "milieu" identifie le centre de chaque pièce. Cela nous permet de déterminer l'emplacement des portes
		 * */
		int nombreColonnes = nbrPiecesX+1;
		int nombreLignes = nbrPiecesY+1;
		int largeurTotale = nbrPiecesX * largeurPiece + nombreColonnes;
		int hauteurTotale = nbrPiecesY * hauteurPiece + nombreLignes;
		int milieuLigne = largeurTotale/nbrPiecesX/2;
		int milieuColonne = hauteurTotale/nbrPiecesY/2;
		grille = new Case [largeurTotale][hauteurTotale];

		//Double boucle For pour créer les murs.
		for (int i = 0 ; i< largeurTotale; i++) {
			for (int j = 0; j < hauteurTotale; j++) {
				//Création des murs (Les murs se situent à +1 distance de la hauteur ou la largeur des pièces)
				if (i%(largeurPiece+1)==0 || j%(hauteurPiece+1)==0) {

					//Création des portes : exception murs aux extrémités
					if (i ==0 || i == largeurTotale-1 || j==0 || j==hauteurTotale-1) {
						grille[i][j]= new Mur();
					}
					else if (i%milieuLigne==0 && j%milieuColonne==0 ) {
						if(i%(largeurPiece+1)==0 && j%(hauteurPiece+1)==0) {
							grille[i][j]=new Mur();
						}else {
							grille[i][j]=new Porte();
						}
					}
					else {
						grille[i][j]=new Mur();
					}
				}
			}
		}

		//Boucle pour placer les Keys (symbole '). Il faut exactement une clef par pièce
		for (int i = 0;i<nbrPiecesX;i++) {
			for (int j = 0; j<nbrPiecesY;j++) {
				boolean condition = false;
				while (condition == false) {
					int x = (int)(Math.random() * largeurPiece) + (largeurPiece+1)*i;
					int y = (int)(Math.random() * hauteurPiece) + (hauteurPiece+1)*j;
					if (grille[x][y] == null){
						grille[x][y] = new Cle();
						condition = true;
					}
				}
			}
		}
		
		//Création des autres objets. On utilise une bouche pour les NonKitten.
		Point pointChat = randomEmptyCell();
		grille[pointChat.getX()][pointChat.getY()] = new Kitten();
		
		Point pointTeleport = randomEmptyCell();
		grille[pointTeleport.getX()][pointTeleport.getY()] = new Teleporteur();
		
		int compteurNonKitten = nbrNonKitten;
		while (compteurNonKitten !=0) {
			Point point = randomEmptyCell();
			grille[point.getX()][point.getY()] = new NonKitten();
			compteurNonKitten--;
		}
	}
	
	/**
	 * Méthode qui ne prend rien en entrée.
	 * 
	 * @return Un élément de type Point qui contient les coordonnées X,Y vers une case vide.
	 * 
	 * @see Point
	 */
	public Point randomEmptyCell() {
		boolean condition = false;
		Point point = null;
		while (condition == false) {
			int x = (int)(Math.random() * grille.length);
			int y = (int)(Math.random() * grille[0].length);	
			if (grille[x][y]==null) {
				condition = true;
				point = new Point (x,y);
			}
		}
		return point;		
	}

	/**
	 * Un getter
	 * @return La grille 2d de cases.
	 */
	public Case[][] getGrille(){
		return this.grille;
	}
	
	//Affiche la grille dans la console à coups de System.out.println(...)
	//Le Robot s'affiche comme un # sur la Grille
	/**
	 * Méthode qui prend en entrée le Robot (afin d'avoir ses coordonnées)
	 * 
	 * @param robot Retourne l'entièreté de la grille à coup de print (ligne à ligne).
	 */
	public void afficher(Robot robot) {
		//La variable resultat accumule les données des deux boucles.
		String resultat ="";
		int robotX = robot.getPositionX();
		int robotY = robot.getPositionY();
		for (int y = 0 ; y<grille[0].length ;System.out.println(resultat),y++) {
			resultat ="";
			for (int x = 0 ; x<grille.length ; x++) {
				if (x == robotX && y == robotY) {
					resultat += '#';
				}else {
					if(grille[x][y] == null) {
						resultat += " ";
					}else {
						resultat += grille[x][y].getRepresentation();
					}
				}

			}
		}
		//Impression du message.
		if (robot.getTeleport()==true) {
			System.out.println(robot.getNom()+ "["+ robot.getKeys()+"]T>");
		}else {
			System.out.println(robot.getNom()+ "["+ robot.getKeys()+"]>");
		}
	}

	
	/**
	 * Évalue la position du Robot + la position souhaitée pour le déplacement en tenant des objets sur la Grille.
	 * 
	 * @param robot
	 * @param x : Coordonnée X + déplacement du Robot à vérifier
	 * @param y : Coordonnée Y + déplacement  du Robot à vérifier
	 * @return : Booléenne vrai ou faux.
	 */
	public boolean deplacementPossible(Robot robot, int x, int y) {
		if (grille[x][y]==null) {
			return true;
		}else if (grille[x][y]!= null) {
			if (grille[x][y].interactionPossible(robot) == true) {
				grille[x][y].interagir(robot);
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
}

