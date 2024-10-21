package personnages;

public class Yakuza extends Humain {
	private String clan;
	private int reputation = 0;
	
	public Yakuza(String nom, String boisson, int argent, String clan) {
		super(nom,boisson,argent);
		this.clan = clan;
	}

	public int getReputation() {
		return reputation;
	}
	
	public void extorquer(Commercant victime) {
		parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par là ?");
		parler(victime + ", si tu tiens à la vie donne moi ta bourse !");
		int argentExtorque = victime.seFaireExtorquer();
		this.argent += argentExtorque;
		parler("J'ai piqué les "+ argentExtorque + " sous de "+ victime.nom + ", ce qui me fait " + argent +" sous dans ma poche. Hi hi !");
		this.reputation += 1;
	}
	
	public int perdre(){
		reputation -= 1;
		int perte = argent;
		parler("J’ai perdu mon duel et mes "+perte+" sous, snif... J'ai déshonoré le clan du "+clan+".");
		return perte;
	}
	
	public void gagner(int gain) {
		argent += gain;
		reputation ++;
		parler("Ce ronin pensait vraiment battre "+nom+" du "+clan+" ? Je l'ai dépouillé de ses "+gain+" sous.");
	}
}
