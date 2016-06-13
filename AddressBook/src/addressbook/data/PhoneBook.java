package addressbook.data;

import java.text.Collator;
import java.text.RuleBasedCollator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

//	public List<PhoneBookEntry> search(String lastName, String firstName){
//
//		List<PhoneBookEntry> tmp = new ArrayList<>();
//
//		if (firstName == null)
//			return searchlastName(lastName, tmp);
//
//		return tmp;
//	}
//
//	private List<PhoneBookEntry> searchlastName(String firstName){
//		int binarySearch = Collections.binarySearch(this, new PhoneBookEntry(lastName));
//		List<PhoneBookEntry> tmp;
//		if(binarySearch == -1)
//			return tmp;
//		if (!tmp.contains(this.get(binarySearch))){
//			tmp.add(this.get(binarySearch));
//			return searchlastName(lastName,  tmp);
//		}
//		else {
//			return tmp;
//		}
//		PhoneBookEntry phoneBookEntry = this.get(binarySearch);
//
//		return tmp;
//	}

}
