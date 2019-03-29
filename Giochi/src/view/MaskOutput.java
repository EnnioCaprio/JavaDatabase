package view;
import java.sql.SQLException;
import java.util.Scanner;
import model.dao.CRUD;
import model.Giochi;
public class MaskOutput {
	Scanner input = new Scanner(System.in);
	public void aggiungi(Giochi g) {
		System.out.println("Aggiungi gioco");
		g.setGioco(input.nextLine());
		System.out.println("Aggiungi il prezzo gioco");
		g.setPrezzo(Double.parseDouble(input.nextLine()));
	}

	public void aggiorna(Giochi g) throws SQLException {
		CRUD c = new CRUD();
		c.leggiProdotto(g);
		System.out.println("Sei sicuro di voler aggiornare un prodotto? si or no");
		String scelta = input.nextLine();
		if(scelta.equals("si")) {
			System.out.println("Aggiorna nome gioco");
			g.setGioco(input.nextLine());
			System.out.println("Aggiorna il prezzo");
			g.setPrezzo(Double.parseDouble(input.nextLine()));
			System.out.println("Scegli gioco");
			g.setId(Integer.parseInt(input.nextLine()));
		}else if(scelta.equals("no")) {
			System.out.println("Processo terminato");
		}else {
			System.out.println("Tasto sbagliato o combinazione di tasti sbagliati");
		}
	}

	public void elimina(Giochi g) throws SQLException {
		CRUD c = new CRUD();
		c.leggiProdotto(g);
		System.out.println("Sei sicuro di voler eliminare un prodotto? si or no");
		String scelta = input.nextLine();
		if(scelta.equals("si")) {
			System.out.println("Elimina gioco");
			g.setGioco(input.nextLine());
		}else if(scelta.equals("no")) {
			System.out.println("Processo terminato");
		}else {
			System.out.println("Tasto sbagliato");
		}
	}
	
	public void eliminaTutto(Giochi g) throws SQLException {
		CRUD c = new CRUD();
		c.leggiProdotto(g);
		System.out.println("Sei sicuro di voler eliminare tutti i prodotti? si or no");
		String scelta = input.nextLine();
		if(scelta.equals("si")) {
			c.eliminaProdottiEPulisci(g);
		}else if(scelta.equals("no")) {
			System.out.println("Processo terminato");
		}else {
			System.out.println("Tasto sbagliato");
		}
	}
	
	public void leggi(Giochi g) {
		System.out.println("Giochi presenti");
		System.out.println("ID -- Prodotto -- Prezzo");
	}
}
