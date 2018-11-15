import java.util.Scanner;
import java.io.*;
import java.util.InputMismatchException;


public class Biblioteka {

	static Scanner input = new Scanner (System.in);
	
public static void main(String[] args) throws IOException {
		
		Racun.listaRacuna = Fajl.readFromFile();
		Knjiga.listaKnjiga = FajlKnjige.readFromF();
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
				izbor = inputInt();
				
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
		Racun racun = new Racun();
		System.out.println("Unesite broj racuna: ");
		int brojRacuna = provjeriDaLiJeNegativan();
		
		while (!racun.provjeraPostojanja(brojRacuna)) {
			System.out.println("Upisani broj racuna je zauzet. Pokusajte sa novim unosom:");
			brojRacuna = provjeriDaLiJeNegativan();
		}
	
		System.out.println("Unesite zeljeni username: ");
		String ime = input.next();
	
		
		int brojPodignutihKnjiga = 0;
		racun = new Racun(brojRacuna, ime, brojPodignutihKnjiga);
		
		String fileName = "racuni.txt";
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter (new File("C:/Users/medn/eclipse-workspace/BibliotekaZadaca/racuni.txt"),true));

			bufferedWriter.write(racun.getBrojRacuna() + " " + racun.getImeMusterije() );
			bufferedWriter.newLine();
			bufferedWriter.close();
		} catch (IOException ex) {
			System.out.println("Error writing to file '" + fileName + "'");

		}
		
		izbornik();
	}
	
	public static void kreiranjeKnjige() throws IOException {
		System.out.println();
		Knjiga knjiga = new Knjiga();
		System.out.println("   DOBRODOSLI U IZBORNIK KREIRANJE KNJIGE   ");
		System.out.println("Unesite broj knjige: ");
		int brojKnjige = provjeriDaLiJeNegativan();
		
		while (!knjiga.provjeraPostojanja(brojKnjige)) {
			System.out.println("Upisani broj knjige je zauzet. Pokusajte sa novim unosom:");
			brojKnjige = provjeriDaLiJeNegativan();
		}
		
		System.out.println("Unesite naziv knjige: ");
		String naziv = input.next();
		
		boolean stanjeKnjige = false;
		
		 knjiga = new Knjiga(brojKnjige, naziv, stanjeKnjige);
		 
		 String fileName = "knjige.txt";
			try {
				BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter (new File("C:/Users/medn/eclipse-workspace/BibliotekaZadaca/knjige.txt"),true));

				bufferedWriter.write(knjiga.getBrojKnjige() + " " + naziv  );
				bufferedWriter.newLine();
				bufferedWriter.close();
			} catch (IOException ex) {
				System.out.println("Error writing to file '" + fileName + "'");

			}
			
		 
		izbornik();
	}
	
	public static void podizanjeKnjige() throws IOException{
		
		System.out.println();
		System.out.println("   DOBRODOSLI U IZBORNIK PODIZANJE KNJIGE   ");
		System.out.println("Unesite broj racuna korisnika biblioteke: ");
		int brojRacuna = provjeriDaLiJeNegativan();
		
		System.out.println("Unesite broj zeljene knjige: ");
		int brojKnjigeZaNajam = provjeriDaLiJeNegativan();
		
		PodizanjeKnjige podizanje = new PodizanjeKnjige(brojRacuna, brojKnjigeZaNajam);
		
		izbornik();
	}

	public static void vracanjeKnjige() throws IOException{
		
		System.out.println();
		System.out.println("   DOBRODOSLI U IZBORNIK VRACANJE KNJIGE   ");
		System.out.println("Unesite broj racuna: ");
		int brojRacuna = provjeriDaLiJeNegativan();
		
		System.out.println("Unesite broj knjige koju vracate: ");
		int brojKnjige = provjeriDaLiJeNegativan();
		
		VracanjeKnjige vracanje = new VracanjeKnjige(brojRacuna, brojKnjige);
		
		izbornik();
	}

	public static void ispisZapisnikaZaPodizanje () throws IOException {
	
		System.out.println();
		System.out.println("   DOBRODOSLI U ZAPISNIK SA INFORMACIJAMA O IZNAJMLJENIM KNJIGAMA   ");
		PodizanjeKnjige.ispisZapisnikaPodignutihKnjiga();
		
		if (PodizanjeKnjige.zapisnik.size() == 0) {
			System.out.println("Zapisnik je prazan, nema podignutih knjiga!");
		}
		
		izbornik();
	}

	public static void ispisZapisnikaZaVracanje () throws IOException {
	
		System.out.println();
		System.out.println("   DOBRODOSLI U ZAPISNIK SA INFORMACIJAMA O VRACENIM KNJIGAMA   ");
		VracanjeKnjige.ispisZapisnikaVracenihKnjiga();
		
		if (VracanjeKnjige.zapisnik.size() == 0) {
			System.out.println("Zapisnik je prazan, nema vracenih knjiga!");
		}
	
		izbornik();
	}

	public static void ispisRacuna() throws IOException {
	
		System.out.println();
		System.out.println("   DOBRODOSLI U IZBORNIK ZA ISPIS RACUNA   ");
		System.out.println("Unesite broj racuna cije stanje zelite provjeriti: ");
		int brojRacuna = provjeriDaLiJeNegativan();
	
		System.out.println(Racun.ispisRacuna(brojRacuna));
		izbornik();
	}
	
	// handle exception za integer brojeve
	public static int inputInt() {
		
		int izbor=0;
		do {
			try {
				 izbor = input.nextInt();
				 break;
			} 
			catch (Exception ex) {
				System.out.println("Pogresan unos. Pokusajte ponovo:");
				input.nextLine();
			}
			
		} while (true);	
		return izbor;
	}
	
	// handle exception za negativne integer brojeve
	public static int provjeriDaLiJeNegativan() {
		
		int izbor =0;
		
		do {
			try {
				izbor = inputInt();
				
				if(izbor < 0)
					throw new InputMismatchException();
				break;
			}
			catch (Exception e) {
				System.out.println("Pogresan unos. Pokusajte ponovo:");
				input.nextLine();
				continue;
			}
		} while(true);
		return izbor;
	}
	
}

