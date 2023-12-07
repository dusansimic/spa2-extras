import java.util.Comparator;

public class ExchangeSort<T extends Comparable<T>> implements Sorter<T> {

  @Override
  public void sort(T[] array, Comparator<T> comparator, Swapper<T> swapper) {
    for (int i = array.length - 1; i >= 1; i--) {
      boolean exchangeOccured = false;
      for (int j = 0; j < i; j++) {
        if (comparator.compare(array[j], array[j + 1]) > 0) {
          swapper.swap(array, j, j + 1);
          exchangeOccured = true;
        }
      }
      if (!exchangeOccured)
        break;
    }
  }

}
