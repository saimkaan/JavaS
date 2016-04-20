package list.generic;

import java.util.Iterator;

import list.iterator.GenericLinkedListIterator;

/**
 * Die Klasse GenericLinkedList repräsentiert eine generische einfach verkettete
 * Liste.
 * 
 * @param <T>
 */
public class GenericLinkedList<T> implements Iterable<T> {

	private GenericNode<T> first, last;

	public void add(T value) {
		GenericNode<T> newNode = new GenericNode<T>(value);
		if (first == null) {
			first = newNode;
			last = newNode;
		} else {
			last.setNext(newNode);
			last = newNode;
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new GenericLinkedListIterator<T>(first);
	}

}
