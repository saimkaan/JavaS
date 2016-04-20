package list.iterator;

import java.util.Iterator;

import list.generic.GenericNode;

public class GenericLinkedListIterator<T> implements Iterator<T> {

	private GenericNode<T> head;

	public GenericLinkedListIterator(GenericNode<T> head) {
		this.head = head;
	}

	@Override
	public boolean hasNext() {
		return head != null;
	}

	@Override
	public T next() {
		T value = head.getValue();
		head = head.getNext();
		return value;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException("Operation is not supported");
	}

}
