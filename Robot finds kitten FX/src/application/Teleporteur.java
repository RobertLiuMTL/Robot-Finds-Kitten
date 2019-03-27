package application;
/*Robert Liu 865826
 * */
public class Teleporteur extends Case{
	//la booléenne teleport sert à déterminer si le Robot a ramassé ou non l'objet.
	boolean teleport = true;
	protected char representation = getRandomSymbole();
	protected String image = getRandomImg();
	protected String phrase = rfkSentences[28];
	
	@Override
	public boolean interactionPossible(Robot robot) {
		return true;
	};

	
	//Le téléporteur 'disparaît' quand il est ramassé(représentation devient espace vide)«aaaaaaaaaaaaaaaaaaaaa
	/**
	 * L'interaction entre le téléporteur et le Robot.
	 * Quand il est ramassé, le téléporteur disparaît de la Grille et modifie le statut du Robot.
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
