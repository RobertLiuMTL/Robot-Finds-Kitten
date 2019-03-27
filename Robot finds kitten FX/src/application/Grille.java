package application;
/*Robert Liu 865826
 * */
public class Grille {
	private Case [][] grille;

	/**
	 * Le constructeur de la Grille de jeu.
	 * 
	 * � l'aide des donn�es entr�es par l'utilisateur, le constructeur b�tit le jeu. En ce moment, un bogue existe pour les 
	 * dimensions paires. 
	 * 
	 * Le constructeur un nombre d'objets NonKitten d�termin� par l'utilisateur. 
	 * Par d�faut, le constructeur place une clef par pi�ce, un Chat sur la carte, ainsi qu'un t�l�porteur.
	 * 
	 * @param nbrPiecesX : D�termine le nombre de pi�ces par ligne
	 * @param nbrPiecesY : D�termine le nombre de colonne par colonne
	 * @param largeurPiece : D�termine la largeur d'une pi�ce
	 * @param hauteurPiece : D�termine la hauteur d'une pi�ce
	 * @param nbrNonKitten : D�termine le nombre d'objets interactifs NonKittenItems
	 * (non-essentiels au d�roulement du jeu)
	 *
	 * @see NonKitten
	 */
	public Grille (int nbrPiecesX, int nbrPiecesY,
			int largeurPiece, int hauteurPiece, int nbrNonKitten) {
		/*Les attributs du Constructeur.
		 * 
		 * Les deux attributs "milieu" identifie le centre de chaque pi�ce. Cela nous permet de d�terminer l'emplacement des portes
		 * */
		int nombreColonnes = nbrPiecesX+1;
		int nombreLignes = nbrPiecesY+1;
		int largeurTotale = nbrPiecesX * largeurPiece + nombreColonnes;
		int hauteurTotale = nbrPiecesY * hauteurPiece + nombreLignes;
		int milieuLigne = largeurTotale/nbrPiecesX/2;
		int milieuColonne = hauteurTotale/nbrPiecesY/2;
		grille = new Case [largeurTotale][hauteurTotale];

		//Double boucle For pour cr�er les murs.
		for (int i = 0 ; i< largeurTotale; i++) {
			for (int j = 0; j < hauteurTotale; j++) {
				//Cr�ation des murs (Les murs se situent � +1 distance de la hauteur ou la largeur des pi�ces)
				if (i%(largeurPiece+1)==0 || j%(hauteurPiece+1)==0) {

					//Cr�ation des portes : exception murs aux extr�mit�s
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

		//Boucle pour placer les Keys (symbole '). Il faut exactement une clef par pi�ce
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
		
		//Cr�ation des autres objets. On utilise une bouche pour les NonKitten.
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
	 * M�thode qui ne prend rien en entr�e.
	 * 
	 * @return Un �l�ment de type Point qui contient les coordonn�es X,Y vers une case vide.
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
	
	//Affiche la grille dans la console � coups de System.out.println(...)
	//Le Robot s'affiche comme un # sur la Grille
	/**
	 * M�thode qui prend en entr�e le Robot (afin d'avoir ses coordonn�es)
	 * 
	 * @param robot Retourne l'enti�ret� de la grille � coup de print (ligne � ligne).
	 */
	public void afficher(Robot robot) {
		//La variable resultat accumule les donn�es des deux boucles.
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
	 * �value la position du Robot + la position souhait�e pour le d�placement en tenant des objets sur la Grille.
	 * 
	 * @param robot
	 * @param x : Coordonn�e X + d�placement du Robot � v�rifier
	 * @param y : Coordonn�e Y + d�placement  du Robot � v�rifier
	 * @return : Bool�enne vrai ou faux.
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

