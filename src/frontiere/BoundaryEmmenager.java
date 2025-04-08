package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
    private ControlEmmenager controlEmmenager;

    public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
        this.controlEmmenager = controlEmmenager;
    }

    public void emmenager(String nomVisiteur) {
        if (controlEmmenager.isHabitant(nomVisiteur)) {
            System.out.println("Mais vous êtes déjà un habitant du village !");
        } else {
            StringBuilder question = new StringBuilder();
            question.append("Êtes-vous :\n");
            question.append("1 - un druide.\n");
            question.append("2 - un gaulois.\n");
            int choixUtilisateur = -1;
            do {
                choixUtilisateur = Clavier.entrerEntier(question.toString());
                switch (choixUtilisateur) {
                    case 1:
                        emmenagerDruide(nomVisiteur);
                        break;

                    case 2:
                        emmenagerGaulois(nomVisiteur);
                        break;

                    default:
                        System.out.println("Vous devez choisir le chiffre 1 ou 2 !");
                        break;
                }
            } while (choixUtilisateur != 1 && choixUtilisateur != 2);
        }
    }
    
    public boolean isHabitant(String nom) {
        return controlEmmenager.isHabitant(nom);
    }

    private void emmenagerDruide(String nomVisiteur) {
        System.out.println("Bienvenue druide " + nomVisiteur);

        // Demande de la force du druide
        StringBuilder question1 = new StringBuilder("Quelle est votre force ?\n");
        int force = Clavier.entrerEntier(question1.toString());

        // Demande des effets de potions min et max, avec validation de l'ordre
        StringBuilder question2 = new StringBuilder("Quelle est la force de potion plus faible que vous produisez ?\n");
        int effetPotionMin = Clavier.entrerEntier(question2.toString());

        StringBuilder question3 = new StringBuilder("Quelle est la force de potion plus forte que vous produisez ?\n");
        int effetPotionMax;
        do {
            effetPotionMax = Clavier.entrerEntier(question3.toString());
            if (effetPotionMax < effetPotionMin) {
                System.out.println("L'effet maximum doit être supérieur ou égal à l'effet minimum !");
            }
        } while (effetPotionMax < effetPotionMin);

        System.out.println("Le druide " + nomVisiteur + 
                           " : « Bonjour, je suis le druide " + nomVisiteur + 
                           " et ma potion peut aller d'une force de " + effetPotionMin + " à " + effetPotionMax + ".»\n");
        controlEmmenager.ajouterDruide(nomVisiteur,force,effetPotionMin,effetPotionMax);
    }


    private void emmenagerGaulois(String nomVisiteur) {
        System.out.println("Bienvenue villageois " + nomVisiteur + ".\n");

        // Demande de la force du gaulois
        StringBuilder question = new StringBuilder();
        question.append("Quelle est votre force ?\n");
        int force = Clavier.entrerEntier(question.toString());

        System.out.println("Bienvenue Gaulois " + nomVisiteur + "! Votre force est " + force + ".\n");
        controlEmmenager.ajouterGaulois(nomVisiteur, force);
    }
}
