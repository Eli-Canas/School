import java.util.List;

/**
 * Bubble Sort as described in "The Bubble Sort" handout.
 * Works on lists of Comparable items, in ascending order.
 */
public class BubbleSort {

    public static <T extends Comparable<? super T>> void bubbleSort(List<T> list) {
        if (list == null || list.size() < 2) return;

        for (int pass = list.size() - 1; pass >= 0; pass--) {
            boolean elementsSwapped = false;

            for (int index = 0; index < pass; index++) {
                T a = list.get(index);
                T b = list.get(index + 1);

                if (a.compareTo(b) > 0) {
                    list.set(index, b);
                    list.set(index + 1, a);
                    elementsSwapped = true;
                }
            }

            if (!elementsSwapped) {
                break; // already sorted
            }
        }
    }
}
