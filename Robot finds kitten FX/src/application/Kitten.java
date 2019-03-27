package application;
/*Robert Liu 865826
 * */
public class Kitten extends Case{

	//représentation ASCII aléatoire du chat
	protected char representation = getRandomSymbole();
	protected String image = getRandomImg();


	@Override
	public boolean interactionPossible(Robot robot) {
		return true;
	};
	
	/**
	 * Permet d'obtenir la représentation en caractère du chat.
	 */
	public char getRepresentation() {
		return representation;
	}
	
	//Une fois le Chat trouvé, il disparaît de la carte et modifie la booléene chat du Robot.
	public void interagir(Robot robot){
		representation = ' ';
		robot.addChat();
	};
}
