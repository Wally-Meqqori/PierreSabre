package personnages;

import java.util.Random;

public class Traitre extends Samourai {

	private int niveauTraitrise = 0;
	
	//
	
	public Traitre(String seigneur, String nom, String boissonFavorite, int argent) {
		super(seigneur, nom, boissonFavorite, argent);
	}
	
	//	
	
	@Override
	public void direBonjour() {
		super.direBonjour();
		this.parler("Mais je suis un tra�tre et mon niveau de tra�trise est : " + this.niveauTraitrise + ". Chut !");
	}
	
	public void ranconner(Commercant commercant) {
		if(this.niveauTraitrise < 3) {
			int rancon = (commercant.getArgent() * 2 / 10);
			
			this.parler("Si tu veux ma protection contre les Yakuzas, il va falloir payer ! Donne-moi " + rancon + " sous ou gare � toi !");
			commercant.parler("Tout de suite grand " + this.getNom() + ".");
			
			this.perdreArgent(rancon);
			this.gagnerArgent(rancon);
			
			this.niveauTraitrise++;
		}
		else { this.parler("Mince je ne peux plus ran�onner personne sinon un samoura� risque de me d�masquer !"); }
	}
	
	public void faireLeGentil() {
		if(this.connaissances().length > 0) {
			int don = this.getArgent() / 20;
			int nombreAleatoire = (int)(Math.random() * (this.connaissances().length)) ;
			Humain ami = this.connaissances()[1];
			this.memoriser(ami);
			this.parler("Il faut absolument remonter ma cote de confiance. Je vais faire ami ami avec " + ami.getNom() + ".");
			this.parler("Bonjour l'ami ! Je voudrais vous aider en vous donnant " + don + " sous.");
			
			this.perdreArgent(don);
			ami.gagnerArgent(don);
			
			this.parler("Merci " + this.getNom() + ". Vous �tes quelqu'un de bien.");
			
			if(this.niveauTraitrise > 1) { this.niveauTraitrise--; }
		}
		else { this.parler("Je ne peux faire ami ami avec personne car je ne connais personne ! Snif."); }
	}
	
}
