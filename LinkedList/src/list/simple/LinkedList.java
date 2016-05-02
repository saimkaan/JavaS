package list.simple;

/**
 * <p>
 * Die Klasse LinkedList repräsentiert eine einfach verkettete Liste.
 * </p>
 * <b>Formal:</b>
 * <p>
 * <ul>
 * <li>Eine Liste ist eine endliche Folge von Elementen
 * <code>[a1,a2,...aN]</code></li>
 * <li>Ein Sonderfall ist die leere Liste <code>[]</code></li>
 * <li>Die Länge einer Liste entspricht der Anzahl ihrer Elemente</li>
 * </ul>
 * </p>
 * <p>
 * Anders als bei Arrays erfolgt der Zugriff auf die Elemente nicht über einen
 * Index, sondern sequenziell. Dabei besitzt jedes Element eine Referenz auf
 * seinen Nachfolger, daher spricht man von einer einfach verketteten Liste.
 * Besitzt ein Element Referenzen auf seinen Vorgänger und seinen Nachfolger,
 * spricht man von einer doppelt verketteten Liste.
 * </p>
 * <p>
 * Die Elemente der einfach verketteten Liste werden durch die Klasse
 * {@link Node} realisiert.
 * </p>
 */
public class LinkedList {

	// Referenzen auf das erste und auf das letzte Element der Liste.
	// Der Zeiger/Referenz auf das letzte Element ermöglicht das Einfügen neuer
	// Elemente in konstanter Zeit.
	private Node first, last;

	// Die Länge der Liste
	private int size = 0;

	/**
	 * Fügt die übergebene Zahl am Ende der Liste ein.
	 * 
	 * @param value
	 */
	public void add(int value) {
		Node newNode = createNode(value);
		if (first == null) {
			// (1) Sonderfall: Liste ist leer, d.h. erstes Element zeigt auf
			// "null"
			first = newNode;
			last = newNode;
		} else {
			// (2) Sonst: Der letzte Knoten bekommt einen Nachfolger...
			last.next = newNode;
			// ... und der neue Knoten wird als letzter Knoten referenziert
			last = newNode;
		}
		size++; // (3) Länge um 1 erhöhen.
	}

	public int getSize() {
		return size;
	}

	/**
	 * Erzeug ein neues Element mit übergebenen Wert.
	 * 
	 * @param value
	 * @return
	 */
	private Node createNode(int value) {
		Node newNode = new Node(); // (1) Erzeuge eine neue Instanz
		newNode.value = value; // (2) Setze den Wert
		return newNode;
	}

	/**
	 * Fügt die übergebene Zahl am Anfang der Liste ein.
	 * 
	 * @param value
	 */
	public void insertFirst(int value) {
		Node newNode = createNode(value);
		if (first == null) {
			// (1) Sonderfall: Liste ist leer, d.h. erstes Element zeigt auf
			// null
			first = newNode;
			last = newNode;
		} else {
			// (2) Sonst: Zeiger des neuen Elements referenziert "first"
			newNode.next = first;
			first = newNode;
		}
		size++; // (3) Länge um 1 erhöhen.
	}

	/**
	 * Gibt die in der Liste gespeicherten Werte sequenziell, d.h. in der
	 * Reihenfolge wie sie eingefügt worden sind, auf die Konsole aus.
	 */
	public void printAll() {
		if (first == null) // (1) Liste ist leer
			return; // Methode wird abgebrochen
		Node current = first;
		// (2) Wir laufen über jedes Element aus der Liste
		while (current != null) { // Solange das aktuelle Element nicht "null"
									// ist
			System.out.println(current.value); // ... geben wir dessen Wert auf
												// die Konsole aus
			current = current.next; // ... und wandern zum nächsten Element.
		}
		System.out.println();
	}

	/**
	 * Löscht das erste Element mit dem gesuchten Wert.
	 * 
	 * @param value
	 */
	public void remove(int value) {
		if (first == null) // (1) Liste ist leer
			return; // Methode wird abgebrochen

		if (first.value == value) {
			// (2) Wert befindet sich im ersten Element
			first = first.next; // ... Element wird überschrieben.
			size--; // Länge der Liste um 1 verringern.
			return; // Methode wird abgebrochen
		}

		if (last.value == value) {
			// (3) Wert befindet sich im letzten Element
			last = last.next; // ...Element wird überschrieben
			size--; // Länge der Liste um 1 verringern.
			return; // Methode wird abgebrochen
		}

		// (4) Das zu löschende Element befindet sich innerhalb der Liste
		Node current = first;
		Node prev = first;
		while (current != null) {
			//
			if (current.value == value) { // (5) "true" wenn Element mit Wert
											// gefunden wurde
				// LÖSCHEN
				Node tmp = current.next; // (6) Die Refernz "current" auf
											// seinen Nachfolgerknoten (d.h. die
											// Verbindung zur restlichen Liste)
											// wird auf "tmp"
											// zwischengespeichert.
				current = prev; // (7) Der aktuelle Knoten wird vom Vorgänger
								// überschrieben (siehe Schritt (11))
				current.next = tmp; // (8) Die Referenz auf die restliche Liste
									// wird als Referenz in "current" gesetzt.
				size--; // (9) Länge der Liste um 1 verringern.
				break; // (10) Wir verlassen die Schleife.
			}
			prev = current; // (11) Wir merken uns den Vorgänger von "current"
			current = current.next; // (12) // ... und wandern zum nächsten
									// Element.
		}
	}

	/**
	 * HA: Erweitern Sie das Beispielprogramm LinkedList um die Methode
	 * insertSorted(int value). Diese soll (sofern ausschließlich mit Hilfe
	 * dieser Methode Elemente der Liste hinzugefügt werden) dafür sorgen, dass
	 * jede Zahl automatisch an der "richtigen" Position eingefügt wird, so dass
	 * bspw. nach Einfügen von [12, 3, 1, 4, 3, 20] die Elemente in der
	 * Reihenfolge [1, 3, 3, 4, 12, 20] gespeichert sind.
	 * 
	 * @param value
	 */
	public void insertSorted(int value) {
		Node n = first;
		int zaehler = 0;
		int platzhalter;

		for (; n != null; n = n.next)
			zaehler++;
		n = first;
		int array[] = new int[zaehler];
		for (int i = 0; i < zaehler; i++) {
			array[i] = n.value;
			n = n.next;
		}

		for (int i = 0; i < zaehler - 1; i++)
		{
			for (int j = 0; j < zaehler - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					platzhalter = array[j];
					array[j] = array[j + 1];
					array[j + 1] = platzhalter;
				}
			}
		}

		System.out.println("Sortierte Ausgabe: ");
		for (int i = 0; i < zaehler; i++)
			System.out.println(array[i] + " ");
		System.out.println(" "); //Zeilenumbruch
	}


}
