import java.util.Comparator;

public class InsertionSort<T extends Comparable<T>> implements Sorter<T> {
  @Override
  public void sort(T[] array, Comparator<T> comparator, Swapper<T> swapper) {
    for (int i = 1; i < array.length; i++) {
      T current = array[i];
      int j = i - 1;
      while (j >= 0 && comparator.compare(array[j], current) > 0) {
        swapper.swap(array, j + 1, j);
        j--;
      }
      array[j + 1] = current;
    }
  }
}
