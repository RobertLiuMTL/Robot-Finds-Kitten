package application;
/*Robert Liu 865826
 * */
public class Mur extends Case{
	protected char representation = '%';
	protected String image = "/wall.png";

	@Override
	public boolean interactionPossible(Robot robot) {
		return false;
	}
	
	//Aucune interaction n'est possible entre le mur et le Robot. �tant donn� que la m�thode est
	//h�rit�e d'une classe abstraite, il faut l'initialiser. Dans notre cas, il n'y a rien.
	/**
	 * M�thode nulle pour le Mur car aucune interaction n'est possible avec le Robot.
	 */
	public void interagir(Robot robot) {
		
	};


}
