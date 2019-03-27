package application;
/*Robert Liu 865826
 * */
/**
 * La class Point a les méthodes suivantes :
 * 1- Constructeur public Point (int x, int y)
 * 
 * 2- egal(int x, int y) qui compare les coordonnées entrées avec les coordonnées stockées.
 * 
 * 3- getX() retourne la coordonnée de X
 * 
 * 4- getY() retourne la coordonnée de Y
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
	 * Un getter qui va chercher la coordonnée X.
	 * 
	 * @return retourne la valeur de X sous forme d'un entier.
	 */
	public int getX() {
		return x;
	}
	
	
	
	/**
	 * Un getter qui va chercher la coordonnée Y.
	 * 
	 * @return retourne la valeur de Y sous forme d'un entier.
	 */
	public int getY() {
		return y;
	}
}
