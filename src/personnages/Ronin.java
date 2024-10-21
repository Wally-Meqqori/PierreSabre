package personnages;

public class Ronin extends Humain{
	private int honneur=1;

	public Ronin(String nom, String boisson, int argent) {
		super(nom,boisson,argent);
	}
	
	public void donner(Commercant beneficiaire) {
		int don = argent/10;
		parler(beneficiaire.nom+" prend ces "+don+" sous.");
		beneficiaire.recevoir(don);
		argent = argent-don;
	}
	
	public void provoquer(Yakuza adversaire) {
		parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre marchand!");
		if ((honneur*2)>=adversaire.getReputation()) {
			parler("Je t’ai eu petit yakuza!");
			honneur++;
			argent += adversaire.perdre();
		} else {
			parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse ont en pris un coup.");
			honneur--;
			adversaire.gagner(argent);
			argent=0;
		}
	}
}