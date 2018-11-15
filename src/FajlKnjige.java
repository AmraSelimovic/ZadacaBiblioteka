import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FajlKnjige {
	
	public static ArrayList<Knjiga> readFromF() {
		String fileName = "knjige.txt";
		ArrayList<Knjiga> knjige = new ArrayList<Knjiga>();
		String line = null;
		System.out.println();

		try {

			BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("C:/Users/medn/eclipse-workspace/BibliotekaZadaca/knjige.txt")));
			
			while ((line = bufferedReader.readLine()) != null) {
				String[] info = line.split(" ");
				Knjiga knjiga = new Knjiga();
				knjiga.setBrojKnjige(Integer.parseInt(info[0]));
				knjiga.setImeKnjige(info[1]);
				knjige.add(knjiga);
			}

			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");

		}
		return knjige;
	} 

}
