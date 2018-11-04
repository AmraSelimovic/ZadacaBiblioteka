import java.util.ArrayList;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Knjiga extends Racun implements Serializable{
	
	private int brojKnjige;
	private String imeKnjige;
	private boolean statusKnjige;
	private int ukupanBrojKnjiga=0;
	 private static File knjige;
	private boolean statusKnjige; //false-izdata, true-slobodna

	protected static ArrayList <Knjiga> listaKnjiga = new ArrayList<Knjiga>();
	
	
	public static void loading () {

		try {
			FileInputStream in = new FileInputStream("listaKnjiga.txt");
			ObjectInputStream oin = new ObjectInputStream(in);

			while (true) 
				listaKnjiga.add((Knjiga)oin.readObject());

		} catch (EOFException ex) {}
		catch (FileNotFoundException e) {knjige = new File ("listaKnjiga.txt");}
		catch (Exception e) {}
	}
	
	
	// konstruktori
	
	public Knjiga() {
		ukupanBrojKnjiga++;
	}
	
	public Knjiga(int brojKnjige, String imeKnjige, boolean statusKnjige) {
		
		if(provjeraPostojanja(brojKnjige)) {
			setBrojKnjige(brojKnjige);
		
			this.imeKnjige = imeKnjige;
			this.statusKnjige = statusKnjige;
			
			listaKnjiga.add(this);

			System.out.println("Knjiga je uspjesno kreirana!");
			ukupanBrojKnjiga++;
			
		}
	}
	
	private boolean provjeraPostojanja(int brojKnjige) {
		
		for (int i = 0; i < listaKnjiga.size(); i++)
			if (listaKnjiga.get(i).brojKnjige == brojKnjige) {
				System.out.println("Unijeti broj knjige vec postoji. Knjiga nije uspjesno kreirana!");
				return false;
			}
		
		return true;
	}
	
	
	
	// geteri


	public int getBrojKnjige() {
		return brojKnjige;
	}
	
	public String getImeKnjige() {
		return imeKnjige;
	}
	
	public boolean isStatusKnjige() {
		return statusKnjige;
	}

	public static Knjiga getKnjiga(int brojKnjige) {
		
		int i = 0;
		
		for (i = 0; i < listaKnjiga.size(); i++)
			if (listaKnjiga.get(i).brojKnjige == brojKnjige)
				return listaKnjiga.get(i);
		
		return null;

	public static boolean stanjeKnjige(int brojKnjige) {
		for (int i = 0; i < listaKnjiga.size(); i++) {
		    if (listaKnjiga.get(i).brojKnjige == brojKnjige) {
		    	if (!listaKnjiga.get(i).isStatusKnjige()) {
		    		return true;
		    	}	
		    }
		}
		return false;
	}

	public static void preuzetaKnjiga(int brojKnjige) { 
		for (int i=0; i<listaKnjiga.size(); i++) {
			if (listaKnjiga.get(i).brojKnjige == brojKnjige) {
				listaKnjiga.get(i).setStatusKnjige(false);;
				System.out.println("Knjiga broj: " + listaKnjiga.get(i).brojKnjige + " je preuzeta.");
			}
		}
	}
	
	public static void vracenaKnjiga(int brojKnjige) {
		for (int i=0; i<listaKnjiga.size(); i++) {
			if (listaKnjiga.get(i).brojKnjige == brojKnjige) {
				listaKnjiga.get(i).setStatusKnjige(true);
				System.out.println("Knjiga broj: " + listaKnjiga.get(i).brojKnjige + " je sada dostupna.");
			}
		}
	}
	
	public int getBrojKnjige() {
		return brojKnjige;
	}

	public void setBrojKnjige(int brojKnjige) {
		this.brojKnjige = brojKnjige;
	}

	public String getImeKnjige() {
		return imeKnjige;
	}

	public void setImeKnjige(String imeKnjige) {
		this.imeKnjige = imeKnjige;
	}

	public boolean isStatusKnjige() {
		return statusKnjige;
	}

	public void setStatusKnjige(boolean statusKnjige) {
		this.statusKnjige = statusKnjige;
	}
	
	// seteri

	public void setBrojKnjige(int brojKnjige) throws IllegalArgumentException {
		if(brojKnjige >= 0) {
			this.brojKnjige = brojKnjige;
		}
		else {
			throw new IllegalArgumentException ("Broj knjige ne moze biti negativan. Knjiga nije uspjesno kreirana!");
		}
	}

	public void setImeKnjige(String imeKnjige) {
		this.imeKnjige = imeKnjige;
	}

	
	public void setStatusKnjige(boolean statusKnjige) {
		this.statusKnjige = statusKnjige;
	}
	
	
	

	
	
}
