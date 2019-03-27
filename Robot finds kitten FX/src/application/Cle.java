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
	 * La m�thode interagir prend en param�tre le Robot et d�termine les interactions avec celui-ci.
	 * La clef dispara�t de la carte une fois ramass�e et modifie l'�tat du robot.
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
