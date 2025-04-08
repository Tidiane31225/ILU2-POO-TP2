package frontiere;

import controleur.ControlAfficherVillage;

public class BoundaryAfficherVillage {
    private ControlAfficherVillage controlAfficherVillage;

    public BoundaryAfficherVillage(ControlAfficherVillage controlAfficherVillage) {
        this.controlAfficherVillage = controlAfficherVillage;
    }

    public void afficherVillage() {
        // Récupération des informations via le contrôleur
        String nomVillage = controlAfficherVillage.donnerNomVillage();
        int nbEtals = controlAfficherVillage.donnerNbEtals();
        String[] villageois = controlAfficherVillage.donnerNomsVillageois();

        // Affichage des informations sur le village
        System.out.println("Bienvenue dans le village des irréductibles dirigé par le chef Abraracourcix.");
        System.out.println("Ce village s'appelle " + nomVillage + ".");
        System.out.println("Il possède un joli marché avec " + nbEtals + " étals mis à disposition des villageois pour vendre leurs produits.");

        // Affichage des habitants
        if (villageois.length > 0) {
            System.out.println("En plus du chef, il y a les habitants suivants :");
            for (String nomVillageois : villageois) {
                System.out.println("- " + nomVillageois);
            }
        } else {
            System.out.println("Pour l'instant, le village ne compte aucun habitant à part le chef.");
        }
    }
}
