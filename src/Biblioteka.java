
import java.util.Scanner;
import java.io.*;
import java.util.InputMismatchException;


public class Biblioteka {

	static Scanner input = new Scanner (System.in);
	
public static void main(String[] args) throws IOException {
		
	Knjiga.loading();
	Racun.loading();
		izbornik();
	}
	
	public static void izbornik() throws IOException {
		
		System.out.println();
		System.out.println("      DOBRODOSLI U GLAVNI IZBORNIK   ");
		System.out.println("   IZABERITE NEKU OD SLJEDECIH OPCIJA: ");
		System.out.println("1. Kreiranje racuna - dodavanje u bazu ");
		System.out.println("2. Kreiranje knjiga - dodavanje u bazu ");
		System.out.println("3. Podizanje knjige ");
		System.out.println("4. Vracanje knjige ");
		System.out.println("5. Ispis zapisnika podignutih knjiga");
		System.out.println("6. Ispis zapisnika vracenih knjiga");
		System.out.println("7. Ispis racuna");
	
		int izbor =0;
		
		do {
			try {
				izbor = input();
				
				if(izbor < 1 || izbor >7 )
					throw new InputMismatchException();
				break;
			}
			catch (Exception e) {
				System.out.println("Pogresan izbor. Pokusajte ponovo.");
				input.nextLine();
				continue;
			}
		} while(true);
		
		
	

		switch (izbor) {
		case 1:
			kreiranjeRacuna();
			break;
		case 2:
			kreiranjeKnjige();
			break;
		case 3:
			podizanjeKnjige();
			break;
		case 4:
			vracanjeKnjige();
			break;
		case 5:
			ispisZapisnikaZaPodizanje();
			break;
		case 6:
			ispisZapisnikaZaVracanje();
			break;
		case 7:
			ispisRacuna();
			break;
		}
	}
	
	public static void kreiranjeRacuna() throws IOException {
		
		System.out.println();
		System.out.println("   DOBRODOSLI U IZBORNIK KREIRANJE RACUNA   ");
		System.out.println("Unesite broj racuna: ");
		int brojRacuna = input();
	
		System.out.println("Unesite zeljeni username: ");
		String ime = input.next();
	
		
		int brojPodignutihKnjiga = 0;
		try { //handle exception za negativan broj racuna
			Racun racun = new Racun(brojRacuna, ime, brojPodignutihKnjiga);
			
			try { 
				FileOutputStream in = new FileOutputStream("listaRacuna.txt");
				ObjectOutputStream oin = new ObjectOutputStream(in);
				oin.writeObject(racun);
			}
			catch(IOException ex){
				System.out.println("Greska pri zapisivanju objekta!");
			}
			
		}
		catch (IllegalArgumentException ex){ 
			System.out.println(ex);
		}
		
		
		izbornik();
	}
	
	public static void kreiranjeKnjige() throws IOException {
		System.out.println();
		System.out.println("   DOBRODOSLI U IZBORNIK KREIRANJE KNJIGE   ");
		System.out.println("Unesite broj knjige: ");
		int brojKnjige = input();
		
		System.out.println("Unesite naziv knjige: ");
		String naziv = input.next();
		
		boolean stanjeKnjige = false;
		
		try { // handle exception za negativan broj knjige
			Knjiga knjiga = new Knjiga(brojKnjige, naziv, stanjeKnjige);
			
			try {
				FileOutputStream in = new FileOutputStream("listaKnjiga.txt");
				ObjectOutputStream oin = new ObjectOutputStream(in);
				oin.writeObject(knjiga);
			}
			catch(IOException ex){
				System.out.println("Greska pri zapisivanju objekta!");
			}
		}
		catch (IllegalArgumentException ex) {
			System.out.println(ex);
		}
		
		izbornik();
	}
	
	public static void podizanjeKnjige() throws IOException{
		
		System.out.println();
		System.out.println("   DOBRODOSLI U IZBORNIK PODIZANJE KNJIGE   ");
		System.out.println("Unesite broj racuna korisnika biblioteke: ");
		int brojRacuna = input();
		
		System.out.println("Unesite broj zeljene knjige: ");
		int brojKnjigeZaNajam = input();
		
		PodizanjeKnjige podizanje = new PodizanjeKnjige(brojRacuna, brojKnjigeZaNajam);
		
		izbornik();
	}

	public static void vracanjeKnjige() throws IOException{
		
		System.out.println();
		System.out.println("   DOBRODOSLI U IZBORNIK VRACANJE KNJIGE   ");
		System.out.println("Unesite broj racuna: ");
		int brojRacuna = input();
		
		System.out.println("Unesite broj knjige koju vracate: ");
		int brojKnjige = input();
		
		VracanjeKnjige vracanje = new VracanjeKnjige(brojRacuna, brojKnjige);
		
		izbornik();
	}

	public static void ispisZapisnikaZaPodizanje () throws IOException {
	
		System.out.println();
		System.out.println("   DOBRODOSLI U ZAPISNIK SA INFORMACIJAMA O IZNAJMLJENIM KNJIGAMA   ");
		PodizanjeKnjige.ispisZapisnikaPodignutihKnjiga();
		
		izbornik();
	}

	public static void ispisZapisnikaZaVracanje () throws IOException {
	
		System.out.println();
		System.out.println("   DOBRODOSLI U ZAPISNIK SA INFORMACIJAMA O IZNAJMLJENIM KNJIGAMA   ");
		VracanjeKnjige.ispisZapisnikaVracenihKnjiga();
	
		izbornik();
	}

	public static void ispisRacuna() throws IOException {
	
		System.out.println();
		System.out.println("   DOBRODOSLI U IZBORNIK ZA ISPIS RACUNA   ");
		System.out.println("Unesite broj racuna cije stanje zelite provjeriti: ");
		int brojRacuna = input();
	
		System.out.println(Racun.ispisRacuna(brojRacuna));
		izbornik();
	}
	
	// handle exception za integer brojeve
	public static int input() {
		
		int izbor=0;
		do {
			try {
				 izbor = input.nextInt();
				 break;
			} 
			catch (Exception ex) {
				System.out.println("Pogresan unos! Try again!");
				input.nextLine();
			}
			
		} while (true);	
		return izbor;
	}
	
	
	
}
