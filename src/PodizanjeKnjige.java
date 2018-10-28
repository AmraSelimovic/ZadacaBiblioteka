import java.util.ArrayList;
import java.util.Date;

public class PodizanjeKnjige extends Knjiga {

	private int brojRacuna;
	private int brojKnjige;
	private Date datum;
	
	private static ArrayList<PodizanjeKnjige> listaIzdatihKnjiga = new ArrayList<PodizanjeKnjige>();
	
	public PodizanjeKnjige(int brojRacuna, int brojKnjige) {
		
			if(brojPodignutihKnjiga(brojRacuna) && stanjeKnjige(brojKnjige)) {
				Racun.posudba(brojRacuna);
				Knjiga.preuzetaKnjiga(brojKnjige);
				this.brojRacuna = brojRacuna;
				this.brojKnjige = brojKnjige;
				this.datum = new Date();
				
				listaIzdatihKnjiga.add(this);
				System.out.println("Uspjesno ste iznajmili knjigu!");
				System.out.println("Knjiga je preuzeta " + datum);
			}
			
			else {
				System.out.println("Ne mozete iznajmiti knjigu! Pokusajte ponovo!");
			
		}
	}
	
	
	
	
			
	
}
	
	
	
			
	

