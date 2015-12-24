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
		// On doit instancier ici les autres animaux dans l'ordre de la doc'
		
		// Instanciation des objets de la classe Intervenants
		Intervenants Patrick = new Intervenants("Suez", "Patrick");
		
		// Calcul quantite totale par type de nourriture : on doit le faire ici car on utilise des objets instanciés dans le main
		// On enlève les commentaires au fur et à mesure qu'on a instancié les autres animaux
		double quantite_totale_viande = (Chimpanzes.getQuantiteViande()*Chimpanzes.getNombreAnimaux());// + (Crocodile.getQuantiteViande()*Crocodile.getNombreAnimaux()) + (Guepard.getQuantiteViande()*Guepard.getNombreAnimaux()) + (Lion.getQuantiteViande()*Lion.getNombreAnimaux()) + (Ours.getQuantiteViande()*Ours.getNombreAnimaux()) + (Tigre.getQuantiteViande()*Tigre.getNombreAnimaux());
		double quantite_totale_poisson = (Chimpanzes.getQuantitePoisson()*Chimpanzes.getNombreAnimaux()); //+ (Otarie.getQuantitePoisson()*Otarie.getNombreAnimaux()) + (Ouistiti.getQuantitePoisson()*Ouistiti.getNombreAnimaux()) + (Ours.getQuantitePoisson()*Ours.getNombreAnimaux());
		double quantite_totale_fourrage = (Antilopes.getQuantiteFourrage()*Antilopes.getNombreAnimaux());// + (Elephant.getQuantiteFourrage()*Elephant.getNombreAnimaux()) + (Girafe.getQuantiteFourrage()*Girafe.getNombreAnimaux()) + (Panda.getQuantiteFourrage()*Panda.getNombreAnimaux()) + (PorcEpic.getQuantiteFourrage()*PorcEpic.getNombreAnimaux()) + (Zebre.getQuantiteFourrage()*Zebre.getNombreAnimaux());
		double quantite_totale_graines = (Chimpanzes.getQuantiteGraines()*Chimpanzes.getNombreAnimaux()); //+ (FlamantRose.getQuantiteGraines()*FlamantRose.getNombreAnimaux()) + (Ouistiti.getQuantiteGraines()*Ouistiti.getNombreAnimaux()) + (Perroquets.getQuantiteGraines()*Perroquets.getNombreAnimaux()) + (PorcEpic.getQuantiteGraines()*PorcEpic.getNombreAnimaux()) + (Tortue.getQuantiteGraines()*Tortue.getNombreAnimaux());
		
		// On utilise la fonction dans Actions pour calculer le cout total de la nourriture
		double cout_total = Actions.CalculerCoutTotal(quantite_totale_viande, quantite_totale_poisson, quantite_totale_fourrage, quantite_totale_graines);
		
		
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
