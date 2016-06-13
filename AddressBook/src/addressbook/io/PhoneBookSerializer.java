package addressbook.io;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import addressbook.data.PhoneBook;



/**
 * Diese Klasse bietet die Funktionalität, die für das Laden und Speichern eines
 * Telefonbuchs mit Hilfe von {@link ObjectOutputStream} und {@link ObjectInputStream}
 * benötigt wird.
 * 
 * @author matana
 *
 */
public class PhoneBookSerializer {
	
	/**
	 * Speichert das übergebene Telefonbuch.
	 * @param book
	 * @throws PhonebookSerializationException falls ein Fehler auftritt
	 */
	public void storePhoneBook(PhoneBook book) throws PhonebookSerializationException {
		try {
			FileOutputStream fos = new FileOutputStream("phonebook.bin");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(book);
			oos.close();
		} catch (FileNotFoundException e) {
			throw new PhonebookSerializationException("Failed to store file", e);
		} catch (IOException e) {
			throw new PhonebookSerializationException(e);
		}
	}
	
	/**
	 * Lädt das zuvor gespeicherte Telefonbuch.
	 * @return
	 * @throws PhonebookSerializationException falls ein Fehler auftritt
	 */
	public PhoneBook loadPhoneBook() throws PhonebookSerializationException {
		try {
			FileInputStream fis = new FileInputStream("phonebook.bin");
			BufferedInputStream bis = new BufferedInputStream(fis);
			ObjectInputStream ois = new ObjectInputStream(bis);
			PhoneBook book = (PhoneBook) ois.readObject();
			ois.close();
			return book;
		} catch (FileNotFoundException e) {
			throw new PhonebookSerializationException(e);
		} catch (ClassNotFoundException e) {
			throw new PhonebookSerializationException(e);
		} catch (IOException e) {
			throw new PhonebookSerializationException(e);
		}
	}

}
