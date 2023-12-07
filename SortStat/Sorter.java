import java.util.Comparator;

public interface Sorter<T extends Comparable<T>> {
  void sort(T[] array, Comparator<T> comparator, Swapper<T> swapper);
}
