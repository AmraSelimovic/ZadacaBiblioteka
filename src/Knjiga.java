import java.util.ArrayList;
public class Knjiga extends Racun {

	private int brojKnjige;
	private String imeKnjige;
	private boolean statusKnjige=true; //false-izdata, true-slobodna
	
	protected static ArrayList <Knjiga> listaKnjiga = new ArrayList<Knjiga>();
	
	public Knjiga() {
		
	}
	
	public Knjiga(int brojKnjige, String imeKnjige) {
		if(provjeriValidacijuKnjige(brojKnjige)) {
			
			this.brojKnjige = brojKnjige;
			this.imeKnjige = imeKnjige;
			
			listaKnjiga.add(this);
			System.out.println("Knjiga je uspjesno dodana u bazu");
		}
		else {
			System.out.println("Knjiga se ne moze dodati u bazu! Provjerite uslove i pokusajte ponovo!");
		}
	}
	
	
	public boolean provjeriValidacijuKnjige ( int brojKnjige ) {
		if(brojKnjige<0) {
			System.out.println("Ne mozete dodati u bazu knjigu sa negativnim brojem!");
			return false;
		}
		
		for(int i=0; i<listaKnjiga.size(); i++) {
			if(listaKnjiga.get(i).brojKnjige == brojKnjige) {
				System.out.println("Knjiga sa ovim brojem vec postoji u bazi!");
				return false;
			}
		}
		
		return true;
	}

	public static boolean stanjeKnjige(int brojKnjige) {
		for (int i = 0; i < listaKnjiga.size(); i++) {
		    if (listaKnjiga.get(i).brojKnjige == brojKnjige) {
			if (listaKnjiga.get(i).statusKnjige) {
			    return true;
			}
		    }
		}
		return false;
	}

	
	
	public boolean provjeriValidnostKnjige(int brojKnjige) {
		for(int i=0; i<listaKnjiga.size(); i++) {
			if(!(listaKnjiga.get(i).statusKnjige)) {
				System.out.println("Ova knjiga je vec izdata. Iznajmite neku drugu!");
				return false;
			}
		}
		return true;
	}
			
	public static boolean provjeriPostojanjeKnjige(int brojKnjige) {
		for(int i=0; i<listaKnjiga.size(); i++) {
			if(listaKnjiga.get(i).brojKnjige != brojKnjige) {
				System.out.println("Ova knjiga je nepostojeca (nema je u bazi)!");
				return false;
			}
			else {
				return true;
			}
		}
		
		return true;
	}
	
}
