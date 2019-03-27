package application;
/*Robert Liu 865826
 * */
public abstract class Case {
	
	protected char representation;
	/**
	 * Retourne la représentation de la case
	 *
	 * @return la représentation de la case
	 */
	
	//Contient l'adresse de l'image
	protected String image;
	
	//La phrase qui est produite en cas d'interaction
	protected String phrase;
	
	public char getRepresentation() {
		return representation;
	}
	

	
	/**
	 * Retourne la phrase.
	 * @return la phrase.
	 */
	public String getPhrase() {
		return phrase;
	}
	
	/**
	 * Indique si une interaction entre la case et le robot est
	 * possible (ex.: le robot peut interagir avec un NonKittenItem
	 * en tout temps, mais ne peut pas interagir avec un mur, le robot
	 * peut interagir avec une porte seulement s'il possède une clef,
	 * etc.)
	 *
	 * @param robot Le robot qui interagirait avec la case
	 * @return true si une interaction entre le robot et la case est possible
	 */
	public abstract boolean interactionPossible(Robot robot);
	
	
	/**
	 * Interaction entre la case et le robot
	 *
	 * @param robot
	 */
	public abstract void interagir(Robot robot);
	
	
	/**
	 * Génère un symbole aléatoire
	 *
	 * @return Un symbole ASCII compris entre ':' et '-'
	 */
	public static char getRandomSymbole() {
		return (char) (Math.random() * (126 - 58) + 58);
	}
	
	
	/**
	 * Génère un String aléatoire contenant l'adresse d'une image Non-Kitten (1 à 82)
	 * @return
	 */
	public static String getRandomImg() {
		return "/"+(int)(Math.random()*81+1)+".png";
	}
	
	
	//Banque de phrases pour nos objets NonKitten
	String rfkSentences[] = {
			/*0*/"This is a tasty-looking banana creme pie.",
			/*1*/"It’s a business plan for a new startup, kitten.net.",
			/*2*/"An automated robot-liker. It smiles at you.",
			/*3*/"A book with “Don’t Panic” in large friendly letters across the cover.",
			/*4*/"It's Emporer Shaddam the 4th's planet!",
			/*5*/"A discredited cosmology, relic of a bygone era.",
			/*6*/"It seems to be a copy of 'A Tail of Two Kitties'.",
			/*7*/"An aromatherapy candle burns with healing light.",
			/*8*/"Look at that, it's the Crudmobile.",
			/*9*/"The rothe hits! The rothe hits!",
			/*10*/"It's the ASCII Floating Head of Seth David Schoen!",
			/*11*/"It's a free Jon Johansen!",
			/*12*/"It's a business plan for a new startup, kitten.net.",
			/*13*/"A hollow voice says 'Plugh'.",
			/*14*/"A kitten sink, for washing kitten (if only kitten liked water).",
			/*15*/"Here's Pete Peterson. His batteries seem to have long gone dead.",
			/*16*/"It's a hundred-dollar bill.",
			/*17*/"This is a Lagrange point. Don't come too close now.",
			/*18*/"It's a black hole. Don't fall in!",
			/*19*/"A bag of groceries taken off the shelf before the expiration date.",
			/*20*/"You found nettik, but that's backwards.",
			/*21*/"The object pushes back at you.",
			/*22*/"It's the phrase 'and her', written in ancient Greek.",
			/*23*/"A 'Get Out of Jail Free' card.",
			/*24*/"It's a rotten old shoe.",
			/*25*/"A magical... magic thing.",
			/*26*/"That's just an old tin can.",
			/*27*/"Well, it looks like a key",
			/*28*/"It says 'Press T' in Latin"};

	/**
	 * Méthode publique qui sélectionne au hasard une phrase de notre banque de données.
	 * 
	 * @return Retourne sous forme de String une phrase.
	 */
	public String randomSentences () {
		return rfkSentences[(int)(Math.random() * (rfkSentences.length-2))];
	}

}

