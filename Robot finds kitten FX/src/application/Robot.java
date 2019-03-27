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
	 *            : L'utilisateur est appelé à choisir un nom pour le Robot au début
	 *            de la partie. Par défaut, le nom du Robot est Jimmy Whooper Bot.
	 *
	 *
	 */
	
	/**
	 * Constructeur qui prend en entrée le nom du Robot (choisi par l'utilisateur, sinon par défaut)
	 * 
	 * @param name Reçoit en paramètre un String
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
	 * @param position : Prend en entrée une position de type Point
	 */
	public void setPosition(Point position) {
		this.position = position;
	}

	
	/**
	 * 
	 * @return Retourne la coordonnée X du Robot.
	 * @see Point
	 */
	public int getPositionX() {
		return this.position.getX();
	}
	
	
	/**
	 * 
	 * @return Retourne la coordonnée Y du Robot.
	 * @see Point
	 */
	public int getPositionY() {
		return this.position.getY();
	}
	
	
	/**
	 * Méthode sans paramètre
	 * 
	 * @return Retourne le nombre de clefs possédées par le Robot.
	 */
	public int getKeys() {
		return this.keys;
	}
	
	
	/**
	 * 
	 * @return Retourne sous forme de booléenne la possession ou non du Téléporteur.
	 */
	public boolean getTeleport() {
		return teleporteur;
	}

	
	
	/**
	 * Retourne une booléenne qui indique si le Robot possède une clef.
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
	 * Une méthode qui permet d'incrémenter le nombre de clefs.
	 *
	 * @return Void
	 */
	public void addKeys() {
		keys+=1;		
	}

	
	/**
	 * Une méthode qui permet de décrémenter le nombre de clefs.
	 *
	 * @return Void
	 */
	public void lowerKeys() {
		if (keys > 0) {
			keys--;
		}
	}
	
	
	/**
	 * Méthode sans paramètre et sans retour qui permet de modifier l'attribut teleport du Robot.
	 */
	public void addTeleport() {
		teleporteur = true;
	}
	
	
	/**
	 * Méthode sans paramètre qui a pour objectif de vérifier si le Robot possède le Chat
	 * 
	 * @return Retourne sous forme de booléenne l'information sur la possession du Chat.
	 */
	public boolean hasChat() {
		return chat;
	}
	
	
	/**
	 * Méthode sans paramètre et sans retour qui a pour but de modifier l'attribut booléen Chat du Robot.
	 */
	public void addChat() {
		this.chat=true;
	}
	

}
