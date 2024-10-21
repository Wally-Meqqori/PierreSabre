package personnages;


public class Commercant extends Humain {
	
	public Commercant(String nom, int argent) {
		super(nom,"Thé",argent);
	}
	
	public int seFaireExtorquer() {
		parler("J'ai tout perdu ! Le monde est trop injuste !");
		int argentPerdu = argent;
		perdreArgent(argent);
		return argentPerdu;
	}
	
	public void recevoir(int argent) {
		parler(argent + " sous  ! Je te remercie généreux donateur ! ");
		gagnerArgent(argent); 
	}
}
