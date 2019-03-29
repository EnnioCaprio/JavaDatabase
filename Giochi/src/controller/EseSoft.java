package controller;
import java.sql.SQLException;
import model.Giochi;
import model.dao.CRUD;
import view.MaskOutput;
import java.util.Scanner;

public class EseSoft {

	public static void main(String[] args) throws SQLException{

		Scanner input = new Scanner(System.in); 
		
		boolean lights = true;

		MaskOutput m = new MaskOutput();

		String aggiungi;
		
		CRUD c = new CRUD();
		
		Giochi g = new Giochi();

		while(lights == true){
			System.out.println("Scegli cosa fare: 1 - Aggiungi Prodotto, 2 - Aggiorna Prodotto, 3 - Elimina Prodotto, 4 - Elimina tutti i prodotti, 5 - Leggi");
			int scelta = input.nextInt();
			switch(scelta) {
			case 1: m.aggiungi(g);
			c.inserisciProdotto(g);
			System.out.println("Inserito!");
			break;
			case 2: m.aggiorna(g);
			c.aggiornaProdotto(g);
			System.out.println("Aggiornato!");
			break;
			case 3: m.elimina(g);
			c.eliminaProdotto(g);
			System.out.println("Eliminato!");
			break;
			case 4: m.eliminaTutto(g);
			System.out.println("Eliminati tutti i prodotti!");
			break;
			case 5: m.leggi(g);
			c.leggiProdotto(g);
			break;
			default: System.out.println("Non corretto");
			break;
			}
			System.out.println("Vuoi scegliere altre funzionalità? si o no");
			aggiungi = input.next();
			if(aggiungi.equals("si")) {
				lights = true;
			}else if(aggiungi.equals("no")) {
				lights = false;
			}else {
				System.out.println("Scelta non corretta");
				lights = false;
			}
		}
	}
}
