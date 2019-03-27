package application;
/*Robert Liu 865826
 * */
public class Porte extends Case{
	protected char representation = '!';
	boolean ouverte = false;
	protected String image = "/door.png";

	@Override
	public boolean interactionPossible(Robot robot) {
		if (ouverte == true) {
			return true;
		}else if(ouverte==false && robot.hasKeys()==true) {
			return true;
		}else {
			return false;
		}
	}
	

	/**
	 * Méthode qui prend en entrée un Robot et qui ne retourne rien. Détermine les interactions avec le Robot
	 */
	public void interagir(Robot robot) {
		if (interactionPossible (robot) == true && ouverte == false) {
			representation = ' ';
			robot.lowerKeys();
			ouverte = true;
			System.out.println("Tu as débarré une porte!");
		}
	};

}
