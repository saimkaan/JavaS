package list.generic;

/**
 * <p>
 * Hier eine generische Implementation eines Elements einer einfach verketteten
 * Liste.
 * </p>
 * <p>
 * <b>T</b> ist eine s.g. Typ-Variable und dient als Platzhalter für einen beliebigen
 * komplexen Datentyp, welcher erst zur Laufzeit des Programms aufgelöst wird.
 * </p>
 * 
 * @param <T>
 */
public class GenericNode<T> {

	private T value;
	private GenericNode<T> next;

	public GenericNode(T value) {
		this.value = value;
	}

	public GenericNode<T> getNext() {
		return next;
	}

	public void setNext(GenericNode<T> next) {
		this.next = next;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "VALUE=" + value + " -> NEXT[" + next + "]";
	}

}
