import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Console {
        /**
         * Cette classe permet de saisir des donnee selon leur type a la place de la classe Scanner
         */

        static BufferedReader entree = new BufferedReader(new InputStreamReader(System.in));
        
        /**
         * Cette mŽthode permet de saisir un entier
         * Elle convertit une chaine de caractre en un entier
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
                                System.out.println("Erreur de format du nombre entrŽe");
                                ok = false;
                        }
                } while (ok==false);
                return nb;
        }
        
        /**
         * Cette mŽthode permet de saisir un dŽcimal
         * Elle convertit une chaine de caractre en un dŽcimal
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
                                System.out.println("Erreur de format du nombre entrŽe");
                                ok = false;
                        }
                } while (ok==false);
                return nb;
        }
        
        public static double saisirDouble() {
            double nb = 0;
            String chaine = "";
            boolean ok;
            do {
                    ok = true;
                    try {
                            chaine = entree.readLine();
                            nb = Double.parseDouble(chaine);
                    } catch (IOException e) {
                            ok = false;
                            System.out.println("Erreur de lecture sur le clavier");
                    } catch (NumberFormatException e) {
                            System.out.println("Erreur de format du nombre entré");
                            ok = false;
                    }
            } while (ok==false);
            return nb;
    }
        
        /**
         * Cette mŽthode permet de saisir une chaine de caratre
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
         * @return char premier caractre de chaine
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