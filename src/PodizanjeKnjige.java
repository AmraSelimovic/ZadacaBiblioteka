import java.util.ArrayList;
import java.util.Date;

public class PodizanjeKnjige extends Knjiga {
	
	private int brojRacuna;
	private int brojKnjige;
	private Date datum;
	
	protected static ArrayList<PodizanjeKnjige> zapisnik = new ArrayList<PodizanjeKnjige>();
	
	public PodizanjeKnjige() {
		
	}
	
	public PodizanjeKnjige(int brojRacuna, int brojKnjige) {
		
			if(provjeraZaPodizanjeKnjige(brojRacuna, brojKnjige)) {
				Knjiga.getKnjiga(brojKnjige).setStatusKnjige(true);
				Racun.getRacun(brojRacuna).setBrojPosudjenihKnjiga(Racun.getRacun(brojRacuna).getBrojPosudjenihKnjiga()+1);

			if(brojPodignutihKnjiga(brojRacuna) && stanjeKnjige(brojKnjige)) {
				Racun.posudba(brojRacuna);
				Knjiga.preuzetaKnjiga(brojKnjige);
				this.brojRacuna = brojRacuna;
				this.brojKnjige = brojKnjige;

				
				this.datum = new Date();
				
				zapisnik.add(this);
				System.out.println("Uspjesno ste podigli knjigu!");
				System.out.println("Knjiga je preuzeta " + datum);
				System.out.println("Broj racuna korisnika: " + brojRacuna);
				System.out.println("Ime korisnika koji je preuzeo Knjigu: " + Racun.getRacun(brojRacuna).getImeMusterije());
				System.out.println("Broj podignute knjige: " + brojKnjige);
        
				listaIzdatihKnjiga.add(this);
				System.out.println("Uspjesno ste iznajmili knjigu!");
				System.out.println("Knjiga je preuzeta " + datum);
			}
			
			else {
				System.out.println("Ne mozete iznajmiti knjigu! Pokusajte ponovo!");
			
		}
	}
	
	
	
	private static boolean provjeraZaPodizanjeKnjige(int brojRacuna, int brojKnjige) {
		
		Racun trenutniRacun = Racun.getRacun(brojRacuna);
		
		if (trenutniRacun == null) {
			System.out.println("Unijeti racun nije pronadjen. Knjiga nije uspjesno podignuta!");
			return false;
		}
		
		Knjiga trenutnaKnjiga = Knjiga.getKnjiga(brojKnjige);
		
		if (trenutnaKnjiga == null) {
			System.out.println("Trazena knjiga nije pronadjena!");
			return false;
		}
		
		if (trenutniRacun.getBrojPosudjenihKnjiga() == 3) {
			System.out.println("Unijeti racun vec ima tri podignute knjige. Knjiga nije uspjesno podignuta!");
			return false;
		}
		
		if (trenutnaKnjiga.isStatusKnjige()) {
			System.out.println("Trazena knjiga je vec podignuta!");
			return false;
		}
		
		return true;
		
		
	}

	
	public static void ispisZapisnikaPodignutihKnjiga() {

		System.out.println();
		for ( int i=0; i<zapisnik.size(); i++) {
			System.out.println("Broj racuna korisnika knjige: " 
								+ zapisnik.get(i).brojRacuna);
			System.out.println("Ime korisnika knjige: " 
								+ Racun.getRacun(zapisnik.get(i).brojRacuna).getImeMusterije());
			System.out.println("Broj izdate knjige: " 
								+ zapisnik.get(i).brojKnjige );
			System.out.println("Naziv izdate knjige: " 
								+ Knjiga.getKnjiga(zapisnik.get(i).brojKnjige).getImeKnjige());
			System.out.println("Knjiga preuzeta na dan: " 
								+ zapisnik.get(i).datum);
			System.out.println();
		}
		
	}
}
	
	
	
			
	

