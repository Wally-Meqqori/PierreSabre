package personnages;

public class Humain {
	private static final int CONNAISSANCES = 30;
	protected String nom;
	protected String boissonFavorite;
	protected int argent;
	private int indiceFinConnaissances = 0;
	private Humain[] connaissances = new Humain[Humain.CONNAISSANCES];
	
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
	
	public final Humain[] connaissances() {
		return this.connaissances;
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
	
	public void repondre(Humain autreHumain) {
		this.direBonjour();
		this.memoriser(autreHumain);
	}
	
	public void faireConnaissanceAvec(Humain autreHumain) {
		this.direBonjour();
		autreHumain.repondre(this);
		this.memoriser(autreHumain);
		
	}
	
	protected void memoriser(Humain humain) {
		final int nbConnaissancesMax = this.connaissances().length;
		
		this.connaissances[this.indiceFinConnaissances] = humain;
		this.indiceFinConnaissances = (this.indiceFinConnaissances + 1) % nbConnaissancesMax;
	}
	
	public void listerConnaissance() {
		StringBuilder string = new StringBuilder();
		string.append("Je connais beaucoup de monde dont : ");
		for(int i = 0;i< connaissances.length;i++) {
			if(connaissances[i] != null) {
				string.append(connaissances[i].nom);
				for(int j = i;j <= i;j+= 1) {
					string.append(", ");
				}
			}
		}
		
		this.parler(string.toString());
	}
}
