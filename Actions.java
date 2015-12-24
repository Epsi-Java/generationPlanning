package fr.epsi.app;
import fr.epsi.model.*;

/* Regroupe les fonctions principales de l'application qui ne concernent pas directement une classe
 * Calculer Cout repas
 * Calculer quantite repas
 * calculer nb_intervenant 
 * génération planning etc...
*/
public class Actions {
	
	public static double CalculerCoutTotal(double quantite_totale_viande, double quantite_totale_poisson, double quantite_totale_fourrage, double quantite_totale_graines){
		double cout_total_viande = quantite_totale_viande*5;
		double cout_total_poisson = quantite_totale_poisson*7;
		double cout_total_fourrage = quantite_totale_fourrage;
		double cout_total_graines = quantite_totale_graines*4;
		
		double cout_total = cout_total_viande + cout_total_poisson + cout_total_fourrage + cout_total_graines;
		
		return cout_total;
	}
	
	public static double CalculerIntervenantMatin(String frequence_repas, int duree_nourrir, String jour, Boolean impair){
		double duree_totale_matin = 0;
		double nb_intervenant_matin = 0;
		for (int nb_cages = 0; nb_cages < 17; nb_cages++){
			if (frequence_repas == "Chaque matin" || frequence_repas == "Chaque matin et soir" || frequence_repas == "Une fois par semaine" || frequence_repas == "Matin, midi et soir" || frequence_repas == "Une fois tous les deux matins" || frequence_repas == "Deux matins par semaine"){
				//crocodiles => tous les lundis
				if (frequence_repas == "Une fois par semaine" && jour == "Lundi"){
					duree_totale_matin += 60;
				}
				// perroquets => tous les 2 matins
				else if (frequence_repas == "Une fois tous les deux matins" && impair == true){
					duree_totale_matin += 10;
				}
				// tigres => mardi et vendredi
				else if (frequence_repas == "Deux matins par semaine" && (jour == "Mardi" || jour =="Vendredi")){
					duree_totale_matin += 45;
				}
				// les autres du matin
				else{
					duree_totale_matin += duree_nourrir;
				}
			}
		}
		nb_intervenant_matin = duree_totale_matin / 120;
		return Math.ceil(nb_intervenant_matin);
	}
	
	public static double CalculerIntervenantSoir(String frequence_repas, int duree_nourrir, String jour, Boolean impair){
		double duree_totale_soir = 0;
		double nb_intervenant_soir = 0;
		for (int nb_cages = 0; nb_cages < 17; nb_cages++){
			if (frequence_repas == "Chaque soir" || frequence_repas == "Chaque matin et soir" || frequence_repas == "Tous les deux soirs" || frequence_repas == "Matin, midi et soir"){
				//lions => tous les 2 soirs
				if (frequence_repas == "Tous les deux soirs" && impair == true){
					duree_totale_soir += 15;
				}
				// les autres du matin
				else{
					duree_totale_soir += duree_nourrir;
				}
			}
		}
		nb_intervenant_soir = duree_totale_soir / 120;
		return Math.ceil(nb_intervenant_soir);
	}
}
