package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[]infosMarche=controlAfficherMarche.donnerInfosMarche();
	if(infosMarche.length==0) {
		System.out.println("Le marché est vide, revenez plus tard.");
		
	}else {
		System.out.println(nomAcheteur+" vous trouverez au marché: ");
		for(int i=0;i<infosMarche.length;i+=3) {
			String nomVendeur = infosMarche[i];
            String produit = infosMarche[i + 1];
            String quantite = infosMarche[i + 2];
			System.out.println("-"+nomVendeur+" qui vend "+quantite+" "+ produit);
		}
	}
	}
}
