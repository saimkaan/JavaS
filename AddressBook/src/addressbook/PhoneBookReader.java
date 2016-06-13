package addressbook;

import addressbook.data.PhoneBook;
import addressbook.data.PhoneBookEntry;
import addressbook.io.PhoneBookSerializer;
import addressbook.io.PhonebookSerializationException;

/**
 * Lädt ein zuvor gespeichertes Telefonbuch (siehe {@link PhoneBookReader}) und
 * gibt die Einträge auf der Konsole aus.
 * 
 * @author matana
 * 
 */
public class PhoneBookReader {

	/**
	 * NB: Bevor Sie dieses Programm ausführen, sollten Sie sicher gehen, dass die
	 * Datei 'phonebook.bin' innerhalb Ihres Projektes existiert. Falls nicht
	 * führen Sie zunächst {@link PhoneBookWriter} aus.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		PhoneBookSerializer serializer = new PhoneBookSerializer();
		try {
			PhoneBook book = serializer.loadPhoneBook();
			for (int i = 0; i < book.size(); i++) {
				PhoneBookEntry entry = book.get(i);
				System.out.println("Eintrag: " + entry);
			}
			book.sortByFirstName();
		} catch (PhonebookSerializationException e) {
			e.printStackTrace();
		}
	}

}
