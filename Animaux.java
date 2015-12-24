package fr.epsi.model;

public class Animaux {
	
	// Déclaration des attributs de la clase
	
	protected String nom_animal; // le nom de l'animal est repris dans les autres classes, pour l'instant c'est ce que sert d'id j'ai trouvé ça plus pratique je sais pas trop si c'est utile...
	protected int nb_animaux;
	protected static int duree_nourrir;
	protected static String frequence_repas; // "Chaque soir", "Chaque matin" etc... On doit faire une fonction pour calculer la fréquence. Cette fonction est déjà construite en php dans le fichier java.php
	protected double quantite_viande;
	protected double quantite_poisson;
	protected double quantite_fourrage;
	protected double quantite_graines;
	protected int fr_jour; // frequence sous forme d'int pour pouvoir s'en servir pour le planning
	
	
	// Constructeur de la classe Animaux
	public Animaux(String pNom_animal, int pNb_animaux, int pDuree_nourrir, String pFrequence_repas, double pQuantite_viande, double pQuantite_poisson, double pQuantite_fourrage, double pQuantite_graines){
		nom_animal = pNom_animal;
		nb_animaux = pNb_animaux;
		duree_nourrir = pDuree_nourrir;	
		quantite_viande = pQuantite_viande;
		quantite_poisson = pQuantite_poisson;
		quantite_fourrage = pQuantite_fourrage;
		quantite_graines = pQuantite_graines;
	 		
	 		switch(pFrequence_repas){
	 		case "Chaque matin et soir":
	 			fr_jour = 2;
	 			break;
	 		case "Chaque matin":
	 			fr_jour = 1;
	 			break;
	 		case "Chaque soir":
	 			fr_jour = 1;
	 			break;
	 		case "Matin, midi et soir":
	 			fr_jour = 3;
	 			break;
	 		case "Une fois par semaine":
	 			fr_jour = 1;
	 			break;
	 		case "Tous les deux soirs":
	 			fr_jour = 1;
	 			break;
	 		case "Une fois tous les deux matins":
	 			fr_jour = 1;
	 			break;
	 		case "Deux matins par semaine":
	 			fr_jour = 1;
	  			break;
	  		default:
	  			fr_jour = 0;
	  		
	  	}
		frequence_repas = pFrequence_repas; 
	}
	
	// Méthodes de la Classe permettant d'accéder au valeur des attributs
	public String getNomAnimal()
	{
		return nom_animal;
	}
	
	public int getNombreAnimaux()
	{
		return nb_animaux;
	}
	
	public static int getDureeRepas()
	{
		return duree_nourrir;
	}
	
	public static String getFrequencerepas()
	{
		return  frequence_repas;
	}
	
	public double getQuantiteViande()
	{
		return  quantite_viande;
	}
	
	public double getQuantitePoisson()
	{
		return  quantite_poisson;
	}
	
	public double getQuantiteFourrage()
	{
		return  quantite_fourrage;
	}
	
	public double getQuantiteGraines()
	{
		return  quantite_graines;
	}
	
	public int getFrJour() {
		return fr_jour;
	}

}
