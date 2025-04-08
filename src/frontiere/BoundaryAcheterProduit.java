package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;
import villagegaulois.Etal;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		 if (!controlAcheterProduit.verifierIdentite(nomAcheteur)) {
	            System.out.println("Désolé, seuls les habitants du village peuvent acheter au marché.");
	            return;
	        }
		 System.out.println(nomAcheteur + ", quel produit voulez-vous acheter ?");
	        String produit = Clavier.entrerClavierString();

	        // Rechercher les étals proposant ce produit
	        Etal[] etals = controlAcheterProduit.rechercherEtalsProduit(produit);
	        if (etals == null || etals.length == 0) {
	            System.out.println("Désolé, aucun vendeur ne propose ce produit au marché.");
	            return;
	        }
	        
	        System.out.println("Voici les vendeurs proposant " + produit + " :");
	        for (int i = 0; i < etals.length; i++) {
	            System.out.println((i + 1) + " - " + etals[i].getVendeur().getNom() +
	                               " vend " + produit + " (Quantité disponible : " + etals[i].getQuantite() + ")");
	        }
	        System.out.println("Entrez le numéro du vendeur avec qui vous souhaitez traiter :");
	        int choix = Clavier.entrerEntier("Choisissez un vendeur :") - 1;

	        if (choix < 0 || choix >= etals.length) {
	            System.out.println("Choix invalide. Retour au menu principal.");
	            return;
	        }

	        // Demander la quantité à acheter
	        Etal etalChoisi = etals[choix];
	        System.out.println("Combien de " + produit + " souhaitez-vous acheter ?");
	        int quantite = Clavier.entrerEntier("Entrez la quantité :");

	        // Procéder à l'achat
	        int quantiteAchetee = controlAcheterProduit.acheterProduit(etalChoisi, quantite);
	        System.out.println("Vous avez acheté " + quantiteAchetee + " " + produit +
	                           " auprès de " + etalChoisi.getVendeur().getNom() + ".");
	    
	}
}
