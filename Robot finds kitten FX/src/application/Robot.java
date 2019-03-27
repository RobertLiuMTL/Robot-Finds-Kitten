package application;
/*Robert Liu 865826
 * */

public class Robot {
	private String nom;
	public String image = "/robot.png";
	private Point position;
	private int keys;
	private boolean teleporteur = false;
	private Boolean chat = false;
	/**
	 * Constructeur du Robot.
	 *
	 * @param name
	 *            : L'utilisateur est appel� � choisir un nom pour le Robot au d�but
	 *            de la partie. Par d�faut, le nom du Robot est Jimmy Whooper Bot.
	 *
	 *
	 */
	
	/**
	 * Constructeur qui prend en entr�e le nom du Robot (choisi par l'utilisateur, sinon par d�faut)
	 * 
	 * @param name Re�oit en param�tre un String
	 */
	public Robot(String name) {
		if (name == "") {
			this.nom = "Jimmy Whooper Bot";
		} else {
			this.nom = name;
		}
	}

	/**
	 * 
	 * @return Retourne le nom du Robot
	 */
	public String getNom() {
		return this.nom;
	}
	
	
	/**
	 * Un setter qui permet de modifier la position du Robot.
	 * @param position : Prend en entr�e une position de type Point
	 */
	public void setPosition(Point position) {
		this.position = position;
	}

	
	/**
	 * 
	 * @return Retourne la coordonn�e X du Robot.
	 * @see Point
	 */
	public int getPositionX() {
		return this.position.getX();
	}
	
	
	/**
	 * 
	 * @return Retourne la coordonn�e Y du Robot.
	 * @see Point
	 */
	public int getPositionY() {
		return this.position.getY();
	}
	
	
	/**
	 * M�thode sans param�tre
	 * 
	 * @return Retourne le nombre de clefs poss�d�es par le Robot.
	 */
	public int getKeys() {
		return this.keys;
	}
	
	
	/**
	 * 
	 * @return Retourne sous forme de bool�enne la possession ou non du T�l�porteur.
	 */
	public boolean getTeleport() {
		return teleporteur;
	}

	
	
	/**
	 * Retourne une bool�enne qui indique si le Robot poss�de une clef.
	 *
	 * @return True ou False.
	 */
	public boolean hasKeys() {
		if (keys != 0) {
			return true;
		} else {
			return false;
		}
	}

	
	/**
	 * Une m�thode qui permet d'incr�menter le nombre de clefs.
	 *
	 * @return Void
	 */
	public void addKeys() {
		keys+=1;		
	}

	
	/**
	 * Une m�thode qui permet de d�cr�menter le nombre de clefs.
	 *
	 * @return Void
	 */
	public void lowerKeys() {
		if (keys > 0) {
			keys--;
		}
	}
	
	
	/**
	 * M�thode sans param�tre et sans retour qui permet de modifier l'attribut teleport du Robot.
	 */
	public void addTeleport() {
		teleporteur = true;
	}
	
	
	/**
	 * M�thode sans param�tre qui a pour objectif de v�rifier si le Robot poss�de le Chat
	 * 
	 * @return Retourne sous forme de bool�enne l'information sur la possession du Chat.
	 */
	public boolean hasChat() {
		return chat;
	}
	
	
	/**
	 * M�thode sans param�tre et sans retour qui a pour but de modifier l'attribut bool�en Chat du Robot.
	 */
	public void addChat() {
		this.chat=true;
	}
	

}
