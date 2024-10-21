package personnages;

public class Humain {
	private String nom;
	private String boissonFavorite;
	private int argent;
	
	public Humain(String nom, String boissonFavorite, int argent) {
		this.nom = nom;
		this.boissonFavorite = boissonFavorite;
		this.argent = argent;
	}
	
	public String direBonjour() {
		return "Bonjour ! Je m'appelle " + nom + " et j'aime boire du "+ this.boissonFavorite;
	}
	
	public String boire() {
		return "Mmmm, un bon verre de " + boissonFavorite + "! GLOUPS !";
	}
	
	public String prendreParole() {
		return "(" + nom + ") - ";
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + texte);
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
	
}
