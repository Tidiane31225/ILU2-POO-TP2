package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if (controlPrendreEtal.verifierIdentite(nomVendeur)==false) {
			System.out.println("Désolée "+ nomVendeur +" mais il faut être un habitant de notre village pour commencer ici.");
		}else {
			System.out.println("Bonjour "+ nomVendeur+", je vais regarder si je peux vous trouver un étal.");
			if((controlPrendreEtal.resteEtals())==false) {
				System.out.println("Désolée "+nomVendeur+"je n'ai plus d'étal qui ne soit pas déjà ocupé.");
			}else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		
		System.out.println("C'est parfait, il me reste un étal pour vous !");
		System.out.println("Il me faudrait quelque renseignements.");
        int numEtal = -1;
        String nomProduit = demanderProduit();
        int quantiteProduit = demanderQuantite();
        numEtal =controlPrendreEtal.prendreEtal(nomVendeur, nomProduit, quantiteProduit);
		System.out.println("Le vendeur "+nomVendeur+" s'est installé à l'etal n°"+numEtal+".");

	}
	
	 private String demanderProduit() {
	        System.out.println("Quel produit souhaitez-vous vendre ?");
	        return Clavier.entrerClavierString();
	    }
	 
	 private int demanderQuantite() {
		 StringBuilder question = new StringBuilder();
	        question.append("Combien souhaitez-vous en vendre ?");
	        return Clavier.entrerEntier(question.toString());
	    }

}
