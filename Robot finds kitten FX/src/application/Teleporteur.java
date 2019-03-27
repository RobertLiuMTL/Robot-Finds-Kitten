package application;
/*Robert Liu 865826
 * */
public class Teleporteur extends Case{
	//la bool�enne teleport sert � d�terminer si le Robot a ramass� ou non l'objet.
	boolean teleport = true;
	protected char representation = getRandomSymbole();
	protected String image = getRandomImg();
	protected String phrase = rfkSentences[28];
	
	@Override
	public boolean interactionPossible(Robot robot) {
		return true;
	};

	
	//Le t�l�porteur 'dispara�t' quand il est ramass�(repr�sentation devient espace vide)�aaaaaaaaaaaaaaaaaaaaa
	/**
	 * L'interaction entre le t�l�porteur et le Robot.
	 * Quand il est ramass�, le t�l�porteur dispara�t de la Grille et modifie le statut du Robot.
	 */
	public void interagir(Robot robot){
		if (teleport ==true) {
			representation = ' ';
			robot.addTeleport();
			System.out.println(rfkSentences[28]);
			teleport = false;
		}
	};
}
