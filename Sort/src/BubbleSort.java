import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * <p>
 * Eine wundervolle und unterhaltsame Demonstration zum Bubblesort-Algorithmus gibt es
 * unter folgendem Link: <a href="https://www.youtube.com/watch?v=lyZQPjUT5B4">Bubble-sort with
 * Hungarian folk dance</a> (youtube)
 * </p>
 * 
 * @author matana
 *
 */
public class BubbleSort {

	public static void main(String[] args) {
		// 1. Bubblesort: Array mit Zahlen
		int[] a = new int[] { 2, 6, 11, 9, -1, 23, 5 };
		bubbleSort(a);
		for (int i : a) {
			System.out.println(i);
		}
		
		System.out.println();
		
		// 2. Bubblesort: Liste mit Strings
		ArrayList<String> list = new ArrayList<String>(Arrays.asList(new String[] { "C", "a", "B", "A", "e", "G", "Z" }));
		genericBubbleSort(list);
		for (String token : list) {
			System.out.printf("%s ", token);
		}
	}

	/**
	 * Generische Methode zum Sortieren von verschiedenen Elementen. Die zu sortierenden Elemente müssen
	 * das Interface Comparable implementieren.
	 * @param list
	 * @return
	 */
	public static <T extends Comparable<? super T>> void genericBubbleSort(List<T> list) {
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size() - 1; j++) {
				int compareTo = list.get(j).compareTo(list.get(j + 1));
				if (compareTo > 0) {
					T tmp = list.get(j);
					list.set(j, list.get(j + 1));
					list.set(j + 1, tmp);
				}
			}
		}
	}

	/**
	 * @param array
	 */
	public static void bubbleSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - 1; j++) {
				if (array[j] > array[j + 1]) {
					int tmp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = tmp;
				}
			}
		}
	}

	public static List<Integer> bubbleSort(List<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size() - 1; j++) {
				if (list.get(j) > list.get(j + 1)) {
					int tmp = list.get(j);
					list.set(j, list.get(j + 1));
					list.set(j + 1, tmp);
				}
			}
		}
		return list;
	}

}
