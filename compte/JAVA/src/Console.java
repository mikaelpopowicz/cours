import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Console {
	/**
	 * Cette classe permet de saisir des donn�e selon leur type � la place de la classe Scanner
	 */

	static BufferedReader entree = new BufferedReader(new InputStreamReader(System.in));
	
	/**
	 * Cette m�thode permet de saisir un entier
	 * Elle convertit une chaine de caract�re en un entier
	 * @return int nb  
	 */
	public static int saisirInt() {
		int nb = 0;
		String chaine = "";
		boolean ok;
		do {
			ok = true;
			try {
				chaine = entree.readLine();
				nb = Integer.parseInt(chaine);
			} catch (IOException e) {
				ok = false;
				System.out.println("Erreur de lecture sur le clavier");
			} catch (NumberFormatException e) {
				System.out.println("Erreur de format du nombre entr�e");
				ok = false;
			}
		} while (ok==false);
		return nb;
	}
	
	/**
	 * Cette m�thode permet de saisir un d�cimal
	 * Elle convertit une chaine de caract�re en un d�cimal
	 * @return float nb
	 */
	public static float saisirFloat() {
		float nb = 0;
		String chaine = "";
		boolean ok;
		do {
			ok = true;
			try {
				chaine = entree.readLine();
				nb = Float.parseFloat(chaine);
			} catch (IOException e) {
				ok = false;
				System.out.println("Erreur de lecture sur le clavier");
			} catch (NumberFormatException e) {
				System.out.println("Erreur de format du nombre entr�e");
				ok = false;
			}
		} while (ok==false);
		return nb;
	}
	
	/**
	 * Cette m�thode permet de saisir une chaine de carat�re
	 * @return String chaine
	 */
	public static String saisirString() {
		String chaine = "";
		try {
			chaine = entree.readLine();
		} catch (IOException e) {
			System.out.println("Erreur de lecture sur le clavier");
		}
		return chaine;
	}
	
	/**
	 * @return char premier caract�re de chaine
	 */
	public static char saisirChar() {
		String chaine = "";
		try {
			chaine = entree.readLine();
		} catch (IOException e) {
			System.out.println("Erreur de lecture sur le clavier");
		}
		return chaine.charAt(0);
	}
}
