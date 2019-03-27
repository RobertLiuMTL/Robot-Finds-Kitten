package application;
/*Robert Liu 865826
 * */
/**
 * La class Point a les m�thodes suivantes :
 * 1- Constructeur public Point (int x, int y)
 * 
 * 2- egal(int x, int y) qui compare les coordonn�es entr�es avec les coordonn�es stock�es.
 * 
 * 3- getX() retourne la coordonn�e de X
 * 
 * 4- getY() retourne la coordonn�e de Y
 * 
 * 
 * 
 * @author Robert / Maud
 *
 */
public class Point {
	private final int x, y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	
	boolean egal(int x, int y) {
		return x == this.x && y == this.y;
	}
	
	
	/**
	 * Un getter qui va chercher la coordonn�e X.
	 * 
	 * @return retourne la valeur de X sous forme d'un entier.
	 */
	public int getX() {
		return x;
	}
	
	
	
	/**
	 * Un getter qui va chercher la coordonn�e Y.
	 * 
	 * @return retourne la valeur de Y sous forme d'un entier.
	 */
	public int getY() {
		return y;
	}
}
