import java.util.concurrent.TimeUnit;

public class SlowComparator<T extends Comparable<T>> extends TimedComparator<T> {
  public SlowComparator() {
    super(TimeUnit.SECONDS, 1);
  }
}
