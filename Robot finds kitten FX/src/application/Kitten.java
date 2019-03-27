package application;
/*Robert Liu 865826
 * */
public class Kitten extends Case{

	//repr�sentation ASCII al�atoire du chat
	protected char representation = getRandomSymbole();
	protected String image = getRandomImg();


	@Override
	public boolean interactionPossible(Robot robot) {
		return true;
	};
	
	/**
	 * Permet d'obtenir la repr�sentation en caract�re du chat.
	 */
	public char getRepresentation() {
		return representation;
	}
	
	//Une fois le Chat trouv�, il dispara�t de la carte et modifie la bool�ene chat du Robot.
	public void interagir(Robot robot){
		representation = ' ';
		robot.addChat();
	};
}
