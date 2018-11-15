import java.util.ArrayList;

public class Racun {
	
	private int brojRacuna;
	private String imeMusterije;
	private int brojPosudjenihKnjiga;
	private static int ukupanBrojRacuna=0;

	protected static ArrayList <Racun> listaRacuna = new ArrayList<Racun>();
	
	
	//konstruktori
	
	public Racun() {
		ukupanBrojRacuna++;
	}
	
	public Racun(int brojRacuna, String imeMusterije, int brojPosudjenihKnjiga) {
			this.brojRacuna = brojRacuna;
			this.imeMusterije = imeMusterije;
			this.brojPosudjenihKnjiga = brojPosudjenihKnjiga;
			
			listaRacuna.add(this);
			
			System.out.println("Racun je uspjesno kreiran!");
			//System.out.println("Broj racuna: " + getBrojRacuna());
			//System.out.println("Ime musterije: " + getImeMusterije());
			//System.out.println("Broj posudjenih knjiga: " + getBrojPosudjenihKnjiga());
		
	}
	
	public boolean provjeraPostojanja(int brojRacuna) {
		
		for (int i = 0; i < listaRacuna.size(); i++)
			if (listaRacuna.get(i).brojRacuna == brojRacuna) {
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
	
	public void setBrojRacuna(int brojRacuna) {
		this.brojRacuna = brojRacuna;
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
