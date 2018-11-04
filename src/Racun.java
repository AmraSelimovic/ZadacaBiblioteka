import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.Serializable;

public class Racun implements Serializable{
	
	private int brojRacuna;
	private String imeMusterije;
	private int brojPosudjenihKnjiga;
	private static int ukupanBrojRacuna=0;
	private static File racuni;
	protected static ArrayList <Racun> listaRacuna = new ArrayList<Racun>();
	
	public static void loading () {

		try {
			FileInputStream in = new FileInputStream("listaRacuna.txt");
			ObjectInputStream oin = new ObjectInputStream(in);

			while (true) 
				listaRacuna.add((Racun)oin.readObject());


		} catch (EOFException ex) {}
		catch (FileNotFoundException e) {racuni = new File ("listaRacuna.txt");}
		catch (Exception e) {}
	}


	
	//konstruktori
	
	public Racun() {
		ukupanBrojRacuna++;
	}
	
	public Racun(int brojRacuna, String imeMusterije, int brojPosudjenihKnjiga) throws IOException {
		if(provjeraPostojanja(brojRacuna)) {
			setBrojRacuna(brojRacuna);
		
			this.imeMusterije = imeMusterije;
			this.brojPosudjenihKnjiga = brojPosudjenihKnjiga;
			
			listaRacuna.add(this);
			
			System.out.println("Racun je uspjesno kreiran!");
			//System.out.println("Broj racuna: " + getBrojRacuna());
			//System.out.println("Ime musterije: " + getImeMusterije());
			//System.out.println("Broj posudjenih knjiga: " + getBrojPosudjenihKnjiga());
		}
	}
	
	private boolean provjeraPostojanja(int brojRacuna) {
		
		for (int i = 0; i < listaRacuna.size(); i++)
			if (listaRacuna.get(i).brojRacuna == brojRacuna) {
				System.out.println("Unijeti broj racuna vec postoji. Racun nije uspjesno kreiran!");
				return false;
			}
		
		return true;
	}
	
	
	
	// geteri 
	
	public int getBrojRacuna() {
		return brojRacuna;
	}
	
	public String getImeMusterije() {
		return imeMusterije;
	}
	
	public int getBrojPosudjenihKnjiga() {
		return brojPosudjenihKnjiga;
	}

	public static Racun getRacun(int brojRacuna) {
		
		int i = 0;
		
		for (i = 0; i < listaRacuna.size(); i++)
			if (listaRacuna.get(i).brojRacuna == brojRacuna)
				return listaRacuna.get(i);
		
		return null;
	}

	
	// seteri
	
	public void setBrojRacuna(int brojRacuna) throws IllegalArgumentException {

		if(brojRacuna >= 0) {
			this.brojRacuna = brojRacuna;
		}
		else {
			throw new IllegalArgumentException ("Broj racuna ne moze biti negativan! Racun nije uspjesno kreiran!");
		}
	}

	public void setImeMusterije(String imeMusterije) {
		this.imeMusterije = imeMusterije;
	}

	public void setBrojPosudjenihKnjiga(int brojPosudjenihKnjiga) {
		this.brojPosudjenihKnjiga = brojPosudjenihKnjiga;
	}


	// ispis Racuna
	
	public static String ispisRacuna(int brojRacuna){
		
		for (int i = 0; i < listaRacuna.size(); i++)
			if (brojRacuna == listaRacuna.get(i).brojRacuna) 
				return "Broj racuna: " + listaRacuna.get(i).brojRacuna 
						+ "\nIme musterije: " + listaRacuna.get(i).imeMusterije 
						+ "\nBroj posudjenih knjiga: " 
						+ listaRacuna.get(i).brojPosudjenihKnjiga;
			
		return "Unijeti broj racuna ne postoji.";
		
	}
}
