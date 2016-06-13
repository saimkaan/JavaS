package addressbook.data;

import java.text.Collator;
import java.text.RuleBasedCollator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Ein Telefonbuch ist hier eine Liste von {@link PhoneBookEntry}-Instanzen - deshalb wird
 * die Klasse {@link ArrayList} überschrieben und um Telefonbuch-spezifische Methoden
 * zum Sortieren der Einträge erweitert.
 * 
 * @author matana
 *
 */
public class PhoneBook extends ArrayList<PhoneBookEntry> {

	private static final long serialVersionUID = 6778986065452834344L;
	
	public void sortByLastName() {
		
		final Collator collator = RuleBasedCollator.getInstance();
		Comparator<PhoneBookEntry> lastNameComparator = new Comparator<PhoneBookEntry>() {
			
			@Override
			public int compare(PhoneBookEntry o1, PhoneBookEntry o2) {
				return collator.compare(o1.getLastName(), o2.getLastName());
			}
		};
		Collections.sort(this, lastNameComparator);
	}

	public void sortByFirstName() {
		
		final Collator collator = RuleBasedCollator.getInstance();
		Comparator<PhoneBookEntry> firstNameComparator = new Comparator<PhoneBookEntry>() {

			@Override
			public int compare(PhoneBookEntry o1, PhoneBookEntry o2) {
				return collator.compare(o1.getFirstName(), o2.getFirstName());
			}
		};
		Collections.sort(this, firstNameComparator);
	}

}
