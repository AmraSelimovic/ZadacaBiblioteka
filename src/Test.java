import java.util.Scanner;

public class Test {

	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		
		bibliotekaTest();
	}
	
	public static void bibliotekaTest() {
		
		System.out.println();
		System.out.println("      DOBRODOSLI U GLAVNI IZBORNIK   ");
		System.out.println("   IZABERITE NEKU OD SLJEDECIH OPCIJA: ");
		System.out.println("1. Kreiranje racuna - dodavanje u bazu ");
		System.out.println("2. Kreiranje knjiga - dodavanje u bazu ");
		System.out.println("3. Podizanje knjige ");
		System.out.println("4. Vracanje knjige ");
		System.out.println("5. Ispis liste posudjenih i vracenih knjiga");
		System.out.println("6. Izlazak iz aplikacije");
		
		int izbor = input.nextInt();
		
		while (izbor < 1 || izbor >6 ){
			System.out.println("Pogresan unos. Pokusajte ponovo.");
			izbor = input.nextInt();
		}

		switch (izbor) {
		case 1:
			noviKorisnik();
			break;
		case 2:
			novaKnjiga();
			break;
		case 3:
			podizanjeKnjige();
			break;
	//	case 4:
		//	vracanjeKnjige();
		//	break;
	//	case 5:
		//	Biblioteka.ispisiListe();
		//	break;
	//	case 6:
		//	break;
			
		}
		

	}
	
	public static void noviKorisnik() {
		System.out.println();
		System.out.println("   DOBRODOSLI U IZBORNIK KREIRANJE RACUNA   ");
		System.out.println("Unesite broj racuna: ");
		int brojRacuna = input.nextInt();
		
		System.out.println("Unesite zeljeni username: ");
		String ime = input.next();
		
		Racun racun = new Racun(brojRacuna, ime);
	
		
		bibliotekaTest();
	}
	
	public static void novaKnjiga() {
		System.out.println();
		System.out.println("   DOBRODOSLI U IZBORNIK KREIRANJE KNJIGE   ");
		System.out.println("Unesite broj knjige: ");
		int brojKnjige = input.nextInt();
		
		System.out.println("Unesite naziv knjige: ");
		String naziv = input.next();
		
		
		Knjiga knjiga = new Knjiga(brojKnjige, naziv);
		
		bibliotekaTest();
		
		
	}
	
	public static void podizanjeKnjige() {
		
		System.out.println();
		System.out.println("   DOBRODOSLI U IZBORNIK PODIZANJE KNJIGE   ");
		System.out.println("Unesite broj racuna: ");
		int brojRacuna = input.nextInt();
		
		System.out.println("Unesite broj zeljene knjige: ");
		int brojKnjige = input.nextInt();
		
		PodizanjeKnjige podizanje = new PodizanjeKnjige(brojRacuna, brojKnjige);
		
		bibliotekaTest();
	}

	
	
	}

