import java.util.Comparator;

public class SelectionSort<T extends Comparable<T>> implements Sorter<T> {

  @Override
  public void sort(T[] array, Comparator<T> comparator, Swapper<T> swapper) {
    for (int i = array.length - 1; i >= 1; i--) {
      int maxIndex = 0;
      for (int j = 1; j <= i; j++) {
        if (comparator.compare(array[maxIndex], array[j]) < 0) {
          maxIndex = j;
        }
      }
      if (maxIndex != i) {
        swapper.swap(array, i, maxIndex);
      }
    }
  }

}
