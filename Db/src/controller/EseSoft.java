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
			System.out.println("Choose what do you want to do: 1- Add Product, 2 - Update Product, 3 - Delete Product, 4 Delete all the products, 5 - Read");
			int scelta = input.nextInt();
			switch(scelta) {
			case 1: m.aggiungi(g);
			c.inserisciProdotto(g);
			System.out.println("Inserito!");
			System.out.println("Added");
			break;
			case 2: m.aggiorna(g);
			c.aggiornaProdotto(g);
			System.out.println("Aggiornato!");
			System.out.println("Updated");
			break;
			case 3: m.elimina(g);
			c.eliminaProdotto(g);
			System.out.println("Eliminato!");
			System.out.println("Deleted");
			break;
			case 4: m.eliminaTutto(g);
			System.out.println("Eliminati tutti i prodotti!");
			System.out.println("Deleted all the products!");
			break;
			case 5: m.leggi(g);
			c.leggiProdotto(g);
			break;
			default: System.out.println("Non corretto");
							 System.out.println("Not right");
			break;
			}
			System.out.println("Vuoi scegliere altre funzionalit�? si o no");
			System.out.println("Do you want to use other functions? si or no");
			aggiungi = input.next();
			if(aggiungi.equals("si")) {
				lights = true;
			}else if(aggiungi.equals("no")) {
				lights = false;
			}else {
				System.out.println("Scelta non corretta/Wrong");
				lights = false;
			}
		}
	}
}
