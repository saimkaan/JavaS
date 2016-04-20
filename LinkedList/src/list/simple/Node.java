package list.simple;

/**
 * <p>
 * Die Klasse Node stellt die wesentliche Komponente einer verketteten Liste
 * dar. Sie kapselt einen best. Wert und eine Referenz auf seinen Nachfolger
 * (rekursive Datenstruktur).
 * </p>
 */
public class Node {

	// Der eigentliche Wert der im Element (Node) gekapselt wird.
	// Hier wurde bewußt auf "private" verzichtet, um die Klasse schlank zu
	// halten. Besser wäre ein Zugriff über set- und get-Methoden
	int value;

	// Die Referenz (oder auch Zeiger) auf das nächste Element.
	// Wenn "next=null" ist, markiert dass das Ende der Liste.
	Node next;

	/**
	 * Default-Konstruktor
	 */
	public Node() {
	}

	/**
	 * Parametrisierter Konstruktur.
	 * 
	 * @param value
	 */
	public Node(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "VALUE=" + value + " -> NEXT[" + next + "]";
	}

}
