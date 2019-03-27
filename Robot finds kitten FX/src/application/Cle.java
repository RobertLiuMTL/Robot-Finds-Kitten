package application;
/*Robert Liu 865826
 * */
public class Cle extends Case{

	//(char)39 = '
	protected char representation = (char)39;
	
	protected String image = "/key.png";
	boolean clefDispo = true;
	protected String phrase = rfkSentences[27];
	
	public String getImg() {
		return this.image;
	}
	
	@Override
	public boolean interactionPossible(Robot robot) {
		return true;
	};
	
	/**
	 * La méthode interagir prend en paramètre le Robot et détermine les interactions avec celui-ci.
	 * La clef disparaît de la carte une fois ramassée et modifie l'état du robot.
	 * 
	 */
	public void interagir(Robot robot){
		representation = ' ';
		if (clefDispo == true) {
			robot.addKeys();
			System.out.println(rfkSentences[27]);
			clefDispo=false;
		}
	}
}
