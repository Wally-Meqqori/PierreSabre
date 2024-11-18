package personnages;

public class Samourai extends Humain{
	private String nomSeigneur;
	public Samourai(String nomSeigneur,String nom, String boisson, int argent ) {
		super(nom,boisson,argent);
		this.nomSeigneur = nomSeigneur;
	}
	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Je suis fier de servir le seigneur " + this.nomSeigneur);
	}
	public void boire(String boisson) {
		this.parler("Qu'est-ce que je vais choisir comme boisson ? Tiens je vais prendre " + boisson + ".");
	}
}
