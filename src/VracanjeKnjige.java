import java.util.ArrayList;
import java.util.Date;

public class VracanjeKnjige extends Knjiga{
	
	private int brojRacuna;
	private int brojKnjige;
	private Date datum;
	
	protected static ArrayList<VracanjeKnjige> zapisnik = new ArrayList<VracanjeKnjige>();
	
	public VracanjeKnjige() {
		
	}
	
	public VracanjeKnjige(int brojRacuna, int brojKnjige) {
		
			if(provjeraZaVracanjeKnjige(brojRacuna, brojKnjige)) {
				Knjiga.getKnjiga(brojKnjige).setStatusKnjige(false);
				Racun.getRacun(brojRacuna).setBrojPosudjenihKnjiga(Racun.getRacun(brojRacuna).getBrojPosudjenihKnjiga()-1);
				this.brojRacuna = brojRacuna;
				this.brojKnjige = brojKnjige;

				
				this.datum = new Date();
				
				zapisnik.add(this);
				System.out.println("Uspjesno ste vratili knjigu!");
				System.out.println("Knjiga je vracena datuma: " + datum);
				System.out.println("Broj racuna korisnika: " + brojRacuna);
				System.out.println("Ime korisnika koji je vratio Knjigu: " + Racun.getRacun(brojRacuna).getImeMusterije());
				System.out.println("Broj vracene knjige: " + brojKnjige);
			}
			
			else {
				System.out.println("Ne mozete vratiti knjigu!");
			
		}
	}
	
	
	private static boolean provjeraZaVracanjeKnjige(int brojRacuna, int brojKnjige) {
		
		Racun trenutniRacun = Racun.getRacun(brojRacuna);
		
		if (trenutniRacun == null) {
			System.out.println("Unijeti racun nije pronadjen. Knjiga nije uspjesno vracena!");
			return false;
		}
		
		Knjiga trenutnaKnjiga = Knjiga.getKnjiga(brojKnjige);
		
		if (trenutnaKnjiga == null) {
			System.out.println("Trazena knjiga nije pronadjena!");
			return false;
		}
		
		if (!trenutnaKnjiga.isStatusKnjige()) {
			System.out.println("Trazena knjiga nije podignuta!");
			return false;
		}
		
		return true;
		
		
	}
	
	
	public static void ispisZapisnikaVracenihKnjiga() {

		System.out.println();
	
		for ( int i=0; i<zapisnik.size(); i++) {

			System.out.println("Broj racuna korisnika koji je vratio knjigu: " 
								+ zapisnik.get(i).brojRacuna);
			System.out.println("Ime korisnika koji je vratio knjigu: " 
								+ Racun.getRacun(zapisnik.get(i).brojRacuna).getImeMusterije());
			System.out.println("Broj vracene knjige: " 
								+ zapisnik.get(i).brojKnjige );
			System.out.println("Naziv vracene knjige: " 
								+ Knjiga.getKnjiga(zapisnik.get(i).brojKnjige).getImeKnjige());
			System.out.println("Knjiga vracena na dan: " 
								+ zapisnik.get(i).datum);
			System.out.println();
		}
		
	
	}
}

