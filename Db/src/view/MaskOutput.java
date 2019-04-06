package view;
import java.sql.SQLException;
import java.util.Scanner;
import model.dao.CRUD;
import model.Giochi;
public class MaskOutput {
	Scanner input = new Scanner(System.in);
	public void aggiungi(Giochi g) {
		System.out.println("Aggiungi gioco/Add game");
		g.setGioco(input.nextLine());
		System.out.println("Aggiungi il prezzo gioco/Add game's price");
		g.setPrezzo(Double.parseDouble(input.nextLine()));
	}

	public void aggiorna(Giochi g) throws SQLException {
		CRUD c = new CRUD();
		c.leggiProdotto(g);
		System.out.println("Sei sicuro di voler aggiornare un prodotto? si or no/Are you sure that you want to update your product? si(yes) or no(no)");
		String scelta = input.nextLine();
		if(scelta.equals("si")) {
			System.out.println("Aggiorna nome gioco/Update game's name");
			g.setGioco(input.nextLine());
			System.out.println("Aggiorna il prezzo/Update game's price");
			g.setPrezzo(Double.parseDouble(input.nextLine()));
			System.out.println("Scegli gioco/Choose the game by Id number");
			g.setId(Integer.parseInt(input.nextLine()));
		}else if(scelta.equals("no")) {
			System.out.println("Processo terminato/Stop");
		}else {
			System.out.println("Tasto sbagliato o combinazione di tasti sbagliati/You typed wrong number or wrong letter");
		}
	}

	public void elimina(Giochi g) throws SQLException {
		CRUD c = new CRUD();
		c.leggiProdotto(g);
		System.out.println("Sei sicuro di voler eliminare un prodotto? si or no/Are you sure that you want to eliminate your product? si(yes) or no(no)");
		String scelta = input.nextLine();
		if(scelta.equals("si")) {
			System.out.println("Elimina gioco/Eliminate game");
			g.setGioco(input.nextLine());
		}else if(scelta.equals("no")) {
			System.out.println("Processo terminato/Stop");
		}else {
			System.out.println("Tasto sbagliato o combinazione di tasti sbagliati/You typed wrong number or wrong letter");
		}
	}

	public void eliminaTutto(Giochi g) throws SQLException {
		CRUD c = new CRUD();
		c.leggiProdotto(g);
		System.out.println("Sei sicuro di voler eliminare tutti i prodotti? si or no/Are you sure that you want to eliminate all your products? si(yes) or no(no)");
		String scelta = input.nextLine();
		if(scelta.equals("si")) {
			c.eliminaProdottiEPulisci(g);
		}else if(scelta.equals("no")) {
			System.out.println("Processo terminato/Stop");
		}else {
			System.out.println("Tasto sbagliato o combinazione di tasti sbagliati/You typed wrong number or wrong letter");
		}
	}

	public void leggi(Giochi g) {
		System.out.println("Giochi presenti/Games available");
		System.out.println("ID -- Prodotto -- Prezzo");
	}
}
