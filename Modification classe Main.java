package fr.epsi.app;
import fr.epsi.model.*;
import fr.epsi.app.Actions;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
	
		// Instanciation des objets de la classe Animaux
		Animaux Antilopes = new Animaux("Antilopes",15,25,"Chaque soir", 0,0,2,0);
		Animaux Chimpanzes = new Animaux("Chimpanzés",9,20,"Chaque matin et soir", 0.1,0.1,0,0.2);
		Animaux Crocodile = new Animaux("Crocodiles",2,60,"Une fois par semaine", 20,0,0,0);
		Animaux Elephant = new Animaux("Eléphants",3,45,"Chaque matin", 0,0,70,0);
		Animaux FlamantRose = new Animaux("Flamants Roses",21,20,"Chaque soir", 0,0,0,1);
		Animaux Guepard = new Animaux("Guépards",1,10,"Chaque soir", 15,0,0,0);
		Animaux Girafe = new Animaux("Girafes",6,25,"Chaque matin", 0,0,30,0);
		Animaux Otarie = new Animaux("Otaries",12,30,"Chaque matin et soir", 0,6,0,0);
		Animaux Lion = new Animaux("Lions",3,15,"Tous les deux soirs", 40,0,0,0);
		Animaux Ouistiti = new Animaux("Ouistitis",11,20,"Chaque matin et soir", 0,0.2,0,0.2);
		Animaux Ours = new Animaux("Ours",3,45,"Chaque soir", 10,10,0,0);
		Animaux Panda = new Animaux("Pandas",2,15,"Matin, midi et soir", 0,0,25,0);
		Animaux Perroquets = new Animaux("Perroquets",6,10,"Une fois tous les deux matins", 0,0,0,0.3);
		Animaux PorcEpic = new Animaux("Porc-épics",10,10,"Chaque soir", 0,0,0.5,0.15);
		Animaux Tigre = new Animaux("Tigres",4,45,"Deux matins par semaine", 80,0,0,0);
		Animaux Tortue = new Animaux("Tortues",20,15,"Chaque soir", 0,0,0,0.15);
		Animaux Zebre = new Animaux("Zèbres",7,25,"Chaque matin et soir", 0,0,5,0);
		
		// Instanciation des objets de la classe Intervenants
		Intervenants Patrick = new Intervenants("Suez", "Patrick");
		Intervenants John = new Intervenants("Kramer", "John");
		Intervenants Claude = new Intervenants("Bourgelat", "Claude");
		
		// Calcul quantite totale par type de nourriture : on doit le faire ici car on utilise des objets instanciés dans le main
		double quantite_totale_viande = (Chimpanzes.getQuantiteViande()*Chimpanzes.getNombreAnimaux()) + (Crocodile.getQuantiteViande()*Crocodile.getNombreAnimaux()) + (Guepard.getQuantiteViande()*Guepard.getNombreAnimaux()) + (Lion.getQuantiteViande()*Lion.getNombreAnimaux()) + (Ours.getQuantiteViande()*Ours.getNombreAnimaux()) + (Tigre.getQuantiteViande()*Tigre.getNombreAnimaux());
		double quantite_totale_poisson = (Chimpanzes.getQuantitePoisson()*Chimpanzes.getNombreAnimaux()) + (Otarie.getQuantitePoisson()*Otarie.getNombreAnimaux()) + (Ouistiti.getQuantitePoisson()*Ouistiti.getNombreAnimaux()) + (Ours.getQuantitePoisson()*Ours.getNombreAnimaux());
		double quantite_totale_fourrage = (Antilopes.getQuantiteFourrage()*Antilopes.getNombreAnimaux()) + (Elephant.getQuantiteFourrage()*Elephant.getNombreAnimaux()) + (Girafe.getQuantiteFourrage()*Girafe.getNombreAnimaux()) + (Panda.getQuantiteFourrage()*Panda.getNombreAnimaux()) + (PorcEpic.getQuantiteFourrage()*PorcEpic.getNombreAnimaux()) + (Zebre.getQuantiteFourrage()*Zebre.getNombreAnimaux());
		double quantite_totale_graines = (Chimpanzes.getQuantiteGraines()*Chimpanzes.getNombreAnimaux()) + (FlamantRose.getQuantiteGraines()*FlamantRose.getNombreAnimaux()) + (Ouistiti.getQuantiteGraines()*Ouistiti.getNombreAnimaux()) + (Perroquets.getQuantiteGraines()*Perroquets.getNombreAnimaux()) + (PorcEpic.getQuantiteGraines()*PorcEpic.getNombreAnimaux()) + (Tortue.getQuantiteGraines()*Tortue.getNombreAnimaux());
		
		// On utilise la fonction dans Actions pour calculer le cout total de la nourriture
		double cout_total = Actions.CalculerCoutTotal(quantite_totale_viande, quantite_totale_poisson, quantite_totale_fourrage, quantite_totale_graines);
		
		// déclaration des variables utilisées pour le calcul du nombre d'intervenants
		// Attention j'ai du modifier 2 truc dans Animaux.java ! (static)
		String frequence_repas = Animaux.getFrequencerepas();
		int duree_nourrir = Animaux.getDureeRepas();
		
		//Generation fichier
		File generationPlanning = new File("Génération Planning.txt");
		generationPlanning.createNewFile();
		
		// On test si la création a été réussie
		  if (!generationPlanning.exists()) { 
		      System.out.println("le fichier n'existe pas");
		      System.exit(1);
		    }      
		   
		  // On écrit dans le fichier
		  FileWriter planningWrite = new FileWriter(generationPlanning);
		  
		  // On écrit la quantité de viande totale
		  planningWrite.write("Viande : "+quantite_totale_viande+"kg");
		  planningWrite.write ("\r\n\r\n"); 
		  
		  // On écrit la quantité de poisson totale
		  planningWrite.write("Poisson : "+quantite_totale_poisson+"kg");
		  planningWrite.write ("\r\n\r\n"); 
		  
		  // On écrit la quantité de fourrage totale
		  planningWrite.write("Fourrage : "+quantite_totale_fourrage+"kg");
		  planningWrite.write ("\r\n\r\n"); 
		  
		  // On écrit la quantité de graines totale
		  planningWrite.write("Graines : "+quantite_totale_graines+"kg");
		  planningWrite.write ("\r\n\r\n");
		  
		  // On écrit le cout total en euro de la nourriture
		  planningWrite.write("Cout total : "+cout_total+"€");
		  planningWrite.write ("\r\n\r\n"); 
		  
		  // On arrête l'écriture et on enregistre les modifications
		  planningWrite.close(); 
		  
		  // On affiche les messages consoles au cas ou y'a un pb pour savoir ou se trouve le fichier généré
		    System.out.println(" Nom du fichier    : "+generationPlanning.getName());
		    System.out.println(" Chemin du fichier : "+generationPlanning.getPath());
		    System.out.println(" Chemin absolu     : "+generationPlanning.getAbsolutePath());
	}

}
