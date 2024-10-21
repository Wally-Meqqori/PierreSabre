package personnages;

public class Humain {
	protected String nom;
	protected String boissonFavorite;
	protected int argent;
	
	public Humain(String nom, String boissonFavorite, int argent) {
		this.nom = nom;
		this.boissonFavorite = boissonFavorite;
		this.argent = argent;
	}
	
	public String prendreParole() {
		return "(" + nom + ") - ";
	}
	
	protected void parler(String texte) {
		System.out.println(prendreParole() + texte );
	}
	
	public void direBonjour() {
		parler("Bonjour ! Je m'appelle " + this.nom + " et j'aime boire du "+ this.boissonFavorite);
	}
	
	public void boire() {
		parler( "Mmmm, un bon verre de " + boissonFavorite + "! GLOUPS !");
	}
	
	public void acheter(String bien, int prix) {
		if (this.argent > prix){
			if(bien == "boisson") {
				parler("J'ai "+ argent + " sous en poche. Je vais pouvoir m'offrir une boisson à "+ prix + " sous.");
				parler("Mmmm, un bon verre de " + this.boissonFavorite + "! GLOUPS !");
			}
			else {
				parler("J'ai "+ argent + " sous en poche. Je vais pouvoir m'offrir un " + bien +" à "+ prix + " sous.");
			}
			argent -= prix;
		}
		else {
			parler("Je n'ai plus que " + argent + " sous en poche. Je ne peux même pas m'offir un "+ bien + " à "+ prix + " sous.");
		}
	}
	
	protected void perdreArgent(int perte) {
		this.argent -= perte;
	}
	
	protected void gagnerArgent(int gain) {
		this.argent += gain;
	}
}
