import java.util.ArrayList;

public class Racun {

	private int brojRacuna;
	private String imeMusterije;
	private int brojPosudjenihKnjiga;
	
	public static ArrayList <Racun> listaRacuna = new ArrayList<Racun>();
	
	public Racun() {
		
	}
	
	public Racun(int brojRacuna, String imeMusterije) {
		if(provjeriValidacijuRacuna(brojRacuna)) {
			this.brojRacuna = brojRacuna;
			this.imeMusterije = imeMusterije;
			
			listaRacuna.add(this);
			System.out.println("Racun je uspjesno kreiran!");
		}
		else {
			System.out.println("Racun nije kreiran");
		}
	}
	
	public boolean provjeriValidacijuRacuna(int brojRacuna) {
		if(brojRacuna<0) {
			System.out.println("Broj racuna ne moze biti negativan.");
			return false;
		}
		
		for( int i=0; i<listaRacuna.size(); i++) {
			if(listaRacuna.get(i).brojRacuna == brojRacuna) {
				System.out.println("Racun sa ovim brojem vec postoji!");
				return false;
			}
		}
		
		return true;
	}

	

	public static boolean brojPodignutihKnjiga(int brojRacuna) {
		for (int i = 0; i < listaRacuna.size(); i++) {
		    if (listaRacuna.get(i).brojRacuna == brojRacuna) {
			if (listaRacuna.get(i).brojPosudjenihKnjiga > 3) {
			    System.out.println("Ne mozete podici vise od tri knjige");
			    return false;
			}
		    }

		}
		return true;
	    }
			
	
	public static void posudba(int brojRacuna) {
		for (int i = 0; i < listaRacuna.size(); i++) {
		    if(listaRacuna.get(i).brojRacuna==brojRacuna) {
			listaRacuna.get(i).brojPosudjenihKnjiga++;
		    }
		}
	    }
	
	    public static void vracanje(int brojRacuna) {
	   	for (int i = 0; i < listaRacuna.size(); i++) {
	   	    if(listaRacuna.get(i).brojRacuna==brojRacuna) 
	   		listaRacuna.get(i).brojPosudjenihKnjiga--;
	   	    
	   	    
	   	}
	       }

		public int getBrojRacuna() {
			return brojRacuna;
		}

		public void setBrojRacuna(int brojRacuna) {
			this.brojRacuna = brojRacuna;
		}

		public String getImeMusterije() {
			return imeMusterije;
		}

		public void setImeMusterije(String imeMusterije) {
			this.imeMusterije = imeMusterije;
		}

		public int getBrojPosudjenihKnjiga() {
			return brojPosudjenihKnjiga;
		}

		public void setBrojPosudjenihKnjiga(int brojPosudjenihKnjiga) {
			this.brojPosudjenihKnjiga = brojPosudjenihKnjiga;
		}
	
	
	    
}

