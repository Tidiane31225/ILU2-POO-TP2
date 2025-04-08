package frontiere;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Clavier {
	private static Scanner scan = new Scanner(System.in);


	public static int entrerEntier(String question) {
        boolean entreeCorrecte = false;
        int chiffre = 0;
        do {
            System.out.println(question);
            try {
                chiffre = scan.nextInt();
                scan.nextLine(); // Consommer le retour à la ligne
                if (chiffre > 0) {
                    entreeCorrecte = true;
                } else {
                    System.out.println("Vous devez entrer un chiffre positif !");
                }
            } catch (InputMismatchException e) {
                System.out.println("Vous devez entrer un chiffre positif !");
                scan.nextLine(); // Consommer l'entrée invalide
            }
        } while (!entreeCorrecte);
        return chiffre;
    }
	
	public static String entrerChaine(String question) {
		System.out.println(question);
		return scan.next();
	}

	    public static String entrerClavierString() {
	        return scan.nextLine(); // Lit une ligne complète de texte
	    }
	

}
