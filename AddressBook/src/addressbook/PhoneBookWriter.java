package addressbook;

import addressbook.data.Address;
import addressbook.data.AddressType;
import addressbook.data.PhoneBook;
import addressbook.data.PhoneBookEntry;
import addressbook.data.PhoneNumber;
import addressbook.io.PhoneBookSerializer;
import addressbook.io.PhonebookSerializationException;

/**
 * Diese Klasse erzeugt einige Telefonbuch-Einträge und sorgt dafür, dass sie
 * zunächst sortiert und dann gespeichert werden. Anschließend kann das
 * Telefonbuch mit Hilfe der Klasse {@link PhoneBookReader} geladen werden.
 * 
 * @author matana
 * 
 */
public class PhoneBookWriter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PhoneBook book = new PhoneBook();

		Address address = new Address("Albertus-Magnus-Platz", 1, 50923, "Köln");
		PhoneNumber number = new PhoneNumber("+49", "221", "470-6675");
		PhoneBookEntry entry = new PhoneBookEntry("Mihail", "Atanassov", AddressType.COMPANY, address, number);
		book.add(entry);

		address = new Address("Albertus-Magnus-Platz", 1, 50923, "Köln");
		number = new PhoneNumber("+49", "221", "470-6675");
		entry = new PhoneBookEntry("Hinz", "Kunz", AddressType.COMPANY, address, number);
		book.add(entry);

		address = new Address("Albertus-Magnus-Platz", 1, 50923, "Köln");
		number = new PhoneNumber("+49", "221", "470-6675");
		entry = new PhoneBookEntry("Krethi", "Plethi", AddressType.COMPANY, address, number);
		book.add(entry);

		address = new Address("Zülpicher Straße", 14, 50927, "Köln");
		number = new PhoneNumber("+49", "221", "4141412");
		entry = new PhoneBookEntry("Max", "Meier", AddressType.MR, address, number);
		book.add(entry);

		address = new Address("Venloer Straße", 123, 50823, "Köln");
		number = new PhoneNumber("+49", "221", "555555");
		entry = new PhoneBookEntry("Petra", "Meyer", AddressType.MRS, address, number);
		book.add(entry);

		address = new Address("Venloer Straße", 123, 50823, "Köln");
		number = new PhoneNumber("+49", "221", "555556");
		entry = new PhoneBookEntry("Andrea", "Meyer", AddressType.MRS, address, number);
		book.add(entry);

		address = new Address("Wiener Platz", 2, 51065, "Köln");
		number = new PhoneNumber("+49", "221", "1234567");
		entry = new PhoneBookEntry("Ute", "Maier", AddressType.MRS, address, number);
		book.add(entry);

		book.sortByFirstName();
		book.sortByLastName();

		PhoneBookSerializer serializer = new PhoneBookSerializer();
		try {
			serializer.storePhoneBook(book);
		} catch (PhonebookSerializationException e) {
			e.printStackTrace();
		}
	}

}
