package application;
/*Robert Liu 865826
 * */
public class NonKitten extends Case{

	//Les deux attributs des objets Non-Kitten sont obtenus � l'aide de deux m�thodes random de la classe parent.
	protected String image = getRandomImg();
	public String phrase = randomSentences();
	
	@Override
	public boolean interactionPossible(Robot robot) {
		return true;
	};

		
	//Le NonKitten demeure sur la carte
	public void interagir(Robot robot){
		//return image;
	};
}
