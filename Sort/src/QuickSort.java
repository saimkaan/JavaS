import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * Eine wundervolle und unterhaltsame Demonstration zum Quicksort-Algorithmus gibt es
 * unter folgendem Link: <a href="https://www.youtube.com/watch?v=ywWBy6J5gz8">Quick-sort with
 * Hungarian folk dance</a> (youtube)
 * </p>
 *
 * 
 * @author matana
 * 
 */
public class QuickSort {

	public static void main(String[] args) {
		Integer[] a = { 2, 6, 11, 9, -1, 23, 5 };

		List<Integer> list = new ArrayList<>(Arrays.asList(a));
		sort(list, 0, list.size() - 1);

		for (Integer i : list) {
			System.out.println(i);
		}
	}

	/**
	 * Eine generische Implementation von Quicksort.
	 * 
	 * @param list
	 * @param left
	 * @param right
	 */
	public static <T extends Comparable<? super T>> void sort(List<T> list,
			int left, int right) {

		int i = left;
		int j = right;

		T pivot = list.get(right);

		while (i <= j) {

			while (list.get(i).compareTo(pivot) < 0)
				i++;

			while (list.get(j).compareTo(pivot) > 0)
				j--;

			if (i <= j) {
				Collections.swap(list, i, j);
				i++;
				j--;
			}

			if (left < j) {
				sort(list, left, j);
				sort(list, i, right);
			}
		}

	}

	/**
	 * <p>
	 * Implementation von Quicksort aus "Algorithmen: in Java" (2. Auflage);
	 * Lang, H.W.; Oldenbourg: 2006
	 * </p>
	 * 
	 * @param a
	 * @param left
	 * @param right
	 */
	public static void sort(int[] a, int left, int right) {

		int i = left;
		int j = right;

		int pivot = a[left + (right - left) / 2];

		while (i <= j) {

			while (a[i] < pivot)
				i++;
			while (a[j] > pivot)
				j--;

			if (i <= j) {
				exchange(a, i, j);
				i++;
				j--;
			}

			if (left < j) {
				sort(a, left, j);
				sort(a, i, right);
			}
		}

	}

	private static void exchange(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

}
