package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		if(controlLibererEtal.isVendeur(nomVendeur)==false) {
			System.out.println("Mais vous n'êtes pas incrit sur le marché aujourd'hui !");
			
		}else {
			String[] donnesEtal=controlLibererEtal.libererEtal(nomVendeur);
			if(donnesEtal[0]=="true") {
				System.out.println("Vous avez vendu "+ donnesEtal[4]+
						" sur "+donnesEtal[3]+" "+donnesEtal[2]+".");
				System.out.println("Au revoir "+nomVendeur+" passez une bonne journée.");
			}
		}
		
	}

}
