import java.util.ArrayList;

public class Knjiga {
	
	private int brojKnjige;
	private String imeKnjige;
	private boolean statusKnjige;
	private int ukupanBrojKnjiga=0;
	 
	protected static ArrayList <Knjiga> listaKnjiga = new ArrayList<Knjiga>();
	
	
	
	// konstruktori
	
	public Knjiga() {
		ukupanBrojKnjiga++;
	}
	
	public Knjiga(int brojKnjige, String imeKnjige, boolean statusKnjige) {
		
			this.brojKnjige = brojKnjige;
			this.imeKnjige = imeKnjige;
			this.statusKnjige = statusKnjige;
			
			listaKnjiga.add(this);

			System.out.println("Knjiga je uspjesno kreirana!");
			ukupanBrojKnjiga++;
			
	}
	
	public boolean provjeraPostojanja(int brojKnjige) {
		
		for (int i = 0; i < listaKnjiga.size(); i++)
			if (listaKnjiga.get(i).brojKnjige == brojKnjige) {
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
	}
	
	
	// seteri
	
	public void setBrojKnjige(int brojKnjige) {
		this.brojKnjige = brojKnjige;
	}

	public void setImeKnjige(String imeKnjige) {
		this.imeKnjige = imeKnjige;
	}

	
	public void setStatusKnjige(boolean statusKnjige) {
		this.statusKnjige = statusKnjige;
	}
	

	
	
}
