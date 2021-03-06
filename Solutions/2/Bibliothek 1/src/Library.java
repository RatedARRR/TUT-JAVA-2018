import java.util.Scanner;
public class Library {
	Book[] dorfBibliothek = new Book[10];
	
	public Book ausleihen(String title) {
		Book geliehen = null;
		for(int i = 0; i < 10; i++) {
			if(dorfBibliothek[i] != null) {
				if(title.equals(dorfBibliothek[i].getTitle())) {
					geliehen = dorfBibliothek[i];
					dorfBibliothek[i] = null;
				}
			}
		}
		return geliehen;
	}
	
	public boolean geben(String title, String isbn) {
		for(int i = 0; i < 10; i++) {
			if(dorfBibliothek != null) {
				if(dorfBibliothek[i] == null) {
					Book book = new Book(title, isbn);
					dorfBibliothek[i] = book;
					return true;
				}
			}
		}
		return false;
	}
	
	public void show() {
		System.out.println("Wir haben ");
		int j = 0;
		for(int i = 0; i<10; i++) {
			if(dorfBibliothek[i] != null) {
				System.out.println(dorfBibliothek[i]);
				j++;
			}
		}
		if(j == 0) {
			System.out.println("aktuell keine B�cher in der Bibliothek.");
		}else {
			System.out.println("in der Bibliothek.");
		}
	} 
	
	public static void main(String[] args) {
		Book book1 = new Book("Der Richter und sein Henker", "12032024ASDF");
		Book book2 = new Book("Dr. Jekyll und Mr Hyde", "127812598ASL�SAFJL");
		Book book3 = new Book("Der F�nger im Roggen", "12�9u91509asfjasfasfo");
		Library lib = new Library();
		Scanner input = new Scanner(System.in);
		
		while(true) {
			boolean abbruch = false;
			System.out.println("Was m�chtest du tun? Ausleihen 1, Geben 2, Anzeigen 3, Abbrechen 4");
			int choice = input.nextInt();
			switch(choice) {
				case 1:
					System.out.println("Welchen Titel hat das Buch das du ausleihen m�chtest?");
					String title = input.next();
					Book book = lib.ausleihen(title);
					if(book != null) {
						System.out.println("Du hast " + book  + " ausgeliehen.");
					}else {
						System.out.println("Dieses Buch haben wir leider nicht.");
					}
					break;
				case 2:
					System.out.println("Was f�r ein Buch m�chtest du uns geben?");
					System.out.println("Bitte Titel eingeben.");
					String title2 = input.next();
					System.out.println("Bitte ISBN eingeben.");
					String isbn = input.next();
					if(lib.geben(title2, isbn)) {
						System.out.println("Danke f�r die Spende von " + title2);
					}else {
						System.out.println("Die Bibliothek ist leider voll.");
					}
					break;
				case 3:
					lib.show();
					break;
				case 4:	
					abbruch = true;
					break;
				default:
					System.out.println("Falsche Eingabe!");
					System.out.println("Was m�chtest du tun? Ausleihen 1, Geben 2, Anzeigen 3");
			}
			if(abbruch) {
				break;
			}
		}
	}
}